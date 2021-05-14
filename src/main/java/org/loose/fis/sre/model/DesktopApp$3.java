package org.loose.fis.sre.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class DesktopApp$3 implements ActionListener {
    DesktopApp$3(DesktopApp var1) {
        this.this$0 = var1;
    }

    public void actionPerformed(ActionEvent e) {
        int result = false;
        String nume_utilizator = this.this$0.nume_utilizator2.getText();
        String parola = new String(this.this$0.parola2.getPassword());
        int result = this.this$0.AirlineApi.GetUser(this.this$0.Conn, this.this$0.Url, this.this$0.User, this.this$0.Password, nume_utilizator, parola);
        if (result == -1) {
            JOptionPane.showMessageDialog(this.this$0.frame, "Numele si parola nu sunt corecte! Incercati din nou.");
            this.this$0.nume_utilizator2.setText("");
            this.this$0.parola2.setText("");
        } else if (result == 0) {
            JOptionPane.showMessageDialog(this.this$0.frame, "Bun venit! Puteti accesa sectiunea operatii client.");
            this.this$0.operatiiClient.setVisible(true);
            this.this$0.CreatePanel3();
        } else if (result == 1) {
            JOptionPane.showMessageDialog(this.this$0.frame, "Bun venit! Puteti accesa sectiunea operatii admin.");
            this.this$0.operatiiAdmin.setVisible(true);
            this.this$0.CreatePanel4();
        }

        this.this$0.childPanel2.revalidate();
        this.this$0.childPanel2.repaint();
    }
}
