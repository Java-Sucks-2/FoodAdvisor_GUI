package src.clienti;

import src.components.*;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Clienti {
    public static void main(String[] args) {
		
		//Window Propieties
        FWindow mainWindow = new FWindow("Food Advisor");
        mainWindow.setVisible(true);
        int width = mainWindow.getWidth();
		int height = mainWindow.getHeight();
		//Icon Window
		ImageIcon img = new ImageIcon("assets/icon.png");
		mainWindow.setIconImage(img.getImage());

        FPage loginPage = new FPage();

        FLabel backgroundLbl = new FLabel();
		backgroundLbl.setBounds(0, 0, 1920, 1081);
		loginPage.add(backgroundLbl);
        backgroundLbl.setIcon(new ImageIcon("assets/background.png"));

        /*FLabel title_lbl = new FLabel("Benvenuto", new Font("Calibri", Font.BOLD, 99));
        title_lbl.autoSetBounds(width, 490, 105, 100);
        loginPage.add(title_lbl);
        
        FLabel subtitle_lbl = new FLabel("Accedi ed inizia a cercare nuovi ristoranti", new Font("Calibri", Font.PLAIN, 18));
        subtitle_lbl.autoSetBounds(width, 490, 105, 200);
        loginPage.add(subtitle_lbl);
/*
        FTextField email_txt = new FTextField("Email");
        email_txt.autoSetBounds(width, 490, 105, 300);
        loginPage.add(email_txt);

        FPasswordField password_txt = new FPasswordField("Password");
        password_txt.autoSetBounds(width, 490, 105, 400);
        loginPage.add(password_txt);*/
        
        /*FButton login_btn = new FButton("Login");
        login_btn.autoSetBounds(width, 490, 105, 500);
        loginPage.add(login_btn);
        
        FButton register_btn = new FButton("Register");
        register_btn.autoSetBounds(width, 490, 105, 600);
        loginPage.add(register_btn);

        FLabel ospite_lbl = new FLabel("<html>Oppure procedi come ospite</html>");
        ospite_lbl.autoSetBounds(width, 490, 105, 700);
		loginPage.add(ospite_lbl);*/
    
        

        mainWindow.setContentPane(loginPage);
	}
}