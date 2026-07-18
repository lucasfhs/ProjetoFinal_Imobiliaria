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
import javafx.scene.control.Button;
import javafx.stage.Stage;



/** 
 * Classe que controla a interação do usuário com a janela carragada
 * do arquivo <b>pix-payment.fxml</b>
*/
public class PixPaymentController extends BaseController implements Initializable {
     @FXML
    private Button bt_SairPix;
     @FXML
    private Button bt_InicioPix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    /**
     * Função do Botao para Voltar a tela inicial
     */
    @FXML
    void clickBt_InicioPix(ActionEvent event) {
        try {           
            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            Scene scene = new Scene(root);
            stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            //Fecha a janela atual
            Stage stageLocal = (Stage) bt_SairPix.getScene().getWindow();    
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

    /**
     * Função do Botao para Sair do programa
     */ 
    @FXML
    void clickBt_SairPix(ActionEvent event) {
        System.exit(0);

    }
    
}
