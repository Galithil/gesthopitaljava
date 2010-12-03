

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.util.Date;
import java.util.Enumeration;


public class FichView implements ActionListener{
	

	JDialog f;
	JComboBox fiches;
	JComboBox numss;
	Controleur myControler;
	String plop[] = new String[500];
	String plip[] = new String[500];
	Object[] objL;
	JList opes;
	JList serv;
	JList meds;
	JList reps;
	JList soins;
	JList obs;

	public FichView(JFrame g, Controleur theControler){
		
		myControler=theControler;
		f  = new JDialog(g,"Visionneur de Fiches",true);
		Container content = f.getContentPane();
		content.setLayout(new GridLayout(10,1));
		//premier couple label+choix
		JPanel pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		pan.add(new JLabel("Patient: "));
		
//		Attention, code qui pique les yeux. Keys renvoie une Enumeration<string>
		//et je veux un tableau de strings pour faire une JComboBox
		
		Enumeration<String> alllogins = myControler.listePatient.keys();
		int i;
		for (i=0;alllogins.hasMoreElements();i++){
			plop[i]=alllogins.nextElement();
			
		}
		numss=new JComboBox(plop);
		pan.add(numss);
		
		//2 labels pour la date d'entree
		pan= new JPanel();
		content.add(pan);
		pan.add(new JLabel("date d'entree : "));
//		Attention, code qui pique les yeux. Keys renvoie une Enumeration<string>
		//et je veux un tableau de strings pour faire une JComboBox
		
		Enumeration<Long> ids = myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.keys();
		for (i=0;ids.hasMoreElements();i++){
			plip[i]=String.valueOf(ids.nextElement());
			
		}
		fiches=new JComboBox(plip);
		fiches.addActionListener(this);
		fiches.setActionCommand("combochange");
		pan.add(fiches);
		
		
		//affichage en lui meme
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
		JLabel labl=new JLabel("Nom: "+myControler.listePatient.get(numss.getSelectedItem().toString()).nom);
		labl.setAlignmentX(Component.CENTER_ALIGNMENT);
		pan.add(labl);
		labl=new JLabel("Prenom: "+myControler.listePatient.get(numss.getSelectedItem().toString()).prenom);
		labl.setAlignmentX(Component.CENTER_ALIGNMENT);
		pan.add(labl);
		labl=new JLabel("Adresse: "+myControler.listePatient.get(numss.getSelectedItem().toString()).adresse);
		labl.setAlignmentX(Component.CENTER_ALIGNMENT);
		pan.add(labl);
		labl=new JLabel("Telephone: "+myControler.listePatient.get(numss.getSelectedItem().toString()).tel);
		labl.setAlignmentX(Component.CENTER_ALIGNMENT);
		pan.add(labl);		
		//date d'entree
		pan = new JPanel();
		content.add(pan);

		pan.setLayout(new BoxLayout(pan,BoxLayout.Y_AXIS));
		Date newDate = (myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).dateEntree.getTime());
		JLabel ddate=new JLabel("Date: "+newDate);
		ddate.setAlignmentX(Component.CENTER_ALIGNMENT);
		pan.add(ddate);
		
		//service
		String serv = (myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).service);
		JLabel sserv = new JLabel("Service: "+serv);
		sserv.setAlignmentX(Component.CENTER_ALIGNMENT);
		pan.add(sserv);
		//liste de soins
		pan = new JPanel();
		pan.setLayout(new BorderLayout());
		content.add(pan);
		Object[] objL=myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).listeOperation.values().toArray();
		opes=new JList(objL);

		pan.add(new JLabel("Operations: "), BorderLayout.NORTH);
		pan.add(opes, BorderLayout.CENTER);
		//liste des op
		pan = new JPanel();
		pan.setLayout(new BorderLayout());
		content.add(pan);
		objL=myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).listeSoin.values().toArray();
		soins=new JList(objL);
		pan.add(new JLabel("Soins: "), BorderLayout.NORTH);
		pan.add(soins, BorderLayout.CENTER);
		
		//liste des med
		pan = new JPanel();
		pan.setLayout(new BorderLayout());
		content.add(pan);
		meds=new JList(myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).listeMedicament.values().toArray());

		pan.add(new JLabel("Medicaments: "), BorderLayout.NORTH);
		pan.add(new JScrollPane(meds), BorderLayout.CENTER);
		//liste des obs
		pan = new JPanel();
		pan.setLayout(new BorderLayout());
		content.add(pan);
		obs=new JList(myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).listeObservation.values().toArray());

		pan.add(new JLabel("Observations: "), BorderLayout.NORTH);
		pan.add(new JScrollPane(obs), BorderLayout.CENTER);
		//liste des repas
		pan = new JPanel();
		pan.setLayout(new BorderLayout());
		content.add(pan);
		reps=new JList(myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).listeRepas.values().toArray());

		pan.add(new JLabel("Repas: "), BorderLayout.NORTH);
		pan.add(new JScrollPane(reps), BorderLayout.CENTER);
		//bouton
		pan = new JPanel();
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		content.add(pan);
		JButton back = new JButton("Retour");
		back.setActionCommand("cancel");
		back.addActionListener(this);
		pan.add(back);
		
		f.setBounds(200,100,400,800);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("cancel")){
			
			this.f.dispose();
			
		
			
		}else if (arg0.getActionCommand().equals("combochange")){
			System.out.println(1);
			System.out.println(numss.getSelectedItem().toString());
			System.out.println(Long.parseLong(fiches.getSelectedItem().toString()));
			System.out.println(myControler.listePatient.get(numss.getSelectedItem().toString()).nom);
			System.out.println(myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).listeOperation.values().toArray());
			objL=myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.get(Long.parseLong(fiches.getSelectedItem().toString())).listeOperation.values().toArray();
			int i=0;
			for (i=0;i<objL.length;i++){
			
				System.out.println(objL[i]);
			}
			opes.setListData(objL);			
		}
		
	}

}
