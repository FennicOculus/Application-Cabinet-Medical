import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.util.Name.Table;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.ScrollPane;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class FDossierMedical extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FDossierMedical frame = new FDossierMedical();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FDossierMedical() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.POPUP);
		setTitle("Cr\u00E9e Dossier Medical");
		setBounds(100, 100, 720, 452);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Groupe Sanguin");
		lblNewLabel.setBounds(10, 108, 83, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Taille");
		lblNewLabel_1.setBounds(10, 140, 83, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Poid");
		lblNewLabel_1_1.setBounds(10, 183, 83, 21);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tension");
		lblNewLabel_1_2.setBounds(10, 215, 83, 21);
		getContentPane().add(lblNewLabel_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "AB", "O"}));
		comboBox.setBounds(121, 108, 39, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"+", "-"}));
		comboBox_1.setBounds(170, 108, 39, 22);
		getContentPane().add(comboBox_1);
		
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
		textField.setBounds(123, 141, 61, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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
		textField_1.setColumns(10);
		textField_1.setBounds(121, 179, 61, 29);
		getContentPane().add(textField_1);
		
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
		textField_2.setColumns(10);
		textField_2.setBounds(131, 211, 39, 29);
		getContentPane().add(textField_2);
		
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
		textField_3.setColumns(10);
		textField_3.setBounds(222, 211, 39, 29);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Allergies");
		lblNewLabel_1_2_1.setBounds(10, 258, 83, 21);
		getContentPane().add(lblNewLabel_1_2_1);
		
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
		textField_4.setColumns(10);
		textField_4.setBounds(121, 251, 173, 29);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_2 = new JLabel("ID Patient");
		lblNewLabel_2.setBounds(10, 11, 83, 22);
		getContentPane().add(lblNewLabel_2);
		
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
		textField_5.setBounds(121, 12, 99, 29);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Maladie Chronique");
		lblNewLabel_3.setBounds(10, 297, 99, 21);
		getContentPane().add(lblNewLabel_3);
		
		textField_6 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField_6.setOpaque(false);
		textField_6.setBackground(new Color(0,0,0,(float)0.2));
		textField_6.setBounds(121, 291, 173, 27);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DossierMedical DM = new DossierMedical(textField_5.getText(),comboBox.getSelectedItem().toString().concat(comboBox_1.getSelectedItem().toString()),Float.parseFloat(textField.getText()),Float.parseFloat(textField_1.getText()),Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()),textField_4.getText(),textField_6.getText());
				DM.AjouterDM();
			}
		});
		btnNewButton_1.setBounds(51, 329, 99, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Mise A Jours");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DossierMedical DM = new DossierMedical(textField_5.getText(),comboBox.getSelectedItem().toString().concat(comboBox_1.getSelectedItem().toString()),Float.parseFloat(textField.getText()),Float.parseFloat(textField_1.getText()),Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()),textField_4.getText(),textField_6.getText());
				DM.ModifierDM();
			}
		});
		btnNewButton_2.setBounds(152, 329, 99, 23);
		getContentPane().add(btnNewButton_2);
		
		JTable AffichageDossierMed = new JTable();
		JScrollPane scrollPane = new JScrollPane(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(0,0,0,(float)0.2));
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(321, 10, 373, 294);
		getContentPane().add(scrollPane);
		
		
		AffichageDossierMed.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String CodeP,Taille,Poid,TensionS,TensionD,Allergies,MaladiesC;
				int LigneSelec = AffichageDossierMed.getSelectedRow();
				CodeP = AffichageDossierMed.getModel().getValueAt(LigneSelec,0).toString();
				Taille =AffichageDossierMed.getModel().getValueAt(LigneSelec,2).toString();
				Poid =AffichageDossierMed.getModel().getValueAt(LigneSelec,3).toString();
				TensionS =AffichageDossierMed.getModel().getValueAt(LigneSelec,4).toString();
				TensionD =AffichageDossierMed.getModel().getValueAt(LigneSelec,5).toString();
				Allergies =AffichageDossierMed.getModel().getValueAt(LigneSelec,6).toString();
				MaladiesC =AffichageDossierMed.getModel().getValueAt(LigneSelec,7).toString();
				//affichage le contenu de ligne selectionné dans les textfeild associé
				textField_5.setText(CodeP);
				textField.setText(Taille);
				textField_1.setText(Poid);
				textField_2.setText(TensionD);
				textField_3.setText(TensionS);
				textField_4.setText(Allergies);
				textField_6.setText(MaladiesC);
			}	
		});
		
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					     //affichage du contenu de la table dossier medicale dans la jTable
					String rq = "SELECT * FROM DOSSIERMED WHERE CODEP='"+textField_5.getText()+"'";
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					AffichageDossierMed.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.toString());
				}
				
			}
		});
		scrollPane.setViewportView(AffichageDossierMed);
		btnNewButton.setBounds(461, 310, 99, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("mmHg");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(170, 211, 39, 29);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("mmHg");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setBounds(260, 211, 39, 29);
		getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("m");
		lblNewLabel_5.setBounds(190, 148, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Kg");
		lblNewLabel_5_1.setBounds(192, 186, 46, 14);
		getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(FDossierMedical.class.getResource("/images/DossierMed.jpg")));
		lblNewLabel_6.setBounds(0, 0, 714, 423);
		getContentPane().add(lblNewLabel_6);
		
		
		
	}
	public Connection conn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
			return cn;}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}return null;
		}

}

