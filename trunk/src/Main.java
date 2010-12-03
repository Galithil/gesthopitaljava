import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.UIManager;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Controleur mainControleur;
		
		mainControleur=new Controleur();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Impossible d'activer le look-and-feel systeme");
		}

//		new File("gest.data").delete();
		if((new File("gest.data")).exists()){
		try{
			FileInputStream filein = new FileInputStream("gest.data");
			ObjectInputStream ois= new ObjectInputStream(filein);
			mainControleur=(Controleur) ois.readObject();
			mainControleur.loginUtilisateurCourant="";
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("plop");
		}
		
		}else{

			Personnel boss = new Personnel("Raynal", "Mathieu", "d", "root");
			mainControleur.listePersonnel.put(boss.login, boss);
			
		}
		
		Basemenu objet1 = new Basemenu(mainControleur);
	}

}
