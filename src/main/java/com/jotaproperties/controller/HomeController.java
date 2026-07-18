package com.jotaproperties.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.jotaproperties.service.PropertyGenerator;
import com.jotaproperties.service.PropertyService;

/**
 * Esta classe é responsável por administrar os componentes da janela <b>home.fxml</b>. <p>Nesta classe
 * estão todos os métodos de tratamento dos eventos que são gerados pela interação do usuário com os
 * componentes da janela.
 * 
 * @author Emanuel Victor
 * @author Lucas Souza
 * @author Caio Lopes
 * @author Gabriel Araujo
 */
public class HomeController extends BaseController implements Initializable {
    @FXML
    private Button bt_pesquisar;

    @FXML
    private Button bt_sair;

    @FXML
    private ComboBox<String> cb_estado;

    @FXML
    private ComboBox<String> cb_cidade;

    @FXML
    private ComboBox<String> cb_imovel;

    @FXML
    private ComboBox<String> cb_acao;

    @FXML
    private ImageView fundo_principal;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    private PropertyService gerenciamento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {        

        /*
         * Inicializa o conteúdo de cada ComboBox 
         */
        ObservableList<String> casaApto = FXCollections.observableArrayList();  
        casaApto.add("Apartamento"); casaApto.add("Casa");                  
        cb_imovel.setItems(casaApto);

        ObservableList<String> listaEstados = FXCollections.observableArrayList();
        listaEstados.addAll(Arrays.asList("Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", 
        "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso",                       //Segundo info do comboBox
        "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco",
        "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
        "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"));

        cb_estado.setItems(listaEstados);
         
        
        ObservableList<String> operacao = FXCollections.observableArrayList();
        operacao.add("Alugar"); operacao.add("Comprar");
        cb_acao.setItems(operacao);
         
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
         
        label1.setBackground(background);
        label2.setBackground(background);
        label3.setBackground(background);
        label4.setBackground(background);
        gerenciamento = new PropertyService();
    } 

    /**
     * Trata o evento de clicar no botão Sair
     * @param event
     */
    @FXML
    void clickSair(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Trata o evento de clicar no botão Estado
     * @param event
     */
    @FXML
    void clickEstado(ActionEvent event) {

        PropertyGenerator temp_casas = new PropertyGenerator();
        ArrayList<String> cidades_ = temp_casas.getConjuntoMunicipioEstado().get(cb_estado.getValue());
        ObservableList<String> listaCidades = FXCollections.observableArrayList();
        listaCidades.addAll(cidades_);
        cb_cidade.setItems(listaCidades);
        cb_cidade.setDisable(false);
    }

    /*
    * Baseado nos campos que estão preenchidos ou não, faz uma pesquisa filtrada
    */
    @FXML
    void clickPesquisar(ActionEvent event) {
        boolean acao;
        if(cb_acao.getValue().equalsIgnoreCase("Alugar")){
            acao = true;
        }else{
            acao = false;
        }

        String caminho = acao?"Alugar":"Comprar";    //Atribui ao label a acao escolhida pelo usuário
        caminho += String.format("> %s > %s > %s", cb_imovel.getValue(), cb_estado.getValue(), cb_cidade.getValue());
        
        //Instancia os imóveis da cidade escolhida em uma lista
        gerenciamento.selectProperties(acao, cb_imovel.getValue(), cb_estado.getValue(), cb_cidade.getValue());

        dados.add(caminho);    //Adiciona o caminho de decisões do usuário
        dados.add(gerenciamento);   //Adiciona o gerenciador de imoveis na coleção de dados do controller
        
        ResultsController resultadosController = new ResultsController();
        try {
            //Chama a próxima cena enviando a coleção de dados atuais para o próximo controller
            showNextScene("/views/results.fxml", resultadosController, dados);

            //Fecha a janela atual
            Stage stageLocal = (Stage) bt_pesquisar.getScene().getWindow();    
            stageLocal.close();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso não seja
            alert.setTitle("Erro");                       //possível carregar o arquivo
            alert.setHeaderText(null);  
            alert.setContentText("Tivemos problemas ao carregar as informações...");
            alert.showAndWait();
            e.printStackTrace();
        }
    }
}

