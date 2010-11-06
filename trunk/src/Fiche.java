package pierre.bioinfo.m2r;
import java.util.*;

public class Fiche {
	
	Hashtable<String, Operation> listeOperation;
	Hashtable<String, Information> listeInformation;
	
	public Fiche () {
		
		listeOperation = new Hashtable<String, Operation>();
		listeInformation = new Hashtable<String, Information>();
		
	}

}
