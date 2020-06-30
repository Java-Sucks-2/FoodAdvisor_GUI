package src.gui.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class FLabel extends JLabel {
    /**
     * Creazione di una JLabel con parametri custom
    */
    private static final long serialVersionUID = 1L;
    
    public FLabel() {
        super();
    }

    //Parte grafica
    public FLabel(String text, Font font) {
        super(text);
        this.setFont(font);
    }
    
    //Per utilizzare una JLabel come immagine
    public FLabel(String imgPath) {
        super(new ImageIcon(imgPath));
    }

}