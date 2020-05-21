package src.ristoratori;

import src.gui.components.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.pages.Login;
import src.gui.pages.Register;
import src.gui.pages.Register2;
import src.gui.pages.Register3;

import java.awt.*;

import src.gui.components.*;

public class Ristoratori {
    private FWindow mainWindow;
    private GridBagConstraints gbc;
    // Restaurant info
    private FLabel nameLabel;
    private FTextField namField;

    private FLabel phoneLabel;
    private FTextField phoneField;

    private FLabel urLabel;
    private FTextField urlField;

    private FLabel typeLabel;
    private String[] resTypeList = { "Italiano", "Etnico", "Fiusion"};
    private JComboBox resType = new JComboBox(resTypeList);

    // Address info
    private String[] addressTypeList = {"Via", "Piazza"};
    private JComboBox addressTyoer = new JComboBox(addressTypeList);

    private FLabel addrNameLabel;
    private FTextField addrNameField;

    private FLabel streetNumberLabel;
    private JSpinner streetNumberField;

    private FLabel townLabel;
    private FTextField townField;

    private FLabel districtLabel;
    private FTextField disrictField;

    private FLabel zipCodeLabel;
    private JSpinner zipCodeField;

    

    public static void main(final String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
    
          @Override
          public void run() {
            new Ristoratori();
          }
        });
      }
      public Ristoratori(){
            registerFonts();
            mainWindow = new FWindow("Register Restaurant");
            mainWindow.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            FPage register = new FPage();
                
                    setGridCoordinatesXY(gbc, 0, 0);
                    register.add(nameLabel = new FLabel("Nome del Ristorante") , gbc);
                    
                    setGridCoordinatesXY(gbc, 0, 1);
                    register.add(addrNameField = new FTextField(38, new Font("Manrope", Font.PLAIN, 22)), gbc);

            gbc.gridx = 0;
            gbc.gridy = 0;
        mainWindow.add(register, gbc);





        mainWindow.setVisible(true);
      }
      
      public static void registerFonts() {
        try {
          final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
          ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/Manrope/static/Manrope-Bold.ttf")));
          ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/Manrope/static/Manrope-ExtraBold.ttf")));
          ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/Manrope/static/Manrope-ExtraLight.ttf")));
          ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/Manrope/static/Manrope-Light.ttf")));
          ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/Manrope/static/Manrope-Medium.ttf")));
          ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/Manrope/static/Manrope-Regular.ttf")));
          ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("assets/Manrope/static/Manrope-SemiBold.ttf")));
        }
        catch(Exception e) {
          e.printStackTrace();
        }
       
      }
      public static void setGridCoordinatesXY(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}