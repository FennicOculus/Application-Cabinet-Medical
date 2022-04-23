import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.PieSectionEntity;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.util.Rotation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Panel;
import javax.swing.ImageIcon;


public class StatsFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtAnne;
	private JTextField txtAnne_1;
	private JTextField txtAnne_2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsFrame frame = new StatsFrame();
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
	public StatsFrame() {
		setTitle("Statistiques");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(290, 24, 544, 356);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		
		txtAnne = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtAnne.setOpaque(false);
		txtAnne.setBackground(new Color(0,0,0,(float)0.2));
		txtAnne.setText("JJ-MM-AA");
		txtAnne.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnne.setBounds(104, 24, 162, 32);
		contentPane.add(txtAnne);
		txtAnne.setColumns(10);
		
		txtAnne_1 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtAnne_1.setOpaque(false);
		txtAnne_1.setBackground(new Color(0,0,0,(float)0.2));
		txtAnne_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnne_1.setText("JJ-MM-AA");
		txtAnne_1.setColumns(10);
		txtAnne_1.setBounds(104, 67, 162, 32);
		contentPane.add(txtAnne_1);
		
		txtAnne_2 = new JTextField(){
			protected void paintComponent(Graphics g)
		    {
		        g.setColor( getBackground() );
		        g.fillRect(0, 0, getWidth(), getHeight());
		        super.paintComponent(g);
		    }
			
		};
		txtAnne_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnne_2.setText("Ann\u00E9e");
		txtAnne_2.setOpaque(false);
		txtAnne_2.setBackground(new Color(0,0,0,(float)0.2));
		txtAnne_2.setBounds(149, 239, 117, 32);
		contentPane.add(txtAnne_2);
		txtAnne_2.setColumns(10);
		
		String d1 = txtAnne.getText();
		String d2= txtAnne_1.getText();
		
		JButton btnNewButton_4 = new JButton("Patient Par Mois");
		btnNewButton_4.setBounds(10, 239, 133, 32);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					String rq = "SELECT count(*),EXTRACT(MONTH FROM DATECONS) FROM consultation where EXTRACT(YEAR FROM DATECONS) = '"+txtAnne_2.getText()+"' group by EXTRACT(MONTH FROM DATECONS)ORDER BY EXTRACT(MONTH FROM DATECONS) ASC";
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					while (rs.next()) {
						int value = rs.getInt("COUNT(*)");
						String columnKey =Month.of(rs.getInt("EXTRACT(MONTHFROMDATECONS)")).getDisplayName(TextStyle.FULL,Locale.FRANCE.FRENCH);
						dataset.setValue(value,"Patients", columnKey);
						
					}
					JFreeChart PatientPeriod = ChartFactory.createLineChart("Patient Par Année","Année","Nombre de Patient",dataset,PlotOrientation.VERTICAL,true,true,false);
					ChartPanel Line = new ChartPanel(PatientPeriod);
					panel.add(Line);
					Line.setSize(544,356);
					panel.setVisible(true);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Veillez Saisir Une Année Valide");
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("Patient Par Ann\u00E9e");
		btnNewButton_3.setBounds(10, 282, 133, 32);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					String rq = "SELECT count(*),EXTRACT(YEAR FROM DATECONS) FROM consultation group by EXTRACT(YEAR FROM DATECONS)ORDER BY EXTRACT(YEAR FROM DATECONS) ASC";
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					while (rs.next()) {
						int value = rs.getInt("COUNT(*)");
						String columnKey = rs.getString("EXTRACT(YEARFROMDATECONS)");
						dataset.setValue(value,"Patients", columnKey);
						
					}
					JFreeChart PatientPeriod = ChartFactory.createLineChart("Patient Par Année","Année","Nombre de Patient",dataset,PlotOrientation.VERTICAL,true,true,false);
					ChartPanel Line = new ChartPanel(PatientPeriod);
					panel.add(Line);
					Line.setSize(544,356);
					panel.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Sexe Par P\u00E9riode");
		btnNewButton_1.setBounds(58, 196, 133, 32);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultPieDataset dataset = new DefaultPieDataset();
				try {
					String rq = "SELECT SEXE,COUNT(SEXE) FROM PATIENT WHERE CODEP IN (SELECT CODEP FROM S WHERE D BETWEEN '"+txtAnne.getText()+"' AND '"+txtAnne_1.getText()+"')GROUP BY SEXE";
					
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					while (rs.next()) {
						String MALADIE;
						if (rs.getString("SEXE").equals("H")) {
							MALADIE = "Homme";
					    }
						else {
							MALADIE = "Femme";
						}
					    int COUNT = rs.getInt("COUNT(SEXE)");
					    dataset.setValue(MALADIE,COUNT); 
					    }
					JFreeChart PieChartObject=ChartFactory.createPieChart3D("Patients par Sexe",dataset,true,true,false);
				    
					PiePlot3D plot = (PiePlot3D) PieChartObject.getPlot();
				    plot.setStartAngle(150);
				    plot.setDirection(Rotation.CLOCKWISE);
				    plot.setForegroundAlpha(0.7f);
				    plot.setNoDataMessage("Aucune Donnée");
				    PieSectionLabelGenerator Label = new StandardPieSectionLabelGenerator("({2})",new DecimalFormat("0"),new DecimalFormat("0%"));
				    ((PiePlot)PieChartObject.getPlot()).setLabelGenerator(Label);
				    
				    ChartPanel Pie = new ChartPanel(PieChartObject);
				    pp.close();
				    rs.close();
				    panel.add(Pie);
				    Pie.setSize(544,356);
				    panel.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Veillez Saisir Une Période Valide");
				}
			}
		});
		
		JButton btnNewButton = new JButton("Patients Par P\u00E9riode");
		btnNewButton.setBounds(58, 110, 133, 32);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JTable table = new JTable();
				JScrollPane scroll = new JScrollPane();
				try {
					String rq = "SELECT * FROM Consultation WHERE DATECONS BETWEEN '"+txtAnne.getText()+"' AND '"+txtAnne_1.getText()+"'";
					String sql = "select count(*) from CONSULTATION WHERE DATECONS BETWEEN '"+txtAnne.getText()+"' AND '"+txtAnne_1.getText()+"'";
					PreparedStatement pp1 = conn().prepareStatement(sql);
					ResultSet rs1 = pp1.executeQuery();
					if(rs1.next()) {
						String add = rs1.getString("count(*)");
						JOptionPane.showMessageDialog(null,"le nombre de Conqultation faites  entre le "+txtAnne.getText()+" et le "+txtAnne_1.getText()+" est de: "+add);
						}
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					panel.add(scroll);
					scroll.setSize(544,356);
					scroll.setViewportView(table);
					panel.setVisible(true);
					scroll.setVisible(true);
					
					
				} catch (SQLDataException e1) {
					JOptionPane.showMessageDialog(null,"Veillez Saisir Une Période Valide");
				}catch(SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
				}
				
			}	
		});
		
		JButton btnNewButton_2 = new JButton("Maladies  Par P\u00E9riode");
		btnNewButton_2.setBounds(58, 153, 133, 32);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DefaultPieDataset dataset = new DefaultPieDataset();
				try {
					String rq = "SELECT MAL,count(*) FROM MALADIES WHERE D BETWEEN '"+txtAnne.getText()+"' and '"+txtAnne_1.getText()+"' GROUP BY MAL";
					PreparedStatement pp = conn().prepareStatement(rq);
					ResultSet rs = pp.executeQuery();
					while (rs.next()) {
					    String MALADIE = rs.getString("MAL");
					    int COUNT = rs.getInt("COUNT(*)");
					    dataset.setValue(MALADIE,COUNT); 
					    }
					JFreeChart PieChartObject=ChartFactory.createPieChart3D("Maladies",dataset,true,true,false);
				    
					PiePlot3D plot = (PiePlot3D) PieChartObject.getPlot();
				    plot.setStartAngle(150);
				    plot.setDirection(Rotation.CLOCKWISE);
				    plot.setForegroundAlpha(0.7f);
				    plot.setNoDataMessage("Aucune Donnée");
				    PieSectionLabelGenerator Label = new StandardPieSectionLabelGenerator("({2})",new DecimalFormat("0"),new DecimalFormat("0%"));
				    ((PiePlot)PieChartObject.getPlot()).setLabelGenerator(Label);
				    
				    ChartPanel Pie = new ChartPanel(PieChartObject);
				    pp.close();
				    rs.close();
				    panel.add(Pie);
				    Pie.setSize(544,356);
				    panel.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
					JOptionPane.showMessageDialog(null,"Veillez Saisir Une Période Valide");
				}
				
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Date D\u00E9but:");
		lblNewLabel.setBounds(16, 24, 90, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblDateFin = new JLabel("Date Fin:");
		lblDateFin.setBounds(16, 67, 90, 32);
		contentPane.add(lblDateFin);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(592, 398, 85, 21);
		contentPane.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Clickedbutton=	JOptionPane.showConfirmDialog(null, "etes-vous sur de revenir au menu?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
					MenuMédecin window = new MenuMédecin();
					window.frame1.setVisible(true);
					dispose();
			}
			}
		});
		JButton btnNewButton_2_1 = new JButton("Exit");
		btnNewButton_2_1.setBounds(749, 398, 85, 21);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StatsFrame.class.getResource("/images/Stats.jpg")));
		lblNewLabel_1.setBounds(0, 0, 856, 441);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("New button");
		button.setBounds(20, 153, 89, 23);
		contentPane.add(button);
		
		
		
		

		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Clickedbutton=	JOptionPane.showConfirmDialog(null, "etes-vous sur de Quitter?","EXIT",JOptionPane.YES_NO_OPTION);
				if(Clickedbutton==JOptionPane.YES_OPTION) {
					dispose();
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
}

