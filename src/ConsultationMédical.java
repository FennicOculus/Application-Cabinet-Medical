import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PopupMenu;

import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.text.DateFormat;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.ScrollPane;

public class ConsultationMédical {

	JFrame frame;
	private JTextField txtAa;
	private JTextField JCodeP;
	private JTextField JTraitement;
	private JTextField JDIagnostique;
	private JTextField JMontantAPayer;
	private JTextField JObservation;
	private JTable table;
	private JTextField textField_7;
	private JTextField JNom;
	private JTextField JPrenom;
	private JTextField JTaille;
	private JTextField JPoid;
	private JTextField JTentionS;
	private JTextField JTentionD;
	private JTextField JAllergie;
	private JTextField JMaladesChro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultationMédical window = new ConsultationMédical();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsultationMédical() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Consultation");
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setBounds(100, 100, 1079, 634);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 51, 121, 25);
		frame.getContentPane().add(lblNewLabel);
		
		txtAa = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor(getBackground());
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtAa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtAa.setOpaque(false);
		txtAa.setBackground(new Color(0,0,0,(float)0.1));
		txtAa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAa.setText("Ann\u00E9e");
		txtAa.setBounds(288, 498, 62, 26);
		frame.getContentPane().add(txtAa);
		txtAa.setColumns(10);
		
		JCodeP = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JCodeP.setOpaque(false);
		JCodeP.setBackground(new Color(0,0,0,(float)0.2));
		JCodeP.setBounds(141, 51, 153, 25);
		frame.getContentPane().add(JCodeP);
		JCodeP.setColumns(10);
		
		JTraitement = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JTraitement.setOpaque(false);
		JTraitement.setBackground(new Color(0,0,0,(float)0.2));
		JTraitement.setBounds(141, 159, 153, 29);
		frame.getContentPane().add(JTraitement);
		JTraitement.setColumns(10);
		
		JDIagnostique = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JDIagnostique.setText("Maladie1,Maladie2, ...");
		JDIagnostique.setOpaque(false);
		JDIagnostique.setBackground(new Color(0,0,0,(float)0.2));
		JDIagnostique.setBounds(141, 198, 153, 29);
		frame.getContentPane().add(JDIagnostique);
		JDIagnostique.setColumns(10);
		
		JMontantAPayer = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JMontantAPayer.setOpaque(false);
		JMontantAPayer.setBackground(new Color(0,0,0,(float)0.2));
		JMontantAPayer.setBounds(141, 238, 153, 31);
		frame.getContentPane().add(JMontantAPayer);
		JMontantAPayer.setColumns(10);
		
		JObservation = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JObservation.setOpaque(false);
		JObservation.setBackground(new Color(0,0,0,(float)0.2));
		JObservation.setBounds(141, 535, 151, 29);
		frame.getContentPane().add(JObservation);
		JObservation.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Traitement");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 163, 121, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Diagnostique");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 198, 121, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Montant \u00E0 payer");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 238, 121, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date Consultation");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 498, 133, 26);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Observation");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 535, 121, 27);
		frame.getContentPane().add(lblNewLabel_6);
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//récupérer le nom et prénom du patient
				try {
					String nom="";
					String prenom="";
					String r1="SELECT NOM,PRENOM FROM PATIENT WHERE CODEP='"+JCodeP.getText()+"'";
					PreparedStatement p=conn().prepareStatement(r1);
					ResultSet rs = p.executeQuery();
					while(rs.next()) {
						nom=rs.getString("NOM");
						prenom=rs.getString("PRENOM");
						
					}
					JNom.setText(nom);
					JPrenom.setText(prenom);
				} catch(SQLException excep) {System.out.println(excep);}
				//s est la date
				String s = String.format("%s-%s-%s",comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),txtAa.getText());
				int kk =0;
				Consul cn = new Consul(JObservation.getText(), JCodeP.getText(), JTraitement.getText(), JDIagnostique.getText(), s, JMontantAPayer.getText());
				cn.ajouterconsul();
				DossierMedical DM = new DossierMedical();
				try {
					DM.AjouterMAJDM(JCodeP.getText(),Float.parseFloat(JTaille.getText()),Float.parseFloat(JPoid.getText()),Integer.parseInt(JTentionS.getText()),Integer.parseInt(JTentionD.getText()),JAllergie.getText(),JMaladesChro.getText());
				} catch (NumberFormatException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Veillez Saisir Un poid, Une Taille et une Tention Valide"); 
				}
				String mot[] = JDIagnostique.getText().split(",");
				 //on cree une table S qui contient le codep comme clé primaire et sa date de consultation pour ne pas contabiliser le patient plus d'une fois dans les satistiques
			     try {
			    	 String sql ="INSERT INTO S VALUES(?,?)";
			    		PreparedStatement pp = conn().prepareStatement(sql);
			    			pp.setString(1, JCodeP.getText());
			    			pp.setString(2, s);
			    			
			    			ResultSet rs = pp.executeQuery();
			    			
			     }
			     catch(SQLException ek){
			    	 //JOptionPane.showMessageDialog(null, ek.toString());
			     }
			    
			     //on cree une autre table qui contient la maladie et le codep comme clé primaire composé afin d'éviter de contabiliser le patient qui fait plus d une consultation pour la meme maladie
			     for(int i=0;i<mot.length;i++) {
			    		try {

			    			String sql ="INSERT INTO MALADIES VALUES(?,?,?)";
			    		    PreparedStatement pp = conn().prepareStatement(sql);
			    			pp.setString(1, mot[i]);
			    			pp.setString(2, s);
			    			pp.setString(3, JCodeP.getText());
			    			ResultSet rs = pp.executeQuery();
			    			
			    			}catch(SQLException ee) {
			    		    	JOptionPane.showMessageDialog(null, ee.toString());
			 				    
			    		}
				

			
			     }}});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(360, 500, 85, 36);
		frame.getContentPane().add(btnNewButton);
		
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
		scrollPane.setBounds(394, 11, 644, 223);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					int ligne =table.getSelectedRow();
					
					String nom,prenom,m,t,mp,obs,nc;
					//affichage du contenu de la ligne du jtable dans les textfeild 
					nc=table.getModel().getValueAt(ligne, 0).toString();
					obs=table.getModel().getValueAt(ligne, 1).toString();
					m=table.getModel().getValueAt(ligne, 2).toString();
					t=table.getModel().getValueAt(ligne, 3).toString();
					mp=table.getModel().getValueAt(ligne, 5).toString();
					nom=table.getModel().getValueAt(ligne, 6).toString();
					
					JCodeP.setText(nom);
					JTraitement.setText(m);
					JDIagnostique.setText(t);
					JMontantAPayer.setText(mp);
					JObservation.setText(obs);
					textField_7.setText(nc);
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}});
		scrollPane.setViewportView(table);
		JButton btnNewButton_1 = new JButton("Consulter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//affichage des données stocké dans la  jtable
					String rq = "SELECT * FROM CONSULTATION WHERE CODEP='"+JCodeP.getText()+"'";
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "veuillez saisir l'id patient");
						
					}
				} 
				catch(Exception excep) {

			    	 JOptionPane.showMessageDialog(null, excep.toString());
			    	 }
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(611, 245, 134, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String s = String.format("%s-%s-%s",comboBox_1.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),txtAa.getText());
					
								try {
									//s est la date
                    Consul cn = new Consul(JObservation.getText(), JCodeP.getText(), JTraitement.getText(), JDIagnostique.getText(), s, JMontantAPayer.getText());
					cn.modifier1(textField_7.getText());
					JOptionPane.showMessageDialog(null, "Consultation Modifiée");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			    	 JOptionPane.showMessageDialog(null, e1.toString());
					    
				}
			
			}});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(360, 546, 85, 36);
		frame.getContentPane().add(btnNewButton_2);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(143, 11, 151, 29);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("N\u00B0 Consultation");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 11, 121, 24);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"}));
		comboBox.setBounds(196, 498, 81, 26);
		frame.getContentPane().add(comboBox);
		
	
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(141, 498, 51, 26);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Clickedbutton=	JOptionPane.showConfirmDialog(null, "etes-vous sur de Quitter?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
					
					frame.dispose();
				}
			
			}
		});
		btnNewButton_4.setBounds(953, 543, 85, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		
		JButton btnNewButton_3 = new JButton("Ordonnance");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ordo window = new Ordo();
					window.frame.setVisible(true);
				}
			});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(634, 546, 111, 36);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int Clickedbutton=	JOptionPane.showConfirmDialog(null, "etes-vous sur de revenir au menu?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
					MenuMédecin window = new MenuMédecin();
					window.frame1.setVisible(true);
					frame.dispose();
				}
			}
		});
		btnMenu.setBounds(786, 543, 85, 21);
		frame.getContentPane().add(btnMenu);
		JTable AffichageDossierMed = new JTable();
		
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
		JButton btnNewButton_5 = new JButton("Suivie M\u00E9dical");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {//affichage du contenu de la table dossier médicale dans la jtable
					String rq = "SELECT * FROM DOSSIERMED WHERE CODEP='"+JCodeP.getText()+"'";
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					AffichageDossierMed.setModel(DbUtils.resultSetToTableModel(rs));
					if(AffichageDossierMed.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"Veuillez Introduire Le code Patient ");
							
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.toString());
				}
			}
		});
		scrollPane_1.setViewportView(AffichageDossierMed);
		btnNewButton_5.add(new PopupMenu());
		btnNewButton_5.setBounds(611, 431, 127, 36);
		frame.getContentPane().add(btnNewButton_5);
		scrollPane_1.setBounds(394, 290, 644, 117);
		frame.getContentPane().add(scrollPane_1);
		
		JNom = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JNom.setOpaque(false);
		JNom.setBackground(new Color(0,0,0,(float)0.2));
		JNom.setBounds(141, 87, 153, 25);
		frame.getContentPane().add(JNom);
		JNom.setColumns(10);
		
		JPrenom = new JTextField()
		{
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JPrenom.setOpaque(false);
		JPrenom.setBackground(new Color(0,0,0,(float)0.2));
		JPrenom.setColumns(10);
		JPrenom.setBounds(141, 123, 153, 25);
		frame.getContentPane().add(JPrenom);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 87, 121, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 127, 121, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton_6 = new JButton("Bilan");
		btnNewButton_6.setBounds(539, 550, 85, 31);
		frame.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_4_1 = new JLabel("Taille");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(10, 280, 63, 31);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Tention");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_2.setBounds(10, 330, 63, 31);
		frame.getContentPane().add(lblNewLabel_4_2);
		
		JTaille = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JTaille.setOpaque(false);
		JTaille.setBackground(new Color(0,0,0,(float)0.2));
		JTaille.setBounds(75, 280, 56, 31);
		frame.getContentPane().add(JTaille);
		JTaille.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("m");
		lblNewLabel_8.setBounds(134, 291, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Poid");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_1_1.setBounds(173, 280, 51, 31);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		
		JPoid = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JPoid.setOpaque(false);
		JPoid.setBackground(new Color(0,0,0,(float)0.2));
		JPoid.setColumns(10);
		JPoid.setBounds(219, 280, 56, 31);
		frame.getContentPane().add(JPoid);
		
		JLabel lblNewLabel_8_1 = new JLabel("Kg");
		lblNewLabel_8_1.setBounds(285, 291, 46, 14);
		frame.getContentPane().add(lblNewLabel_8_1);
		
		JTentionS = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JTentionS.setOpaque(false);
		JTentionS.setBackground(new Color(0,0,0,(float)0.2));
		JTentionS.setColumns(10);
		JTentionS.setBounds(83, 330, 56, 31);
		frame.getContentPane().add(JTentionS);
		
		JLabel lblNewLabel_8_2 = new JLabel("mmHg");
		lblNewLabel_8_2.setBounds(142, 341, 46, 14);
		frame.getContentPane().add(lblNewLabel_8_2);
		
		JTentionD = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JTentionD.setOpaque(false);
		JTentionD.setBackground(new Color(0,0,0,(float)0.2));
		JTentionD.setColumns(10);
		JTentionD.setBounds(189, 330, 56, 31);
		frame.getContentPane().add(JTentionD);
		AffichageDossierMed.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int ligne =AffichageDossierMed.getSelectedRow();
				try {
				String taille,poid,ts,td,mc,al;
				//affichage du contenu de la ligne du jtable dans les textfeild 
				taille=AffichageDossierMed.getModel().getValueAt(ligne, 2).toString();
			    poid=AffichageDossierMed.getModel().getValueAt(ligne, 3).toString();
			    ts=AffichageDossierMed.getModel().getValueAt(ligne, 4).toString();
			    td=AffichageDossierMed.getModel().getValueAt(ligne, 5).toString();
			        JTaille.setText(taille);
			    JPoid.setText(poid);
			    JTentionS.setText(ts);
			    JTentionD.setText(td);
			    }
				catch(NullPointerException ee) {
					
				}
			    
			    
			}});
		JLabel lblNewLabel_8_3 = new JLabel("mmHg");
		lblNewLabel_8_3.setBounds(248, 341, 46, 14);
		frame.getContentPane().add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("Allergie");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_3.setBounds(10, 382, 121, 31);
		frame.getContentPane().add(lblNewLabel_4_3);
		
		JAllergie = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JAllergie.setOpaque(false);
		JAllergie.setBackground(new Color(0,0,0,(float)0.2));
		JAllergie.setColumns(10);
		JAllergie.setBounds(141, 382, 153, 31);
		frame.getContentPane().add(JAllergie);
		
		JLabel lblNewLabel_4_4 = new JLabel("Maladies Chronique");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4_4.setBounds(10, 436, 121, 31);
		frame.getContentPane().add(lblNewLabel_4_4);
		
		JMaladesChro = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		JMaladesChro.setOpaque(false);
		JMaladesChro.setBackground(new Color(0,0,0,(float)0.2));
		JMaladesChro.setColumns(10);
		JMaladesChro.setBounds(141, 436, 153, 31);
		frame.getContentPane().add(JMaladesChro);
		
		btnNewButton_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Fbilan Bilan = new Fbilan();
				Bilan.setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setIcon(new ImageIcon(ConsultationMédical.class.getResource("/images/Consultation.jpg")));
		lblNewLabel_9.setBounds(-120, 0, 1200, 650);
		frame.getContentPane().add(lblNewLabel_9);
		
		
	}
	public JTextField getTextField_1() {
		return JCodeP;
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

