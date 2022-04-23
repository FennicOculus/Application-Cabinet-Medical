import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DossierMedical {
	
	private String CodePatient;
	private String GroupeSanguin;
	private float Taille;
	private float Poid;
	private int TentionS;
	private int TentionD;
	private String Allergie;
	private String MaladieChronique;
	
	public String getCodePatient() {
		return CodePatient;
	}
	public void setCodePatient(String codePatient) {
		CodePatient = codePatient;
	}
	public String getGroupeSanguin() {
		return GroupeSanguin;
	}
	public void setGroupeSanguin(String groupeSanguin) {
		GroupeSanguin = groupeSanguin;
	}
	public float getTaille() {
		return Taille;
	}
	public void setTaille(float taille) {
		Taille = taille;
	}
	public float getPoid() {
		return Poid;
	}
	public void setPoid(float poid) {
		Poid = poid;
	}
	public int getTentionS() {
		return TentionS;
	}
	public void setTentionS(int tentionS) {
		TentionS = tentionS;
	}
	public int getTentionD() {
		return TentionD;
	}
	public void setTentionD(int tentionD) {
		TentionD = tentionD;
	}
	public String getAllergie() {
		return Allergie;
	}
	public void setAllergie(String allergie) {
		Allergie = allergie;
	}
	public String getMaladieChronique() {
		return MaladieChronique;
	}
	public void setMaladieChronique(String maladieChronique) {
		MaladieChronique = maladieChronique;
	}
	
	public DossierMedical(String Codep) {
		this.CodePatient=Codep;
	}
	public DossierMedical(String codePatient, String groupeSanguin, float taille, float poid, int tentionS, int tentionD,
			String allergie, String maladieChronique) {
		CodePatient = codePatient;
		GroupeSanguin = groupeSanguin;
		Taille = taille;
		Poid = poid;
		TentionS = tentionS;
		TentionD = tentionD;
		Allergie = allergie;
		MaladieChronique = maladieChronique;
	}
	
	public Connection conn(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
			return cn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void AjouterDM() {
		
		try {
			//Ajout
			Statement st = conn().createStatement();
			String rq = "INSERT INTO DOSSIERMED VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pp = conn().prepareStatement(rq);
			pp.setString(1, CodePatient);
			pp.setString(2, GroupeSanguin);
			pp.setFloat(3, Taille);
			pp.setFloat(4, Poid);
			pp.setInt(5, TentionS);
			pp.setInt(6, TentionD);
			pp.setString(7, Allergie);
			pp.setString(8, MaladieChronique);
			ResultSet rs = pp.executeQuery();
		} catch (SQLIntegrityConstraintViolationException e) {
			//pour traiter l'exception de si le médecin se trompe ou saisie un patient qui n'existe pas d	ans la BDD
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "patient inexistant");
		}catch(Exception e1) {
			//pour traiter tout genre d'exception (sqlexception....)
			JOptionPane.showMessageDialog(null, e1.toString());
		}
		
	}

	public void ModifierDM() {
		
		try {
			//Modification
			Statement st = conn().createStatement();
			String rq = "UPDATE DOSSIERMED Set Taille="+(float)Taille+",POID="+(float)Poid+",T_SYSTOLIQUE= "+TentionD+",T_DIASTOLIQUE="+TentionS+",ALLERGIES='"+Allergie+"',MALADIES_CHRONIQUE='"+MaladieChronique+"' ,GROUPE_SANGUIN ='"+GroupeSanguin+"' WHERE CODEP='"+CodePatient+"'" ;
			PreparedStatement pp = conn().prepareStatement(rq);
			ResultSet rs = pp.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.toString());
			
		}
	}
	
	
	public void SupprimerDM(String CodeP) {
		
		try {
			//Suppression
			Statement st = conn().createStatement();
			String rq = "DELETE FROM DOSSIERMED WHERE CODEP= '"+CodeP+"' " ;
			PreparedStatement pp = conn().prepareStatement(rq);
			ResultSet rs = pp.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
	
	public void AjouterMAJDM(String CodeP,float Taille,float Poid,int TentionS,int TentionD,String Allergies,String MaladiesChronique) {
		try { String groupeSang="";
		
			Statement st = conn().createStatement();
			String rq = "INSERT INTO DOSSIERMED VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pp = conn().prepareStatement(rq);
			String r1="select GROUPE_SANGUIN from dossiermed where codep='"+CodeP+"'";
			PreparedStatement p = conn().prepareStatement(r1);
			ResultSet rs = p.executeQuery();
			while(rs.next()) {
				groupeSang= rs.getString("GROUPE_SANGUIN");
				 
			}
			pp.setString(1, CodeP);
			pp.setString(2,groupeSang);
			pp.setFloat(3, Taille);
			pp.setFloat(4, Poid);
			pp.setInt(5, TentionS);
			pp.setInt(6, TentionD);
			pp.setString(7, Allergies);
			pp.setString(8, MaladiesChronique);
			ResultSet rs1 = pp.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NumberFormatException NumberFormatE) {
			JOptionPane.showMessageDialog(null,NumberFormatE.toString());
		}
	}
	public DossierMedical() {
	}
}



