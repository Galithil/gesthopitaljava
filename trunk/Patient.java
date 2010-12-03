
import java.io.Serializable;
import java.util.*;

public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nom, prenom, adresse, tel, noSecu;
	GregorianCalendar dateDerniereFiche;
	Hashtable<Long, Fiche> listeFiche;

	public Patient (String n, String p, String a, String t, String nS) {
		
		nom = n;
		prenom = p;
		adresse = a;
		tel = t;
		noSecu = nS;
		
		listeFiche = new Hashtable<Long, Fiche>();
		
	}
}

