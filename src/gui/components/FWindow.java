package src.gui.components;

import javax.swing.JFrame;

public class FWindow extends JFrame {
    /***/
    private static final long serialVersionUID = 1L;
    
    public FWindow(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);
        this.setBounds(0,0,1280,760);
        
    }
} 