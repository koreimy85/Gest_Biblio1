package com.tpgenielogiciel.control;
	
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import com.tpgenielogiciel.model.Utilisatmodel;
public class Utilisatcontrole {
	
	Utilisatmodel utilisateur = new Utilisatmodel();
	bdd based = new bdd();
	Statement stat;
	ResultSet resultat;
	boolean exist ;
	
	
	// methode permettant de recherche un utilisateur
	public boolean existe (Utilisatmodel model) {
		String nom = model.getNom();
		String motpass = model.getPasswd();
		
		try {
			   stat = based.connect().createStatement();
			   resultat = stat.executeQuery("select id from utilisateur where nom = '"+nom+"' and prenom = '"+motpass+"'");
			   if(resultat.next())
				   exist = true;
			   else
				   exist = false;		
			   
			   System.out.println("voici le resultat");
		}
			catch(SQLException ex) {
				System.out.println("erreur controleur existence  "+ex.getMessage());
			}
		   return exist;
	}
	// validation du nom
	public boolean existnom (Utilisatmodel model) {
		try {
				stat = based.connect().createStatement();
				resultat = stat.executeQuery("select id from utilisateur where nom ='"+model.getNom()+"'");
				 if(resultat.next())
				 {
					 exist = true;
					 System.out.println("entrez dedans");
					 
				 }
				 else
					 exist = false;
		} 
			catch(SQLException ex) {
				System.out.println("erreur de nom"+ex.getMessage());
			}
		return exist;
	}
	
	// validation du mot de passe
	public boolean existmotpass (Utilisatmodel model) {
		
		   try {
			   	stat = based.connect().createStatement();
			   	resultat = stat.executeQuery("select id from utilisateur where passwd = '"+model.getPasswd()+"' ");
			   	 if(resultat.next())
			   	 {
			   		 exist = true;
			   		 System.out.println("y a un problem");
			   	 }
			   		
			   	 else
			   	 {
			   		exist = false;
			   		System.out.println("est le problem?????");
			   	 }
			   		 
			   
		   }
		   		catch(SQLException ex) {
		   			System.out.println("erreur de mot de pass"+ex.getMessage());
		   		}
		   return exist;
	}
	
	//methode de determination de status
	
	public String role(Utilisatmodel model) {
		String fonct = "";
		try {
				stat = based.connect().createStatement();
				resultat = stat.executeQuery("select statut from utilisateur where id = "+model.getId()+" ");
				if(resultat.next())
				fonct = resultat.getString("statut");	
		  }
		catch(SQLException ex) {
				System.out.println("erreur statut "+ex.getMessage());
			}
		return fonct;
	}
	
	// methode d insertion d un nouveau client
	
	public void ajout (Utilisatmodel mode) {
		
		mode.setAccess(false);
		
		try {
				stat=based.connect().createStatement();
				stat.executeUpdate("INSERT INTO utilisateur(nom,prenom,lieunssce,statut,datenssce,access,passwd) values('"+mode.getNom()+"','"+mode.getPrenom()+"','"+mode.getLieunssce()+"','"+mode.getStatut()+"',"+mode.getDatenssce()+","+mode.isAccess()+",'"+mode.getPasswd()+"')");			 
			}
			catch(SQLException ex)
		    {
				System.out.println("erreur d insertion "+ex.getMessage());
		    }
	}
	

}
