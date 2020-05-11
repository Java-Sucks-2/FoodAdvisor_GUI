package src.components;

import javax.swing.JPasswordField;

public class FPasswordField extends JPasswordField {
    /***/
    private static final long serialVersionUID = 1L;
    
    public FPasswordField(String text) {
        super(text);
    }

    public void autoSetBounds(int win_width, int width, int height, int ycoord) {
        int xcoord = (win_width-width)/2;
        this.setBounds(xcoord, ycoord, width, height);
    }
}