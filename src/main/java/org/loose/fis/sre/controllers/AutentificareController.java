package org.loose.fis.sre.controllers;

import com.sun.javafx.charts.Legend;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.AirlineApi;
import org.loose.fis.sre.services.UserModel;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.awt.event.ActionEvent;

public class AutentificareController {

    @FXML
    private TextField numeField;
    @FXML
    private TextField parolaField;
    @FXML
    public Button autentif;
    @FXML
    private Text textfieldMessage;

    public void actionPerformed(ActionEvent e) {
        int result = 0;
        String nume_utilizator = numeField.getText();
        String pass = parolaField.getText();
        result = AirlineApi.GetUser(nume_utilizator, pass);
        if(result == -1){
            textfieldMessage.setText("Numele sau Parola gresita!");
        }
        else if(result == 0){
            textfieldMessage.setText("Bun venit! Puteti accesa sectiunea client.");

        }
        else if(result == 1){
            textfieldMessage.setText("Bun venit! Puteti accesa sectiunea admin.");
        }
    }
}
