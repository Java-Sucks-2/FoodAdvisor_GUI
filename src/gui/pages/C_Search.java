package src.gui.pages;

import src.gui.components.*;
import java.awt.*;

import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class C_Search {
    private FPage page;
    private GridBagConstraints gbc;

    private FLabel menuIcon_lbl;
    private FLabel userIcon_lbl;
    private FLabel userName_lbl;
    private FLabel title_lbl;
    public FTextField searchBar_tb;
    private FList restaurants_lst;

    public FPage getPage() {
        return page;
    }

    public C_Search(String username) {
        page = new FPage();
        gbc = new GridBagConstraints();

        int topMargin = -610;

        menuIcon_lbl = new FLabel("assets/MenuIcon.png");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.06;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(topMargin,0,0,0);
        setGridCoordinatesXY(gbc, 0, 0);
        page.add(menuIcon_lbl, gbc);

        FLabel gap_lbl = new FLabel();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(topMargin,0,0,0);
        gbc.weightx = 0.8;
        setGridCoordinatesXY(gbc, 1, 0);
        page.add(gap_lbl, gbc);

        userIcon_lbl = new FLabel("assets/UserIcon.png");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.06;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(topMargin,0,0,0);
        setGridCoordinatesXY(gbc, 2, 0);
        page.add(userIcon_lbl, gbc);

        userName_lbl = new FLabel(username, new Font("Manrope Regular", Font.PLAIN, 25));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.weightx = 0.03;
        setGridCoordinatesXY(gbc, 3, 0);
        gbc.insets = new Insets(topMargin,0,0,0);
        page.add(userName_lbl, gbc);
        gbc = new GridBagConstraints();

        String title = "Trova il tuo ristorante preferito!";
        title_lbl = new FLabel(title, new Font("Manrope ExtraLight", Font.PLAIN, 45));
        gbc.gridwidth = 4;
        setGridCoordinatesXY(gbc, 0, 1);
        gbc.insets = new Insets(-280,0,0,0);
        page.add(title_lbl, gbc);

        searchBar_tb = new FTextField(38, new Font("Manrope", Font.PLAIN, 24));
        searchBar_tb.setText("Comune, tipologia, nome del ristorante");
        searchBar_tb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent arg0) {
                //mouse pressed
                if(searchBar_tb.getText().equals("Comune, tipologia, nome del ristorante")) {
                    searchBar_tb.setText("");
                    searchBar_tb.setForeground(Color.BLACK);
                }
            }
        });

        searchBar_tb.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent e) {
                //focus lost
                if(searchBar_tb.getText().equals("")){
                    searchBar_tb.setForeground(Color.GRAY);
                    searchBar_tb.setText("Comune, tipologia, nome del ristorante");
                }
            }
        });
        
        searchBar_tb.setBorder(new LineBorder(Color.BLACK, 1));
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        setGridCoordinatesXY(gbc, 0, 2);
        gbc.gridwidth = 4;
        gbc.insets = new Insets(-130, 0, 0, 0);
        searchBar_tb.setBackground(Color.WHITE);
        page.add(searchBar_tb, gbc);

        restaurants_lst = new FList();
        restaurants_lst.setPreferredSize(new Dimension(762,40));
        gbc.insets = new Insets(-52,0,0,0);
        setGridCoordinatesXY(gbc, 0, 3);
        page.add(restaurants_lst, gbc);
    }

    public static void setGridCoordinatesXY(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}