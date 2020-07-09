package src.gui.pages;

import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import src.classes.Restaurant;
import src.classes.User;
import src.gui.components.FLabel;
import src.gui.components.FPage;
import src.gui.components.FButton;
import src.gui.components.FComboBox;
import src.gui.components.FTextField;

public class C_Reviews {
    private FPage page;
    private GridBagConstraints gbc;
    public  FLabel backIcon_lbl;
    private FLabel userIcon_lbl;
    private FLabel userName_lbl;
    private FLabel restName_lbl;
    private FLabel restImage_lbl;
    private FPage body;
    
    public FPage getPage() {
        return page;
    }    

    public C_Reviews(User user, Restaurant restaurant) {
      //Setup base della pagina
      page = new FPage(new BorderLayout());
        
      int topMargin = 20;

      FPage header = new FPage();
      gbc = new GridBagConstraints();
      //Label con immagine freccia sx
      try {
          backIcon_lbl = new FLabel("assets/BackIcon.png");
      } catch(IOException e) {
          // Exit
      }
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
      try {
          userIcon_lbl = new FLabel(iconPath);
      } catch(IOException e) {
          // Exit
      }
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

      try {
          restImage_lbl = new FLabel(imagePath);
      } catch(IOException e) {
          // Exit
      }
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.insets = new Insets(0,0,100,0);
      setGridCoordinatesXY(gbc, 0, 0);
      body.add(restImage_lbl, gbc);

      FPage rightSide = new FPage();

      //Label per display nome ristorante
      restName_lbl = new FLabel(restaurant.GetName(), new Font("Manrope Medium", Font.PLAIN, 80));
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.CENTER;
      setGridCoordinatesXY(gbc, 0, 0);
      gbc.insets = new Insets(0,0,0,0);
      gbc.gridwidth = 2;
      rightSide.add(restName_lbl, gbc);

      //FPage 

      gbc = new GridBagConstraints();
      gbc.insets = new Insets(0,50,150,0);
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