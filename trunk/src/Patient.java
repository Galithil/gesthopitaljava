package pierre.bioinfo.m2r;
import java.util.*;

public class Patient {
	
	String nom, prenom, adresse, tel, noSecu;
	Hashtable<String, Fiche> listeFiche;
	
	public Patient (String n, String p, String a, String t, String nS) {
		
		nom = n;
		prenom = p;
		adresse = a;
		tel = t;
		noSecu = nS;
		
		listeFiche = new Hashtable<String, Fiche>();
		
	}
}
