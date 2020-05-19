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

import src.gui.pages.Login;
import src.gui.pages.Register;
import src.gui.pages.Register2;
import src.gui.pages.Register3;

public class Clienti {
  private FWindow mainWindow;
  private Login loginPage;
  private Register registerPage;
  private Register2 registerPage2;
  private Register3 registerPage3;
  
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
    mainWindow = new FWindow("Login");

    loginPage = new Login();
    registerPage = new Register();
    registerPage2 = new Register2();
    registerPage3 = new Register3();

    mainWindow.setIconImage(new ImageIcon("assets/icon.png").getImage());

    changePage(loginPage.getPage(), loginPage.pageTitle);

    loginPage.register_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage.getPage(), registerPage.pageTitle);
      }
    });
    
    registerPage.back_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(loginPage.getPage(), loginPage.pageTitle);
      }
    });

    registerPage.continue_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage2.getPage(), registerPage.pageTitle);
      }
    });

    registerPage2.back_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage.getPage(), registerPage.pageTitle);
      }
    });

    registerPage2.continue_btn.addMouseListener(new MouseInputAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage3.getPage(), registerPage3.pageTitle);
      }
    });

    registerPage3.back_btn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(final MouseEvent arg0) {
        changePage(registerPage2.getPage(), registerPage2.pageTitle);
      }
    });

    mainWindow.setVisible(true);
  }

  public void changePage(FPage newPage, String title) {
    mainWindow.setTitle(title);
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
