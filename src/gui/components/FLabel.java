package src.gui.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class FLabel extends JLabel {
    /***/
    private static final long serialVersionUID = 1L;
    
    public FLabel() {
        super();
    }

    public FLabel(String text, Font font) {
        super(text);
        this.setFont(font);
    }
    
    public FLabel(String imgPath) {
        super(new ImageIcon(imgPath));
    }

    public void autoSetBounds(int win_width, int width, int height, int ycoord) {
        int xcoord = (win_width-width)/2;
        this.setBounds(xcoord, ycoord, width, height);
    }
}