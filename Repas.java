
public class Repas extends Information {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String periodeRepas;
	String menu;
	
	public Repas (Personnel p, String pR, String m) {
		
		super(p);
		periodeRepas = pR;
		menu = m;
		
	}
	public String toString() {
		
		String plop= this.periodeRepas+" -- "+this.menu;
		
		return plop;
	}
}
