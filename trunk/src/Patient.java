import java.util.*;

public class Patient {
	
	private String nom, prenom, adresse, tel, noSecu;
	private Hashtable<String, Fiche> listeFiche;
	
	public Patient (String nom, String prenom, String adresse, String tel, String noSecu) {	
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.noSecu = noSecu;
		
		listeFiche = new Hashtable<String, Fiche>();		
	}
}
