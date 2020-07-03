package src.gui.pages;

import java.awt.*;

import src.classes.Address;
import src.classes.Restaurant;
import src.classes.User;
import src.gui.components.FLabel;
import src.gui.components.FPage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent; 

public class C_RestaurantInfo {
    
    private FPage page;
    private GridBagConstraints gbc;
    public FLabel backIcon_lbl;
    private FLabel userIcon_lbl;
    private FLabel userName_lbl;
    private FLabel restName_lbl;
    private FLabel restImage_lbl;
    private FLabel ratings_lbl;
    private FPage body;

    public FPage getPage() {
        return page;
    }

    public C_RestaurantInfo(User user, Restaurant restaurant) {
        //Setup base della pagina
        page = new FPage(new BorderLayout());
        
        int topMargin = 0;

        FPage header = new FPage();
        gbc = new GridBagConstraints();
        //Label con immagine freccia sx
        backIcon_lbl = new FLabel("assets/BackIcon.png");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.06;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(topMargin,0,0,0);
        setGridCoordinatesXY(gbc, 0, 0);
        header.add(backIcon_lbl, gbc);

        //Label di gap
        FLabel gap_lbl = new FLabel();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(topMargin,0,0,0);
        gbc.weightx = 0.8;
        setGridCoordinatesXY(gbc, 1, 0); 
        header.add(gap_lbl, gbc);

        //Label con l'immagine guest o user
        String iconPath = user != null ? "assets/UserIcon.png" : "assets/GuestIcon.png";
        userIcon_lbl = new FLabel(iconPath);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.06;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(topMargin,0,0,0);
        setGridCoordinatesXY(gbc, 2, 0);
        header.add(userIcon_lbl, gbc);

        //Label per display username
        String username = user != null ? user.GetNickname() : "Guest";
        userName_lbl = new FLabel(username, new Font("Manrope Regular", Font.PLAIN, 25));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.weightx = 0.03;
        setGridCoordinatesXY(gbc, 3, 0);
        gbc.insets = new Insets(topMargin,0,0,0);
        header.add(userName_lbl, gbc);
        
        page.add(header, BorderLayout.PAGE_START);

        body = new FPage();
        gbc = new GridBagConstraints();

        //Label con l'immagine del ristorante
        String imagePath = null;

        if(restaurant.GetType().toString().equals("Italiano")) 
            imagePath = "assets/Pizza.png";
        else if(restaurant.GetType().toString().equals("Etnico")) 
            imagePath = "assets/Hamburger.png";
        else if(restaurant.GetType().toString().equals("Fusion")) 
            imagePath = "assets/Sushi.png";

        restImage_lbl = new FLabel(imagePath);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,100,0);
        setGridCoordinatesXY(gbc, 0, 0);
        body.add(restImage_lbl, gbc);

        FPage rightSide = new FPage();

        //Label per display nome ristorante
        restName_lbl = new FLabel(restaurant.GetName(), new Font("Manrope Medium", Font.PLAIN, 80));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        setGridCoordinatesXY(gbc, 0, 0);
        gbc.insets = new Insets(0,50,0,0);
        gbc.gridwidth = 2;
        rightSide.add(restName_lbl, gbc);

        gbc = new GridBagConstraints();

        //Label con immagine stelle di rating
        ratings_lbl = new FLabel("assets/3Stars.png");
        gbc.insets = new Insets(0, 50, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 0, 1);
        rightSide.add(ratings_lbl, gbc);
        
        FLabel ratingsText_lbl = new FLabel("<html>23 recensioni, <font color='blue'>visualizza</font></html>", new Font("Manrope Regular", Font.PLAIN, 20));
        gbc.insets = new Insets(0, 15, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 1, 1);
        rightSide.add(ratingsText_lbl, gbc);
        //Azioni della label
        ratingsText_lbl.addMouseListener(new MouseAdapter() {
            public void mouseEntered(final MouseEvent e) {
                //"Ospite" scritto in rosso se ci si avvicina con il mouse 
                ratingsText_lbl.setText("<html>23 recensioni, <font color='red'>visualizza</font></html>");
            }
            public void mouseExited(final MouseEvent e) {
                //"Ospite" scritto in blu se ci si allontana con il mouse
                ratingsText_lbl.setText("<html>23 recensioni, <font color='blue'>visualizza</font></html>");
            }
        });

        FPage infoBox = new FPage();
        gbc = new GridBagConstraints();

        //Label con immagine stelle di rating
        FLabel location_lbl = new FLabel("assets/LocationIcon.png");
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 0, 0);
        infoBox.add(location_lbl, gbc);

        Address address = restaurant.GetAddress();
        String addressType = address.GetType().toString();
        String addressName = address.GetStreetName();
        String addressNumber = String.valueOf(address.GetStreetNumber());
        String zipcode = String.valueOf(address.GetZipCode());
        String town = address.GetTownName();
        String district = address.GetDistrict();

        String restAddress = String.format("%s %s %s, %s %s %s", addressType, addressName, addressNumber, zipcode, town, district);
        FLabel locationTxt_lbl = new FLabel(restAddress, new Font("Manrope Regular", Font.PLAIN, 20));
        gbc.insets = new Insets(0, 15, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 1, 0);
        infoBox.add(locationTxt_lbl, gbc);

        FLabel website_lbl = new FLabel("assets/WebsiteIcon.png");
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 0, 1);
        infoBox.add(website_lbl, gbc);

        String website = restaurant.GetURL().toString();
        FLabel websiteTxt_lbl = new FLabel(website, new Font("Manrope Regular", Font.PLAIN, 20));
        gbc.insets = new Insets(15, 15, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 1, 1);
        infoBox.add(websiteTxt_lbl, gbc);

        FLabel telephone_lbl = new FLabel("assets/TelephoneIcon.png");
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 0, 2);
        infoBox.add(telephone_lbl, gbc);

        String telnumber = restaurant.GetPhoneNumber().toString();
        FLabel telephoneTxt_lbl = new FLabel(telnumber, new Font("Manrope Regular", Font.PLAIN, 20));
        gbc.insets = new Insets(15, 15, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 1, 2);
        infoBox.add(telephoneTxt_lbl, gbc);
        
        FLabel restTypology_lbl = new FLabel("assets/RestTypologyIcon.png");
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 0, 3);
        infoBox.add(restTypology_lbl, gbc);

        String typology = restaurant.GetType().toString();
        FLabel restTypologyTxt_lbl = new FLabel(typology, new Font("Manrope Regular", Font.PLAIN, 20));
        gbc.insets = new Insets(15, 15, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        setGridCoordinatesXY(gbc, 1, 3);
        infoBox.add(restTypologyTxt_lbl, gbc);
        
        gbc = new GridBagConstraints();
        setGridCoordinatesXY(gbc, 0, 2);
        gbc.insets = new Insets(25, 50, 100, 0);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 2;
        rightSide.add(infoBox, gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0,50,70,0);
        setGridCoordinatesXY(gbc, 1, 0);
        body.add(rightSide, gbc);

        page.add(body, BorderLayout.CENTER);
    }

    //Metodo per settare le coordinate più efficacemente
    public static void setGridCoordinatesXY(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}