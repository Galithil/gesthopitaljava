import java.util.*;

public class Controleur {

	private Vector<Personnel> listePersonnel;
	private Vector<Patient> listePatient;

	public Controleur() {
		listePersonnel = new Vector<Personnel>();
		listePatient = new Vector<Patient>();
	}

	public void ajouterPersonnel(String nom, String prenom, String typePers) {
		listePersonnel.add(new Personnel(nom, prenom, typePers));
	}

	public void modifierPersonnel() {

	}

	public void supprimerPersonnel() {

	}

	public void ajouterPatient(String n, String p, String a, String t, String nS) {
		listePatient.add(new Patient(n, p, a, t, nS));
	}

	public void modifierPatient() {

	}

}
