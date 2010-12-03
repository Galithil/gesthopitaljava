import java.io.Serializable;
import java.util.*;

public class Information implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long date;
	Personnel personne;
	
	public Information(Personnel p) {
		
		date = new GregorianCalendar().getTimeInMillis();
		personne = p;
		
	}


}
