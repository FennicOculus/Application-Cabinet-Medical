import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

import javax.swing.SwingConstants;

public class Authentification {
	static int xx,yy;
	private JFrame frame;
	private JTextField txtTest;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatLightLaf.install();
					UIManager.setLookAndFeel( new FlatLightLaf());
					UIManager.put( "Button.arc",20 );
					UIManager.put( "TextComponent.arc", 10 );
					UIManager.put( "Component.arc", 5 );
					UIManager.put( "CheckBox.arc", 5 );
					UIManager.put( "ProgressBar.arc", 5 );
					UIManager.put( "Component.innerFocusWidth", 2 );
					UIManager.put( "ScrollBar.trackArc", 999 );
					UIManager.put( "ScrollBar.thumbArc", 999 );
					UIManager.put( "ScrollBar.trackInsets", new Insets( 2, 4, 2, 4 ) );
					UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
					UIManager.put( "ScrollBar.track", new Color( 0xe0e0e0 ) );
					Authentification window = new Authentification();
				
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login");
		frame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x= e.getXOnScreen();
				int y= e.getYOnScreen();
				frame.setLocation(x-xx,y-yy);
			}
		});
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				yy=e.getY();
			}
		});
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 0, 0, 5));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 908, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		txtTest = new JTextField();
		txtTest.setBounds(605, 184, 275, 40);
		frame.getContentPane().add(txtTest);
		txtTest.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(605, 184, 275, 40);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(605, 160, 125, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(605, 260, 125, 26);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(605, 286, 275, 40);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
					Statement st = cn.createStatement();
					String rqq="SELECT * FROM USERS";
					ResultSet rss=st.executeQuery(rqq);
					String p=txtTest.getText();
					String l= passwordField.getText();
					String M="médecin";
					String secr= "secrétaire";
					//var bool pour savoir si le user existe dans notre table "USERS"
					int b=0;
					while(rss.next()) {
						String user=rss.getString(1);
						String pass = rss.getString(2);
						String s=rss.getString(3);
						//verifier chaque tuple de la table user avec les information saisie
						if(user.equals(p)&&pass.equals(l)) {
							//si le user existe dans notre table on vérifie donc sa spécialité pour séparer 
							
							b=1;
							if(s.equals(M)) {
								MenuMédecin window = new MenuMédecin();
								//menu Médecin
								window.frame1.setVisible(true);
								frame.dispose();
							}
							if(s.equals(secr)) {
								//Menu Secrétaire
								GestionRDV window = new GestionRDV();
								window.frame.setVisible(true);
								frame.dispose();
								
							}
						}	}
					if(b==0) {
						//JOptionPane.showConfirmDialog(null, "username ou password invalide", "ERREUR D'AUTHENTIFICATION", JOptionPane.ERROR_MESSAGE);
						
						JOptionPane.showMessageDialog(null,"username ou password invalide");
					}
					
					} 
				catch(Exception ee) {
						ee.printStackTrace();
					}
			}
		});
		btnNewButton.setForeground(SystemColor.inactiveCaptionText);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(664, 355, 145, 40);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 950, 627);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Authentification.class.getResource("/images/hi.jpg")));
		
		
		
		
	}
}
