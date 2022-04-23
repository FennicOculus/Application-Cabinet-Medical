import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class GestionRDV {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtHh;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField txtMm;
	private JTextField textField_9;
	private JTable table_1;
	private JTextField txtJjmmaa;
	private JTextField txtAa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//UIManager.setLookAndFeel(new NimbusLookAndFeel());
					GestionRDV window = new GestionRDV();
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
	public GestionRDV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Agenda");
		frame.setResizable(false);
		frame.getContentPane().setForeground(new Color(240, 255, 255));
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setType(Type.POPUP);
		frame.setForeground(Color.BLACK);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 898, 582);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		textField.setBounds(98, 61, 149, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(8, 67, 63, 19);
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
		
		textField_1.setBounds(98, 96, 149, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtHh = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtHh.setOpaque(false);
		txtHh.setBackground(new Color(0,0,0,(float)0.2));
		txtHh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHh.setHorizontalAlignment(SwingConstants.CENTER);
		txtHh.setBounds(98, 165, 51, 27);
		frame.getContentPane().add(txtHh);
		txtHh.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(5, 96, 80, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Heure");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(8, 168, 63, 13);
		frame.getContentPane().add(lblNewLabel_3);
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		JButton btnNewButton = new JButton("AJOUTER RDV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//S est une date
				String s = String.format("%s-%s-%s",comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),txtAa.getText());
				//K est l'heure du rdv
				String k  = String.format("%sH%s", txtHh.getText(),txtMm.getText());
				int l =0;
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
					Statement st = cn.createStatement();
					/*vérifier si le nom et prénom du patient figure dans la table patient si le patient existe déja
					 * dans la bdd alors on lui attribue un rendez vous si c'est son premier rendez-vous alors il ne figure pas dans la bdd
					 * on ajoute ala fin de son nom et prenom le signe "*" pour que le médecin puisse savoir que v'est un nouveau patient*/
					
					String rqq="SELECT nom,prenom FROM PATIENT";
					ResultSet rss=st.executeQuery(rqq);
					String n=textField.getText();
					String p= textField_1.getText();
					
					while(rss.next()) {
						String nom=rss.getString("NOM");
						String prenom = rss.getString("PRENOM");
						
						if(nom.equals(n)&&prenom.equals(p)) 
							
							{//var bool pour savoir si le patient existe déja ou pas
							l=1;}
							}	
								
						
					} 
					
					
				catch(Exception ee) {
						ee.printStackTrace();
						JOptionPane.showMessageDialog(null, ee.toString());
					}
				if(l==1) {
					//ajouter le rendez-vous
					RDV v = new RDV(k,s, textField.getText(), textField_1.getText(), textField_4.getText(), textField_5.getText());
					v.ajouterrdv();
				}else {
					//ajouter le signe "*" a la fin du nom et prénom du patient
				String l11 =textField.getText().concat("*");
				String l1=textField_1.getText().concat("*");
		
				RDV v = new RDV(k,s, l11, l1, textField_4.getText(), textField_5.getText());
              
				v.ajouterrdv();}
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 306, 119, 26);
		frame.getContentPane().add(btnNewButton);
		
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
		textField_4.setBounds(98, 200, 149, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
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
		textField_5.setBounds(98, 236, 149, 25);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("E-Mail");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(8, 206, 63, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("T\u00E9l\u00E9phone");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(8, 243, 85, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
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
		scrollPane.setBounds(369, 23, 379, 219);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{int ligne =table.getSelectedRow();
				String nom,prenom,email,tel,id;
				// remplir les textfeild avec les information de la ligne selectionné de la jtable
				nom=table.getModel().getValueAt(ligne, 0).toString();
				prenom=table.getModel().getValueAt(ligne, 1).toString();
				tel=table.getModel().getValueAt(ligne, 5).toString();
				email=table.getModel().getValueAt(ligne, 4).toString();
				id=table.getModel().getValueAt(ligne, 6).toString();
				textField.setText(nom);
				textField_1.setText(prenom);
				textField_4.setText(email);
				textField_5.setText(tel);
				textField_9.setText(id);}
				catch(NullPointerException ee) {
					JOptionPane.showMessageDialog(null, "champs vide");
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
				}
				
			}
		});
		scrollPane.setViewportView(table);

		
		JButton btnNewButton_1 = new JButton("CONSULTER AGENDA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {	//affichage le contenu de la table RDV dans la jtable
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(496, 283, 147, 27);
		frame.getContentPane().add(btnNewButton_1);
		
		txtMm = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtMm.setOpaque(false);
		txtMm.setBackground(new Color(0,0,0,(float)0.2));
		txtMm.setHorizontalAlignment(SwingConstants.CENTER);
		txtMm.setBounds(178, 165, 51, 27);
		frame.getContentPane().add(txtMm);
		txtMm.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Date");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(8, 137, 57, 13);
		frame.getContentPane().add(lblNewLabel_8);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"janvier", "f\u00E9vrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"}));
		comboBox.setToolTipText("");
		
		JButton btnNewButton_2 = new JButton("SUPPRIMER");
		btnNewButton_2.addActionListener(new ActionListener() {
			//suprression
			//s est la date et le k est l'heure:minutes
			public void actionPerformed(ActionEvent e) {
				String s = String.format("%s-%s-%s",comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),txtAa.getText());
				
				String k  = String.format("%sH%s", txtHh.getText(),txtMm.getText());
				
				
						RDV v = new RDV(k,s, textField.getText(), textField_1.getText(), textField_4.getText(), textField_5.getText());
			v.supprimer(textField_9.getText());;
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(220, 306, 107, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//S est la date et k est l'heure
				String s = String.format("%s-%s-%s",comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),txtAa.getText());
				String k  = String.format("%sH%s", txtHh.getText(),txtMm.getText());
				
				RDV v = new RDV(k,s, textField.getText(), textField_1.getText(), textField_4.getText(), textField_5.getText());
				if (textField_9.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Selectionner le rendez-vous dans l'agenda");
				}
				else {
					
				v.modifier1(textField_9.getText());
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(132, 341, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		textField_9 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField_9.setOpaque(false);
		textField_9.setBackground(new Color(0,0,0,(float)0.2));
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setBounds(98, 271, 119, 24);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("N\u00B0 RDV");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(8, 267, 85, 19);
		frame.getContentPane().add(lblNewLabel_9);
		
		JScrollPane scrollPane_1 = new JScrollPane(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};
		scrollPane_1.setOpaque(false);
		scrollPane_1.setBackground(new Color(0,0,0,(float)0.2));
		scrollPane_1.getViewport().setOpaque(false);
		scrollPane_1.setBounds(369, 356, 384, 108);
		frame.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_4 = new JButton("CONSULTER RDV");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String sql="SELECT nom,prenom,tel,email FROM RDV WHERE DATE_RDV='"+txtJjmmaa.getText()+"'";
				PreparedStatement pp = conn().prepareStatement(sql);
				ResultSet rs = pp.executeQuery();
				
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
				if(table_1.getRowCount()==0) {
					//si la table est vide alors il n ya pas de rendez-vous à la date saisie
					JOptionPane.showMessageDialog(null,"pas de rendez-vous prévu pour cette journée");}
					}
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, e1.toString());
				}
				
			
			}});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_4.setBounds(483, 495, 160, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		txtJjmmaa = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtJjmmaa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		txtJjmmaa.setOpaque(false);
		txtJjmmaa.setBackground(new Color(0,0,0,(float)0.1));
		txtJjmmaa.setText("JJ-MM-AA");
		txtJjmmaa.setHorizontalAlignment(SwingConstants.CENTER);
		txtJjmmaa.setBounds(252, 395, 107, 27);
		frame.getContentPane().add(txtJjmmaa);
		txtJjmmaa.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Date");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(180, 395, 80, 22);
		frame.getContentPane().add(lblNewLabel_10);
		
		txtAa = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtAa.setOpaque(false);
		txtAa.setBackground(new Color(0,0,0,(float)0.2));
		txtAa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAa.setText("Ann\u00E9e");
		txtAa.setBounds(248, 137, 79, 24);
		frame.getContentPane().add(txtAa);
		txtAa.setColumns(10);
		String [] k = {"janvier","février","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","décembre"};
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
	comboBox.setMaximumRowCount(12);
		comboBox.setBounds(149, 134, 80, 27);
		frame.getContentPane().add(comboBox);
		
		
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(98, 134, 45, 27);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Min");
		lblNewLabel_2.setBounds(231, 168, 46, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("h");
		lblNewLabel_6.setBounds(159, 167, 24, 21);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(GestionRDV.class.getResource("/images/Agenda.jpg")));
		lblNewLabel_7.setBounds(0, 0, 882, 616);
		frame.getContentPane().add(lblNewLabel_7);
	}
	public Connection conn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
					return cn;}
		catch(Exception e) {
			System.out.println(e);
		}return null;
		
	}
}

