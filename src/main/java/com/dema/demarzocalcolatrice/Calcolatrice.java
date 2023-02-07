package com.dema.demarzocalcolatrice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Calcolatrice extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Calcolatrice.class.getResource("calcolatrice.fxml"));
        String css = Objects.requireNonNull(this.getClass().getResource("test.css")).toExternalForm();
        Scene scene = new Scene(fxmlLoader.load(), 286, 432);
        stage.getIcons().add(new Image(Calcolatrice.class.getResourceAsStream("calculator-icon.png")));
        stage.setResizable(false);
        scene.getStylesheets().add(css);
        stage.setTitle("Calcolatrice");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}