package src.clienti;

import src.classes.User;
import src.classes.Restaurant;
import src.gui.components.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.pages.C_Login;
import src.gui.pages.C_Register;
import src.gui.pages.C_Register2;
import src.gui.pages.C_Register3;
import src.gui.pages.C_Search;
import src.util.*;

public class Clienti {
  private FWindow mainWindow;
  private C_Login loginPage;
  private C_Register registerPage;
  private C_Register2 registerPage2;
  private C_Register3 registerPage3;
  private C_Search searchPage;
  private boolean canChangePage;

  private static User user;
  private static List<Restaurant> restaurants;

  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new Clienti(); }
    });
  }

  public Clienti() {
    registerFonts();
    user = null;
    restaurants = FileManager.GetRestaurants();

    mainWindow = new FWindow("FoodAdvisor Clienti");

    loginPage = new C_Login();

    changePage(loginPage.getPage());
    addLoginPageListeners();

    mainWindow.setVisible(true);
    loginPage.getPage().requestFocusInWindow();
  }

  /** Registra un nuovo utente inserendolo nel file "Utenti.dati"
  * @param user Oggetto User da registrare
  * @return Esito della registrazione (boolean) */
  public static boolean RegisterNewUser(User user) {
      return FileManager.SaveUser(user);
  }

  /** Autentica l'account di un cliente
   * @param nickname Nickname da autenticare
   * @param password Password da autenticare
   * @return Esito dell'autenticazione (boolean) */
  public static boolean AuthenticateUser(String email, String password) {
    // Array di stringhe contenente l'intero contenuto del file Utenti.dati 
    String[] records = FileManager.GetFileRecords("Utenti.dati");
    // Se la stringa in posizione 0 ritornata dal metodo per leggere
    // dal file è "Error" ritorno (false), l'autenticazione non è
    // andata a buon fine, altrimenti continuo
    if(records.length == 0) return false;
    // Per ognuno dei record (utenti) controllo se l'email e
    // la password inseriti dall'utente che desidera accedere corrispondono
    for(String record: records) {
        // Splitto il record corrente per i suoi campi
        String[] fields = record.split("\\|");
        // Field 5 => Email, Field 6 => Hashed password
        String inputPasswordHash = Security.GetHash(password);
        if(fields[5].equals(email) && fields[6].equals(inputPasswordHash)) {
            // Accesso riuscito correttamente
            //nickname, nome, cognome, comune, provincia, email, password(hash)
            user = new User(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6]);
            return true;
        }
    }
    return false;
  }

  public void addLoginPageListeners() {
    loginPage.login_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        canChangePage &= validateField(loginPage.email_tf, "Email");
        canChangePage &= validateField(loginPage.password_pf, "Password");

        if(canChangePage) {
          String email = loginPage.email_tf.getText();
          String password = String.valueOf(loginPage.password_pf.getPassword());

          if(AuthenticateUser(email, password)) {
            emptyFields();
            searchPage = new C_Search(user.GetNickname());
            addSearchPageListeners();
            changePage(searchPage.getPage());
          } else {
            emptyField(loginPage.email_tf, "Email");
            emptyField(loginPage.password_pf, "Password");
            validateField(loginPage.email_tf, "Email");
            validateField(loginPage.password_pf, "Password");
          }
        }
      }
    });

    loginPage.register_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        emptyFields();
        registerPage  = new C_Register();
        addRegisterPageListeners();
        changePage(registerPage.getPage());
      }
    });

    loginPage.guest_lb.addMouseListener(new MouseAdapter() {
      public void mouseClicked(final MouseEvent e) {
        searchPage = new C_Search("Guest");
        addSearchPageListeners();
        changePage(searchPage.getPage());
      }
    });
  }

  public void addRegisterPageListeners() {
    registerPage.back_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(loginPage.getPage());
      }
    });

    registerPage.continue_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
         /* TO DO: Controllo nickname */
         canChangePage = true;

         if (registerPage.nick_tf.getText().length() > 20 || 
         registerPage.nick_tf.getText().length() < 5) 
          emptyField(registerPage.nick_tf, "Nickname");

         canChangePage &= validateField(registerPage.nick_tf, "Nickname");
         canChangePage &= validateField(registerPage.name_tf, "Nome");
         canChangePage &= validateField(registerPage.surname_tf, "Cognome");
 
         if(canChangePage) { 
            registerPage2 = new C_Register2();
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

    registerPage2.continue_btn.addMouseListener(new MouseInputAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        canChangePage &= validateField(registerPage2.town_tf, "Comune");
        canChangePage &= validateField(registerPage2.district_tf, "Provincia");

        if(canChangePage) {
          registerPage3 = new C_Register3();
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

        String pass1 = String.valueOf(registerPage3.password1_pf.getPassword());
        String pass2 = String.valueOf(registerPage3.password2_pf.getPassword());

        if(!pass1.equals(pass2)) {
          emptyField(registerPage3.password1_pf, "Password");
          emptyField(registerPage3.password2_pf, "Password");
        }

        canChangePage &= validateField(registerPage3.email_tf, "Email");
        canChangePage &= validateField(registerPage3.password1_pf, "Password");
        canChangePage &= validateField(registerPage3.password2_pf, "Password");

        if(canChangePage) {
          // Registra l'utente
          // nickname, nome, cognome, comune, provincia, email, password(hash)
          String nickname = registerPage.nick_tf.getText();
          String name     = registerPage.name_tf.getText();
          String surname  = registerPage.surname_tf.getText();

          String town = registerPage2.town_tf.getText();
          String district = registerPage2.district_tf.getText();

          String email = registerPage3.email_tf.getText();
          String hashedPsw = Security.GetHash(pass1);

          User user = new User(nickname,name,surname,town,district,email,hashedPsw);
          
          String result = RegisterNewUser(user) ? "Registrazione effettuata con successo" 
                                                : "Registrazione fallita, ritenta.";

          JOptionPane.showMessageDialog(null, result, "Registrazione", JOptionPane.PLAIN_MESSAGE);
          
          emptyFields();
          changePage(loginPage.getPage());
        }
      }
    });
  }

  public void addSearchPageListeners() {
    searchPage.searchBar_tb.getDocument().addDocumentListener(new DocumentListener(){
      public void removeUpdate(DocumentEvent e) {updateRestaurantsList();}
    
      public void insertUpdate(DocumentEvent e) {updateRestaurantsList();}
    
      public void changedUpdate(DocumentEvent e) {updateRestaurantsList();}

      public void updateRestaurantsList() {
        String value = searchPage.searchBar_tb.getText().toLowerCase();

        List<Restaurant> filteredList = FilterListBy(restaurants, "Name", new String[] {value});

        System.out.println("\n\n");
        for(Restaurant r: filteredList) {
          System.out.println(r.GetName() + "\n");
        }
      }

    });

    searchPage.backIcon_lbl.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(loginPage.getPage());
      }
    });
  }

  /**
   * Filtra una lista data in input in base ad un parametro
   * @param list Lista di oggetti Restaurant originale da filtrare
   * @param filterType Stringa rappresentante l'attributo da filtrare: (Town, Typology, Name, Town&Typology)
   * @param values Array di stringhe contenenti i valori per cui filtrare
   * @return Lista di ristoranti filtrata */
  public static List<Restaurant> FilterListBy(List<Restaurant> list, String filterType, String[] values) {
    /* FORMATO RECORD RISTORANTE */
    /* 2|Mesopotamia|Via|Isonzo|10|Azzate|VA|21022|3883085877|https://www.google.it/|Fusion */
    
    if(list.isEmpty()) return new ArrayList<Restaurant>();
    if(values[0].equals("")) return new ArrayList<Restaurant>();
    
    Predicate<Restaurant> filter;
      switch(filterType) {
          case "Town": 
              filter = restaurant -> restaurant.GetAddress().GetTownName().toLowerCase().equals(values[0]);
              break;

          case "Typology":
              filter = restaurant -> restaurant.GetType().toString().toLowerCase().equals(values[0]);
              break;

          case "Name":
              filter = restaurant -> restaurant.GetName().toLowerCase().contains(values[0]);
              break;

          case "Town&Typology":
              list = FilterListBy(list, "Town", new String[] {values[0]});
              if(list.isEmpty()) return new ArrayList<Restaurant>();
              filter = restaurant -> restaurant.GetType().toString().toLowerCase().equals(values[1]);
              break;

          default:
              filter = restaurant -> restaurant.toString() != null;
              break;
      }

      List<Restaurant> filteredList = list.stream()
          .filter(filter)
          .collect(Collectors.toList());

      return filteredList;
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
    if(loginPage != null) {
      loginPage.email_tf.setText("Email");
      loginPage.email_tf.setForeground(Color.GRAY);
      loginPage.password_pf.setText("Password");
      loginPage.password_pf.setForeground(Color.GRAY);
    }

    if(registerPage != null) {
      registerPage.nick_tf.setText("Nickname");
      registerPage.nick_tf.setForeground(Color.GRAY);
      registerPage.name_tf.setText("Nome");
      registerPage.name_tf.setForeground(Color.GRAY);
      registerPage.surname_tf.setText("Cognome");
      registerPage.surname_tf.setForeground(Color.GRAY);
    }

    if(registerPage2 != null) {
      registerPage2.town_tf.setText("Comune");
      registerPage2.town_tf.setForeground(Color.GRAY);
      registerPage2.district_tf.setText("Provincia");
      registerPage2.district_tf.setForeground(Color.GRAY);
    }

    if(registerPage3 != null) {
      registerPage3.email_tf.setText("Email");
      registerPage3.email_tf.setForeground(Color.GRAY);
      registerPage3.password1_pf.setText("Password");
      registerPage3.password1_pf.setForeground(Color.GRAY);
      registerPage3.password2_pf.setText("Password");
      registerPage3.password2_pf.setForeground(Color.GRAY);
    }
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

    } else if(field instanceof FPasswordField) {
      String value = String.valueOf(((FPasswordField)field).getPassword());
      if(value.equals(placeholder)) {
        ((FPasswordField)field).setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        return false;
      } else {
        ((FPasswordField)field).setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        return true;
      }
    }
    return false;
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
