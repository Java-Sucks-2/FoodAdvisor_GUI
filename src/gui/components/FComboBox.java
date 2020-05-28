package src.gui.components;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class FComboBox extends JComboBox<String> {
    /****/
    private static final long serialVersionUID = 1L;
    
    public FComboBox(String[] values, Font font) {
        super(values);
        this.setOpaque(false);
        this.setFont(font);
        this.setBackground(Color.WHITE);
        ((JLabel)this.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
}