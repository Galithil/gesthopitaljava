package pierre.bioinfo.m2r;
import java.util.*;

public class Utilisateur {
	
	String idUtilisateur, nom, prenom, typeUtilisateur;
	Hashtable<String, Droit> listeDroit;
	
	public Utilisateur (String n, String p, char tU) {
		
		if ( tU=='d' || tU=='a' || tU=='m' || tU=='i' || tU=='s' ) {
			
			nom = n;
			prenom = p;
			idUtilisateur = "";
			idUtilisateur.concat(n).concat(p);
			
			Droit dGP = null, dES = null, dOp = null, dS = null,
						dM = null, dOb = null, dR = null;
			
			switch (tU) {
			case 'd':
				typeUtilisateur = "Directeur";
				dGP = new Droit(true, true);
				dES = new Droit(false, false);
				dOp = new Droit(false, false);
				dS = new Droit(false, false);
				dM = new Droit(false, false);
				dOb = new Droit(false, false);
				dR = new Droit(false, false);
			break;
			case 'a':
				typeUtilisateur = "Personnel Administratif";
				dGP = new Droit(false, false);
				dES = new Droit(true, true);
				dOp = new Droit(false, false);
				dS = new Droit(false, false);
				dM = new Droit(false, false);
				dOb = new Droit(false, false);
				dR = new Droit(false, false);
			break;
			case 'm':
				typeUtilisateur = "Medecin";
				dGP = new Droit(false, false);
				dES = new Droit(true, false);
				dOp = new Droit(true, true);
				dS = new Droit(true, false);
				dM = new Droit(true, false);
				dOb = new Droit(true, false);
				dR = new Droit(true, false);
			break;
			case 'i':
				typeUtilisateur = "Infirmiere";
				dGP = new Droit(false, false);
				dES = new Droit(true, false);
				dOp = new Droit(true, false);
				dS = new Droit(true, true);
				dM = new Droit(true, true);
				dOb = new Droit(true, true);
				dR = new Droit(true, false);
			break;
			case 's':
				typeUtilisateur = "Aide Soignante";
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
			
		} else {
			
		}
		
	}
	
}
