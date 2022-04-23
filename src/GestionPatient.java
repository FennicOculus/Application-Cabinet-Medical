import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GestionPatient {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtAa;
	private JTextField txtAa_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					GestionPatient window = new GestionPatient();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.toString());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */public Connection conn() {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
					return cn;}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,e.toString());
			}return null;
			
		}
	private void initialize() {
		frame = new JFrame("Création Patient");
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField.setOpaque(false);
		textField.setBackground(new Color(0,0,0,(float)0.2));
		textField.setBounds(88, 29, 96, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Code Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 32, 77, 13);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField_1.setOpaque(false);
		textField_1.setBackground(new Color(0,0,0,(float)0.2));
		textField_1.setBounds(88, 74, 96, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 77, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField_2.setOpaque(false);
		textField_2.setBackground(new Color(0,0,0,(float)0.2));
		textField_2.setBounds(88, 124, 96, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pr\u00E9nom");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 127, 56, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField_3.setOpaque(false);
		textField_3.setBackground(new Color(0,0,0,(float)0.2));
		textField_3.setBounds(88, 168, 147, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 174, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_4 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField_4.setOpaque(false);
		textField_4.setBackground(new Color(0,0,0,(float)0.2));
		textField_4.setBounds(88, 204, 147, 30);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("E-Mail");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 212, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_5 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField_5.setOpaque(false);
		textField_5.setBackground(new Color(0,0,0,(float)0.2));
		textField_5.setBounds(88, 244, 147, 29);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("N\u00B0 T\u00E9l\u00E9phone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 251, 77, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtAa = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtAa.setOpaque(false);
		txtAa.setBackground(new Color(0,0,0,(float)0.4));
		txtAa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAa.setText("Ann\u00E9e");
		txtAa.setBounds(253, 284, 64, 26);
		frame.getContentPane().add(txtAa);
		txtAa.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"janvier", "f\u00E9vrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"}));
		comboBox.setBounds(173, 284, 70, 26);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(119, 284, 45, 26);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("Date de Naissance");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 286, 106, 24);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtAa_1 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtAa_1.setOpaque(false);
		txtAa_1.setBackground(new Color(0,0,0,(float)0.2));
		txtAa_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAa_1.setText("Ann\u00E9e");
		txtAa_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAa_1.setBounds(253, 322, 64, 26);
		frame.getContentPane().add(txtAa_1);
		txtAa_1.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"janvier", "f\u00E9vrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"}));
		comboBox_2.setBounds(173, 321, 70, 26);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_3.setBounds(119, 321, 45, 26);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblNewLabel_7 = new JLabel("Date d'Inscription");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 321, 99, 22);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Sexe");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 373, 45, 13);
		frame.getContentPane().add(lblNewLabel_8);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"F", "H"}));
		comboBox_4.setBounds(88, 366, 67, 26);
		frame.getContentPane().add(comboBox_4);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//s est d des dates
				String s = String.format("%s-%s-%s",comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),txtAa.getText());
				String d = String.format("%s-%s-%s",comboBox_3.getSelectedItem().toString(),comboBox_2.getSelectedItem().toString(),txtAa_1.getText());
				Patient p = new Patient( comboBox_4.getSelectedItem().toString(), textField_1.getText(), textField_2.getText(), textField_4.getText(), textField_5.getText(), s, d, textField_3.getText());
			p.ajoutpatient();
			//récuperer
			textField.setText(p.getCodep());
			JOptionPane.showMessageDialog(null, "patient ajouté avec succés");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(67, 446, 96, 26);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// s et d dates
				String s = String.format("%s-%s-%s",comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),txtAa.getText());
				String d = String.format("%s-%s-%s",comboBox_3.getSelectedItem().toString(),comboBox_2.getSelectedItem().toString(),txtAa_1.getText());
				Patient p = new Patient( comboBox_4.getSelectedItem().toString(), textField_1.getText(), textField_2.getText(), textField_4.getText(), textField_5.getText(), s, d, textField_3.getText());
			    p.modifier(textField.getText());
			    JOptionPane.showMessageDialog(null, "patient modfié avec succés");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(165, 446, 106, 26);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//quitter
				int Clickedbutton=JOptionPane.showConfirmDialog(null, "etes-vous sur de quitter?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
				frame.dispose();}
			}
		});
		btnNewButton_4.setBounds(749, 457, 85, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//revenir au menu
				int Clickedbutton=	JOptionPane.showConfirmDialog(null, "etes-vous sur de revenir au menu?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
					MenuMédecin window = new MenuMédecin();
					window.frame1.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnMenu.setBounds(624, 457, 85, 21);
		frame.getContentPane().add(btnMenu);
		
		JButton btnNewButton = new JButton("Cr\u00E9er Dossier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FDossierMedical window = new FDossierMedical();
				window.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(382, 446, 106, 26);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setIcon(new ImageIcon(GestionPatient.class.getResource("/images/CreationPatient.jpg")));
		lblNewLabel_9.setBounds(-10, -80, 900, 600);
		frame.getContentPane().add(lblNewLabel_9);
		frame.setBounds(100, 100, 895, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
