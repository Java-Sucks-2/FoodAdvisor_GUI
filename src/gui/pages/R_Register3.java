package src.gui.pages;

import java.awt.*;


import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.components.*;

public class R_Register3 {
    private FPage page;
    public String pageTitle;

    private GridBagConstraints gbc;
    private FLabel title_lbl;
    private String text;
    private FLabel info_lbl;
    public FTextField town_tf;
    public FTextField district_tf;
    public FTextField zipcode_tf;
    private FPage bts_pane;
    public FButton back_btn;
    public FButton continue_btn;
    private FLabel procedure_lb;

    boolean towntxtAlreadyClicked;
    boolean districttxtAlreadyClicked;
    boolean zipcodetxtAlreadyClicked;

    public FPage getPage() {
        return page;
    }

    public R_Register3() {
        page = new FPage();
        gbc = new GridBagConstraints();

        title_lbl = new FLabel("Registrazione", new Font("Manrope ExtraBold", Font.PLAIN, 99));
        title_lbl.setForeground(Color.BLACK);
        gbc.fill = GridBagConstraints.CENTER;
        setGridCoordinatesXY(gbc, 0, 0);
        // spacing Insets(int top, int left, int bottom, int right)
        gbc.insets = new Insets(-30, 0, 0, 0);
        page.add(title_lbl, gbc);

        text = "Registra un nuovo ristorante!";
        info_lbl = new FLabel(text, new Font("Manrope Light", Font.PLAIN, 27));
        setGridCoordinatesXY(gbc, 0, 1);
        gbc.insets = new Insets(10, 0, 15, 0);
        page.add(info_lbl, gbc);

        town_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        town_tf.setForeground(Color.GRAY);
        town_tf.setText("Comune");
        town_tf.addFocusListener(new FocusAdapter() {
            public void focusLost(final FocusEvent arg0) {
                //focus lost
                if(town_tf.getText().equals("")){
                    town_tf.setForeground(Color.GRAY);
                    town_tf.setText("Comune");
                }
            }
            public void focusGained(final FocusEvent e) {
                //focus gained
                if(!towntxtAlreadyClicked || town_tf.getText().equals("Comune")) {
                    town_tf.setText("");
                    towntxtAlreadyClicked = true;
                    town_tf.setForeground(Color.BLACK);
                }
            }
            });
        town_tf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 2);
        page.add(town_tf, gbc);

        districttxtAlreadyClicked = false;
        district_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        district_tf.setText("Provincia");
        district_tf.addMouseListener(new MouseAdapter() {
            public void mousePressed(final MouseEvent arg0) {
            //mouse pressed
                if(!districttxtAlreadyClicked || district_tf.getText().equals("Provincia")) {
                    district_tf.setText("");
                    districttxtAlreadyClicked = true;
                    district_tf.setForeground(Color.BLACK);
                }
            }
        });

        district_tf.addFocusListener(new FocusAdapter() {
                public void focusLost(final FocusEvent e) {
                //focus lost
                    if(district_tf.getText().equals("")){
                        district_tf.setForeground(Color.gray);
                        district_tf.setText("Provincia");
                    }
                }

                public void focusGained(final FocusEvent e) {
                    if(!districttxtAlreadyClicked || district_tf.getText().equals("Provincia")) {
                        district_tf.setText("");
                        districttxtAlreadyClicked = true;
                        district_tf.setForeground(Color.BLACK);
                    }
                }
        });
        
        district_tf.setBorder(new LineBorder(Color.BLACK, 1));
        setGridCoordinatesXY(gbc, 0, 3);
        gbc.insets = new Insets(20, 0, 0, 0);
        district_tf.setBackground(Color.WHITE);
        page.add(district_tf, gbc);

        zipcodetxtAlreadyClicked = false;
        zipcode_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        zipcode_tf.setText("CAP");
        zipcode_tf.addMouseListener(new MouseAdapter() {
            public void mousePressed(final MouseEvent arg0) {
            //mouse pressed
                if(!zipcodetxtAlreadyClicked || zipcode_tf.getText().equals("CAP")) {
                    zipcode_tf.setText("");
                    zipcodetxtAlreadyClicked = true;
                    zipcode_tf.setForeground(Color.BLACK);
                }
            }
        });

        zipcode_tf.addFocusListener(new FocusAdapter() {
                public void focusLost(final FocusEvent e) {
                //focus lost
                    if(zipcode_tf.getText().equals("")){
                        zipcode_tf.setForeground(Color.gray);
                        zipcode_tf.setText("CAP");
                    }
                }

                public void focusGained(final FocusEvent e) {
                    if(!zipcodetxtAlreadyClicked || zipcode_tf.getText().equals("CAP")) {
                        zipcode_tf.setText("");
                        zipcodetxtAlreadyClicked = true;
                        zipcode_tf.setForeground(Color.BLACK);
                    }
                }
        });
        
        zipcode_tf.setBorder(new LineBorder(Color.BLACK, 1));
        setGridCoordinatesXY(gbc, 0, 4);
        gbc.insets = new Insets(20, 0, 0, 0);
        zipcode_tf.setBackground(Color.WHITE);
        page.add(zipcode_tf, gbc);

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
        bts_pane.add(back_btn, gbc);

        FLabel gap_lbl = new FLabel();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.weightx = 0.1;
        setGridCoordinatesXY(gbc, 1, 0);
        bts_pane.add(gap_lbl, gbc);

        continue_btn = new FButton("Registra");
        continue_btn.addMouseListener(new MouseAdapter() {
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