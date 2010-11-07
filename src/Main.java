import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controleur mainControleur;
		
		mainControleur=new Controleur();
		
		if((new File("gest.data")).exists()){
			
		try{
			FileInputStream filein = new FileInputStream("gest.data");
			ObjectInputStream ois= new ObjectInputStream(filein);
			mainControleur=(Controleur) ois.readObject();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		}else{

			Personnel boss = new Personnel("Raynal", "Mathieu", "d", "root");
			mainControleur.listePersonnel.put(boss.login, boss);
			
		}
		
		
		Basemenu objet1 = new Basemenu(mainControleur);
	}

}
