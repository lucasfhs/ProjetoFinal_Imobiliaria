package com.jotaproperties.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;

/** 
 * Classe que controla a interação do usuário com a janela carragada
 * do arquivo <b>bank-slip.fxml</b>
*/
public class BankSlipController extends BaseController implements Initializable {
    
    @FXML
    private Button bt_SairBoleto;
    @FXML
    private Button bt_InicioBoleto;

    /**
     * Inicializa a classe controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    
    /**
     * Função do Botao para Sair do programa
     */
    @FXML
    void clickBt_SairBoleto(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Função do Botao para Voltar à tela inicial
     */
    @FXML
    void clickBt_InicioBoleto(ActionEvent event) {
        try {           
            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            //Fecha a janela atual
            Stage stageLocal = (Stage) bt_SairBoleto.getScene().getWindow();    
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
