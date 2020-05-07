package src.components;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class FButton extends JButton {
    /***/
	private static final long serialVersionUID = 1L;

    public FButton(String text) {
        super(text);
        AddStyle();
    }

    private void AddStyle() {
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(237, 71, 53));
        this.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.setFocusPainted(false);
        this.setContentAreaFilled(true);
        this.setBorderPainted(false);
    }
}