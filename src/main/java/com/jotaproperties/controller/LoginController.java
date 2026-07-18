package com.jotaproperties.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Esta classe é responsável por administrar os componentes da janela <b>login.fxml</b>. <p>Nesta classe
 * estão todos os métodos de tratamento dos eventos que são gerados pela interação do usuário com os
 * componentes da janela.
 * 
 * @author Emanuel Victor
 * @author Lucas Souza
 * @author Caio Lopes
 * @author Gabriel Araujo
 */
public class LoginController extends BaseController implements Initializable {
    @FXML
    private Button btnEntrar;
    @FXML
    private TextField txtNome;

    private String nome;

    /**
     * Inicializa a classe controller atual.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dados = new ArrayList<Object>();    //Inicializa a coleção de dados
    }

    /**
     * Funçao de clique no botão para entrar no programa.
     */
    @FXML
    void clickBtnEntrar(ActionEvent event) {
        realizaLogin();
    }
    /**
     * Funçao de pressionar ENTER para entrar no programa.
     */
    @FXML
    void digitoTxt(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
            realizaLogin();         //Chama a próxima janela
        }
    }

    /**
     * Chama a próxima cena passando a {@code ArrayList} de dados para o controller seguinte
     */
    private void realizaLogin(){
        nome = txtNome.getText();
  
        dados.add(nome);           //Salva o nome fornecido na coleção de dados

        HomeController principalController = new HomeController(); //Classe controller da cena seguinte
        
        try {
            //Chama a próxima cena enviando a coleção de dados (com a String nome) para o próximo controller
            showNextScene("/views/home.fxml", principalController, dados);
            
            //Fecha a janela atual
            Stage stageLocal = (Stage) btnEntrar.getScene().getWindow();    
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
