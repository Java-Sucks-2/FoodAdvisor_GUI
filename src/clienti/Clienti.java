package src.clienti;

import src.gui.components.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.pages.C_Login;
import src.gui.pages.C_Register;
import src.gui.pages.C_Register2;
import src.gui.pages.C_Register3;

public class Clienti {
  private FWindow mainWindow;
  private C_Login loginPage;
  private C_Register registerPage;
  private C_Register2 registerPage2;
  private C_Register3 registerPage3;
  private boolean canChangePage;

  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      
      public void run() {
        new Clienti();
      }
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

    Border redBorder = BorderFactory.createLineBorder(Color.RED, 3);
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

    loginPage.login_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        if(loginPage.email_tf.getText().equals("Email")) {
          loginPage.email_tf.setBorder(redBorder);
          canChangePage = false;
        } else loginPage.email_tf.setBorder(border);

        if(String.valueOf(loginPage.password_pf.getPassword()).equals("Password")) {
          loginPage.password_pf.setBorder(redBorder);
          canChangePage = false;
        } else loginPage.password_pf.setBorder(border);

        if(canChangePage) {
          loginPage.email_tf.setBorder(border);
          loginPage.password_pf.setBorder(border);

          // LOGGA LO STRACAZZO DI UTENTE
        }
      }
    });

    loginPage.register_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage.getPage());
      }
    });
    
    registerPage.back_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(loginPage.getPage());
      }
    });

    registerPage.continue_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
         /* TO DO: Controllo nickname */
         canChangePage = true;

         if(registerPage.nick_tf.getText().equals("Nickname")) {
           registerPage.nick_tf.setBorder(redBorder);
           canChangePage = false;
         } else registerPage.nick_tf.setBorder(border);
 
         if(registerPage.name_tf.getText().equals("Nome")) {
           registerPage.name_tf.setBorder(redBorder);
           canChangePage = false;
         } else registerPage.name_tf.setBorder(border);
 
         if(registerPage.surname_tf.getText().equals("Cognome")) {
           registerPage.surname_tf.setBorder(redBorder);
           canChangePage = false;
         } else registerPage.surname_tf.setBorder(border);
 
         if(canChangePage){ 
           registerPage.nick_tf.setBorder(border);
           registerPage.name_tf.setBorder(border);
           registerPage.surname_tf.setBorder(border);

           changePage(registerPage2.getPage());
         }
        }
    });

    registerPage2.back_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage.getPage());
      }
    });

    registerPage2.continue_btn.addMouseListener(new MouseInputAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        if(registerPage2.town_tf.getText().equals("Comune")) {
          registerPage2.town_tf.setBorder(redBorder);
          canChangePage = false;
        } else registerPage2.town_tf.setBorder(border);

        if(registerPage2.district_tf.getText().equals("Provincia")) {
          registerPage2.district_tf.setBorder(redBorder);
          canChangePage = false;
        } else registerPage2.district_tf.setBorder(border);

        if(canChangePage){ 
          registerPage2.town_tf.setBorder(border);
          registerPage2.district_tf.setBorder(border);

          changePage(registerPage3.getPage());
        }
      }
    });

    registerPage3.back_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage2.getPage());
      }
    });

    registerPage3.continue_btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(final MouseEvent arg0) {
        canChangePage = true;

        if(registerPage3.email_tf.getText().equals("Email")) {
          registerPage3.email_tf.setBorder(redBorder);
          canChangePage = false;
        } else registerPage3.email_tf.setBorder(border);

        if(String.valueOf(registerPage3.password1_pf.getPassword()).equals("Password")) {
          registerPage3.password1_pf.setBorder(redBorder);
          canChangePage = false;
        } else registerPage3.password1_pf.setBorder(border);

        if(String.valueOf(registerPage3.password2_pf.getPassword()).equals("Password")) {
          registerPage3.password2_pf.setBorder(redBorder);
          canChangePage = false;
        } else registerPage3.password2_pf.setBorder(border);

        if(canChangePage){ 
          registerPage3.email_tf.setBorder(border);
          registerPage3.password1_pf.setBorder(border);
          registerPage3.password2_pf.setBorder(border);
          
          // REGISTRA LO STRACAZZO DI UTENTEEEEEEE
        }
      }
    });

    mainWindow.setVisible(true);
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
