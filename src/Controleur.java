package pierre.bioinfo.m2r;
import java.util.*;

public class Controleur {

	Vector<Personnel> listePersonnel;
	Vector<Patient> listePatient;
	
	public Controleur () {
		
		listePersonnel = new Vector<Personnel>();
		listePatient = new Vector<Patient>();
		
	}
	
	public void ajouterPersonnel (String nom, String prenom, String typePers) {
		
		Personnel pers = new Personnel(nom, prenom, typePers);
		
		listePersonnel.add(pers);
		
	}
	
	public void modifierPersonnel () {
		
		
		
	}
	
	public void supprimerPersonnel () {
		
		
		
	}
	
	public void ajouterPatient (String n, String p , String a, String t, String nS) {
		
		Patient pat = new Patient(n,p,a,t,nS);
		
		listePatient.add(pat);
		
	}
	
	public void modifierPatient () {
		
		
		
	}

}
