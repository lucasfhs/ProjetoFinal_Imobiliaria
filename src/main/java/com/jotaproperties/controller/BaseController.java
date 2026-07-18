package com.jotaproperties.controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Compartilha a navegação e os dados enviados entre as telas. */
public abstract class BaseController {
    protected ArrayList<Object> dados;
    protected Stage stage;

    public ArrayList<Object> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Object> dados) {
        this.dados = dados;
    }

    public void showNextScene(String viewPath, BaseController controller, ArrayList<Object> sceneData)
            throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
        controller.setDados(sceneData);
        loader.setController(controller);

        Parent root = loader.load();
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
