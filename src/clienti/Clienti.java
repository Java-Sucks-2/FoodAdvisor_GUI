package src.clienti;

import src.classes.User;
import src.gui.components.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import javax.swing.BorderFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.pages.C_Login;
import src.gui.pages.C_Register;
import src.gui.pages.C_Register2;
import src.gui.pages.C_Register3;
import src.util.FileManager;

public class Clienti {
  private FWindow mainWindow;
  private C_Login loginPage;
  private C_Register registerPage;
  private C_Register2 registerPage2;
  private C_Register3 registerPage3;
  private boolean canChangePage;

  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() { new Clienti(); }
    });
  }

  public Clienti() {
    registerFonts();

    mainWindow = new FWindow("FoodAdvisor Clienti");

    loginPage     = new C_Login();
    registerPage  = new C_Register();
    registerPage2 = new C_Register2();
    registerPage3 = new C_Register3();

    changePage(loginPage.getPage());

    addLoginPageListeners();
    addRegisterPageListeners();
    addRegisterPage2Listeners();
    addRegisterPage3Listeners();

    mainWindow.setVisible(true);
  }

  /** Registra un nuovo utente inserendolo nel file "Utenti.dati"
  * @param user Oggetto User da registrare
  * @return Esito della registrazione (boolean) */
  public static boolean RegisterNewUser(User user) {
      return FileManager.SaveUser(user);
  }

  public void addLoginPageListeners() {
    loginPage.login_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        canChangePage &= validateField(loginPage.email_tf, "Email");
        canChangePage &= validateField(loginPage.password_pf, "Password");

        if(canChangePage) {/* Logga l'utente */}
      }
    });

    loginPage.register_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage.getPage());
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

         canChangePage &= validateField(registerPage.nick_tf, "Nickname");
         canChangePage &= validateField(registerPage.name_tf, "Nome");
         canChangePage &= validateField(registerPage.surname_tf, "Cognome");
 
         if(canChangePage) changePage(registerPage2.getPage());
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

        if(canChangePage) changePage(registerPage3.getPage());
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

        canChangePage &= validateField(registerPage3.email_tf, "Email");
        canChangePage &= validateField(registerPage3.password1_pf, "Password");
        canChangePage &= validateField(registerPage3.password2_pf, "Password");

        if(canChangePage){/*REGISTRA LO STRACAZZO DI UTENTEEEEEEE*/}
      }
    });
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
