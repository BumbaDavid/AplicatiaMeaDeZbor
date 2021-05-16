package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.graalvm.compiler.core.common.type.ArithmeticOpTable;
import org.loose.fis.sre.exceptions.DisplayMessage;
import org.loose.fis.sre.model.AirlineApi;
import org.loose.fis.sre.model.FlightModel;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Objects;

public class AdminController {
 @FXML
    private TextField plecareTara;
 @FXML
    private TextField plecareOras;
 @FXML
    private TextField plecareAeroport;
 @FXML
    private TextField destTara;
 @FXML
    private TextField destOras;
 @FXML
    private TextField destAeroport;
 @FXML
    private TextField dataPlecare;
 @FXML
    private TextField oraPlecarii;
 @FXML
    private TextField dataSosire;
 @FXML
    private TextField oraSosire;
 @FXML
    private TextField nrID;
 @FXML
    private TextField nrLocuri;
 @FXML
    public Button actualizareStare;
 @FXML
    public Button actualizareLocuri;
 @FXML
    public Button istoric;
 @FXML
    private ChoiceBox tipBilet;
 @FXML
    private TextField companie;
 @FXML
    private TextField durataZb;
 @FXML
    private TextField pret;
 @FXML
    public Button stergeZbor;
 @FXML
    private ChoiceBox stare;
 @FXML
    public Button adaugaZbor;
    private JTable Table1;

    @FXML
    public void initialize() {
        tipBilet.getItems().addAll("dus", "dus-intors");
    }
    @FXML
    public void handlerActualizareLoc(ActionEvent e){
        UpdateSeats();
    }
    @FXML
    public void handlerActualizareSt(){
        UpdateState();
    }
    @FXML
    public void handlerStergeZbor(){
        DeleteFlight();
    }
    @FXML
    public void handlerAdaugaZbor(){
        AddFlight();
    }
    @FXML
    public void handlerIstoric(){
        ShowHistory();
    }

    public void AddFlight() {
        int tip = -1;
        int result1 = -1;
        int result2 = -1;
        int result3 = -1;
        int id1 = -1;
        int id2 = -1;
        int nr = 0;
        int t = 0;
        double p = 0;
        if (plecareTara.getText().length() > 0 && plecareOras.getText().length() > 0 && plecareAeroport.getText().length() > 0 && destTara.getText().length() > 0 && destOras.getText().length() > 0 && destAeroport.getText().length() > 0 && tipBilet.getValue().toString().length() > 0
                && dataPlecare.getText().length() > 0 && oraPlecarii.getText().length() > 0 && dataSosire.getText().length() > 0 && oraSosire.getText().length() > 0 && nrLocuri.getText().length() > 0 && companie.getText().length() > 0 && durataZb.getText().length() > 0 && pret.getText().length() > 0) {
            if (tipBilet.getValue().toString() == "dus")
                tip = 1;
            else if (tipBilet.getValue().toString() == "dus-intors")
                tip = 0;
            //convert string to int / double
            nr = Integer.parseInt(nrLocuri.getText());
            t = Integer.parseInt(durataZb.getText());
            p = Double.parseDouble(pret.getText());

            //adaugare
            result1 = AirlineApi.AddFlight( plecareTara.getText(), plecareOras.getText(), plecareAeroport.getText(), destTara.getText(), destOras.getText(), destAeroport.getText(), nr, tip, companie.getText());
            result2 = AirlineApi.AddDates(dataPlecare.getText(), oraPlecarii.getText(), dataSosire.getText(), oraSosire.getText(), t, p);

            if (result1 > 0 && result2 > 0) {
                id1 = AirlineApi.SelectFlight(plecareTara.getText(), plecareOras.getText(), plecareAeroport.getText(), destTara.getText(), destOras.getText(), destAeroport.getText(), nr, tip, companie.getText());
                id2 = AirlineApi.SelectDate( dataPlecare.getText(), oraPlecarii.getText(), dataSosire.getText(), oraSosire.getText(), t, p);

                if (id1 > 0 && id2 > 0) {
                    result3 = AirlineApi.AddFlightDate( id1, id2);
                    adaugaZbor.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor","Inseararea a fost facuta cu succes!"));
                }
            } else {
                adaugaZbor.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor","Inseararea nu a reusit!"));
            }

        } else {
            adaugaZbor.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor","Toate campurile trebuie completate!"));
        }
    }

    public void UpdateState(){
     int result = -1;
        if(nrID.getText().length() > 0 && stare.getValue().toString().length() > 0) {
            int id = Integer.parseInt(nrID.getText());
            result = AirlineApi.UpdateState(id, stare.getValue().toString());
            if (result > 0) {
                actualizareStare.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Actualizarea a fost facuta cu succes!"));
            }
            else{
                actualizareStare.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Actualizarea nu a reusit!"));
            }
        }
        else{
            actualizareStare.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Toate campurile trebuiesc completate!"));
        }
    }
    public void DeleteFlight() {
        int result = -1;
        if(nrID.getText().length() > 0) {

            int id = Integer.parseInt(nrID.getText());

            result = AirlineApi.DeleteFlight(id);
            if(result > 0){
                stergeZbor.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Stergerea a fost facuta cu succes!"));
            }
            else{
                stergeZbor.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Stergerea nu a reusit!"));
            }
        }
        else{
            stergeZbor.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Toate campurile trebuiesc completate!"));
        }
    }

    public void UpdateSeats() {
        int result = -1;
        if(nrID.getText().length() > 0 && nrLocuri.getText().length() > 0) {

            int id = Integer.parseInt(nrID.getText());
            int nr = Integer.parseInt(nrLocuri.getText());

            result = AirlineApi.UpdateSeats(id, nr);
            if(result > 0)
            {
                actualizareLocuri.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Actualizarea a fost facuta cu succes!"));

            }
            else
            {
                actualizareLocuri.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Actualizarea nu a reusit!"));
            }
        }
        else
        {
            actualizareLocuri.setOnAction(e -> DisplayMessage.display("Aplicatia Mea De Zbor", "Toate campurile trebuiesc completate!"));
        }
    }

    private void ShowHistory(JPanel panel){
        //create a new table
        Table1 = new JTable();
        //configure the width for each column
        int[] width= { 100, 80, 90, 90, 150, 90, 90, 150,70, 40, 90, 60, 90, 60, 80, 80, 80};
        //configure the name for column header
        String[] names={ "Nume", "Companie", "TaraPlec", "OrasPlec", "AeroportPlec", "TaraDest", "OrasDest", "AeroportDest",
                "NrLocuri", "Dus", "DataPlec", "OraPlec", "DataSosire", "OraSosire", "Durata", "Pret", "Status"};

        //add the table to the Frame
        panel.add(Table1);
        List<FlightModel> list= AirlineApi.GetHistory();
        //retrieve the table model
        DefaultTableModel model = (DefaultTableModel) Table1.getModel();
        //add first row
        model.addRow(names);
        //set the first row to have bold text
        Table1.setDefaultRenderer(Object.class, new FirstRowBold());
        //iterate the results from query and add them to the table
        for(FlightModel p : list)
        {
            Object[] row = { p.name , p.airline, p.departure_country, p.departure_city, p.departure_airport, p.destination_country, p.destination_city, p.destination_airport, p.number_seats, p.one_way,
                    p.departure_date, p.depature_time, p.arriver_date, p.arriver_time, p.time, p.price, p.flight_status};
            model.addRow(row);
        }
    }



}
