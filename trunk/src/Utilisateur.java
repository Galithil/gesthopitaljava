import java.util.*;

public class Utilisateur {
	
	private String idUtilisateur, nom, prenom, typeUtilisateur;
	private Hashtable<String, Droit> listeDroit;
	
	public Utilisateur (String nom, String prenom, char typeUtilisateur) {
		
		if ( typeUtilisateur=='d' || typeUtilisateur=='a' || typeUtilisateur=='m' || typeUtilisateur=='i' || typeUtilisateur=='s' ) {
			
			this.nom = nom;
			this.prenom = prenom;
			idUtilisateur = new String(nom + prenom);
			
			Droit dGP = null, dES = null, dOp = null, dS = null,
						dM = null, dOb = null, dR = null;
			
			switch (typeUtilisateur) {
			case 'd':
				this.typeUtilisateur = "Directeur";
				dGP = new Droit(true, true);
				dES = new Droit(false, false);
				dOp = new Droit(false, false);
				dS = new Droit(false, false);
				dM = new Droit(false, false);
				dOb = new Droit(false, false);
				dR = new Droit(false, false);
			break;
			case 'a':
				this.typeUtilisateur = "Personnel Administratif";
				dGP = new Droit(false, false);
				dES = new Droit(true, true);
				dOp = new Droit(false, false);
				dS = new Droit(false, false);
				dM = new Droit(false, false);
				dOb = new Droit(false, false);
				dR = new Droit(false, false);
			break;
			case 'm':
				this.typeUtilisateur = "Medecin";
				dGP = new Droit(false, false);
				dES = new Droit(true, false);
				dOp = new Droit(true, true);
				dS = new Droit(true, false);
				dM = new Droit(true, false);
				dOb = new Droit(true, false);
				dR = new Droit(true, false);
			break;
			case 'i':
				this.typeUtilisateur = "Infirmiere";
				dGP = new Droit(false, false);
				dES = new Droit(true, false);
				dOp = new Droit(true, false);
				dS = new Droit(true, true);
				dM = new Droit(true, true);
				dOb = new Droit(true, true);
				dR = new Droit(true, false);
			break;
			case 's':
				this.typeUtilisateur = "Aide Soignante";
				dGP = new Droit(false, false);
				dES = new Droit(true, false);
				dOp = new Droit(true, false);
				dS = new Droit(true, false);
				dM = new Droit(true, true);
				dOb = new Droit(true, true);
				dR = new Droit(true, true);
			break;
			}
			
			listeDroit.put("GestionPersonnel", dGP );
			listeDroit.put("EntreeSortie", dES );
			listeDroit.put("Operation", dOp );
			listeDroit.put("Soin", dS );
			listeDroit.put("Medicament", dM );
			listeDroit.put("Observation", dOb );
			listeDroit.put("Repas", dR );
			
		} 
	}
	
}
