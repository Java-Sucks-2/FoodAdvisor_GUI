package src.clienti;

import src.gui.components.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

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
  
  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new Clienti();
      }
    });
  }

  public Clienti() {
    registerFonts();
    mainWindow = new FWindow("Clienti");

    loginPage     = new C_Login();
    registerPage  = new C_Register();
    registerPage2 = new C_Register2();
    registerPage3 = new C_Register3();

    changePage(loginPage.getPage());

    loginPage.register_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage.getPage());
      }
    });
    
    registerPage.back_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(loginPage.getPage());
      }
    });

    registerPage.continue_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage2.getPage());
      }
    });

    registerPage2.back_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage.getPage());
      }
    });

    registerPage2.continue_btn.addMouseListener(new MouseInputAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage3.getPage());
      }
    });

    registerPage3.back_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage2.getPage());
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
