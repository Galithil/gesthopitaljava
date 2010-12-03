import java.io.Serializable;



//import java.util.*;

public class Personnel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String[] listeTypeUtilisateur = {"d","pA","m","i","aS"};
	String login, nom, prenom, typePersonnel, password;
	
	public Personnel (String n, String p, String tP, String pw) {
		
		login = n+p.charAt(0);
		nom = n;
		prenom = p;
		typePersonnel = tP;
		password = pw;
		
	}
	
	public Personnel (String n, String p, String tP) {
		
		login = n+p.charAt(0);
		nom = n;
		prenom = p;
		typePersonnel = tP;
		password = "password";
		
	}

	public static String[] getListetypeutilisateur() {
		
		return listeTypeUtilisateur;
	
	}
	
}

