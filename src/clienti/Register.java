package src.clienti;

import src.gui.components.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;

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
