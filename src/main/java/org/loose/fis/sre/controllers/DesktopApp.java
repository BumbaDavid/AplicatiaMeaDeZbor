package org.loose.fis.sre.controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class DesktopApp {

    //parentPanel
    private JFrame frame;
    private JToolBar toolBar;
    private JButton butonInregistrare;
    private JButton butonAutentificare;
    private JRadioButton client;
    private JRadioButton admin;
    private JButton inregistrare;
    //childPanel1
    private JTextField nume_utilizator;
    private JTextField prenume_nume;
    private JTextField adresa;
    private JTextField telefon;
    private JPanel parentPanel;
    private JPanel childPanel1;
    private JPanel childPanel2;
    private JPasswordField parola;
    //childPanel2
    private JTextField nume_utilizator2;
    private JPasswordField parola2;
    private JButton autentificare;
    //childPanel3
    private JPanel childPanel3;
    private JTextField tara;
    private JTextField oras;
    private JTextField aeroport;
    private JComboBox tip_bilet;
    private JTextField tara2;
    private JTextField oras2;
    private JTextField aeroport2;
    private JTextField data_plecarii;
    private JButton cautare;
    private JTable Table1;
    private JTable Table2;
    //childPanel4
    private JPanel childPanel4;
    private JTextField nr_locuri;
    private JTextField companie_;
    private JTextField data_sosirii;
    private JTextField ora_plecare;
    private JTextField ora_sosire;
    private JTextField timp_;
    private JTextField pret_;
    private JTextField id_;
    private JButton adaugare;
    private JButton update;
    private JComboBox stare_;
    private JTextField locuri;
    private JButton update2;
    private JButton stergere;
    private JButton istoric;
    //Api
    private AirlineApi AirlineApi;

    //database Connection settings
    private String Url="jdbc:mysql://localhost:3306/airline";
    private	String User="root";
    private	String Password="Realmadrid132!";
    private	Connection Conn=null;
    private JButton operatiiClient;
    private JButton operatiiAdmin;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DesktopApp window = new DesktopApp();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public DesktopApp() {
        initialize();
    }
    //inregistrare
    public void CreatePanel1() {

        RemovePanels();

        operatiiClient.setVisible(false);
        operatiiAdmin.setVisible(false);

        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        childPanel1 = new JPanel();
        childPanel1.setBounds(00, 0, 837, 538);
        parentPanel.add(childPanel1);
        childPanel1.setLayout(null);

        client = new JRadioButton("Client");
        client.setFont(new Font("Verdana", Font.PLAIN, 16));
        client.setBounds(333, 66, 181, 55);
        childPanel1.add(client);

        admin = new JRadioButton("Admin");
        admin.setFont(new Font("Verdana", Font.PLAIN, 16));
        admin.setBounds(538, 66, 181, 55);
        childPanel1.add(admin);

        JLabel alegeRol = new JLabel("Alege un rol:");
        alegeRol.setFont(new Font("Verdana", Font.PLAIN, 16));
        alegeRol.setBounds(103, 66, 166, 55);
        childPanel1.add(alegeRol);

        JLabel titlu = new JLabel("Inregistrare");
        titlu.setForeground(Color.BLACK);
        titlu.setBackground(Color.YELLOW);
        titlu.setFont(new Font("Verdana", Font.PLAIN, 18));
        titlu.setBounds(313, 0, 166, 55);
        childPanel1.add(titlu);

        JLabel numeUtilizatorLabel = new JLabel("Nume utilizator:");
        numeUtilizatorLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        numeUtilizatorLabel.setBounds(185, 163, 156, 31);
        childPanel1.add(numeUtilizatorLabel);

        JLabel parolaLabel = new JLabel("Parola:");
        parolaLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        parolaLabel.setBounds(185, 228, 123, 31);
        childPanel1.add(parolaLabel);

        JLabel prenumeNumeLabel = new JLabel("Prenume Nume:");
        prenumeNumeLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        prenumeNumeLabel.setBounds(185, 292, 140, 31);
        childPanel1.add(prenumeNumeLabel);

        JLabel adresaLabel = new JLabel("Adresa:");
        adresaLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        adresaLabel.setBounds(185, 354, 114, 31);
        childPanel1.add(adresaLabel);

        JLabel telefonLabel = new JLabel("Telefon:");
        telefonLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        telefonLabel.setBounds(185, 408, 114, 31);
        childPanel1.add(telefonLabel);

        nume_utilizator = new JTextField();
        nume_utilizator.setBounds(351, 163, 216, 38);
        childPanel1.add(nume_utilizator);
        nume_utilizator.setColumns(10);

        prenume_nume = new JTextField();
        prenume_nume.setColumns(10);
        prenume_nume.setBounds(351, 292, 216, 38);
        childPanel1.add(prenume_nume);

        adresa = new JTextField();
        adresa.setColumns(10);
        adresa.setBounds(351, 354, 216, 38);
        childPanel1.add(adresa);

        telefon = new JTextField();
        telefon.setColumns(10);
        telefon.setBounds(351, 408, 216, 38);
        childPanel1.add(telefon);

        parola = new JPasswordField();
        parola.setBounds(351, 224, 216, 38);
        childPanel1.add(parola);

        inregistrare = new JButton("INREGISTRARE");
        inregistrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoveTables();
                int result = 0;
                String parolaString = new String(parola.getPassword());
                if(client.isSelected() == true) {

                    if(nume_utilizator.getText().length()>0 && parolaString.length()>0 && prenume_nume.getText().length()>0 && adresa.getText().length()>0 && telefon.getText().length()>0) {

                        UserModel user = new UserModel(nume_utilizator.getText(), parolaString, prenume_nume.getText(), adresa.getText(), telefon.getText(), 0);
                        result = AirlineApi.AddUser(Conn, Url, User, Password, user);
                    }
                }
                else if(admin.isSelected() == true){

                    if(nume_utilizator.getText().length()>0 && parolaString.length()>0 && prenume_nume.getText().length()>0 && adresa.getText().length()>0 && telefon.getText().length()>0) {

                        UserModel user = new UserModel(nume_utilizator.getText(), parolaString, prenume_nume.getText(), adresa.getText(), telefon.getText(), 1);
                        result = AirlineApi.AddUser(Conn, Url, User, Password, user);
                    }
                }

                if(result == 1)
                {
                    JOptionPane.showMessageDialog(frame, "Inserarea s-a facut cu succes!");
                    CreatePanel2();
                }
                else {

                    JOptionPane.showMessageDialog(frame, "Inserarea nu a reusit!");
                }
            }
        });

        inregistrare.setFont(new Font("Verdana", Font.PLAIN, 14));
        inregistrare.setBounds(273, 457, 202, 62);
        childPanel1.add(inregistrare);
    }
    //autentificare
    public void CreatePanel2() {

        RemovePanels();

        operatiiClient.setVisible(false);
        operatiiAdmin.setVisible(false);

        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        childPanel2 = new JPanel();
        childPanel2.setBounds(10, 0, 837, 538);
        childPanel2.setLayout(null);
        parentPanel.add(childPanel2);

        JLabel numeUtilizatorLabel = new JLabel("Nume utilizator:");
        numeUtilizatorLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        numeUtilizatorLabel.setBounds(185, 163, 156, 31);
        childPanel2.add(numeUtilizatorLabel);

        JLabel parolaLabel = new JLabel("Parola:");
        parolaLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        parolaLabel.setBounds(185, 228, 123, 31);
        childPanel2.add(parolaLabel);

        nume_utilizator2 = new JTextField();
        nume_utilizator2.setBounds(351, 163, 216, 38);
        childPanel2.add(nume_utilizator2);
        nume_utilizator2.setColumns(10);

        parola2 = new JPasswordField();
        parola2.setBounds(351, 224, 216, 38);
        childPanel2.add(parola2);

        nume_utilizator2.setText("");
        parola2.setText("");

        autentificare = new JButton("AUTENTIFICARE");
        autentificare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RemoveTables();
                int result = 0;
                String nume_utilizator = nume_utilizator2.getText();
                String parola = new String(parola2.getPassword());
                result = AirlineApi.GetUser(Conn, Url, User, Password, nume_utilizator, parola);
                if (result == -1)
                {
                    JOptionPane.showMessageDialog(frame, "Numele si parola nu sunt corecte! Incercati din nou.");
                    nume_utilizator2.setText("");
                    parola2.setText("");
                }
                else if(result == 0)
                {
                    JOptionPane.showMessageDialog(frame, "Bun venit! Puteti accesa sectiunea operatii client.");
                    operatiiClient.setVisible(true);
                    CreatePanel3();
                }
                else if(result == 1)
                {
                    JOptionPane.showMessageDialog(frame, "Bun venit! Puteti accesa sectiunea operatii admin.");
                    operatiiAdmin.setVisible(true);
                    CreatePanel4();
                }
                childPanel2.revalidate();
                childPanel2.repaint();
            }
        });

        autentificare.setFont(new Font("Verdana", Font.PLAIN, 14));
        autentificare.setBounds(273, 457, 202, 62);
        childPanel2.add(autentificare);
    }

    private void FlightFields(JPanel p) {

        JLabel taraOrasAeroport = new JLabel("Tara                 Oras                Aeroport:                                             YYYY-MM-DD:");
        taraOrasAeroport.setFont(new Font("Verdana", Font.PLAIN, 14));
        taraOrasAeroport.setBounds(170, 10, 640, 25);
        p.add(taraOrasAeroport);

        JLabel locPlecare = new JLabel("Plecare:");
        locPlecare.setFont(new Font("Verdana", Font.PLAIN, 14));
        locPlecare.setBounds(20, 40, 140, 25);
        p.add(locPlecare);

        JLabel destinatia = new JLabel("Destinatia:");
        destinatia.setFont(new Font("Verdana", Font.PLAIN, 14));
        destinatia.setBounds(20, 70, 140, 25);
        p.add(destinatia);

        JLabel dataPlecarii = new JLabel("Data plecarii:");
        dataPlecarii.setFont(new Font("Verdana", Font.PLAIN, 14));
        dataPlecarii.setBounds(530, 40, 150, 25);
        p.add(dataPlecarii);


        tara = new JTextField();
        tara.setBounds(170, 40, 110, 25);
        p.add(tara);

        oras = new JTextField();
        oras.setBounds(281, 40, 110, 25);
        p.add(oras);

        aeroport = new JTextField();
        aeroport.setBounds(395, 40, 110, 25);
        p.add(aeroport);


        tara2 = new JTextField();
        tara2.setBounds(170, 70, 110, 25);
        p.add(tara2);

        oras2 = new JTextField();
        oras2.setBounds(281, 70, 110, 25);
        p.add(oras2);

        aeroport2 = new JTextField();
        aeroport2.setBounds(395, 70, 110, 25);
        p.add(aeroport2);

        data_plecarii = new JTextField();
        data_plecarii.setBounds(690, 40, 130, 25);
        p.add(data_plecarii);
    }

    //operatii client
    public void CreatePanel3() {

        RemovePanels();

        childPanel3 = new JPanel();
        childPanel3.setBounds(0, 0, 2500, 538);
        childPanel3.setLayout(null);
        parentPanel.add(childPanel3);

        JLabel tipBilet = new JLabel("Tipul biletului:");
        tipBilet.setFont(new Font("Verdana", Font.PLAIN, 14));
        tipBilet.setBounds(550, 70, 140, 25);
        childPanel3.add(tipBilet);

        tip_bilet = new JComboBox();
        tip_bilet.setBounds(750, 70, 90, 25);
        tip_bilet.setVisible(true);
        tip_bilet.setModel(new DefaultComboBoxModel(new String[] {"dus-intors", "dus"}));
        childPanel3.add(tip_bilet);

        FlightFields(childPanel3);

        cautare = new JButton("CAUTA");
        cautare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FilterFlights();
            }
        });

        cautare.setFont(new Font("Verdana", Font.PLAIN, 14));
        cautare.setBounds(900, 40, 140, 50);
        childPanel3.add(cautare);

        ShowFlights(childPanel3);

    }
    //operatii admin
    public void CreatePanel4() {

        RemovePanels();

        childPanel4 = new JPanel();
        childPanel4.setBounds(0, 0, 2500, 538);
        childPanel4.setLayout(null);
        parentPanel.add(childPanel4);

        FlightFields(childPanel4);

        JLabel ora = new JLabel("Ora:");
        ora.setFont(new Font("Verdana", Font.PLAIN, 14));
        ora.setBounds(825, 10, 50, 25);
        childPanel4.add(ora);

        JLabel dataSosirii = new JLabel("Data sosirii:");
        dataSosirii.setFont(new Font("Verdana", Font.PLAIN, 14));
        dataSosirii.setBounds(530, 70, 150, 25);
        childPanel4.add(dataSosirii);

        data_sosirii = new JTextField();
        data_sosirii.setBounds(690, 70, 130, 25);
        childPanel4.add(data_sosirii);

        ora_plecare = new JTextField();
        ora_plecare.setBounds(825, 40, 70, 25);
        childPanel4.add(ora_plecare);

        ora_sosire = new JTextField();
        ora_sosire.setBounds(825, 70, 70, 25);
        childPanel4.add(ora_sosire);

        JLabel nrLocuri = new JLabel("Numar locuri:");
        nrLocuri.setFont(new Font("Verdana", Font.PLAIN, 14));
        nrLocuri.setBounds(900, 40, 150, 25);
        childPanel4.add(nrLocuri);

        nr_locuri = new JTextField();
        nr_locuri.setBounds(1000, 40, 130, 25);
        childPanel4.add(nr_locuri);

        JLabel companie = new JLabel("Companie:");
        companie.setFont(new Font("Verdana", Font.PLAIN, 14));
        companie.setBounds(900, 70, 150, 25);
        childPanel4.add(companie);

        companie_ = new JTextField();
        companie_.setBounds(1000, 70, 130, 25);
        childPanel4.add(companie_);

        JLabel timp = new JLabel("Durata:");
        timp.setFont(new Font("Verdana", Font.PLAIN, 14));
        timp.setBounds(1150, 40, 180, 25);
        childPanel4.add(timp);

        timp_ = new JTextField();
        timp_.setBounds(1300, 40, 130, 25);
        childPanel4.add(timp_);

        JLabel pret = new JLabel("Pret(EURO):");
        pret.setFont(new Font("Verdana", Font.PLAIN, 14));
        pret.setBounds(1150, 70, 180, 25);
        childPanel4.add(pret);

        pret_ = new JTextField();
        pret_.setBounds(1300, 70, 130, 25);
        childPanel4.add(pret_);

        JLabel tipBilet = new JLabel("Tip bilet:");
        tipBilet.setFont(new Font("Verdana", Font.PLAIN, 14));
        tipBilet.setBounds(1500, 40, 120, 25);
        childPanel4.add(tipBilet);

        tip_bilet = new JComboBox();
        tip_bilet.setBounds(1630, 40, 90, 25);
        tip_bilet.setVisible(true);
        tip_bilet.setModel(new DefaultComboBoxModel(new String[] {"dus-intors", "dus"}));
        childPanel4.add(tip_bilet);

        adaugare = new JButton("ADAUGA");
        adaugare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddFlight();
            }
        });

        adaugare.setFont(new Font("Verdana", Font.PLAIN, 14));
        adaugare.setBounds(1750, 40, 140, 25);
        childPanel4.add(adaugare);

        JLabel id = new JLabel("ID:");
        id.setFont(new Font("Verdana", Font.PLAIN, 14));
        id.setBounds(20, 100, 50, 25);
        childPanel4.add(id);

        id_ = new JTextField();
        id_.setBounds(80, 100, 100, 25);
        childPanel4.add(id_);

        JLabel stare = new JLabel("Stare:");
        stare.setFont(new Font("Verdana", Font.PLAIN, 14));
        stare.setBounds(190, 100, 50, 25);
        childPanel4.add(stare);

        stare_ = new JComboBox();
        stare_.setBounds(280, 100, 90, 25);
        stare_.setVisible(true);
        stare_.setModel(new DefaultComboBoxModel(new String[] {"scheduled", "delayed", "departed", "in air", "landed", "cancelled"}));
        childPanel4.add(stare_);

        update = new JButton("UPDATE Stare");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateState();
            }
        });

        update.setFont(new Font("Verdana", Font.PLAIN, 14));
        update.setBounds(430, 100, 140, 25);
        childPanel4.add(update);

        JLabel nr_locuri = new JLabel("Nr Locuri:");
        nr_locuri.setFont(new Font("Verdana", Font.PLAIN, 14));
        nr_locuri.setBounds(580, 100, 80, 25);
        childPanel4.add(nr_locuri);

        locuri = new JTextField();
        locuri.setBounds(670, 100, 50, 25);
        childPanel4.add(locuri);

        update2 = new JButton("UPDATE Locuri");
        update2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdateSeats();
            }
        });

        update2.setFont(new Font("Verdana", Font.PLAIN, 14));
        update2.setBounds(730, 100, 140, 25);
        childPanel4.add(update2);

        stergere = new JButton("Stergere zbor");
        stergere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteFlight();
            }
        });

        stergere.setFont(new Font("Verdana", Font.PLAIN, 14));
        stergere.setBounds(880, 100, 140, 25);
        childPanel4.add(stergere);

        istoric = new JButton("Istoric");
        istoric.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShowHistory(childPanel4);
            }
        });

        istoric.setFont(new Font("Verdana", Font.PLAIN, 14));
        istoric.setBounds(1200, 100, 140, 40);
        childPanel4.add(istoric);


        ShowFlights(childPanel4);
    }

    //Create a new table with the basic settings for column width and header names
    public JTable CreateNewTable(JTable table, int[] width, String[] names){

        table.setFont(new Font("Verdana", Font.PLAIN, 13));
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                names
        ) {
            private static final long serialVersionUID = 1L;
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        for(int i=0;i<width.length;i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
            table.getColumnModel().getColumn(i).setMaxWidth(width[i]);
        }
        table.setBounds(0, 150, 2500, 500);

        return table;
    }

    //bold the first row to see better the header
    public class FirstRowBold extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel parent = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if(row == 0) {
                parent.setFont(
                        parent.getFont().deriveFont(Font.BOLD));
            }
            return parent;
        }
    }

    //remove all existent tables before adding a new one
    public void RemoveTables() {
        if(Table1!=null) {
            if(childPanel3 != null)
                childPanel3.remove(Table1);
            if(childPanel4 != null)
                childPanel4.remove(Table1);
        }
        if(Table2!=null) {
            childPanel3.remove(Table2);
        }
    }

    public void RemovePanels() {
        if(childPanel1 != null)
        {
            parentPanel.remove(childPanel1);
            parentPanel.revalidate();
            parentPanel.repaint();
        }

        if(childPanel2 != null)
        {
            parentPanel.remove(childPanel2);
            parentPanel.revalidate();
            parentPanel.repaint();
        }

        if(childPanel3 != null)
        {
            parentPanel.remove(childPanel3);
            parentPanel.revalidate();
            parentPanel.repaint();
        }
    }

    //get all flights and show them in the table
    private void ShowFlights(JPanel panel)
    {
        RemoveTables();
        //create a new table
        Table1 = new JTable();
        //configure the width for each column
        int[] width= { 40, 80, 90, 90, 150, 90, 90, 150,70, 40, 90, 60, 90, 60, 80, 80, 80};
        //configure the name for column header
        String[] names={ "ID", "Companie", "TaraPlec", "OrasPlec", "AeroportPlec", "TaraDest", "OrasDest", "AeroportDest",
                "NrLocuri", "Dus", "DataPlec", "OraPlec", "DataSosire", "OraSosire", "Durata", "Pret", "Status"};
        //create the table
        CreateNewTable(Table1, width, names);
        //add the table to the Frame
        panel.add(Table1);

        List<FlightModel> list= AirlineApi.GetFlights(Conn, Url, User, Password);
        //retrieve the table model
        DefaultTableModel model = (DefaultTableModel) Table1.getModel();
        //add first row
        model.addRow(names);
        //set the first row to have bold text
        Table1.setDefaultRenderer(Object.class, new FirstRowBold());
        //iterate the results from query and add them to the table
        for(FlightModel p : list)
        {
            Object[] row = { p.id , p.airline, p.departure_country, p.departure_city, p.departure_airport, p.destination_country, p.destination_city, p.destination_airport, p.number_seats, p.one_way,
                    p.departure_date, p.depature_time, p.arriver_date, p.arriver_time, p.time, p.price, p.flight_status};
            model.addRow(row);
        }
    }

    //get history info
    private void ShowHistory(JPanel panel)
    {
        RemoveTables();
        //create a new table
        Table1 = new JTable();
        //configure the width for each column
        int[] width= { 100, 80, 90, 90, 150, 90, 90, 150,70, 40, 90, 60, 90, 60, 80, 80, 80};
        //configure the name for column header
        String[] names={ "Nume", "Companie", "TaraPlec", "OrasPlec", "AeroportPlec", "TaraDest", "OrasDest", "AeroportDest",
                "NrLocuri", "Dus", "DataPlec", "OraPlec", "DataSosire", "OraSosire", "Durata", "Pret", "Status"};
        //create the table
        CreateNewTable(Table1, width, names);
        //add the table to the Frame
        panel.add(Table1);

        List<FlightModel> list= AirlineApi.GetHistory(Conn, Url, User, Password);
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

    //get filtered flights and show them in the table
    private void FilterFlights()
    {
        RemoveTables();
        //create a new table
        Table2 = new JTable();
        //configure the width for each column
        int[] width= { 40, 80, 90, 90, 150, 90, 90, 150,70, 40, 90, 60, 90, 60, 40, 60, 90};
        //configure the name for column header
        String[] names={ "ID", "Companie", "TaraPlec", "OrasPlec", "AeroportPlec", "TaraDest", "OrasDest", "AeroportDest",
                "NrLocuri", "Dus", "DataPlec", "OraPlec", "DataSosire", "OraSosire", "Durata", "Pret", "Status"};
        //create the table
        CreateNewTable(Table2, width, names);
        //add the table to the Frame
        childPanel3.add(Table2);

        int tip = -1;
        if(tip_bilet.getSelectedItem().toString() == "dus")
            tip = 1;
        else if(tip_bilet.getSelectedItem().toString() == "dus-intors")
            tip = 0;


        if(tara.getText().length()>0 && oras.getText().length()>0 && aeroport.getText().length()>0 && tara2.getText().length()>0 && oras2.getText().length()>0 && aeroport2.getText().length()>0 && tip != -1 && data_plecarii.getText().length()>0)
        {
            List<FlightModel> list = AirlineApi.GetFilteredFlights(Conn, Url, User, Password, tara.getText(), oras.getText(), aeroport.getText(), tara2.getText(), oras2.getText(), aeroport2.getText(), tip, data_plecarii.getText());

            //retrieve the table model
            DefaultTableModel model = (DefaultTableModel) Table2.getModel();
            //add first row
            model.addRow(names);
            //set the first row to have bold text
            Table2.setDefaultRenderer(Object.class, new FirstRowBold());
            //iterate the results from query and add them to the table
            for(FlightModel p : list)
            {
                Object[] row = { p.id , p.airline, p.departure_country, p.departure_city, p.departure_airport, p.destination_country, p.destination_city, p.destination_airport, p.number_seats, p.one_way,
                        p.departure_date, p.depature_time, p.arriver_date, p.arriver_time, p.time, p.price, p.flight_status};
                model.addRow(row);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Toate campurile trebuiesc completate!");
        }
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

        if(tara.getText().length()>0 && oras.getText().length()>0 && aeroport.getText().length()>0 && tara2.getText().length()>0 && oras2.getText().length()>0 && aeroport2.getText().length()>0 && tip_bilet.getSelectedItem().toString().length() >0
                && data_plecarii.getText().length()>0 && ora_plecare.getText().length()>0 && data_sosirii.getText().length()>0 && ora_sosire.getText().length()>0 && nr_locuri.getText().length()>0 && companie_.getText().length()>0 && timp_.getText().length()>0 && pret_.getText().length()>0)
        {
            if(tip_bilet.getSelectedItem().toString() == "dus")
                tip = 1;
            else if(tip_bilet.getSelectedItem().toString() == "dus-intors")
                tip = 0;

            //convert string to int / double
            nr = Integer.parseInt(nr_locuri.getText());
            t=  Integer.parseInt(timp_.getText());
            p = Double.parseDouble(pret_.getText());

            //ADD
            result1 = AirlineApi.AddFlight(Conn, Url, User, Password, tara.getText(), oras.getText(), aeroport.getText(), tara2.getText(), oras2.getText(), aeroport2.getText(), nr, tip, companie_.getText());
            result2 = AirlineApi.AddDates(Conn, Url, User, Password, data_plecarii.getText(), ora_plecare.getText(),data_sosirii.getText(), ora_sosire.getText(), t, p);

            if(result1 > 0 && result2 > 0)
            {
                id1 = AirlineApi.SelectFlight(Conn, Url, User, Password, tara.getText(), oras.getText(), aeroport.getText(), tara2.getText(), oras2.getText(), aeroport2.getText(), nr, tip, companie_.getText());
                id2 = AirlineApi.SelectDate(Conn, Url, User, Password, data_plecarii.getText(), ora_plecare.getText(),data_sosirii.getText(), ora_sosire.getText(), t, p);

                if (id1 > 0 && id2 >0 )
                {
                    result3 = AirlineApi.AddFlightDate(Conn, Url, User, Password, id1, id2);
                    JOptionPane.showMessageDialog(frame, "Inseararea a fost facuta cu succes!");
                    ShowFlights(childPanel4);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Inseararea nu a reusit!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Toate campurile trebuiesc completate!");
        }
    }

    public void UpdateState() {
        int result = -1;
        if(id_.getText().length() > 0 && stare_.getSelectedItem().toString().length() > 0) {
            int id = Integer.parseInt(id_.getText());
            result = AirlineApi.UpdateState(Conn, Url, User, Password, id, stare_.getSelectedItem().toString());
            if(result > 0)
            {
                JOptionPane.showMessageDialog(frame, "Modificare facuta cu succes!");
                ShowFlights(childPanel4);
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Modificarea nu a reusit!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Toate campurile trebuiesc completate!");
        }
    }

    public void UpdateSeats() {
        int result = -1;
        if(id_.getText().length() > 0 && locuri.getText().length() > 0) {

            int id = Integer.parseInt(id_.getText());
            int nr = Integer.parseInt(locuri.getText());

            result = AirlineApi.UpdateSeats(Conn, Url, User, Password, id, nr);
            if(result > 0)
            {
                JOptionPane.showMessageDialog(frame, "Modificare facuta cu succes!");
                ShowFlights(childPanel4);
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Modificarea nu a reusit!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Toate campurile trebuiesc completate!");
        }
    }

    public void DeleteFlight() {
        int result = -1;
        if(id_.getText().length() > 0) {

            int id = Integer.parseInt(id_.getText());

            result = AirlineApi.DeleteFlight(Conn, Url, User, Password, id);
            if(result > 0)
            {
                JOptionPane.showMessageDialog(frame, "Stergere facuta cu succes!");
                ShowFlights(childPanel4);
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Stergerea nu a reusit!");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Toate campurile trebuiesc completate!");
        }
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        AirlineApi = new AirlineApi();
        frame = new JFrame();
        frame.setBounds(100, 100, 871, 669);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //create a toolbar and add it directly to the Frame
        toolBar = new JToolBar();
        toolBar.setEnabled(false);
        frame.getContentPane().add(toolBar);
        toolBar.setBackground(new Color(0, 204, 255));
        toolBar.setBounds(0, 0, 2500, 77);

        //create buttons
        butonInregistrare = new JButton("    Inregistrare   ");
        butonInregistrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreatePanel1();
            }
        });
        butonInregistrare.setFont(new Font("Verdana", Font.PLAIN, 16));
        butonInregistrare.setBackground(new Color(204, 255, 255));
        butonInregistrare.setBorder(new LineBorder(Color.BLACK));
        toolBar.add(butonInregistrare);

        butonAutentificare = new JButton("    Autentificare     ");
        butonAutentificare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreatePanel2();
            }
        });
        butonAutentificare.setFont(new Font("Verdana", Font.PLAIN, 16));
        butonAutentificare.setBorder(new LineBorder(Color.BLACK));
        butonAutentificare.setBackground(new Color(204, 255, 255));
        toolBar.add(butonAutentificare);

        operatiiClient = new JButton("    Operatii Client      ");
        operatiiClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreatePanel3();
            }
        });
        operatiiClient.setFont(new Font("Verdana", Font.PLAIN, 16));
        operatiiClient.setBorder(new LineBorder(Color.BLACK));
        operatiiClient.setBackground(new Color(204, 255, 255));
        operatiiClient.setVisible(false);
        toolBar.add(operatiiClient);

        operatiiAdmin = new JButton("    Operatii Admin    ");
        operatiiAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreatePanel4();
            }
        });
        operatiiAdmin.setFont(new Font("Verdana", Font.PLAIN, 16));
        operatiiAdmin.setBorder(new LineBorder(Color.BLACK));
        operatiiAdmin.setBackground(new Color(204, 255, 255));
        operatiiAdmin.setVisible(false);
        toolBar.add(operatiiAdmin);

        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        parentPanel = new JPanel();
        parentPanel.setBounds(0, 78, 2500, 549);
        frame.getContentPane().add(parentPanel);
        parentPanel.setLayout(null);

        CreatePanel1();


    }
}

