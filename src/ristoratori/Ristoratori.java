package src.ristoratori;

import src.classes.Address;
import src.classes.Address.TypeAddress;
import src.classes.Restaurant;
import src.classes.Restaurant.TypeRestaurant;
import src.gui.components.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import src.gui.pages.*;
import src.util.FileManager;

public class Ristoratori {
  private FWindow mainWindow;
  private R_Register registerPage;
  private R_Register2 registerPage2;
  private R_Register3 registerPage3;
  private boolean canChangePage;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new Ristoratori(); }
    });
  }

  public Ristoratori() {
    registerFonts();
    mainWindow = new FWindow("FoodAdvisor Ristoratori");
    registerPage = new R_Register();
    
    addRegisterPageListeners();
    changePage(registerPage.getPage());
    
    mainWindow.setVisible(true);
    registerPage.getPage().requestFocusInWindow();
  }

  public void addRegisterPageListeners() {
    registerPage.continue_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        if (registerPage.name_tf.getText().length() > 20 || 
            registerPage.name_tf.getText().length() < 5) 
            emptyField(registerPage.name_tf, "Nome");

        if(registerPage.number_tf.getText().length() != 10 ||
           !isNumeric(registerPage.number_tf.getText()))
           emptyField(registerPage.number_tf, "Numero di Telefono");

        if(!isURLValid(registerPage.website_tf.getText()))
          emptyField(registerPage.website_tf, "Sito Web");

        canChangePage &= validateField(registerPage.name_tf, "Nome");
        canChangePage &= validateField(registerPage.number_tf, "Numero di Telefono");
        canChangePage &= validateField(registerPage.website_tf, "Sito Web");
        canChangePage &= validateField(registerPage.type_cb, "Tipologia");

        if(canChangePage) {
          registerPage2 = new R_Register2();
          addRegisterPage2Listeners();
          changePage(registerPage2.getPage());
        }
      }
    });
  }

  public void addRegisterPage2Listeners() {
    registerPage2.back_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage.getPage());
      }
    });

    registerPage2.continue_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        if(!registerPage2.addressname_tf.getText().matches("[a-zA-Z]+"))
          emptyField(registerPage2.addressname_tf, "Nome della Via");

        if(!isNumeric(registerPage2.number_tf.getText())) 
          emptyField(registerPage2.number_tf, "Numero Civico");

        canChangePage &= validateField(registerPage2.addresstype_cb, "Tipo Indirizzo");
        canChangePage &= validateField(registerPage2.addressname_tf, "Nome della Via");
        canChangePage &= validateField(registerPage2.number_tf, "Numero Civico");

        if(canChangePage) {
          registerPage3 = new R_Register3();
          addRegisterPage3Listeners();
          changePage(registerPage3.getPage());
        }
      }
    });
  }

  public void addRegisterPage3Listeners() {
    registerPage3.back_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage2.getPage());
      }
    });

    registerPage3.continue_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        if(!registerPage3.town_tf.getText().matches("[a-zA-Z]+"))
          emptyField(registerPage3.town_tf, "Comune");

        if(registerPage3.district_tf.getText().length() != 2 ||
           !registerPage3.district_tf.getText().matches("[A-Z]+"))
           emptyField(registerPage3.district_tf, "Provincia");

        if(registerPage3.zipcode_tf.getText().length() != 5 ||
           !isNumeric(registerPage3.zipcode_tf.getText()))
           emptyField(registerPage3.zipcode_tf, "CAP");

        canChangePage &= validateField(registerPage3.town_tf, "Comune");
        canChangePage &= validateField(registerPage3.district_tf, "Provincia");
        canChangePage &= validateField(registerPage3.zipcode_tf, "CAP");

      if(canChangePage) {
        // Acquisizione del codice univoco
        // 1. Se nel file EatAdvisor.dati non ci sono records assegno il primo id
        // 2. Se esistono record incremento l'id finche' non ne trovo uno libero
        int id;
        if (FileManager.FileIsEmpty("EatAdvisor.dati")) id=0;
        else {
            boolean alreadyTaken;
            id=1;
            do {
                alreadyTaken = FileManager.GetRecordFromID("EatAdvisor.dati", Integer.toString(id)) != null;
                if (alreadyTaken) id++;
            } while(alreadyTaken);
        }
            // Creazione dell'oggetto indirizzo
            TypeAddress addressType =  TypeAddress.valueOf(registerPage2.addresstype_cb.getSelectedItem().toString());
            String addressName      =  registerPage2.addressname_tf.getText();
            int street_number       =  Integer.parseInt(registerPage2.number_tf.getText());
            String town             =  registerPage3.town_tf.getText();
            String district         =  registerPage3.district_tf.getText();
            int zipcode             =  Integer.parseInt(registerPage3.zipcode_tf.getText());

            Address tAddress = new Address(addressType, addressName, street_number, town, district, zipcode);
                    
            String restName = registerPage.name_tf.getText();
            long telNumber = Long.parseLong(registerPage.number_tf.getText());
            URL website = null;

            try { website = new URL(registerPage.website_tf.getText()); }
            catch(MalformedURLException e) { System.err.println(e); }

            TypeRestaurant restType = TypeRestaurant.valueOf(registerPage.type_cb.getSelectedItem().toString());

            // Instanzio l'oggetto Ristorante
            Restaurant tRestaurant = new Restaurant(id, restName, tAddress, telNumber, website, restType);
                
            String result = "";

            //Effettuo il salvataggio nel file di testo
            if (FileManager.SaveRestaurant(tRestaurant)) 
              result = "Registrazione del ristorante effettuata con successo!";
            else 
              result = "Registrazione fallita, ritenta.";

            JOptionPane.showMessageDialog(null, result, "Registrazione", JOptionPane.PLAIN_MESSAGE);

            emptyFields();
            changePage(registerPage.getPage());
        }
      }
    });
  }

  public void emptyField(Object field, String placeholder) {
    if(field instanceof FTextField) {
      ((FTextField)field).setText(placeholder);
      ((FTextField)field).setForeground(Color.GRAY);
    } else if(field instanceof FPasswordField) {
      ((FPasswordField)field).setText(placeholder);
      ((FPasswordField)field).setForeground(Color.GRAY);
    }
  }

  public void emptyFields() {
    registerPage.name_tf.setText("Nome");
    registerPage.name_tf.setForeground(Color.GRAY);
    registerPage.number_tf.setText("Numero di Telefono");
    registerPage.number_tf.setForeground(Color.GRAY);
    registerPage.website_tf.setText("Sito Web");
    registerPage.website_tf.setForeground(Color.GRAY);
    registerPage.type_cb.setSelectedIndex(0);

    registerPage2.addresstype_cb.setSelectedIndex(0);
    registerPage2.addressname_tf.setText("Nome della Via");
    registerPage2.addressname_tf.setForeground(Color.GRAY);
    registerPage2.number_tf.setText("Numero Civico");
    registerPage2.number_tf.setForeground(Color.GRAY);

    registerPage3.town_tf.setText("Comune");
    registerPage3.town_tf.setForeground(Color.GRAY);
    registerPage3.district_tf.setText("Provincia");
    registerPage3.district_tf.setForeground(Color.GRAY);
    registerPage3.zipcode_tf.setText("CAP");
    registerPage3.zipcode_tf.setForeground(Color.GRAY);
  }

  public boolean validateField(Object field, String placeholder) {
    if(field instanceof FTextField) {
      String value = ((FTextField)field).getText();
      if(value.equals(placeholder)) {
        ((FTextField)field).setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        return false;
      } else {
        ((FTextField)field).setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return true;
      }
    } else if (field instanceof FComboBox) {
      String value = ((FComboBox)field).getSelectedItem().toString();
      if(value.equals(placeholder)) {
        ((FComboBox)field).setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        return false;
      } else {
        ((FComboBox)field).setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return true;
      }
    }

    return false;
  }

  public boolean isNumeric(String number) {
    try {
      Long.parseLong(number);
      return true;
    } catch(NumberFormatException e) {
      return false;
    }
  }

  public boolean isURLValid(String url) {
    try {
      new URL(url);
      return true;
    } catch(MalformedURLException e) {
      return false;
    }
  }

  public void changePage(FPage newPage) {
    mainWindow.getContentPane().removeAll();
    mainWindow.getContentPane().add(newPage);
    mainWindow.repaint();
    mainWindow.revalidate();
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
}