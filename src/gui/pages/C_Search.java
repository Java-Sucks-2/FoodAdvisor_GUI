package src.gui.pages;

import src.gui.components.*;
import java.awt.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class C_Search {
    private FPage page;
    private GridBagConstraints gbc;

    public FLabel backIcon_lbl;
    private FLabel userIcon_lbl;
    private FLabel userName_lbl;
    private FLabel title_lbl;
    public FTextField searchBar_tb;
    public FList restaurants_lst;
    public DefaultListModel<String> listModel;

    public FPage getPage() {
        return page;
    }

    public C_Search(String username) {
        page = new FPage();
        gbc = new GridBagConstraints();
        listModel = new DefaultListModel<String>();

        int topMargin = -100;

        backIcon_lbl = new FLabel("assets/BackIcon.png");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.06;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(topMargin,0,0,0);
        setGridCoordinatesXY(gbc, 0, 0);
        page.add(backIcon_lbl, gbc);

        FLabel gap_lbl = new FLabel();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(topMargin,0,0,0);
        gbc.weightx = 0.8;
        setGridCoordinatesXY(gbc, 1, 0);
        page.add(gap_lbl, gbc);

        String iconPath = username.equals("Guest") ? "assets/GuestIcon.png" : "assets/UserIcon.png";
        userIcon_lbl = new FLabel(iconPath);
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
        gbc.insets = new Insets(100,0,0,0);
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
        gbc.insets = new Insets(30, 0, 0, 0);
        searchBar_tb.setBackground(Color.WHITE);
        page.add(searchBar_tb, gbc);

        FPage scrollingList = new FPage(new BorderLayout());
        scrollingList.setPreferredSize(new Dimension(763,300));
        scrollingList.setBackground(Color.WHITE);
        scrollingList.setOpaque(true);
        gbc.insets = new Insets(0,0,0,0);
        setGridCoordinatesXY(gbc, 0, 3);

        restaurants_lst = new FList(listModel);
        //restaurants_lst.setPreferredSize(new Dimension(762,300));
        //gbc.insets = new Insets(-2,0,0,0);
        //setGridCoordinatesXY(gbc, 0, 3);
        //page.add(restaurants_lst, gbc);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setOpaque(true);
        scrollPane.setBorder(new LineBorder(Color.WHITE, 1));
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setViewportView(restaurants_lst);
        restaurants_lst.setLayoutOrientation(JList.VERTICAL);
        scrollingList.add(scrollPane);

        page.add(scrollingList, gbc);
    }

    public static void setGridCoordinatesXY(GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
    }
}