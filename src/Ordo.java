import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class Ordo {

	JFrame frame;
	private JTextField txtOrdonance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordo window = new Ordo();
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
	public Ordo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 564, 803);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnDateNomEt = new JTextPane();
		txtpnDateNomEt.setBackground(SystemColor.controlLtHighlight);
		txtpnDateNomEt.setFont(new Font("Tahoma", Font.BOLD, 14));
		LocalDate d = LocalDate.now();
		txtpnDateNomEt.setText("                                                                                                            DATE:2020-06-24\r\n\r\n\r\nNOM et PRENOM :\r\nAGE:\r\n\r\n\r\n                                                    MEDICAMENTS                        \r\n");
		txtpnDateNomEt.setBounds(0, 38, 550, 663);
		frame.getContentPane().add(txtpnDateNomEt);
		
		txtOrdonance = new JTextField();
		txtOrdonance.setEnabled(false);
		txtOrdonance.setEditable(false);
		txtOrdonance.setBackground(SystemColor.inactiveCaptionBorder);
		txtOrdonance.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtOrdonance.setText("ORDONANCE");
		txtOrdonance.setHorizontalAlignment(SwingConstants.CENTER);
		txtOrdonance.setBounds(0, 0, 550, 40);
		frame.getContentPane().add(txtOrdonance);
		txtOrdonance.setColumns(10);
		
		JButton btnNewButton = new JButton("IMPRIMER");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean hh = txtOrdonance.print();
					if(hh) {
						JOptionPane.showMessageDialog(null, "IMPRESSION EN COURS");
					} else JOptionPane.showMessageDialog(null, "ATTENTION!! L'ORDONNANCE N'A PAS ETE IMPRIMEE");
					
				} catch (PrinterException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(193, 718, 155, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
