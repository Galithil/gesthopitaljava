

import java.util.*;

public class Controleur {

	Hashtable<String, Personnel> listePersonnel;
	Hashtable<String, Patient> listePatient;
	static final String[] listeService = {"Cardiologie","Gastro-Enterologie","Urgences"};
	
	public Controleur () {
		
		listePersonnel = new Hashtable<String, Personnel>();
		listePatient = new Hashtable<String, Patient>();
	}
	
	public int ajouterPersonnel (String nom, String prenom, String typePers) {
		
		Personnel personnel = new Personnel(nom, prenom, typePers);
		
		if (!listePersonnel.containsKey(personnel.login)) {
			
			listePersonnel.put(personnel.login, personnel);
			return 1;
			
		} else return 0;
		
	}
	
	public void supprimerPersonnel (String login) {
		
		listePersonnel.remove(login);
		
	}
	
	public int ajouterPatient (String nom, String prenom, String adresse, String tel, String noSecu) {
		
		Patient patient = new Patient(nom,prenom,adresse,tel,noSecu);
		
		if (!listePatient.containsKey(patient.noSecu)) {
			
			listePatient.put(patient.noSecu, patient);
			return 1;
			
		} else return 0;
		
	}
	
	public int ajouterFiche (String noSecu, String service) {
		
		if (!listePatient.containsKey(noSecu)) {
			
			Fiche fiche = new Fiche(service);
			
			if (listePatient.get(noSecu).listeFiche.containsKey(fiche.dateEntree)) {
				
				listePatient.get(noSecu).listeFiche.put(fiche.dateEntree, fiche);
				return 1;
				
			} else return 0;
			
		} else return -1;
		
	}
	
public int ajouterOperation (String noSecu, GregorianCalendar dateDerniereFiche, String type) {
		
		if (listePatient.containsKey(noSecu)) {
			
			if (listePatient.get(noSecu).listeFiche.containsKey(dateDerniereFiche)) {
				
				Operation operation = new Operation(type);
				
				if (!listePatient.get(noSecu).listeFiche.get(dateDerniereFiche).listeOperation.containsKey(operation.date)) {
				
					listePatient.get(noSecu).listeFiche.get(dateDerniereFiche).listeOperation.put(operation.date.toString(), operation);
					return 1;
					
				} else return 0;
					
			} else return -1;
			
		} else return -2;
		
	}

	public int ajouterInformation (String noSecu, GregorianCalendar dateDerniereFiche) {
		
		if (listePatient.containsKey(noSecu)) {
			
			if (listePatient.get(noSecu).listeFiche.containsKey(dateDerniereFiche)) {
				
				Information information = new Information();
				
				if (!listePatient.get(noSecu).listeFiche.get(dateDerniereFiche).listeInformation.containsKey(information.date)) {
				
					listePatient.get(noSecu).listeFiche.get(dateDerniereFiche).listeInformation.put(information.date.toString(), information);
					return 1;
					
				} else return 0;
					
			} else return -1;
			
		} else return -2;
		
	}
}