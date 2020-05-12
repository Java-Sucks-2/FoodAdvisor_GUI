package src.clienti;

import src.components.FLabel;
import src.components.FPage;
import src.components.FPasswordField;
import src.components.FTextField;
import src.components.FWindow;
import java.awt.Font;

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
    
        window.add(loginPane);

        FLabel title_lbl = new FLabel("Benvenuto", new Font("Calibri", Font.PLAIN, 99));
        title_lbl.setBounds((width-481)/2, (heigth-400)/2, 481, 100);
        loginPane.add(title_lbl);
    
        String text = "Accedi ed iniza a cercare nuovi ristoranti";
        FLabel info_lbl = new FLabel(text, new Font("Tahoma", Font.PLAIN, 18));
        info_lbl.setBounds((width-481)/2, (heigth-300)/2, 481, 100);
        loginPane.add(info_lbl);

        FTextField email_tf = new FTextField("-Email-");
        email_tf.setBounds((width-481)/2, (heigth-100)/2, 400, 50);
        loginPane.add(email_tf);
        
        FPasswordField password_pf = new FPasswordField("-Pass-");
        password_pf.setBounds((width-481)/2, (heigth)/2, 400, 50);
        loginPane.add(password_pf);


        //va sempre messa alla fine
        email_tf.setVisible(true);
        password_pf.setVisible(true);
        
        
    }
}
