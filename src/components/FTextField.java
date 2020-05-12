package src.components;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FTextField extends JTextField {
    /***/
    private static final long serialVersionUID = 1L;
    
    public FTextField(String text) {
        super(text);
    }
    public FTextField(int value) {
        super(value);
    }

    public void autoSetBounds(int win_width, int width, int height, int ycoord) {
        int xcoord = (win_width-width)/2;
        this.setBounds(xcoord, ycoord, width, height);
       // this.setBorder(border);
    }
}