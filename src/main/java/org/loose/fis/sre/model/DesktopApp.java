package org.loose.fis.sre.model;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;

public class DesktopApp {
    private JFrame frame;
    private JToolBar toolBar;
    private JButton butonInregistrare;
    private JButton butonAutentificare;
    private JRadioButton client;
    private JRadioButton admin;
    private JButton inregistrare;
    private JTextField nume_utilizator;
    private JTextField prenume_nume;
    private JTextField adresa;
    private JTextField telefon;
    private JPanel parentPanel;
    private JPanel childPanel1;
    private JPanel childPanel2;
    private JPasswordField parola;
    private JTextField nume_utilizator2;
    private JPasswordField parola2;
    private JButton autentificare;
    private JPanel childPanel3;
    private JPanel childPanel4;
    private AirlineApi AirlineApi;
    private String Url = "jdbc:mysql://localhost:3306/airline";
    private String User = "root";
    private String Password = "familiabodin";
    private Connection Conn = null;
    private JButton operatiiClient;
    private JButton operatiiAdmin;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DesktopApp window = new DesktopApp();
                    window.frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public DesktopApp() {
        this.initialize();
    }

    public void CreatePanel1() {
        if (this.childPanel2 != null) {
            this.parentPanel.remove(this.childPanel2);
            this.parentPanel.revalidate();
            this.parentPanel.repaint();
        }

        this.operatiiClient.setVisible(false);
        this.operatiiAdmin.setVisible(false);
        this.frame.getContentPane().revalidate();
        this.frame.getContentPane().repaint();
        this.childPanel1 = new JPanel();
        this.childPanel1.setBounds(10, 0, 837, 538);
        this.parentPanel.add(this.childPanel1);
        this.childPanel1.setLayout((LayoutManager)null);
        this.client = new JRadioButton("Client");
        this.client.setFont(new Font("Verdana", 0, 16));
        this.client.setBounds(333, 66, 181, 55);
        this.childPanel1.add(this.client);
        this.admin = new JRadioButton("Admin");
        this.admin.setFont(new Font("Verdana", 0, 16));
        this.admin.setBounds(538, 66, 181, 55);
        this.childPanel1.add(this.admin);
        JLabel alegeRol = new JLabel("Alege un rol:");
        alegeRol.setFont(new Font("Verdana", 0, 16));
        alegeRol.setBounds(103, 66, 166, 55);
        this.childPanel1.add(alegeRol);
        JLabel titlu = new JLabel("Inregistrare");
        titlu.setForeground(Color.BLACK);
        titlu.setBackground(Color.YELLOW);
        titlu.setFont(new Font("Verdana", 0, 18));
        titlu.setBounds(313, 0, 166, 55);
        this.childPanel1.add(titlu);
        JLabel numeUtilizatorLabel = new JLabel("Nume utilizator:");
        numeUtilizatorLabel.setFont(new Font("Verdana", 0, 16));
        numeUtilizatorLabel.setBounds(185, 163, 156, 31);
        this.childPanel1.add(numeUtilizatorLabel);
        JLabel parolaLabel = new JLabel("Parola:");
        parolaLabel.setFont(new Font("Verdana", 0, 16));
        parolaLabel.setBounds(185, 228, 123, 31);
        this.childPanel1.add(parolaLabel);
        JLabel prenumeNumeLabel = new JLabel("Prenume Nume:");
        prenumeNumeLabel.setFont(new Font("Verdana", 0, 16));
        prenumeNumeLabel.setBounds(185, 292, 140, 31);
        this.childPanel1.add(prenumeNumeLabel);
        JLabel adresaLabel = new JLabel("Adresa:");
        adresaLabel.setFont(new Font("Verdana", 0, 16));
        adresaLabel.setBounds(185, 354, 114, 31);
        this.childPanel1.add(adresaLabel);
        JLabel telefonLabel = new JLabel("Telefon:");
        telefonLabel.setFont(new Font("Verdana", 0, 16));
        telefonLabel.setBounds(185, 408, 114, 31);
        this.childPanel1.add(telefonLabel);
        this.nume_utilizator = new JTextField();
        this.nume_utilizator.setBounds(351, 163, 216, 38);
        this.childPanel1.add(this.nume_utilizator);
        this.nume_utilizator.setColumns(10);
        this.prenume_nume = new JTextField();
        this.prenume_nume.setColumns(10);
        this.prenume_nume.setBounds(351, 292, 216, 38);
        this.childPanel1.add(this.prenume_nume);
        this.adresa = new JTextField();
        this.adresa.setColumns(10);
        this.adresa.setBounds(351, 354, 216, 38);
        this.childPanel1.add(this.adresa);
        this.telefon = new JTextField();
        this.telefon.setColumns(10);
        this.telefon.setBounds(351, 408, 216, 38);
        this.childPanel1.add(this.telefon);
        this.parola = new JPasswordField();
        this.parola.setBounds(351, 224, 216, 38);
        this.childPanel1.add(this.parola);
        this.inregistrare = new JButton("INREGISTRARE");
        this.inregistrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = 0;
                String parolaString = new String(DesktopApp.this.parola.getPassword());
                UserModel user;
                if (DesktopApp.this.client.isSelected()) {
                    if (DesktopApp.this.nume_utilizator.getText().length() > 0 && parolaString.length() > 0 && DesktopApp.this.prenume_nume.getText().length() > 0 && DesktopApp.this.adresa.getText().length() > 0 && DesktopApp.this.telefon.getText().length() > 0) {
                        user = new UserModel(DesktopApp.this.nume_utilizator.getText(), parolaString, DesktopApp.this.prenume_nume.getText(), DesktopApp.this.adresa.getText(), DesktopApp.this.telefon.getText(), 0);
                        result = DesktopApp.this.AirlineApi.AddUser(DesktopApp.this.Conn, DesktopApp.this.Url, DesktopApp.this.User, DesktopApp.this.Password, user);
                    }
                } else if (DesktopApp.this.admin.isSelected() && DesktopApp.this.nume_utilizator.getText().length() > 0 && parolaString.length() > 0 && DesktopApp.this.prenume_nume.getText().length() > 0 && DesktopApp.this.adresa.getText().length() > 0 && DesktopApp.this.telefon.getText().length() > 0) {
                    user = new UserModel(DesktopApp.this.nume_utilizator.getText(), parolaString, DesktopApp.this.prenume_nume.getText(), DesktopApp.this.adresa.getText(), DesktopApp.this.telefon.getText(), 1);
                    result = DesktopApp.this.AirlineApi.AddUser(DesktopApp.this.Conn, DesktopApp.this.Url, DesktopApp.this.User, DesktopApp.this.Password, user);
                }

                if (result == 1) {
                    JOptionPane.showMessageDialog(DesktopApp.this.frame, "Inserarea s-a facut cu succes!");
                    DesktopApp.this.CreatePanel2();
                } else {
                    JOptionPane.showMessageDialog(DesktopApp.this.frame, "Inserarea nu a reusit!");
                }

            }
        });
        this.inregistrare.setFont(new Font("Verdana", 0, 14));
        this.inregistrare.setBounds(273, 457, 202, 62);
        this.childPanel1.add(this.inregistrare);
    }

    public void CreatePanel2() {
        this.parentPanel.remove(this.childPanel1);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.operatiiClient.setVisible(false);
        this.operatiiAdmin.setVisible(false);
        this.frame.getContentPane().revalidate();
        this.frame.getContentPane().repaint();
        this.childPanel2 = new JPanel();
        this.childPanel2.setBounds(10, 0, 837, 538);
        this.childPanel2.setLayout((LayoutManager)null);
        this.parentPanel.add(this.childPanel2);
        JLabel numeUtilizatorLabel = new JLabel("Nume utilizator:");
        numeUtilizatorLabel.setFont(new Font("Verdana", 0, 16));
        numeUtilizatorLabel.setBounds(185, 163, 156, 31);
        this.childPanel2.add(numeUtilizatorLabel);
        JLabel parolaLabel = new JLabel("Parola:");
        parolaLabel.setFont(new Font("Verdana", 0, 16));
        parolaLabel.setBounds(185, 228, 123, 31);
        this.childPanel2.add(parolaLabel);
        this.nume_utilizator2 = new JTextField();
        this.nume_utilizator2.setBounds(351, 163, 216, 38);
        this.childPanel2.add(this.nume_utilizator2);
        this.nume_utilizator2.setColumns(10);
        this.parola2 = new JPasswordField();
        this.parola2.setBounds(351, 224, 216, 38);
        this.childPanel2.add(this.parola2);
        this.nume_utilizator2.setText("");
        this.parola2.setText("");
        this.autentificare = new JButton("AUTENTIFICARE");
        this.autentificare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = false;
                String nume_utilizator = DesktopApp.this.nume_utilizator2.getText();
                String parola = new String(DesktopApp.this.parola2.getPassword());
                int resultx = DesktopApp.this.AirlineApi.GetUser(DesktopApp.this.Conn, DesktopApp.this.Url, DesktopApp.this.User, DesktopApp.this.Password, nume_utilizator, parola);
                if (resultx == -1) {
                    JOptionPane.showMessageDialog(DesktopApp.this.frame, "Numele si parola nu sunt corecte! Incercati din nou.");
                    DesktopApp.this.nume_utilizator2.setText("");
                    DesktopApp.this.parola2.setText("");
                } else if (resultx == 0) {
                    JOptionPane.showMessageDialog(DesktopApp.this.frame, "Bun venit! Puteti accesa sectiunea operatii client.");
                    DesktopApp.this.operatiiClient.setVisible(true);
                    DesktopApp.this.CreatePanel3();
                } else if (resultx == 1) {
                    JOptionPane.showMessageDialog(DesktopApp.this.frame, "Bun venit! Puteti accesa sectiunea operatii admin.");
                    DesktopApp.this.operatiiAdmin.setVisible(true);
                    DesktopApp.this.CreatePanel4();
                }

                DesktopApp.this.childPanel2.revalidate();
                DesktopApp.this.childPanel2.repaint();
            }
        });
        this.autentificare.setFont(new Font("Verdana", 0, 14));
        this.autentificare.setBounds(273, 457, 202, 62);
        this.childPanel2.add(this.autentificare);
    }

    public void CreatePanel3() {
        this.parentPanel.remove(this.childPanel2);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.childPanel3 = new JPanel();
        this.childPanel3.setBounds(10, 0, 837, 538);
        this.childPanel3.setLayout((LayoutManager)null);
        this.parentPanel.add(this.childPanel3);
        JLabel locPlecare = new JLabel("Loc plecare:");
        locPlecare.setFont(new Font("Verdana", 0, 14));
        locPlecare.setBounds(185, 163, 160, 31);
        this.childPanel3.add(locPlecare);
        JLabel tipBilet = new JLabel("Tipul biletului:");
        tipBilet.setFont(new Font("Verdana", 0, 14));
        tipBilet.setBounds(185, 228, 160, 31);
        this.childPanel3.add(tipBilet);
        JLabel destinatia = new JLabel("Destinatia:");
        destinatia.setFont(new Font("Verdana", 0, 14));
        destinatia.setBounds(185, 292, 160, 31);
        this.childPanel3.add(destinatia);
        JLabel dataPlecarii = new JLabel("Data plecarii YYYY-MM-DD:");
        dataPlecarii.setFont(new Font("Verdana", 0, 14));
        dataPlecarii.setBounds(185, 354, 200, 31);
        this.childPanel3.add(dataPlecarii);
    }

    public void CreatePanel4() {
        this.parentPanel.remove(this.childPanel2);
        this.parentPanel.revalidate();
        this.parentPanel.repaint();
        this.childPanel4 = new JPanel();
        this.childPanel4.setBounds(10, 0, 837, 538);
        this.childPanel4.setLayout((LayoutManager)null);
        this.parentPanel.add(this.childPanel4);
        JLabel numeUtilizatorLabel = new JLabel("adbvabab");
        numeUtilizatorLabel.setFont(new Font("Verdana", 0, 16));
        numeUtilizatorLabel.setBounds(185, 163, 156, 31);
        this.childPanel4.add(numeUtilizatorLabel);
    }

    private void initialize() {
        this.AirlineApi = new AirlineApi();
        this.frame = new JFrame();
        this.frame.setBounds(100, 100, 871, 669);
        this.frame.setDefaultCloseOperation(3);
        this.frame.getContentPane().setLayout((LayoutManager)null);
        this.toolBar = new JToolBar();
        this.toolBar.setEnabled(false);
        this.frame.getContentPane().add(this.toolBar);
        this.toolBar.setBackground(new Color(0, 204, 255));
        this.toolBar.setBounds(0, 0, 1298, 77);
        this.butonInregistrare = new JButton("    Inregistrare   ");
        this.butonInregistrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DesktopApp.this.CreatePanel1();
            }
        });
        this.butonInregistrare.setFont(new Font("Verdana", 0, 16));
        this.butonInregistrare.setBackground(new Color(204, 255, 255));
        this.butonInregistrare.setBorder(new LineBorder(Color.BLACK));
        this.toolBar.add(this.butonInregistrare);
        this.butonAutentificare = new JButton("    Autentificare     ");
        this.butonAutentificare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DesktopApp.this.CreatePanel2();
            }
        });
        this.butonAutentificare.setFont(new Font("Verdana", 0, 16));
        this.butonAutentificare.setBorder(new LineBorder(Color.BLACK));
        this.butonAutentificare.setBackground(new Color(204, 255, 255));
        this.toolBar.add(this.butonAutentificare);
        this.operatiiClient = new JButton("    Operatii Client      ");
        this.operatiiClient.setFont(new Font("Verdana", 0, 16));
        this.operatiiClient.setBorder(new LineBorder(Color.BLACK));
        this.operatiiClient.setBackground(new Color(204, 255, 255));
        this.operatiiClient.setVisible(false);
        this.toolBar.add(this.operatiiClient);
        this.operatiiAdmin = new JButton("    Operatii Admin    ");
        this.operatiiAdmin.setFont(new Font("Verdana", 0, 16));
        this.operatiiAdmin.setBorder(new LineBorder(Color.BLACK));
        this.operatiiAdmin.setBackground(new Color(204, 255, 255));
        this.operatiiAdmin.setVisible(false);
        this.toolBar.add(this.operatiiAdmin);
        this.frame.getContentPane().revalidate();
        this.frame.getContentPane().repaint();
        this.parentPanel = new JPanel();
        this.parentPanel.setBounds(10, 78, 837, 549);
        this.frame.getContentPane().add(this.parentPanel);
        this.parentPanel.setLayout((LayoutManager)null);
        this.CreatePanel1();
    }
}