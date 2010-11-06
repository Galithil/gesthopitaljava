import java.util.*;

public class Fiche {
	
	private Hashtable<String, Operation> listeOperation;
	private Hashtable<String, Information> listeInformation;
	
	public Fiche () {
		
		listeOperation = new Hashtable<String, Operation>();
		listeInformation = new Hashtable<String, Information>();
		
	}

}
