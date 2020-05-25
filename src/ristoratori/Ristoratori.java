package src.ristoratori;

import src.gui.components.*;

import java.awt.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.SwingUtilities;

import src.gui.pages.R_Register;

public class Ristoratori {
  private FWindow mainWindow;
  private R_Register registerPage;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new Ristoratori();
      }
    });
  }

  public Ristoratori() {
    registerFonts();
    mainWindow = new FWindow("Ristoratori");
    registerPage = new R_Register();

    changePage(registerPage.getPage());

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