import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import oracle.sql.DATE;

public class RDV {
private String heure;
private String D;
private String nom,prenom,email,tel;
private int IDRDV;

public RDV(String heure, String d, String nom, String prenom, String email, String tel) {
	super();
	this.heure = heure;
	D = d;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.tel = tel;
	//le numero de rendez-vous est composee de la date et l'heure comme clé primairepour ne pas avoir 2 rendez-vous dans la meme journée
	int k=d.concat(heure).hashCode()/106937;
	if(k<0) {
		IDRDV=k*(-1);
	}else {
		IDRDV=k;
	}
}

public String getHeure() {
	return heure;
}

public void setHeure(String heure) {
	this.heure = heure;
}

public String getD() {
	return D;
}


public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
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
public void ajouterrdv()  {
	
	try {
	
			//ajouter	
			Statement stt =conn().createStatement();
	
		String rq="INSERT INTO rdv VALUES(?,?,?,?,?,?,?)";
		PreparedStatement	pp = conn().prepareStatement(rq);
		
		pp.setString(1, nom);
		pp.setString(2, prenom);
		pp.setString(3,D);
		pp.setString(4, heure);
		pp.setString(5, email);
		pp.setString(6, tel);
		pp.setInt(7, IDRDV);
		
		ResultSet rss= pp.executeQuery();
		}
		catch (SQLIntegrityConstraintViolationException e) {
			
			JOptionPane.showMessageDialog(null, "RENDEZ-VOUS DEJA PRIS");
			System.out.println(e);
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1.toString());
		}
		
		
	
}
public void supprimer(String id) {
	//suppression
	String sql = "DELETE FROM RDV WHERE IDRDV="+id+"";
	try {
		PreparedStatement pp = conn().prepareStatement(sql);
		pp.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e);
	}
	
	
}
public void modifier1(String id) {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Projet","system","test");
		String rq = "UPDATE RDV SET NOM='"+nom+"' ,PRENOM='"+prenom+"' ,DATE_RDV='"+D+"' ,HEURE='"+heure+"' , EMAIL='"+email+"' ,TEL='"+tel+"'WHERE IDRDV='"+id+"'";
	    PreparedStatement pp=cn.prepareStatement(rq);
	    pp.execute();
	}catch(SQLException e) {
		System.out.println(e);
	}
	catch(NullPointerException ee) {
		JOptionPane.showMessageDialog(null, "DATE NOT FOUND");
	}
	catch(ClassNotFoundException e4) {
		e4.getStackTrace();
		JOptionPane.showMessageDialog(null, e4.toString());
	}
}
}

