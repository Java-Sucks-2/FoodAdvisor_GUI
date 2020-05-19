package src.clienti;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;


public class Register {
  ImageIcon img = new ImageIcon("assets/icon.png");

  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        final Register form = new Register();

      }
    });

  }

  public Register() {

  }
}
