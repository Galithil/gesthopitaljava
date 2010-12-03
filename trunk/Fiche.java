

import java.io.Serializable;
import java.util.*;

public class Fiche implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GregorianCalendar dateEntree, dateSortie;
	String service;
	public static final String[] listeService = {"Cardiologie","Gastro-Enterologie","Urgences"};
	Hashtable<Long, Operation> listeOperation;
	Hashtable<String, Soin> listeSoin;
	Hashtable<String, Medicament> listeMedicament;
	Hashtable<String, Observation> listeObservation;
	Hashtable<String, Repas> listeRepas;
	
	public Fiche (String s) {
		
		dateEntree = new GregorianCalendar();
		dateSortie = new GregorianCalendar();
		service = s;
		listeOperation = new Hashtable<Long, Operation>();
		listeSoin = new Hashtable<String, Soin>();
		listeMedicament = new Hashtable<String, Medicament>();
		listeObservation = new Hashtable<String, Observation>();
		listeRepas = new Hashtable<String, Repas>();
		
	}

	public static String[] getListeservice() {
		
		return listeService;
		
	}
	
}