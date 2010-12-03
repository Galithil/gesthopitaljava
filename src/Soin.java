import java.io.Serializable;


public class Soin extends Information implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String commentaire;
	
	public Soin (Personnel p, String c) {
		
		super(p);
		commentaire = c;
		
	}
	@Override
	public String toString() {

		return this.commentaire;
	}
	
}
