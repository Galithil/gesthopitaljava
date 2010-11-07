
//import java.util.*;

public class Personnel {

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
	
}

