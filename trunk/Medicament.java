
public class Medicament extends Information {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nom;
	String dosage;
	
	public Medicament (Personnel p, String n, String d) {
		
		super(p);
		nom = n;
		dosage = d;
		
	}
	public String toString() {
		
		String plop= this.nom+" -- "+this.dosage;
		
		return plop;
	}
}
