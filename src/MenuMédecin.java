

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.Color;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuMédecin {

	JFrame frame1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					MenuMédecin window = new MenuMédecin();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuMédecin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setResizable(false);
		frame1.setTitle("Menu");
		frame1.setBounds(100, 100, 827, 524);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,5));
		panel.setBounds(0, 0, 315, 466);
		frame1.getContentPane().add(panel);
		panel.setLayout(null);
		
		Button button = new Button("Gestion Patient");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//gestion de patient
				GestionPatient window = new GestionPatient();
				window.frame.setVisible(true);
				//frame1.dispose();	
		
					
				frame1.setVisible(false);
			 
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 12));
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(SystemColor.inactiveCaptionBorder);
		button.setBounds(0, 157, 315, 39);
		panel.add(button);
		
		Button button_1 = new Button("Consulter Agenda");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//consulter agenda
				ConsulterAgenda window = new ConsulterAgenda();
				window.frame.setVisible(true);
				frame1.setVisible(false);
				//frame1.dispose();
			}
		});
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		button_1.setBackground(SystemColor.inactiveCaptionBorder);
		button_1.setBounds(0, 202, 315, 39);
		panel.add(button_1);
		
		Button button_2 = new Button("Consultation");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//etablir  la consultation
				ConsultationMédical window = new ConsultationMédical();
				window.frame.setVisible(true);
				frame1.setVisible(false);
				
			}
		});
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setBackground(SystemColor.inactiveCaptionBorder);
		button_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		button_2.setBounds(0, 247, 315, 39);
		panel.add(button_2);
		
		Button button_3 = new Button("Statistiques");
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		button_3.setBounds(0, 292, 315, 39);
		panel.add(button_3);
		button_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				StatsFrame Stats = new StatsFrame();
				Stats.setVisible(true);
				frame1.setVisible(false);
			}
		});
		
		Button button_4 = new Button("Mes Patients");
		button_4.setFont(new Font("Dialog", Font.PLAIN, 12));
		button_4.setForeground(Color.DARK_GRAY);
		button_4.setBounds(0, 337, 315, 39);
		panel.add(button_4);
		
		JButton btnNewButton = new JButton("Gestion Compte");
		btnNewButton.setBounds(0, 432, 116, 34);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CreationCompte CC = new CreationCompte();
				CC.setVisible(true);
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataBase DB = new DataBase();
				DB.setVisible(true);
				frame1.setVisible(false);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(0, -11, 813, 537);
		frame1.getContentPane().add(panel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MenuMédecin.class.getResource("/images/JABAKELB.jpg")));
		
		
	}
}
