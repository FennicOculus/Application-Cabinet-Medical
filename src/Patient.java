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

import javax.swing.JOptionPane;

public class Patient {
	private String codep,s,nom,prenom,email,tel,DN,DC,adr;
	
//le code patient est composé de l'annee d'inscription du patient et un numéro séquentiel
	public String getCodep() {
		return codep;
	}

	public void setCodep(String codep) {
		this.codep = codep;
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

	
	public Patient( String s, String nom, String prenom, String email, String tel, String dN, String dC,
			String adr) {
		super();
		LocalDate date= LocalDate.now();
		StringBuilder kk= new StringBuilder();
	    codep=kk.append(date.getYear()).toString();
		this.s = s;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		DN = dN;
		DC = dC;
		this.adr = adr;
	}
	
	public Patient(String codep) {
		this.codep=codep;
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
	public void ajoutpatient()  {
		
	
		
	try {	//ajout
		String rq1="SELECT  Codep_sequ.NEXTVAL S FROM dual";
		 Statement p = conn().createStatement();
	  
	    ResultSet rs1= p.executeQuery(rq1);
	   int val=1;
	    if(rs1.next()) {
	    	val=rs1.getInt(1);
	    	 
	    	
	    }
	    StringBuilder kk= new StringBuilder();
	    String l=kk.append(val).toString();
	    codep=codep.concat(l);
		String rq = "INSERT INTO PATIENT VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pp = conn().prepareStatement(rq);
		pp.setString(1, codep);
		pp.setString(2, nom);
		pp.setString(3, prenom);
		pp.setString(4, adr);
		pp.setString(5, email);
		pp.setString(6,tel);
		pp.setString(7, s);
		pp.setString(8, DN);
		pp.setString(9, DC);
		ResultSet rs = pp.executeQuery();}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, e.toString());
	}
	}
public void modifier(String cp) {
	try {//modification
	String rq = "UPDATE PATIENT SET NOM='"+nom+"' ,PRENOM='"+prenom+"' ,ADR='"+adr+"' ,EMAIL='"+email+"' , TEL='"+tel+"' ,SEXE='"+s+"' ,DATDEN='"+DN+"' ,DATEDEINSCR='"+DC+"'WHERE CODEP='"+cp+"'";
    PreparedStatement pp=conn().prepareStatement(rq);
    pp.execute();}
	catch(SQLException e) {
		JOptionPane.showMessageDialog(null, e.toString());
	}

	
	
}
public void supp(String cp) {
	int nummax=0;
	String date=null;
	int b=0;
	String sql1="SELECT * FROM CONSULTATION WHERE CODEP= '"+cp+"'";
	try {PreparedStatement p = conn().prepareStatement(sql1);
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
    		
    		//JOptionPane.showMessageDialog(null, "La Dernière Consultation De Ce Patient Remonte à 5 ans ");
    		int Clickedbutton=	JOptionPane.showConfirmDialog(null, "La Dernière Consultation De Ce Patient Remonte à Plus 5 ans \n\nVoulez Vous Vraiment Le Supprimer ?","Suppression",JOptionPane.YES_NO_OPTION);
			if(Clickedbutton==JOptionPane.YES_OPTION) {
    		DossierMedical d = new DossierMedical(cp);
    		d.SupprimerDM(cp);
    		String sq = "DELETE FROM BILAN WHERE CODEP= '"+cp+"' ";
    		PreparedStatement p1 = conn().prepareStatement(sq);
    		p1.execute();
    		String sql2 = "DELETE FROM CONSULTATION WHERE CODEP= '"+cp+"' ";
    		PreparedStatement p3 = conn().prepareStatement(sql2);
    		p3.execute();
	  		String sql3 = "DELETE FROM PATIENT WHERE CODEP= '"+cp+"'";
	  		PreparedStatement p2 = conn().prepareStatement(sql3);
	  		p2.execute();
			}
    	} else {
    		int Clickedbutton=	JOptionPane.showConfirmDialog(null, "ATTENTION\nLa Dernière Consultation De Ce Patient Ne Remonte Pas à 5 ans \n\nVoulez Vous Vraiment Le Supprimer Quand Même ?","Suppression",JOptionPane.YES_NO_OPTION);
			if(Clickedbutton==JOptionPane.YES_OPTION) {
    		DossierMedical d = new DossierMedical(cp);
    		d.SupprimerDM(cp);
    		String sq = "DELETE FROM BILAN WHERE CODEP= '"+cp+"' ";
    		PreparedStatement p1 = conn().prepareStatement(sq);
    		p1.execute();
    		String sql2 = "DELETE FROM CONSULTATION WHERE CODEP= '"+cp+"' ";
    		PreparedStatement p3 = conn().prepareStatement(sql2);
    		p3.execute();
	  		String sql3 = "DELETE FROM PATIENT WHERE CODEP= '"+cp+"'";
	  		PreparedStatement p2 = conn().prepareStatement(sql3);
	  		p2.execute();
			}
    	}
    	
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, e.toString());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}

