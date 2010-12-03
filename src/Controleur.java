
import java.io.Serializable;
import java.util.*;

public class Controleur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String loginUtilisateurCourant = "";
	Hashtable<String, Personnel> listePersonnel;
	Hashtable<String, Patient> listePatient;
	

	
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
	
	public int ajouterPersonnel (String nom, String prenom, String typePers, String password) {
		
		Personnel personnel = new Personnel(nom, prenom, typePers, password);
		
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
		
		if (listePatient.containsKey(noSecu)) {
			
			Fiche fiche = new Fiche(service);
			
			if (!listePatient.get(noSecu).listeFiche.containsKey(fiche.dateEntree.toString())) {
				
				listePatient.get(noSecu).listeFiche.put(fiche.dateEntree.getTimeInMillis(), fiche);
				listePatient.get(noSecu).dateDerniereFiche = fiche.dateEntree;
				return 1;
				
			} else return 0;
			
		} else return -1;
		
	}
	
	public int ajouterOperation (String noSecu, GregorianCalendar dateDerniereFiche, String type) {
		
		if (listePatient.containsKey(noSecu)) {
			
			if (listePatient.get(noSecu).listeFiche.containsKey(dateDerniereFiche.getTimeInMillis())) {
				
				Operation operation = new Operation(type);
				
				if (!listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeOperation.containsKey(operation.date.getTimeInMillis())) {
				
					listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeOperation.put(operation.date.getTimeInMillis(), operation);
					return 1;
					
				} else return 0;
					
			} else return -1;
			
		} else return -2;
		
	}

	public int ajouterSoin (String noSecu, GregorianCalendar dateDerniereFiche, String commentaire) {
		
		if (listePatient.containsKey(noSecu)) {
			
			if (listePatient.get(noSecu).listeFiche.containsKey(dateDerniereFiche.getTimeInMillis())) {
				
				Soin soin = new Soin(listePersonnel.get(loginUtilisateurCourant), commentaire);
				
				if (!listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeSoin.containsKey(soin.date.toString())) {
				
					listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeSoin.put(soin.date.toString(), soin);
					return 1;
					
				} else return 0;
					
			} else return -1;
			
		} else return -2;
		
	}
	
	public int ajouterMedicament (String noSecu, GregorianCalendar dateDerniereFiche, String nom, String dosage) {
		
		if (listePatient.containsKey(noSecu)) {
			
			if (listePatient.get(noSecu).listeFiche.containsKey(dateDerniereFiche.getTimeInMillis())) {
				
				Medicament medicament = new Medicament(listePersonnel.get(loginUtilisateurCourant), nom, dosage);
				
				if (!listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeMedicament.containsKey(medicament.date.toString())) {
				
					listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeMedicament.put(medicament.date.toString(), medicament);
					return 1;
					
				} else return 0;
					
			} else return -1;
			
		} else return -2;
		
	}
	
	public int ajouterObservation (String noSecu, GregorianCalendar dateDerniereFiche, String commentaire) {
	
		if (listePatient.containsKey(noSecu)) {
			
			if (listePatient.get(noSecu).listeFiche.containsKey(dateDerniereFiche.getTimeInMillis())) {
				
				Observation observation = new Observation(listePersonnel.get(loginUtilisateurCourant), commentaire);
				
				if (!listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeObservation.containsKey(observation.date.toString())) {
				
					listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeObservation.put(observation.date.toString(), observation);
					return 1;
					
				} else return 0;
					
			} else return -1;
			
		} else return -2;
	
	}

	public int ajouterRepas (String noSecu, GregorianCalendar dateDerniereFiche, String periodeRepas, String menu) {
		
		if (listePatient.containsKey(noSecu)) {
			
			if (listePatient.get(noSecu).listeFiche.containsKey(dateDerniereFiche.getTimeInMillis())) {
				
				Repas repas = new Repas(listePersonnel.get(loginUtilisateurCourant), periodeRepas, menu);
				
				if (!listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeRepas.containsKey(repas.date.toString())) {
				
					listePatient.get(noSecu).listeFiche.get(dateDerniereFiche.getTimeInMillis()).listeRepas.put(repas.date.toString(), repas);
					return 1;
					
				} else return 0;
					
			} else return -1;
			
		} else return -2;
		
	}
	
}