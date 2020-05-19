package src.gui.components;

import javax.swing.JTextField;
import java.awt.Font;

public class FTextField extends JTextField {
    /***/
    private static final long serialVersionUID = 1L;
    
    public FTextField(String text, Font font) {
        super(text);
        this.setFont(font);
        this.setHorizontalAlignment(JTextField.CENTER);
    }
    public FTextField(int value, Font font) {
        super(value);
        this.setFont(font);
        this.setHorizontalAlignment(JTextField.CENTER);
    }

    public void autoSetBounds(int win_width, int width, int height, int ycoord) {
        int xcoord = (win_width-width)/2;
        this.setBounds(xcoord, ycoord, width, height);
       // this.setBorder(border);
    }
}