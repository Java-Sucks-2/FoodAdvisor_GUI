package src.gui.pages;

import java.awt.*;

import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.components.*;

public class R_Register {
    private FPage page;

    public String pageTitle;

    private GridBagConstraints gbc;
    private FLabel title_lbl;
    private String text;
    private FLabel info_lbl;
    private FTextField name_tf;
    private FTextField number_tf;
    private FTextField website_tf;
    private FComboBox type_cb;
    public FButton back_btn;
    public FButton continue_btn;
    private FLabel procedure_lb;

    boolean nametxtAlreadyClicked;
    boolean numbertxtAlreadyClicked;
    boolean websitetxtAlreadyClicked;

    public FPage getPage() {
        return page;
    }

    public R_Register() {

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

        name_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        name_tf.setText("Nome");
        name_tf.addFocusListener(new FocusAdapter() {
            public void focusLost(final FocusEvent arg0) {
                //focus lost
                if(name_tf.getText().equals("")){
                    name_tf.setForeground(Color.GRAY);
                    name_tf.setText("Nome");
                }
            }
        });
        name_tf.addMouseListener(new MouseAdapter() {
            public void mousePressed(final MouseEvent arg0) {
                if(!nametxtAlreadyClicked || name_tf.getText().equals("Nome")) {
                    name_tf.setText("");
                    nametxtAlreadyClicked = true;
                    name_tf.setForeground(Color.BLACK);
                }
            } 
        });


        name_tf.setBorder(new LineBorder(Color.BLACK, 1));

        //gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 2);
        page.add(name_tf, gbc);

        number_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        number_tf.setText("Numero di Telefono");
        number_tf.addFocusListener(new FocusAdapter() {
            public void focusLost(final FocusEvent arg0) {
                if(number_tf.getText().equals("")){
                    number_tf.setForeground(Color.GRAY);
                    number_tf.setText("Numero di Telefono");
                    
                }
            }
            public void focusGained(final FocusEvent e) {
                if(!numbertxtAlreadyClicked || number_tf.getText().equals("Numero di Telefono")) {
                    number_tf.setText("");
                    numbertxtAlreadyClicked = true;
                    number_tf.setForeground(Color.BLACK);
                }
            }
        });

        number_tf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.insets = new Insets(20, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 3);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(number_tf, gbc);

        website_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        website_tf.setText("Sito Web");
        website_tf.addFocusListener(new FocusAdapter() {
            public void focusLost(final FocusEvent arg0) {
                if(website_tf.getText().equals("")){
                    website_tf.setForeground(Color.GRAY);
                    website_tf.setText("Sito Web");
                    
                }
            }
            public void focusGained(final FocusEvent e) {
                if(!websitetxtAlreadyClicked || website_tf.getText().equals("Sito Web")) {
                    website_tf.setText("");
                    websitetxtAlreadyClicked = true;
                    website_tf.setForeground(Color.BLACK);
                }
            }
        });

        website_tf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.insets = new Insets(20, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 4);
        // gbc.insets = new Insets(-60,0,50,0);
        page.add(website_tf, gbc);

        String[] values = new String[] {"Tipologia","Italiano","Etnico","Fusion"};
        type_cb = new FComboBox(values, new Font("Manrope", Font.PLAIN, 22));
        type_cb.setBorder(new LineBorder(Color.BLACK, 1));
        //gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 5);
        page.add(type_cb, gbc);
       
        continue_btn = new FButton("Continua");
       // continue_btn.setPreferredSize(new Dimension(1,69) );
        continue_btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent arg0) {
                //mouse clicked
            }
        });
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 6);
        // gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        // gbc.insets = new Insets(0,269,0,0);
        page.add(continue_btn, gbc);

        procedure_lb = new FLabel("assets/Step1-2.png");
        setGridCoordinatesXY(gbc, 0, 7);
        gbc.insets = new Insets(30, 0, 0, 0);
        page.add(procedure_lb, gbc);
    }

    public static void setGridCoordinatesXY(final GridBagConstraints gbc, final int x, final int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}