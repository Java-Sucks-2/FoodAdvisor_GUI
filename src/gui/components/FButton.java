package src.gui.components;

import java.awt.Color;
import java.awt.Dimension;
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
        this.setFont(new Font("Manrope", Font.PLAIN, 22));
        this.setFocusPainted(false);
        this.setContentAreaFilled(true);
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(100, 45));
    }

    public void autoSetBounds(int win_width, int width, int height, int ycoord) {
        int xcoord = (win_width-width)/2;
        this.setBounds(xcoord, ycoord, width, height);
    }
}