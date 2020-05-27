package src.gui.pages;

import java.awt.*;

import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import src.gui.components.*;

public class R_Register2 {
    private FPage page;
    private FPage registerPage;

    public String pageTitle;

    private GridBagConstraints gbc;
    private FLabel title_lbl;
    private String text;
    private FLabel info_lbl;
    private FTextField town_tf;
    private FTextField district_tf;
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

    public R_Register2() {

        page = new FPage();
        gbc = new GridBagConstraints();
        registerPage = new FPage();
        
        title_lbl = new FLabel("Registrazione", new Font("Manrope ExtraBold", Font.PLAIN, 99));
        title_lbl.setForeground(Color.BLACK);
        gbc.fill = GridBagConstraints.CENTER;
        setGridCoordinatesXY(gbc, 0, 0);
        // spacing Insets(int top, int left, int bottom, int right)
        gbc.insets = new Insets(-30, 0, 0, 0);
        page.add(title_lbl, gbc);

        text = "Immetti la localizzazione del locale!";
        info_lbl = new FLabel(text, new Font("Manrope Light", Font.PLAIN, 27));
        setGridCoordinatesXY(gbc, 0, 1);
        gbc.insets = new Insets(0, 0, 0, 0);
        page.add(info_lbl, gbc);

        registerPage = new FPage();
        
        setGridCoordinatesXY(gbc, 0, 2);
        gbc.insets = new Insets(0, 0, 0, 0);
        page.add(registerPage, gbc);

        town_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        town_tf.setText("Comune");
        town_tf.addFocusListener(new FocusAdapter() {
            public void focusLost(final FocusEvent arg0) {
                //focus lost
                if(town_tf.getText().equals("")){
                    town_tf.setForeground(Color.GRAY);
                    town_tf.setText("Comune");
                }
            }
        });
        town_tf.addMouseListener(new MouseAdapter() {
            public void mousePressed(final MouseEvent arg0) {
                if(!nametxtAlreadyClicked || town_tf.getText().equals("Comune")) {
                    town_tf.setText("");
                    nametxtAlreadyClicked = true;
                    town_tf.setForeground(Color.BLACK);
                }
            } 
        });


        town_tf.setBorder(new LineBorder(Color.BLACK, 1));

       // gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        setGridCoordinatesXY(gbc, 0, 0);
        registerPage.add(town_tf, gbc);

        district_tf = new FTextField(38, new Font("Manrope", Font.PLAIN, 22));
        district_tf.setText("Provincia");
        district_tf.addFocusListener(new FocusAdapter() {
            public void focusLost(final FocusEvent arg0) {
                if(district_tf.getText().equals("")){
                    district_tf.setForeground(Color.GRAY);
                    district_tf.setText("Provincia");
                    
                }
            }
            public void focusGained(final FocusEvent e) {
                if(!numbertxtAlreadyClicked || district_tf.getText().equals("Provincia")) {
                    district_tf.setText("");
                    numbertxtAlreadyClicked = true;
                    district_tf.setForeground(Color.BLACK);
                }
            }
        });

        
        gbc.insets = new Insets(0, 0, 0, 0);
        setGridCoordinatesXY(gbc, 1, 0);
        // gbc.insets = new Insets(-60,0,50,0);
        //gbc.weightx = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        registerPage.add(district_tf, gbc);

        procedure_lb = new FLabel("assets/Step2-2.png");
        setGridCoordinatesXY(gbc, 0, 3);
        gbc.insets = new Insets(30, 0, 0, 0);
        page.add(procedure_lb, gbc);
    }

    public static void setGridCoordinatesXY(final GridBagConstraints gbc, final int x, final int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}