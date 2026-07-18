
package com.jotaproperties.controller;

import com.jotaproperties.model.House;
import com.jotaproperties.model.Property;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Esta classe gerencia as informações apresentadas dentro de cada card de
 * um imóvel, tais como {@code ImageView} e {@code Label} de preço 
 * e outros atributos
 * 
 * @author Emanuel Victor
 * @author Lucas Souza
 * @author Caio Lopes
 * @author Gabriel Araujo
 */
public class PropertyCardController extends BaseController {
    // Atributos da classe
    @FXML
    private ImageView img_ImovelImagem;
    @FXML
    private Label lb_ImovelTipo;
    @FXML
    private Label lb_imovelArea;
    @FXML
    private Label lb_imovelGaragens;
    @FXML
    private Label lb_imovelLocal;
    @FXML
    private Label lb_imovelPreco;
    @FXML
    private VBox BoxCard;

    private Property imovelDocard;

    private String etapas;

    /**
     * Passa os dados de um imóvel salvo no programa para
     * os elementos da interface gráfica
     * 
     * @param imovel Imóvel que será apresentado na cena
     * 
     * @author Emanuel Victor
     * @author Lucas Souza
     * @author Caio Lopes
     * @author Gabriel Araujo
     */
    public void setDadosImovel(Property imovel){
        imovelDocard = imovel;
        /* 
         * Cria uma instância de Image por meio da String do objeto imovel
         * que contém o caminho relativo do arquivo imagem no sistema
         */
        Image imagem = new Image(getClass().getResourceAsStream(imovel.getfonteImagem()));

        /* 
         * Atribui cada atributo do imóvel aos elementos na janela
         */
        //Imagem
        img_ImovelImagem.setImage(imagem);
        if (imovel instanceof House)
            lb_ImovelTipo.setText("Casa");
        else{
            lb_ImovelTipo.setText("Apartamento");
        }
        //Local
        lb_imovelLocal.setText("" + imovel.getEstado()+ "/" + imovel.getCidade());
        //Valor
        double preco = imovel.getValor();
        lb_imovelPreco.setText("R$ " + new DecimalFormat("#,###,##0.00").format(preco));    //Formata no padrão brasileiro
        //Área
        lb_imovelArea.setText("" + String.format("%.2f m²", imovel.getArea()));
        //Garagens
        lb_imovelGaragens.setText("" + imovel.getVagasGaragem() + (imovel.getVagasGaragem()>1?" garagens":" garagem"));
    }
    public void setCaminho(String caminho){
        etapas = caminho;
    }


    /**
     * Chama o cena Descrição em resposta ao evento de clique no Vbox
     * 
     * @param event Clique no vbox
     */
    @FXML
    void clickBox(MouseEvent event) {
        dados = new ArrayList<Object>();
        dados.add(imovelDocard);    // Salva o objeto Imovel correspondente ao card
        dados.add(etapas);
        PropertyDetailsController descricaoController = new PropertyDetailsController(); //Classe controller da proxima cena
        try {
            //Chama a próxima cena enviando a coleção de dados (com o Imovel do card) para o próximo controller
            showNextScene("/views/property-details.fxml", descricaoController, dados);
            
            //Fecha a janela atual
            Stage stageLocal = (Stage) lb_ImovelTipo.getScene().getWindow();    
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
