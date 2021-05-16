package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.Objects;

public class StartController {
    @FXML
    public Button inregistrare;
    @FXML
    public Button autentificare;


    public void handleInregistrareClick() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("inregistrare.fxml")));

        Stage window = (Stage) inregistrare.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }

    public void handleAutentificareClick() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("autentificare.fxml")));

        Stage window = (Stage) autentificare.getScene().getWindow();
        window.setScene(new Scene(root, 750, 500));
    }
}

