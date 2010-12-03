import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Gestmenu implements ActionListener{

	public JFrame fenetre;
	public Controleur myControler;
	
	public Gestmenu(Controleur theControler){
	
		myControler=theControler;
		fenetre=new JFrame();
		fenetre.setTitle("Gestionnaire Hopital");

		
		Container content = fenetre.getContentPane();
		content.setLayout(new GridLayout(8,1));
		
		
		
		JPanel pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addpers = new JButton("Ajouter un membre du personnel");
		addpers.setActionCommand("newpers");
		addpers.addActionListener(this);
		pan.add(addpers);
		
		 pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton rempers = new JButton("Retirer un membre du personnel");
		rempers.setActionCommand("delpers");
		rempers.addActionListener(this);
		pan.add(rempers);
		
		 pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addpat = new JButton("Ajouter un nouveau patient");
		addpat.setActionCommand("newpat");
		addpat.addActionListener(this);
		pan.add(addpat);
		
		
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addfich = new JButton("Ajouter une fiche d'hospitalisation");
		addfich.setActionCommand("newfich");
		addfich.addActionListener(this);
		pan.add(addfich);
		
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addope = new JButton("Entrer une operation");
		addope.setActionCommand("newope");
		addope.addActionListener(this);
		pan.add(addope);
		
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addinf = new JButton("Ajouter des informations supplementaires");
		addinf.setActionCommand("newinf");
		addinf.addActionListener(this);
		pan.add(addinf);

		
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton seefich = new JButton("Acceder a une fiche");
		seefich.setActionCommand("lookfich");
		seefich.addActionListener(this);
		pan.add(seefich);
		
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton save = new JButton("Sauvegarder");
		save.setActionCommand("save");
		save.addActionListener(this);
		pan.add(save);

		
//		Taking care of the rights
		
if (myControler.listePersonnel.get(myControler.loginUtilisateurCourant).typePersonnel.equals("d")){
			
			addpers.setEnabled(true);
			rempers.setEnabled(true);
			addpat.setEnabled(false);
			addfich.setEnabled(false);
			addope.setEnabled(false);
			addinf.setEnabled(false);
			seefich.setEnabled(false);
			
			
		}else if (myControler.listePersonnel.get(myControler.loginUtilisateurCourant).typePersonnel.equals("pA")){
			
			addpers.setEnabled(false);
			rempers.setEnabled(false);
			addpat.setEnabled(true);
			addfich.setEnabled(true);
			addope.setEnabled(false);
			addinf.setEnabled(false);
			seefich.setEnabled(false);
			save.setEnabled(true);
			
			
		}else if (myControler.listePersonnel.get(myControler.loginUtilisateurCourant).typePersonnel.equals("m")){
			
			addpers.setEnabled(false);
			rempers.setEnabled(false);
			addpat.setEnabled(false);
			addfich.setEnabled(false);
			addope.setEnabled(true);
			addinf.setEnabled(false);
			seefich.setEnabled(true);
			save.setEnabled(true);
			
			
		}else if (myControler.listePersonnel.get(myControler.loginUtilisateurCourant).typePersonnel.equals("i")){
			
			addpers.setEnabled(true);
			rempers.setEnabled(true);
			addpat.setEnabled(false);
			addfich.setEnabled(false);
			addope.setEnabled(false);
			addinf.setEnabled(true);
			seefich.setEnabled(true);
			save.setEnabled(true);
			
			
		}else if (myControler.listePersonnel.get(myControler.loginUtilisateurCourant).typePersonnel.equals("aS")){
			
			addpers.setEnabled(true);
			rempers.setEnabled(true);
			addpat.setEnabled(false);
			addfich.setEnabled(false);
			addope.setEnabled(false);
			addinf.setEnabled(true);
			seefich.setEnabled(true);
			save.setEnabled(true);
			
			
		}else{
			
			addpers.setEnabled(false);
			rempers.setEnabled(false);
			addpat.setEnabled(false);
			addfich.setEnabled(false);
			addope.setEnabled(false);
			addinf.setEnabled(false);
			seefich.setEnabled(false);
			save.setEnabled(true);
			
			
		}
		
		
		
		
		
		
	
		fenetre.setBounds(300,300,300,600);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
	
		
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("newpers")){
		

				 new Addpersmenu(fenetre,myControler);
		}else if (ae.getActionCommand().equals("delpers")){
			
			
			new Rempersmenu(fenetre,myControler);
		}else if (ae.getActionCommand().equals("newpat")){
			
			
			new Addpatmenu(fenetre,myControler);
		}else if (ae.getActionCommand().equals("newfich")){
			
			
			new AddFichMenu(fenetre,myControler);
		}else if (ae.getActionCommand().equals("newope")){
			
			
			new AddOpeMenu(fenetre,myControler);
		}else if (ae.getActionCommand().equals("newinf")){
			
			
			new AddInfMenu(fenetre,myControler);
		}else if (ae.getActionCommand().equals("lookfich")){
			
			
			new FichView(fenetre,myControler);
		}else if (ae.getActionCommand().equals("newinf")){
			
			
			new AddInfMenu(fenetre,myControler);
		}else if (ae.getActionCommand().equals("save")){
			
		try{
			
			FileOutputStream fos=new FileOutputStream("gest.data");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(myControler);
			oos.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.out.println("Fichier de sauvegarde introuvable !");
		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Impossible d'ecrire !");
		
		}
		
		
		}
		
	}
}
