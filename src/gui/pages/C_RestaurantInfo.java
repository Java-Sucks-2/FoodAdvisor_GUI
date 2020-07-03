package src.gui.pages;

import java.awt.*;
import src.classes.Restaurant;
import src.classes.User;
import src.gui.components.FLabel;
import src.gui.components.FPage;

public class C_RestaurantInfo {
    
    private FPage page;
    private GridBagConstraints gbc;
    public FLabel backIcon_lbl;
    private FLabel userIcon_lbl;
    private FLabel userName_lbl;

    public FPage getPage() {
        return page;
    }

    public C_RestaurantInfo(User user, Restaurant restaurant) {
        //Setup base della pagina
        page = new FPage();
        gbc = new GridBagConstraints();

        int topMargin = -500;

        //Label con immagine freccia sx
        backIcon_lbl = new FLabel("assets/BackIcon.png");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.06;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(topMargin,0,0,0);
        setGridCoordinatesXY(gbc, 0, 0);
        page.add(backIcon_lbl, gbc);

        //Label di gap
        FLabel gap_lbl = new FLabel();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(topMargin,0,0,0);
        gbc.weightx = 0.8;
        setGridCoordinatesXY(gbc, 1, 0);
        page.add(gap_lbl, gbc);

        //Label con l'immagine guest o user
        String iconPath = user != null ? "assets/UserIcon.png" : "assets/GuestIcon.png";
        userIcon_lbl = new FLabel(iconPath);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.06;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(topMargin,0,0,0);
        setGridCoordinatesXY(gbc, 2, 0);
        page.add(userIcon_lbl, gbc);

        //Label per display username
        String username = user != null ? user.GetNickname() : "Guest";
        userName_lbl = new FLabel(username, new Font("Manrope Regular", Font.PLAIN, 25));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.weightx = 0.03;
        setGridCoordinatesXY(gbc, 3, 0);
        gbc.insets = new Insets(topMargin,0,0,0);
        page.add(userName_lbl, gbc);
        gbc = new GridBagConstraints();
    }

    //Metodo per settare le coordinate più efficacemente
    public static void setGridCoordinatesXY(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}