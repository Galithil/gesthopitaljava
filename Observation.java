
public class Observation extends Information {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String commentaire;
	
	public Observation (Personnel p, String c) {
		
		super(p);
		commentaire = c;
		
	}
	public String toString() {
		
		
		return this.commentaire;
	}
}
