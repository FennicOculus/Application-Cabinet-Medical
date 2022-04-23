import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class DataBase extends JFrame {
	private JTextField txtCodep;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataBase frame = new DataBase();
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
	public DataBase() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.POPUP);
		setTitle("Mes Patients");
		setBounds(100, 100, 720, 452);
		getContentPane().setLayout(null);
		
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
		scrollPane.setBounds(227, 10, 467, 294);
		getContentPane().add(scrollPane);
		
		txtCodep = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtCodep.setEditable(false);
		txtCodep.setOpaque(false);
		txtCodep.setBackground(new Color(0,0,0,(float)0.2));
		txtCodep.setBounds(20, 52, 112, 32);
		getContentPane().add(txtCodep);
		txtCodep.setColumns(10);
		
		JTable table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int ligne =table.getSelectedRow();
				String CodeP;
				
				CodeP=table.getModel().getValueAt(ligne, 0).toString();
				
				txtCodep.setText(CodeP);
				int nummax=0;
				String date=null;
				int b=0;
				String sql1="SELECT * FROM CONSULTATION WHERE CODEP= '"+txtCodep.getText()+"'";
				try {
				PreparedStatement p = conn().prepareStatement(sql1);
				     ResultSet rs=p.executeQuery();
				     int nb=0;
				     while(rs.next()) {
				    	 String i=rs.getString(1);
				    	 nb=Integer.valueOf(i);
				    	 if(nb>nummax) {
				    		 nummax=nb;
				    		 date=rs.getString(5);
				    		 
				    	 }
				    	 
				     }
				     
				    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
			    	LocalDate actu = LocalDate.now();
			    	Date dateactu= Date.from(actu.atStartOfDay(ZoneId.systemDefault()).toInstant());
			    	DateFormat dt= new SimpleDateFormat("yyyy-MM-dd");
			    	String dateact=dt.format(dateactu);
			    	Date date1= sdf.parse(dateact);
			    	Date date2= sdf.parse(date);
			    	long diffinmillies=Math.abs(date1.getTime()-date2.getTime());
			    	long diff=TimeUnit.DAYS.convert(diffinmillies,TimeUnit.MILLISECONDS);
			    	 //365 jurs*5=1825
			    	if(diff>=1825) {
			    	table.setSelectionForeground(Color.RED);
			    		
			    	}}catch(SQLException ee) {
			    		System.out.println(ee);
			    	} 
				catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}});
		
		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.setBounds(451, 326, 112, 32);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CodeP");
		lblNewLabel.setBounds(10, 10, 104, 32);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.setBounds(10, 129, 112, 32);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.setBounds(550, 369, 85, 21);
		getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int Clickedbutton=JOptionPane.showConfirmDialog(null, "etes-vous sur de quitter?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
				dispose();
			}
				}
		});
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(425, 369, 85, 21);
		getContentPane().add(btnMenu);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DataBase.class.getResource("/images/BaseDeDonnee.jpg")));
		lblNewLabel_1.setBounds(0, 0, 714, 423);
		getContentPane().add(lblNewLabel_1);
		btnMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int Clickedbutton=	JOptionPane.showConfirmDialog(null, "etes-vous sur de revenir au menu?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
					MenuMédecin window = new MenuMédecin();
					window.frame1.setVisible(true);
					dispose();
			}
				}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
					DossierMedical t1= new DossierMedical(txtCodep.getText());
					t1.SupprimerDM(txtCodep.getText());
					try {
						//Suppression de la table bilan
						Statement st = conn().createStatement();
						String rq = "DELETE FROM BILAN WHERE CODEP= '"+txtCodep.getText()+"' " ;
						PreparedStatement pp = conn().prepareStatement(rq);
						ResultSet rs = pp.executeQuery();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.toString());
					}
					try {
						//Suppression de la table S
						Statement st = conn().createStatement();
						String rq = "DELETE FROM S WHERE CODEP= '"+txtCodep.getText()+"' " ;
						PreparedStatement pp = conn().prepareStatement(rq);
						ResultSet rs = pp.executeQuery();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.toString());
					}
					Patient t = new Patient(txtCodep.getText());
					t.supp(txtCodep.getText());
				
				
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					//afficher les patient d'ordre croissant du plus ancient au nouveau avec la date d'inscription
					String rq = "SELECT * FROM PATIENT  JOIN S ON s.codep = patient.codep ORDER BY s.d ASC";
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					scrollPane.setViewportView(table);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.toString());
				} 
				
				
			}});
		
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
