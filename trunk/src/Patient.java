
import java.util.*;

public class Patient {
	
	String nom, prenom, adresse, tel, noSecu;
	GregorianCalendar dateDerniereFiche;
	Hashtable<GregorianCalendar, Fiche> listeFiche;
	
	public Patient (String nom, String prenom, String adresse, String tel, String noSecu) {	
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.noSecu = noSecu;
		
		nom = n;
		prenom = p;
		adresse = a;
		tel = t;
		noSecu = nS;
		
		listeFiche = new Hashtable<GregorianCalendar, Fiche>();
		
	}
}

