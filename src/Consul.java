import java.sql.Connection;
	import java.sql.Date;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
	import java.time.LocalDate;
	import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Consul {
	
	
		 private String numcons;
		 private String obs,nom,prenom;
		 private String traitmntpr;
		 private String maladiediag;
		 private String datecons,cp;
		 private static int  k =1;
		
		private String montantpayé;
		public String getNumcons() {
			return numcons;
		}
		public String getMaladiediag() {
			return maladiediag;
		}
		public String getObs() {
			return obs;
		}
		public String getTraitmntpr() {
			return traitmntpr;
		}
		public String getDatecons() {
			return datecons;
		}
		public String getMontantpayé() {
			return montantpayé;
		}
		public Consul(String obs, String cp, String traitmntpr, String maladiediag,
				String datecons, String montantpayé) {
			super();
			
			LocalDate d = LocalDate.now();
					
			StringBuilder kk = new StringBuilder();
			//initialiser le numéro de consultation à un String 
			//compossé de la date du jour
	String rs =  kk.append(d.getDayOfMonth()).append(d.getMonthValue()).toString();
	
			this.numcons =rs;
			//k++;
			this.obs = obs;
		this.cp=cp;
			this.traitmntpr = traitmntpr;
			this.maladiediag = maladiediag;
			this.datecons = datecons;
			this.montantpayé = montantpayé;
			
		}
		public String getNom() {
			return nom;
		}
		public String getPrenom() {
			return prenom;
		}
	
		@Override
		public String toString() {
			return "Consultation [numcons=" + numcons + ", maladiediag=" + maladiediag + ", obs=" + obs + ", traitmntpr="
					+ traitmntpr + ", datecons=" + datecons + ", montantpayé=" + montantpayé + "]";
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
		public void ajouterconsul() {
			//création d'un séquenceur
			try {
				 String rq1="SELECT  C_sequ.NEXTVAL S FROM dual";
				 Statement p = conn().createStatement();
			  
			    ResultSet rs1= p.executeQuery(rq1);
			   int val=1;
			    if(rs1.next()) {
			    	val=rs1.getInt(1);
			    	 
			    	
			    }
			    //le numéro consultation sera donc composé du séquenceur et dela date du jour 
			    StringBuilder kk= new StringBuilder();
			    String l=kk.append(val).toString();
			    numcons=numcons.concat(l);
				Statement st = conn().createStatement();
				String rq = "INSERT INTO CONSULTATION VALUES (?,?,?,?,?,?,?)";
				PreparedStatement pp = conn().prepareStatement(rq);
				pp.setString(1, numcons);
				pp.setString(2, obs);
				pp.setNString(3, maladiediag);
				pp.setString(4, traitmntpr);
				pp.setString(5, datecons);
				pp.setString(6, montantpayé);
				pp.setString(7, cp);
			
				ResultSet rs = pp.executeQuery();
			} catch(SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(null, "patient inexistant");
			
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
			}
		
				
			}
		public void modifier1(String nc) {
			try {
				//Modification
				Class.forName("oracle.jdbc.OracleDriver");
				Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
				
				String rq = "UPDATE CONSULTATION SET OBS='"+obs+"' ,MALADIE='"+maladiediag+"' ,TRAITMNTPR='"+traitmntpr+"' ,DATECONS='"+datecons+"' , MONTANTP='"+montantpayé+"' ,CODEP='"+cp+"'WHERE NUMCONS='"+nc+"'";
			    PreparedStatement pp=cn.prepareStatement(rq);
			    pp.execute();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		}

		public void supprimer(String id) {

    		String sql2 = "DELETE FROM CONSULTATION WHERE CODEP= '"+id+"' ";
    		PreparedStatement p1;
			try {
				p1 = conn().prepareStatement(sql2);
				p1.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}




