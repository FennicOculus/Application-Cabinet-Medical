import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
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
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.ScrollPane;

public class Fbilan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fbilan frame = new Fbilan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fbilan() {
		setResizable(false);
		setType(Type.POPUP);
		setTitle("Bilan");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("ID Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 34, 79, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField() {
			
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setOpaque(false);
		textField.setBackground(new Color(0,0,0,(float)0.2));
		textField.setBounds(86, 34, 128, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Analyses");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 169, 79, 26);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea() {
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};
		textArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 13));
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setBackground(new Color(0,0,0,(float)0.2));
		textArea.setBackground(new Color(0, 0, 0,20));
		JScrollPane scrollPane_1 = new JScrollPane(textArea) {
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
		scrollPane_1.setOpaque(false);
		getContentPane().add(scrollPane_1);
		scrollPane_1.setBounds(10, 206, 203, 101);
		contentPane.add(scrollPane_1);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(255, 34, 102, 26);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
						try {//Ajout
							Statement st = conn().createStatement();
							String rq = "INSERT INTO BILAN VALUES (?,?)";
							PreparedStatement pp = conn().prepareStatement(rq);
							pp.setString(1,textField.getText().toString());
							pp.setString(2,textArea.getText().toString());
							ResultSet rs = pp.executeQuery();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Consulter");
		btnNewButton_1.setBounds(367, 34, 102, 26);
		contentPane.add(btnNewButton_1);
		JTable AfficherBilan = new JTable();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {//consultation des données stockée dans la table bilan
					String rq = "SELECT * FROM BILAN WHERE CODEP="+textField.getText();
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					AfficherBilan.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.toString());
				}
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
		};
		scrollPane.setBounds(265, 71, 358, 276);
		contentPane.add(scrollPane);
		scrollPane.setOpaque(false);
		scrollPane.setBackground(new Color(0,0,0,(float)0.2));
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setViewportView(AfficherBilan);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Fbilan.class.getResource("/images/Bilan.jpg")));
		lblNewLabel_2.setBounds(-60, -45, 720, 475);
		contentPane.add(lblNewLabel_2);
		AfficherBilan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String CodeP,Analyses;
				int LigneSelec = AfficherBilan.getSelectedRow();
				//en cliquant sur une ligne de jtable les infos seront saisie dans les textfeild approprié
				CodeP = AfficherBilan.getModel().getValueAt(LigneSelec,0).toString();
				Analyses = AfficherBilan.getModel().getValueAt(LigneSelec, 1).toString();
				
				textField.setText(CodeP);
				textArea.setText(Analyses);
				
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
}
