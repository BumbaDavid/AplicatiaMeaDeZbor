package org.loose.fis.sre.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class DesktopApp$2 implements ActionListener {
    DesktopApp$2(DesktopApp var1) {
        this.this$0 = var1;
    }

    public void actionPerformed(ActionEvent e) {
        int result = 0;
        String parolaString = new String(this.this$0.parola.getPassword());
        User user;
        if (this.this$0.client.isSelected()) {
            if (this.this$0.nume_utilizator.getText().length() > 0 && parolaString.length() > 0 && this.this$0.prenume_nume.getText().length() > 0 && this.this$0.adresa.getText().length() > 0 && this.this$0.telefon.getText().length() > 0) {
                user = new User(this.this$0.nume_utilizator.getText(), parolaString, this.this$0.prenume_nume.getText(), this.this$0.adresa.getText(), this.this$0.telefon.getText(), 0);
                result = this.this$0.AirlineApi.AddUser(this.this$0.Conn, this.this$0.Url, this.this$0.User, this.this$0.Password, user);
            }
        } else if (this.this$0.admin.isSelected() && this.this$0.nume_utilizator.getText().length() > 0 && parolaString.length() > 0 && this.this$0.prenume_nume.getText().length() > 0 && this.this$0.adresa.getText().length() > 0 && this.this$0.telefon.getText().length() > 0) {
            user = new User(this.this$0.nume_utilizator.getText(), parolaString, this.this$0.prenume_nume.getText(), this.this$0.adresa.getText(), this.this$0.telefon.getText(), 1);
            result = this.this$0.AirlineApi.AddUser(this.this$0.Conn, this.this$0.Url, this.this$0.User, this.this$0.Password, user);
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(this.this$0.frame, "Inserarea s-a facut cu succes!");
            this.this$0.CreatePanel2();
        } else {
            JOptionPane.showMessageDialog(this.this$0.frame, "Inserarea nu a reusit!");
        }

    }
}