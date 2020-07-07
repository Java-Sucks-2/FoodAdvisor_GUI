package src.gui.components;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FWindow extends JFrame {
    /**
     * Creazione di un JFrame con parametri custom
    */
    private static final long serialVersionUID = 1L;
    
    public FWindow(String title) {
        super(title);
        //Parte grafica
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        this.setBounds(0,0,1280,760);
        this.setIconImage(new ImageIcon("assets/icon.png").getImage());
        
    }
} 