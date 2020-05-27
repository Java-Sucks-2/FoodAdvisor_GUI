package src.gui.components;

import javax.swing.JComboBox;
import java.awt.Font;

public class FComboBox extends JComboBox<String> {
    /****/
    private static final long serialVersionUID = 1L;
    
    public FComboBox(String[] values, Font font) {
        super(values);
        this.setFont(font);
    }
}