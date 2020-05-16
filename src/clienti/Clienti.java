package src.clienti;

import src.components.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;

public class Clienti {
  ImageIcon img = new ImageIcon("assets/icon.png");

  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        final Clienti form = new Clienti();

      }
    });

  }

  public Clienti() {

    registerFonts();

    final FWindow window = new FWindow("Login");
    window.setIconImage(img.getImage());
    final int width = window.getWidth();
    final int heigth = window.getHeight();

    final FPage loginPane = new FPage();

    final GridBagConstraints gbc = new GridBagConstraints();
    window.add(loginPane);

    final FLabel title_lbl = new FLabel("Benvenuto!", new Font("Manrope ExtraBold", Font.PLAIN, 99));
    title_lbl.setForeground(Color.BLACK);
    gbc.fill = GridBagConstraints.CENTER;
    setGridCoordinatesXY(gbc, 0, 0);
    // spacing Insets(int top, int left, int bottom, int right)
    gbc.insets = new Insets(0, 0, 0, 0);
    loginPane.add(title_lbl, gbc);

    final String text = "Accedi ed iniza a cercare nuovi ristoranti";
    final FLabel info_lbl = new FLabel(text, new Font("Manrope Light", Font.PLAIN, 27));
    setGridCoordinatesXY(gbc, 0, 1);
    gbc.insets = new Insets(20, 0, 15, 0);
    loginPane.add(info_lbl, gbc);


    final FTextField email_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 20));
    email_tf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(final MouseEvent arg0) {
        //mouse pressed
			}
    });

    email_tf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent e) {
        //focus lost
			}
    });
    
    email_tf.setBorder(new LineBorder(Color.BLACK, 1));
    setGridCoordinatesXY(gbc, 0, 2);
    gbc.insets = new Insets(10, 0, 0, 0);
    email_tf.setBackground(Color.WHITE);
    loginPane.add(email_tf, gbc);

    final FPasswordField password_pf = new FPasswordField(38, new Font("Manrope", Font.PLAIN, 20));
    password_pf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent arg0) {
        //focus lost
			}
			@Override
			public void focusGained(final FocusEvent e) {
        //focus gained
			}
		});
    password_pf.setBorder(new LineBorder(Color.BLACK, 1));
    gbc.insets = new Insets(10, 0, 0, 0);
    setGridCoordinatesXY(gbc, 0, 3);
    // gbc.insets = new Insets(-60,0,50,0);
    loginPane.add(password_pf, gbc);

    final FLabel questionMark_image = new FLabel("assets/questionMark32.png");
    questionMark_image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
        JOptionPane.showMessageDialog(null, "Inserisci in questo campo la tua password", "Help", JOptionPane.PLAIN_MESSAGE);
        
			}
    });
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(10, 5, 0, 0);
    setGridCoordinatesXY(gbc, 1, 3);
    // gbc.insets = new Insets(-60,0,50,0);
    loginPane.add(questionMark_image, gbc);

    final FPage bts_pane = new FPage();
    setGridCoordinatesXY(gbc, 0, 4);
    gbc.insets = new Insets(10, 0, 0, 0);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    loginPane.add(bts_pane, gbc);

    final FButton login_btn = new FButton("Accedi");
    login_btn.addMouseListener(new MouseAdapter() {
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
    bts_pane.add(login_btn, gbc);

    final FButton register_btn = new FButton("Registrati");
    register_btn.addMouseListener(new MouseAdapter() {
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
    bts_pane.add(register_btn, gbc);

    final FLabel guest_lb = new FLabel("<html>Oppure procedi come <font color='blue'>ospite</font></html>", new Font("Manrope", Font.PLAIN, 15));
    guest_lb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(final MouseEvent e) {
				guest_lb.setText("<html>Oppure procedi come <font color='red'>ospite</font></html>");
			}
			@Override
			public void mouseExited(final MouseEvent e) {
				guest_lb.setText("<html>Oppure procedi come <font color='blue'>ospite</font></html>");
			}
			@Override
			public void mouseClicked(final MouseEvent e) {
				//mouse clicked
			}
		});
    setGridCoordinatesXY(gbc, 0, 1);
    gbc.insets = new Insets(10, 0, 0, 0);
    gbc.ipadx = -100;
    bts_pane.add(guest_lb, gbc);


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
