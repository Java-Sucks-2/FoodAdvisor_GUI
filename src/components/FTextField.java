package src.components;

import javax.swing.JTextField;

public class FTextField extends JTextField {
    /***/
    private static final long serialVersionUID = 1L;
    
    public FTextField(String text) {
        super(text);
    }

    public void autoSetBounds(int win_width, int width, int height, int ycoord) {
        int xcoord = (win_width-width)/2;
        this.setBounds(xcoord, ycoord, width, height);
    }
}