package src.gui.components;

import javax.swing.JPasswordField;
import java.awt.Font;

public class FPasswordField extends JPasswordField {
    /***/
    private static final long serialVersionUID = 1L;
    
    public FPasswordField(int i, Font font) {
        super(i);
        this.setFont(font);
    }

    public void autoSetBounds(int win_width, int width, int height, int ycoord) {
        int xcoord = (win_width-width)/2;
        this.setBounds(xcoord, ycoord, width, height);
    }
}