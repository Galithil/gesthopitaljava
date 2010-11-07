
import java.util.*;

public class Operation {

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
	
}
