

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CreationCompte extends JFrame {

	private JPanel contentPane;
	private JTextField usertxt;
	private JPasswordField vermdptxt;
	private JPasswordField mdptxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreationCompte frame = new CreationCompte();
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
	public CreationCompte() {
		setTitle("Cr\u00E9ation Compte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setBounds(10, 11, 86, 31);
		contentPane.add(lblNewLabel);
		
		usertxt = new JTextField();
		usertxt.setBounds(129, 11, 140, 31);
		contentPane.add(usertxt);
		usertxt.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(10, 56, 138, 31);
		contentPane.add(lblMotDePasse);
		
		JLabel lblConfirmerMotDe = new JLabel("Confirmer Mot de Passe");
		lblConfirmerMotDe.setBounds(10, 98, 138, 31);
		contentPane.add(lblConfirmerMotDe);
		
		vermdptxt = new JPasswordField();
		vermdptxt.setBounds(129, 98, 162, 31);
		contentPane.add(vermdptxt);
		
		mdptxt = new JPasswordField();
		mdptxt.setBounds(129, 53, 162, 31);
		contentPane.add(mdptxt);
		
		JComboBox spec = new JComboBox();
		spec.setModel(new DefaultComboBoxModel(new String[] {"m\u00E9decin", "secr\u00E9taire"}));
		spec.setBounds(129, 140, 107, 36);
		contentPane.add(spec);
		
		JButton btnNewButton = new JButton("Cr\u00E9er Compte");
		btnNewButton.setBounds(151, 210, 140, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblSpcialit = new JLabel("Sp\u00E9cialit\u00E9");
		lblSpcialit.setBounds(10, 140, 138, 31);
		contentPane.add(lblSpcialit);
		
		JButton btnNewButton_1 = new JButton("Supprimer Compte");
		btnNewButton_1.setBounds(321, 210, 140, 36);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (usertxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Veillez entré un nom d'utilisateur valide");
				}
				else {
					try {
						Class.forName("oracle.jdbc.OracleDriver");
						Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
						String sq = "DELETE FROM USERS WHERE LOGIN= '"+usertxt.getText()+"' ";
						PreparedStatement p1 = cn.prepareStatement(sq);
						p1.execute();
						
					} catch (ClassNotFoundException e1) {
	
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null,"Suppression Effectuer");
				}
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CreationCompte.class.getResource("/images/hi.jpg")));
		lblNewLabel_1.setBounds(0, 0, 586, 326);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (mdptxt.getText().equals(vermdptxt.getText())) {
					try {
						Class.forName("oracle.jdbc.OracleDriver");
						Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
						String rq = "INSERT INTO USERS VALUES (?,?,?)";
						PreparedStatement pp = cn.prepareStatement(rq);
						pp.setString(1,usertxt.getText());
						pp.setString(2,mdptxt.getText());
						pp.setString(3,spec.getSelectedItem().toString());
						ResultSet rs = pp.executeQuery();
						JOptionPane.showMessageDialog(null,"Comtpe Crée");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Vérifier votre mot de passe");
				}
				
				
			}
		});
	}
}
