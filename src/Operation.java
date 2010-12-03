
import java.io.Serializable;
import java.util.*;

public class Operation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String[] listeTypeOperation = {"Ambulatoire","Chirurgie Generale"};
	GregorianCalendar date;
	String type;
	Hashtable<String, Personnel> listePersonnelPresent;
	Vector<String> observationsDiverses;
	
	public Operation(String t) {
		
		date = new GregorianCalendar();
		type = t;
		
		listePersonnelPresent = new Hashtable<String, Personnel>();
		observationsDiverses = new Vector<String>();
		
	}

	public static String[] getListetypeoperation() {
		
		return listeTypeOperation;
	
	}

	@Override
	public String toString() {
		
		String plop= this.type+" -- "+this.date.getTime().toString();
		
		return plop;
	}
	
}
