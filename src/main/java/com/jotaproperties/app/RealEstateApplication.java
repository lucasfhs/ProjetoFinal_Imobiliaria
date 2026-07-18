package com.jotaproperties.app;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/** Ponto de entrada da aplicação JavaFX. */
public class RealEstateApplication extends Application {
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
        stage.setTitle("Jota Imóveis");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
        playSoundtrack();
    }

    private void playSoundtrack() {
        URL soundtrack = getClass().getResource("/audio/upbeat.wav");
        if (soundtrack == null) {
            return;
        }

        mediaPlayer = new MediaPlayer(new Media(soundtrack.toExternalForm()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.10);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
