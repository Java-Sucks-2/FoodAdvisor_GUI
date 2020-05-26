package src.gui.pages;

import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.components.*;

public class C_Register3 { 

    private FPage page;

    public String pageTitle;

    private GridBagConstraints gbc;
    private FLabel title_lbl;
    private String text;
    private FLabel info_lbl;
    public FTextField email_tf;
    public FPasswordField password1_pf;
    public FPasswordField password2_pf;
    private FPage bts_pane;
    public FButton back_btn;
    public FButton continue_btn;
    private FLabel procedure_lb;
    private FLabel questionMark1_image;
    private FLabel questionMark2_image;

    boolean emailtxtAlreadyClicked;
    boolean pass1txtAlreadyClicked;
    boolean pass2txtAlreadyClicked;

    public FPage getPage() {
        return page;
    }

    public C_Register3() {

        page = new FPage();
        pageTitle = "Register 3/3";
        gbc = new GridBagConstraints();

        title_lbl = new FLabel("Registrazione", new Font("Manrope ExtraBold", Font.PLAIN, 99));
        title_lbl.setForeground(Color.BLACK);
        gbc.fill = GridBagConstraints.CENTER;
        setGridCoordinatesXY(gbc, 0, 0);
        // spacing Insets(int top, int left, int bottom, int right)
        gbc.insets = new Insets(-30, 0, 0, 0);
        page.add(title_lbl, gbc);

        text = "Registrati per avere accesso a tutte le funzioni";
        info_lbl = new FLabel(text, new Font("Manrope Light", Font.PLAIN, 27));
        setGridCoordinatesXY(gbc, 0, 1);
        gbc.insets = new Insets(10, 0, 15, 0);
        page.add(info_lbl, gbc);

        emailtxtAlreadyClicked = false;
        email_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
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
                        email_tf.setForeground(Color.gray);
                        email_tf.setText("Email");
                    }
                }
        });
        
        email_tf.setBorder(new LineBorder(Color.BLACK, 1));
        setGridCoordinatesXY(gbc, 0, 2);
        gbc.insets = new Insets(30, 0, 0, 0);
        email_tf.setBackground(Color.WHITE);
        page.add(email_tf, gbc);

        password1_pf = new FPasswordField(38, new Font("Manrope", Font.PLAIN, 22));
        password1_pf.setForeground(Color.GRAY);
        password1_pf.setText("Password");
        password1_pf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent arg0) {
                //focus lost
                if(String.valueOf(password1_pf.getPassword()).equals("")){
                    password1_pf.setForeground(Color.GRAY);
                    password1_pf.setText("Password");
                }
            }
            @Override
            public void focusGained(final FocusEvent e) {
                //focus gained
                if(!pass1txtAlreadyClicked || String.valueOf(password1_pf.getPassword()).equals("Password")) {
                    password1_pf.setText("");
                    pass1txtAlreadyClicked = true;
                    password1_pf.setForeground(Color.BLACK);
                }
            }
            });
            password1_pf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.insets = new Insets(20, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 3);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(password1_pf, gbc);

        questionMark1_image = new FLabel("assets/QM_Red_32.png");
        questionMark1_image.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent arg0) {
                JOptionPane.showMessageDialog(null, "Inserisci in questo campo la password", "Help", JOptionPane.PLAIN_MESSAGE);
            }
        });
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 5, 0, 0);
        setGridCoordinatesXY(gbc, 1, 3);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(questionMark1_image, gbc);

        password2_pf = new FPasswordField(38, new Font("Manrope", Font.PLAIN, 22));
        password2_pf.setForeground(Color.GRAY);
        password2_pf.setText("Password");
        password2_pf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent arg0) {
                //focus lost
                if(String.valueOf(password2_pf.getPassword()).equals("")){
                    password2_pf.setForeground(Color.GRAY);
                    password2_pf.setText("Password");
                }
            }
            @Override
            public void focusGained(final FocusEvent e) {
                //focus gained
                if(!pass2txtAlreadyClicked || String.valueOf(password2_pf.getPassword()).equals("Password")) {
                    password2_pf.setText("");
                    pass2txtAlreadyClicked = true;
                    password2_pf.setForeground(Color.BLACK);
                }
            }
        });
        password2_pf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.insets = new Insets(20, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 4);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(password2_pf, gbc);

        questionMark2_image = new FLabel("assets/QM_Red_32.png");
        questionMark2_image.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent arg0) {
                JOptionPane.showMessageDialog(null, "Ripeti la tua password", "Help", JOptionPane.PLAIN_MESSAGE);
            }
        });
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 5, 0, 0);
        setGridCoordinatesXY(gbc, 1, 4);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(questionMark2_image, gbc);

        bts_pane = new FPage();
        setGridCoordinatesXY(gbc, 0, 5);
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        page.add(bts_pane, gbc);

        back_btn = new FButton("Indietro");
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        // gbc.insets = new Insets(0,0,0,294);
        bts_pane.add(back_btn, gbc);

        FLabel gap_lbl = new FLabel();
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 0.1;
        setGridCoordinatesXY(gbc, 1, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        // gbc.insets = new Insets(0,269,0,0);
        bts_pane.add(gap_lbl, gbc);

        continue_btn = new FButton("Finito");
        continue_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                //mouse clicked
            }
        });

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 0.5;
        setGridCoordinatesXY(gbc, 2, 0);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        // gbc.insets = new Insets(0,269,0,0);
        bts_pane.add(continue_btn, gbc);

        procedure_lb = new FLabel("assets/Step3.png");
        setGridCoordinatesXY(gbc, 0, 1);
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.ipadx = -600;
        bts_pane.add(procedure_lb, gbc);
    }

    public static void setGridCoordinatesXY(final GridBagConstraints gbc, final int x, final int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }

}