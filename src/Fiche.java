

import java.util.*;

public class Fiche {
	
	GregorianCalendar dateEntree, dateSortie;
	String service;
	Hashtable<String, Operation> listeOperation;
	Hashtable<String, Information> listeInformation;
	
	public Fiche (String s) {
		
		dateEntree = new GregorianCalendar();
		dateSortie = new GregorianCalendar();
		service = s;
		listeOperation = new Hashtable<String, Operation>();
		listeInformation = new Hashtable<String, Information>();
		
	}

}