
package com.jotaproperties.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jotaproperties.model.Property;
import com.jotaproperties.service.PropertyService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Esta classe é responsável por administrar os componentes da janela <b>results.fxml</b>. <p>Nesta classe
 * estão todos os métodos de tratamento dos eventos que são gerados pela interação do usuário com os
 * componentes da janela.
 * 
 * @author Emanuel Victor
 * @author Lucas Souza
 * @author Caio Lopes
 * @author Gabriel Araujo
 */
public class ResultsController extends BaseController implements Initializable {

    private List<Property> listaImoveis;
    private int coluna;
    private int linha;

    @FXML
    private GridPane imovelContainer;

    @FXML
    private ToggleButton bt_numG1;

    @FXML
    private ToggleButton bt_numG2;

    @FXML
    private ToggleButton bt_numG3;

    @FXML
    private ToggleButton bt_numG4;

    @FXML
    private ToggleButton bt_numG5;
    
    @FXML
    private Button bt_Pesquisar;
    
    @FXML
    private Label lb_Nome;
    
    @FXML
    private Label lb_Caminho;

    @FXML
    private TextField txtAreaMaxima;

    @FXML
    private TextField txtAreaMinima;

    @FXML
    private TextField txtPrecoMaximo;

    @FXML
    private TextField txtPrecoMinimo;

    private ArrayList<VBox> cardBoxes; 

    private ToggleGroup grupoBotoesG;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Atribui a lista de imóveis filtrados vindos da janela anterior à variável listaImoveis
        PropertyService gerenciador = (PropertyService) dados.get(2);
        //Atribui a lista de imóveis filtrados vindos da janela anterior à variável listaImoveis
        listaImoveis = gerenciador.getSelectedProperties();

        //Carrega na janela os cards de cada imovel selecionado 

        cardBoxes = new ArrayList<VBox>();


        inicializaBotoes();
        String nome = (String) dados.get(0);    //Atribui o nome fornecido ao label nome
        lb_Nome.setText(nome);

        String caminho = (String) dados.get(1); //Atribui o caminho de escolhas feitas pelo usuário
        lb_Caminho.setText(caminho);

        /**
         * Dentro do for, o programa carrega (apenas carrega) as 10 mini janelas 
         * do tipo Card_Controller para cada imovel da lista, em seguida ele as 
         * apresenta na janela com os métodos filtraImoveis e adicionaImoveisPorIndice.
         */
        try {
            for (Property imovel : listaImoveis) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/views/property-card.fxml"));

                                                //Preenche a lista cardBoxes, por meio do carregamento
                cardBoxes.add(loader.load());   //de uma hierarquia de todos os objetos fxml do arquivo
                
                //Passa os atributos de cada imovel para as componentes fx do controller do Card
                ((PropertyCardController) loader.getController()).setDadosImovel(imovel);
                ((PropertyCardController) loader.getController()).setCaminho(caminho);
            }
            //Inicialmente, adiciona todos os imóveis (sem critérios) na janela de resultados
            adicionaImoveisPorIndice(filtraImoveis(0, 0, 0, 0,0));       
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso não seja
            alert.setTitle("Erro");                       //possível carregar o arquivo
            alert.setHeaderText(null);  
            alert.setContentText("Tivemos problemas ao carregar as informações...");
            alert.showAndWait();
            e.printStackTrace();
        } 
    }

    @FXML
    void clickbtNum(ActionEvent event) {
        refazPesquisa();
    }
    
    @FXML
    void clickBtPesquisar(ActionEvent event) {
        refazPesquisa();
    }

    /**
     * Aplica os grupos de botões dentro de um ToggleGroup
     */
    private void inicializaBotoes(){
        //Botões nº Garagem
        grupoBotoesG = new ToggleGroup();
        bt_numG1.setToggleGroup(grupoBotoesG);
        bt_numG2.setToggleGroup(grupoBotoesG);
        bt_numG3.setToggleGroup(grupoBotoesG);
        bt_numG4.setToggleGroup(grupoBotoesG);
        bt_numG5.setToggleGroup(grupoBotoesG);
    }

    /**
     * Aplica na janela um painel com os cards referentes a cada imóvel da lista
     * {@code listaImoveis} (dos imóveis selecionados). Os imóveis a serem
     * adicionados são aqueles cujo índice na lista corresponde aos índices
     * passados como argumento.
     * <p>
     * É necessário ter carregado os cards dentro da lista {@code cardBoxes}
     * antes de poder usar este método. Uma vez carregados, não há restrições 
     * de desempenho no programa.
     * 
     * @param indiceDosImoveis lista de Índices que referenciam cada um dos imoveis salvos na variável {@code listaImoveis}
     */
    private void adicionaImoveisPorIndice(ArrayList<Integer> indiceDosImoveis ){
        coluna = 0;     //Valor inicial do número de colunas
        linha = 1;      //e linhas para dispor os cards no GridPane

        for (int i : indiceDosImoveis){
            if(coluna == 4){    //Salta de linha ao atingir o limite de cards
                coluna = 0;
                linha++;
            }
            //Adiciona os respectivos imoveis no gridPane da janela
            imovelContainer.add(cardBoxes.get(i),coluna++,linha);    //(objeto VBox, IndexColuna, IndexLinha)
            
            GridPane.setMargin(cardBoxes.get(i), new Insets(10));    //(objeto VBox, Distância entre compontes)
        }
    }

    /**
     * Baseado nos crtérios passados como argumento, realiza uma série de 
     * condições de modo a incluir ou descartá-lo dos índices dos imóveis selecionados
     * <p>
     * Os índices serão os mesmos correspondentes à lista CardBoxes. 
     * <p>
     * Argumento iguais a zero significa sem critério.
     * 
     * @param conjuntoImoveis Lista de imóveis a ser filtrada
     * @param numGarg   Número de Garagens
     * @param areaMin   Área Mínima do terreno
     * @param areaMax   Área Máxima do terreno
     * @param precoMin  Valor mínimo pelo imóvel
     * @param precoMax  Valor máximo
     * @return ArrayList com os índices dos imóveis que atendem às condições
     */
    private ArrayList<Integer> filtraImoveis(int numGarg, double areaMin, double areaMax, double precoMin, double precoMax ){
        ArrayList<Integer> indiceImoveisFiltrados = new ArrayList<>();
        boolean criterio1 = true;               
        boolean criterio2 = true;                   //Inicializa todas as flags como true
        boolean criterio3 = true;           
        boolean criterio4 = true;
        boolean criterio5 = true;

        for (int i = 0; i<listaImoveis.size(); i++){              //Testa cada condição dos argumentos
            if(listaImoveis.get(i).getVagasGaragem() != numGarg && numGarg != 0.0)
                criterio1 = false;
            if(listaImoveis.get(i).getArea() < areaMin && areaMin != 0.0)
                criterio2 = false;
            if(listaImoveis.get(i).getArea() > areaMax && areaMax != 0.0)
                criterio3 = false;
            if(listaImoveis.get(i).getValor() < precoMin && precoMin != 0.0)
                criterio4 = false;
            if(listaImoveis.get(i).getValor() > precoMax && precoMax != 0.0)
                criterio5 =  false;

            if(criterio1 && criterio2 && criterio3 && criterio4 && criterio5)   //Faz o teste da intersecção das condições
                indiceImoveisFiltrados.add(i);
            criterio1 = true;               
            criterio2 = true;                   //Reseta o valor de todas as flags para true
            criterio3 = true;           
            criterio4 = true;
            criterio5 = true;
        }
        return indiceImoveisFiltrados;      //Retorna a ArrayList
    }


    /**
     * Recarrega o gridPane selecionando para apresentar apenas os cards 
     * que correspondem aos critérios de Área, n° de Garagens e Preço
     */
    private void refazPesquisa(){
        //Pega a 7º posição da string do id do botão e converte para inteiro
        int numGarg = 0;
        double areaMin = 0.0;
        double areaMax = 0.0;
        double precoMin = 0.0;
        double precoMax = 0.0;
        try{
            //Se as strings das entradas não forem nulas, leia e converta seu valor para Double
            if(!(txtAreaMinima.getText().equals("")))
                areaMin = Double.parseDouble(txtAreaMinima.getText());

            if(!(txtAreaMaxima.getText().equals("")))
                areaMax = Double.parseDouble(txtAreaMaxima.getText());

            if(!(txtPrecoMinimo.getText().equals("")))
                precoMin = Double.parseDouble(txtPrecoMinimo.getText());

            if(!(txtPrecoMaximo.getText().equals("")))
                precoMax = Double.parseDouble(txtPrecoMaximo.getText());

            if (grupoBotoesG.getSelectedToggle() != null)
                numGarg = Integer.parseInt(((ToggleButton)grupoBotoesG.getSelectedToggle()).getText());

        }   catch (NumberFormatException e){
            Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso o formato
            alert.setTitle("Ops...");                         //do número seja fora do padrão
            alert.setHeaderText(null);  
            alert.setContentText("Alguma das entradas fornecidas é inválida");
            alert.showAndWait();
            e.printStackTrace();
        }
        imovelContainer.getChildren().clear();  //Limpa todos os cards atuais da janela

        //Adiciona somente os imóveis que atendem aos dados critérios na janela de resultados
        adicionaImoveisPorIndice(filtraImoveis(numGarg, areaMin, areaMax, precoMin, precoMax));  
    }
}
