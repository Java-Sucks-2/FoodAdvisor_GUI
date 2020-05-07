package src.clienti;

import src.components.*;

public class Clienti {
    public static void main(String[] args) {

        FWindow mainWindow = new FWindow("App Clienti");
        mainWindow.setVisible(true);
        
        FPage registration1 = new FPage();
        FButton btn = new FButton("Test");
        btn.setBounds(100,100,50,50);
        registration1.add(btn);

        mainWindow.setContentPane(registration1);
    }
}