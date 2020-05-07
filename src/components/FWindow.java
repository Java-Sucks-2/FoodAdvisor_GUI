package src.components;

import javax.swing.JFrame;

public class FWindow extends JFrame {
    /***/
    private static final long serialVersionUID = 1L;
    
    public FWindow(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        this.setBounds(100, 100, 960, 540);
    }
}