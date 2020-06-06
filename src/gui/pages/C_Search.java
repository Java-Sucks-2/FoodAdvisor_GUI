package src.gui.pages;

import src.gui.components.*;
import java.awt.*;

public class C_Search {
    private FPage page;
    private GridBagConstraints gbc;

    private FLabel bottomImage;

    public FPage getPage() {
        return page;
    }

    public C_Search() {
        page = new FPage();
        gbc = new GridBagConstraints();

        bottomImage = new FLabel("assets/BottomImageBanner.png");
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.anchor = GridBagConstraints.LAST_LINE_END;
        //gbc.insets = new Insets(0,0,0,0);
        setGridCoordinatesXY(gbc, 0, 0);
        page.add(bottomImage, gbc);
    }

    public static void setGridCoordinatesXY(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}