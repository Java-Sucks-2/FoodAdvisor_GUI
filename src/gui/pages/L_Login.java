package src.gui.pages;

import src.gui.components.*;
import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class L_Login {
   
    private FPage page;

    public String pageTitle;

    private FLabel title_lbl;
    private FTextField email_tf;
    private FPasswordField password_pf;
    private FLabel questionMark_image;
    public FButton register_btn;
    private FPage bts_pane;
    private FButton login_btn;
    final FLabel info_lbl;
    FLabel guest_lb; 

    final String text;
    boolean emailtxtAlreadyClicked;
    boolean passtxtAlreadyClicked;

    //private Register register;
    private GridBagConstraints gbc;

    public FPage getPage() {
        return page; 
    }
    
    public L_Login(){
        
        page = new FPage();
        pageTitle = "Login";
        gbc = new GridBagConstraints();

        title_lbl = new FLabel("Benvenuto!", new Font("Manrope ExtraBold", Font.PLAIN, 99));
        title_lbl.setForeground(Color.BLACK);
        gbc.fill = GridBagConstraints.CENTER;
        setGridCoordinatesXY(gbc, 0, 0);
        // spacing Insets(int top, int left, int bottom, int right)
        gbc.insets = new Insets(0, 0, 0, 0);
        page.add(title_lbl, gbc);

        text = "Accedi ed iniza a cercare nuovi ristoranti";
        info_lbl = new FLabel(text, new Font("Manrope Light", Font.PLAIN, 27));
        setGridCoordinatesXY(gbc, 0, 1);
        gbc.insets = new Insets(20, 0, 15, 0);
        page.add(info_lbl, gbc);

        emailtxtAlreadyClicked = false;
        email_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 20));
        email_tf.setText("Email");
        email_tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent arg0) {
                //mouse pressed
                if(!emailtxtAlreadyClicked || email_tf.getText().equals("Email")) {
                    email_tf.setText("");
                    emailtxtAlreadyClicked = true;
                    email_tf.setForeground(Color.BLACK);
                }
            }
        });

        email_tf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent e) {
                //focus lost
                if(email_tf.getText().equals("")){
                    email_tf.setForeground(Color.GRAY);
                    email_tf.setText("Email");
                }
            }
        });
        
        email_tf.setBorder(new LineBorder(Color.BLACK, 1));
        setGridCoordinatesXY(gbc, 0, 2);
        gbc.insets = new Insets(10, 0, 0, 0);
        email_tf.setBackground(Color.WHITE);
        page.add(email_tf, gbc);

        password_pf = new FPasswordField(38, new Font("Manrope", Font.PLAIN, 20));
        password_pf.setForeground(Color.GRAY);
        password_pf.setText("Password");
        password_pf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent arg0) {
                if(String.valueOf(password_pf.getPassword()).equals("")){
                    password_pf.setText("Password");
                    password_pf.setForeground(Color.GRAY);
                }
            }
            @Override
            public void focusGained(final FocusEvent e) {
                //focus gained
                if(!passtxtAlreadyClicked || String.valueOf(password_pf.getPassword()).equals("Password")) {
                    password_pf.setText("");
                    passtxtAlreadyClicked = true;
                    password_pf.setForeground(Color.BLACK);
                }
            }
        });

        password_pf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.insets = new Insets(10, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 3);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(password_pf, gbc);

        questionMark_image = new FLabel("assets/QM_Red_32.png");
        questionMark_image.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent arg0) {
                JOptionPane.showMessageDialog(null, "Inserisci in questo campo la tua password", "Help", JOptionPane.PLAIN_MESSAGE);
            }
        });

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 0, 0);
        setGridCoordinatesXY(gbc, 1, 3);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(questionMark_image, gbc);

        bts_pane = new FPage();
        setGridCoordinatesXY(gbc, 0, 4);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(bts_pane, gbc);

        login_btn = new FButton("Accedi");
        login_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                
            }
        });
        
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        // gbc.insets = new Insets(0,0,0,294);
        bts_pane.add(login_btn, gbc);

        FLabel gap_lbl = new FLabel();
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.weightx = 0.1;
        setGridCoordinatesXY(gbc, 1, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        // gbc.insets = new Insets(0,269,0,0);
        bts_pane.add(gap_lbl, gbc);

        register_btn = new FButton("Registrati");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.weightx = 0.5;
        setGridCoordinatesXY(gbc, 2, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        // gbc.insets = new Insets(0,269,0,0);
        bts_pane.add(register_btn, gbc);

        guest_lb = new FLabel("<html>Oppure procedi come <font color='blue'>ospite</font></html>", new Font("Manrope", Font.PLAIN, 15));
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
        gbc.ipadx = -65;
        bts_pane.add(guest_lb, gbc);
    }

    public static void setGridCoordinatesXY(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}