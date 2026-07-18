package com.jotaproperties.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import com.jotaproperties.model.Property;


/**
 * Esta classe é responsável por administrar os componentes da janela <b>payment.fxml</b>. <p>Nesta classe
 * estão todos os métodos de tratamento dos eventos que são gerados pela interação do usuário com os
 * componentes da janela.
 * 
 * @author Emanuel Victor
 * @author Lucas Souza
 * @author Caio Lopes
 * @author Gabriel Araujo
 */
public class PaymentController extends BaseController implements Initializable {

    @FXML
    private TextField txtPagamento;
    @FXML
    private RadioButton bt_Boleto;
    @FXML
    private RadioButton bt_Pix;
    @FXML
    private Button bt_Concluir;
    
    private ToggleGroup grupoBotoes;

    private String opcao;
                

    /**
    * Inicializa a classe controller.
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        opcao = new String();
        //Inicializa os dois botões em um ToggleGroup
        grupoBotoes = new ToggleGroup();
        bt_Boleto.setToggleGroup(grupoBotoes);
        bt_Pix.setToggleGroup(grupoBotoes);
        double preco = ((Property)dados.get(0)).getValor();
        txtPagamento.setText("R$ " + new DecimalFormat("#,###,##0.00").format(preco));    //Formata no padrão brasileiro
    }   

    /**
     * Função do Botao para concluir o pagamento
     */
    @FXML
    void clickBt_Concluir(ActionEvent event) {
        switch(opcao){
            case "Boleto":
                //Chama a cena de pagamento via Boleto 
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/views/bank-slip.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();

                    //Fecha a janela atual
                    Stage stageLocal = (Stage) bt_Boleto.getScene().getWindow();    
                    stageLocal.close();
                } catch (IOException e) {
                    Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso não seja
                    alert.setTitle("Erro");                       //possível carregar o arquivo
                    alert.setHeaderText(null);  
                    alert.setContentText("Tivemos problemas ao carregar as informações...");
                    alert.showAndWait();
                    e.printStackTrace();
                }
                break;

            case "PIX":
                //Chama a cena de pagamento via PIX 
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/views/pix-payment.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();

                    //Fecha a janela atual
                    Stage stageLocal = (Stage) bt_Boleto.getScene().getWindow();    
                    stageLocal.close();
                } catch (IOException e) {
                    Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso não seja
                    alert.setTitle("Erro");                       //possível carregar o arquivo
                    alert.setHeaderText(null);  
                    alert.setContentText("Tivemos problemas ao carregar as informações...");
                    alert.showAndWait();
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * Função do RadionButton do Boleto
     */
    @FXML
    void clickBtBoleto(ActionEvent event) {
        opcao = "Boleto";
    }

     /**
     * Função do RadionButton do Pix
     */
    @FXML
    void clickBtPix(ActionEvent event) {
        opcao = "PIX";
    }
}
