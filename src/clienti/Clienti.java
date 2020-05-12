package src.clienti;

import src.components.FButton;
import src.components.FLabel;
import src.components.FPage;
import src.components.FPasswordField;
import src.components.FTextField;
import src.components.FWindow;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class Clienti{
    public static void main(String[] args) {
		Clienti form = new Clienti();
    }
    
    public Clienti(){
        FWindow window = new FWindow("Login");
    
        int width = window.getWidth();
        int heigth = window.getHeight();
        
        FPage loginPane = new FPage();
    
        GridBagConstraints gbc = new GridBagConstraints();

        window.add(loginPane);

        FLabel title_lbl = new FLabel("Benvenuto", new Font("Calibri", Font.PLAIN, 99));
        gbc.gridx=0;
        gbc.gridy=0;

        //spacing Insets(int top, int left, int bottom, int right)
        gbc.insets = new Insets(-300,0,100,0);
        loginPane.add(title_lbl, gbc);
    
        String text = "Accedi ed iniza a cercare nuovi ristoranti";
        FLabel info_lbl = new FLabel(text, new Font("Tahoma", Font.PLAIN, 18));
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(-200,0,50,0);
        loginPane.add(info_lbl, gbc);

        FTextField email_tf = new FTextField(41);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets = new Insets(-120,0,50,0);
        loginPane.add(email_tf, gbc);

        FTextField password_pf = new FTextField(41);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets = new Insets(-60,0,50,0);
        loginPane.add(password_pf, gbc);

        FButton login_btn = new FButton("Login");
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets = new Insets(0,0,0,294);
        loginPane.add(login_btn, gbc);

        FButton register_btn = new FButton("Register");
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets = new Insets(0,269,0,0);
        loginPane.add(register_btn, gbc);
        
        window.setVisible(true);
    }
}
