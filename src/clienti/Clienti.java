package src.clienti;

import src.components.*;
import java.awt.Font;

public class Clienti {
    public static void main(String[] args) {
        
        FWindow mainWindow = new FWindow("Food Advisor");
        mainWindow.setVisible(true);
        int width = mainWindow.getWidth();
        int height = mainWindow.getHeight();

        FPage loginPage = new FPage();
        
        //FButton btn = new FButton("Test");
        //btn.setBounds(100,100,150,150);
        //loginPage.add(btn);
        
        FLabel title_lbl = new FLabel("Benvenuto", new Font("Calibri", Font.BOLD, 99));
        title_lbl.autoSetBounds(width, 490, 105, 100);
        loginPage.add(title_lbl);

        FLabel subtitle_lbl = new FLabel("Accedi ed inizia a cercare nuovi ristoranti", new Font("Calibri", Font.PLAIN, 18));
        subtitle_lbl.autoSetBounds(width, 490, 105, 200);
        loginPage.add(subtitle_lbl);
/*
        FTextField email_txt = new FTextField("Email");
        email_txt.autoSetBounds(width, 490, 105, 300);
        loginPage.add(email_txt);

        FPasswordField password_txt = new FPasswordField("Password");
        password_txt.autoSetBounds(width, 490, 105, 400);
        loginPage.add(password_txt);*/
        
        FButton login_btn = new FButton("Login");
        login_btn.autoSetBounds(width, 490, 105, 500);
        loginPage.add(login_btn);
        
        FButton register_btn = new FButton("Register");
        register_btn.autoSetBounds(width, 490, 105, 600);
        loginPage.add(register_btn);

        FLabel ospite_lbl = new FLabel("<html>Oppure procedi come ospite</html>");
        ospite_lbl.autoSetBounds(width, 490, 105, 700);
        loginPage.add(ospite_lbl);

        mainWindow.setContentPane(loginPage);
    
    }
}

/*

//------------------------------------


public class test extends JFrame {
	private String passwordScritta="";
	private String emailScritta="";
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPass;
	private JPanel panel;
	private boolean passFocus = true;
	private boolean emailFocus = true;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */

     /*
	public test() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(370, 160, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Accedi ed inizia a cercare nuovi ristoranti!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 12;
		
		JLabel Registerlbl = new JLabel("Benvenuto!");
		Registerlbl.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 99));
		GridBagConstraints gbc_Registerlbl = new GridBagConstraints();
		gbc_Registerlbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_Registerlbl.insets = new Insets(0, 0, 5, 0);
		gbc_Registerlbl.gridx = 5;
		gbc_Registerlbl.gridy = 0;
		contentPane.add(Registerlbl, gbc_Registerlbl);
		
		JLabel Labelb1 = new JLabel("Accedi ed inizia a cercare nuovi ristoranti");
		Labelb1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_Labelb1 = new GridBagConstraints();
		gbc_Labelb1.anchor = GridBagConstraints.NORTHWEST;
		gbc_Labelb1.insets = new Insets(0, 0, 5, 0);
		gbc_Labelb1.gridx = 5;
		gbc_Labelb1.gridy = 1;
		contentPane.add(Labelb1, gbc_Labelb1);
		
		
		txtEmail = new JTextField("-Email-");
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				emailScritta = txtEmail.getText();
				
				if(!(emailScritta.equals("-Email-"))) {
					
					txtEmail.setText(emailScritta);
					System.out.println(emailScritta);
					}
				if(emailScritta.equals("")||emailScritta.equals(" ")) {
					txtEmail.setText("-Email-");
				}
			
			}
		});
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				emailScritta = txtEmail.getText();
				if(emailFocus || emailScritta.equals("-Email-")) {
					emailFocus=false;
					txtEmail.setText("");
				}
			}
		});
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.BOTH;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 5;
		gbc_txtEmail.gridy = 2;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		float[] a = new float[] {1f, 1f, 1f};
		
		txtPass = new JPasswordField("-Password-");
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordScritta = txtPass.getText();
				if(passFocus || passwordScritta.equals("-Password-")) {
					passFocus=false;
					txtPass.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				
				passwordScritta = txtPass.getText();
			
				if(!(passwordScritta.equals("-Password-"))) {
					
					txtPass.setText(passwordScritta);
					System.out.println(passwordScritta);
					}
				if(passwordScritta.equals("")||passwordScritta.equals(" ")) {
					txtPass.setText("-Password-");
				}
			
			}
		});
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.insets = new Insets(0, 0, 5, 0);
		gbc_txtPass.gridx = 5;
		gbc_txtPass.gridy = 3;
		contentPane.add(txtPass, gbc_txtPass);
		txtPass.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 5;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("Accedi");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(237, 71, 53));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(true);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setBounds(0, 2, 239, 33);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Registrati");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setForeground(Color.WHITE);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(true);
		button.setBackground(new Color(237, 71, 53));
		button.setBounds(235, 0, 239, 33);
		panel.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("Oppure procedi come");
		lblNewLabel_1.setBounds(0, 37, 153, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" ospite");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Accesso da ospite");
			}
		});
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(123, 31, 69, 33);
		panel.add(lblNewLabel_2);
	}
}

*/