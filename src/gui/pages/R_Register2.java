package src.gui.pages;

import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.components.*;

public class R_Register2 {
    private FPage page;
    public String pageTitle;

    private GridBagConstraints gbc;
    private FLabel title_lbl;
    private String text;
    private FLabel info_lbl;
    public FComboBox addresstype_cb;
    public FTextField addressname_tf;
    public FTextField number_tf;
    private FPage bts_pane;
    public FButton back_btn;
    public FButton continue_btn;
    private FLabel procedure_lb;

    boolean addressnameAlreadyClicked;
    boolean numbertxtAlreadyClicked;

    public FPage getPage() {
        return page;
    }

    public R_Register2() {
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

        String[] values = new String[] {"Tipo Indirizzo","Via","Piazza"};
        addresstype_cb = new FComboBox(values, new Font("Manrope", Font.PLAIN, 22));
        addresstype_cb.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(30, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 2);
        page.add(addresstype_cb, gbc);

        addressname_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        addressname_tf.setForeground(Color.GRAY);
        addressname_tf.setText("Nome della Via");
        addressname_tf.addFocusListener(new FocusAdapter() {
            public void focusLost(final FocusEvent arg0) {
                //focus lost
                if(addressname_tf.getText().equals("")){
                    addressname_tf.setForeground(Color.GRAY);
                    addressname_tf.setText("Nome della Via");
                }
            }
            public void focusGained(final FocusEvent e) {
                //focus gained
                if(!addressnameAlreadyClicked || addressname_tf.getText().equals("Nome della Via")) {
                    addressname_tf.setText("");
                    addressnameAlreadyClicked = true;
                    addressname_tf.setForeground(Color.BLACK);
                }
            }
            });
        addressname_tf.setBorder(new LineBorder(Color.BLACK, 1));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 3);
        page.add(addressname_tf, gbc);

        numbertxtAlreadyClicked = false;
        number_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        number_tf.setText("Numero Civico");
        number_tf.addMouseListener(new MouseAdapter() {
            public void mousePressed(final MouseEvent arg0) {
            //mouse pressed
                if(!numbertxtAlreadyClicked || number_tf.getText().equals("Numero Civico")) {
                    number_tf.setText("");
                    numbertxtAlreadyClicked = true;
                    number_tf.setForeground(Color.BLACK);
                }
            }
        });

        number_tf.addFocusListener(new FocusAdapter() {
                public void focusLost(final FocusEvent e) {
                //focus lost
                    if(number_tf.getText().equals("")){
                        number_tf.setForeground(Color.gray);
                        number_tf.setText("Numero Civico");
                    }
                }
        });
        
        number_tf.setBorder(new LineBorder(Color.BLACK, 1));
        setGridCoordinatesXY(gbc, 0, 4);
        gbc.insets = new Insets(20, 0, 0, 0);
        number_tf.setBackground(Color.WHITE);
        page.add(number_tf, gbc);

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

        continue_btn = new FButton("Continua");
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

        procedure_lb = new FLabel("assets/Step2.png");
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