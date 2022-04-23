import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.TextField;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.SwingConstants;
import java.awt.Label;


public class ConsulterAgenda {

	JFrame frame;
	private JTextField txtAa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					ConsulterAgenda window = new ConsulterAgenda();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
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
	/**
	 * Create the application.
	 */
	public ConsulterAgenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Agenda");
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 910, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 142, 40, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"janvier", "f\u00E9vrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"}));
		comboBox.setBounds(122, 143, 73, 21);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(60, 142, 50, 21);
		frame.getContentPane().add(comboBox_1);
		
		txtAa = new JTextField();
		txtAa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAa.setText("Ann\u00E9e");
		txtAa.setBounds(205, 142, 73, 21);
		frame.getContentPane().add(txtAa);
		txtAa.setColumns(10);
		
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
		scrollPane.setBounds(301, 11, 557, 328);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("CONSULTER AGENDA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//afficher le contenu de la table RDV dans la JTable
					String rq = "SELECT * FROM RDV";
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.toString());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(489, 380, 197, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RDV DE LA JOURNEE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//S est la Date
				String s = String.format("%s-%s-%s",comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),txtAa.getText());
try {
					//afficher les tuples de la table RDV qui correspondent à la date saisie
					String sql="SELECT nom,prenom,tel,email FROM RDV WHERE DATE_RDV='"+s+"'";
				PreparedStatement pp = conn().prepareStatement(sql);
				ResultSet rs = pp.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				//si la jtable est vide donc il nya aucun rendez vous qui correspond à la date saisie
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(null,"no rdv");}
					}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null, e1.toString());
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(72, 190, 162, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pour quitter
				int Clickedbutton=	JOptionPane.showConfirmDialog(null, "etes-vous sur de vouloir quitter?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
					frame.dispose();
				}
				
			}
		});
		btnNewButton_2.setBounds(773, 424, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextPane txtpnLesNouveauPatients = new JTextPane();
		txtpnLesNouveauPatients.setEnabled(false);
		txtpnLesNouveauPatients.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnLesNouveauPatients.setForeground(Color.RED);
		txtpnLesNouveauPatients.setBackground(SystemColor.inactiveCaptionBorder);
		txtpnLesNouveauPatients.setText("\t   Les nouveaux patients sont marqu\u00E9es aveec le signe \"*\"");
		txtpnLesNouveauPatients.setBounds(345, 350, 511, 19);
		frame.getContentPane().add(txtpnLesNouveauPatients);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pour revenir au Menu
				int Clickedbutton=	JOptionPane.showConfirmDialog(null, "etes-vous sur de revenir au menu?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
					MenuMédecin window = new MenuMédecin();
					window.frame1.setVisible(true);
					frame.dispose();
				}
				
			}
		});
		btnMenu.setBounds(616, 424, 85, 21);
		frame.getContentPane().add(btnMenu);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ConsulterAgenda.class.getResource("/images/ConsultationAg.jpg")));
		lblNewLabel_1.setBounds(0, 0, 904, 482);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
