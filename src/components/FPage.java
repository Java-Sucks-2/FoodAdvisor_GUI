package src.components;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class FPage extends JPanel {
    /***/
    private static final long serialVersionUID = 1L;

    public FPage() {
        super(new GridBagLayout());
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setBackground(Color.WHITE);
    }

	public void setText(String string) {
	}
}