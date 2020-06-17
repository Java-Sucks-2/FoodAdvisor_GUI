package src.gui.components;

import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class FList extends JList<String> {
    /***/
    private static final long serialVersionUID = 1L;

    public FList() {
        super();
        addStyle();
    }

    public FList(String[] items) {
        super(items);
        addStyle();
    }

    public void addStyle() {
        this.setFont(new Font("Manrope", Font.PLAIN, 22));
        this.setOpaque(false);
        this.setBackground(Color.WHITE);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) this.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
}