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

public class Register2 {
  ImageIcon img = new ImageIcon("assets/icon.png");

  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        final Register2 form = new Register2();

      }
    });

  }

  public Register2() {

    registerFonts();

    final FWindow window = new FWindow("Register 2/3");
    window.setIconImage(img.getImage());

    final FPage loginPane = new FPage();

    final GridBagConstraints gbc = new GridBagConstraints();
    window.add(loginPane);

    final FLabel title_lbl = new FLabel("Registrazione", new Font("Manrope ExtraBold", Font.PLAIN, 99));
    title_lbl.setForeground(Color.BLACK);
    gbc.fill = GridBagConstraints.CENTER;
    setGridCoordinatesXY(gbc, 0, 0);
    // spacing Insets(int top, int left, int bottom, int right)
    gbc.insets = new Insets(0, 0, 0, 0);
    loginPane.add(title_lbl, gbc);

    final String text = "Registrati per avere accesso a tutte le funzioni";
    final FLabel info_lbl = new FLabel(text, new Font("Manrope Light", Font.PLAIN, 27));
    setGridCoordinatesXY(gbc, 0, 1);
    gbc.insets = new Insets(20, 0, 15, 0);
    loginPane.add(info_lbl, gbc);


    final FTextField town_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 20));
    town_tf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent arg0) {
        //mouse pressed
			}
    });

    town_tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent e) {
        //focus lost
			}
    });
    
    town_tf.setBorder(new LineBorder(Color.BLACK, 1));
    setGridCoordinatesXY(gbc, 0, 2);
    gbc.insets = new Insets(10, 0, 0, 0);
    town_tf.setBackground(Color.WHITE);
    loginPane.add(town_tf, gbc);

    final FTextField district_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 20));
    district_tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent arg0) {
        //focus lost
			}
			@Override
			public void focusGained(final FocusEvent e) {
        //focus gained
			}
		});
        district_tf.setBorder(new LineBorder(Color.BLACK, 1));
    gbc.insets = new Insets(10, 0, 0, 0);
    setGridCoordinatesXY(gbc, 0, 3);
    // gbc.insets = new Insets(-60,0,50,0);
    loginPane.add(district_tf, gbc);

    final FPage bts_pane = new FPage();
    setGridCoordinatesXY(gbc, 0, 4);
    gbc.insets = new Insets(10, 0, 0, 0);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    loginPane.add(bts_pane, gbc);

    final FButton back_btn = new FButton("Indietro");
    back_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
        //mouse clicked
        
			}
    });
    gbc.weightx = 0.5;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(10, 0, 0, 0);
    setGridCoordinatesXY(gbc, 0, 0);
    // gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    // gbc.insets = new Insets(0,0,0,294);
    bts_pane.add(back_btn, gbc);

    final FButton continue_btn = new FButton("Continua");
    continue_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
        //mouse clicked
			}
    });

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(10, 0, 0, 0);
    gbc.weightx = 0.5;
    setGridCoordinatesXY(gbc, 1, 0);
    // gbc.anchor = GridBagConstraints.FIRST_LINE_END;
    // gbc.insets = new Insets(0,269,0,0);
    bts_pane.add(continue_btn, gbc);

    final FLabel procedure_lb = new FLabel("1/3", new Font("Manrope", Font.PLAIN, 15));
    setGridCoordinatesXY(gbc, 0, 1);
    gbc.insets = new Insets(10, 0, 0, 0);
    gbc.ipadx = -100;
    bts_pane.add(procedure_lb, gbc);


    window.setVisible(true);
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
    catch(final Exception e) {
      System.err.println(e);
    }
  }

  public static void setGridCoordinatesXY(final GridBagConstraints gbc, final int x, final int y) {
    gbc.gridx = x;
    gbc.gridy = y;
  }
}
