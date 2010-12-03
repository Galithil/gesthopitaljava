
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.util.Enumeration;


public class AddInfMenu implements ActionListener{
	

	JDialog f;
	JComboBox fiches;
	JComboBox numss;
	JTextField medocs;
	JTextField medocsdos;
	JTextArea obs;
	JTextField repas;
	JTextField repmenu;
	JTextArea soins;
	Controleur myControler;
	String plop[] = new String[500];
	String plip[] = new String[500];

	public AddInfMenu(JFrame g, Controleur theControler){
		
		myControler=theControler;
		f  = new JDialog(g,"Ajouter des informations",true);
		Container content = f.getContentPane();
		content.setLayout(new GridLayout(11,1));
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
		pan.add(fiches);

			pan = new JPanel();
			content.add(pan);
			pan.setLayout(new FlowLayout(FlowLayout.CENTER));
			pan.add(new JLabel("Medicaments : "));
			pan = new JPanel();
			content.add(pan);
			medocs = new JTextField(10);
			pan.add(medocs);
			medocsdos = new JTextField(10);
			pan.add(medocsdos);
			pan = new JPanel();
			content.add(pan);
			pan.add(new JLabel("Observations : "));
			pan = new JPanel();
			content.add(pan);
			obs = new JTextArea(8,25);
			pan.add(obs);
			if (myControler.listePersonnel.get(myControler.loginUtilisateurCourant).typePersonnel.equals("aS")){
				pan = new JPanel();
				content.add(pan);
			pan.add(new JLabel("Repas : "));
			pan = new JPanel();
			content.add(pan);
			repas = new JTextField(20);
			pan.add(repas);
			repmenu = new JTextField(20);
			pan.add(repas);
			pan.add(repmenu);
			
//			boutons
			pan = new JPanel();
			pan.setLayout(new FlowLayout(FlowLayout.CENTER));
			content.add(pan);
			JButton back = new JButton("Annuler");
			back.setActionCommand("cancel");
			back.addActionListener(this);
			pan.add(back);
			JButton ok = new JButton("Enregistrer");
			ok.setActionCommand("saveAS");
			ok.addActionListener(this);
			pan.add(ok);
			
		}else if (myControler.listePersonnel.get(myControler.loginUtilisateurCourant).typePersonnel.equals("i")){
			pan = new JPanel();
			content.add(pan);
			pan.add(new JLabel("Soins : "));
			pan = new JPanel();
			content.add(pan);
			soins = new JTextArea(8,25);
			pan.add(soins);
			
//			boutons
			pan = new JPanel();
			pan.setLayout(new FlowLayout(FlowLayout.CENTER));
			content.add(pan);
			JButton back = new JButton("Annuler");
			back.setActionCommand("cancel");
			back.addActionListener(this);
			pan.add(back);
			JButton ok = new JButton("Enregistrer");
			ok.setActionCommand("saveI");
			ok.addActionListener(this);
			pan.add(ok);
		
		}else{
			
			
		
		}
		
		
		f.setBounds(100,100,350,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("cancel")){
			
			this.f.dispose();
			
		}else if(arg0.getActionCommand().equals("saveAS")){
			int i=0;
			int j=0;
			int retvalue=0;
			if(! medocs.getText().isEmpty()){
				j++;
				retvalue=myControler.ajouterMedicament( numss.getSelectedItem().toString(), myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche, medocs.getText(), medocsdos.getText());
				if(retvalue == 1){
			   i++;
		
				}else{
					System.out.println(retvalue);
					JOptionPane.showMessageDialog(this.f, "Erreur en mettant a jour les medicaments !", "Erreur",JOptionPane.ERROR_MESSAGE);
					
					
				}
			}
			retvalue=0;
			if (! obs.getText().isEmpty()){
				j++;
				retvalue=myControler.ajouterObservation( numss.getSelectedItem().toString(), myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche, obs.getText());
				if(retvalue == 1){
					   i++;
				
						}else{
							System.out.println(retvalue);
							JOptionPane.showMessageDialog(this.f, "Erreur en mettant a jour les observations !", "Erreur",JOptionPane.ERROR_MESSAGE);
							
							
						}
				
				
			}
			retvalue=0;
			if (! repas.getText().isEmpty()){
				j++;
				retvalue=myControler.ajouterRepas( numss.getSelectedItem().toString(), myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche, repas.getText(), repmenu.getText());
				if(retvalue == 1){
					   i++;
				
						}else{
							System.out.println(retvalue);
							JOptionPane.showMessageDialog(this.f, "Erreur en mettant a jour les repas !", "Erreur",JOptionPane.ERROR_MESSAGE);
							
							
						}
				
				
			}
			
			if (i==j){
				
				JOptionPane.showMessageDialog(this.f, "Modifications enregistrees", "Succes",JOptionPane.INFORMATION_MESSAGE);
				this.f.dispose();
			
			}
		}else if(arg0.getActionCommand().equals("saveI")){
				
			int i=0;
			int j=0;
			int retvalue=0;
			if(! medocs.getText().isEmpty()){
				j++;
				retvalue=myControler.ajouterMedicament( numss.getSelectedItem().toString(), myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche, medocs.getText(), medocsdos.getText());
				if(retvalue == 1){
			   i++;
		
				}else{
					System.out.println(retvalue);
					JOptionPane.showMessageDialog(this.f, "Erreur en mettant a jour les medicaments !", "Erreur",JOptionPane.ERROR_MESSAGE);
					
					
				}
			}
			retvalue=0;
			if (! obs.getText().isEmpty()){
				j++;
				retvalue=myControler.ajouterObservation( numss.getSelectedItem().toString(), myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche, obs.getText());
				if(retvalue == 1){
					   i++;
				
						}else{
							System.out.println(retvalue);
							JOptionPane.showMessageDialog(this.f, "Erreur en mettant a jour les observations !", "Erreur",JOptionPane.ERROR_MESSAGE);
							
							
						}
				
				
			}
			retvalue=0;
			if (! soins.getText().isEmpty()){
				j++;
				retvalue=myControler.ajouterSoin( numss.getSelectedItem().toString(), myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche, soins.getText());
				if(retvalue == 1){
					   i++;
				
						}else{
							System.out.println(retvalue);
							JOptionPane.showMessageDialog(this.f, "Erreur en mettant a jour les soins !", "Erreur",JOptionPane.ERROR_MESSAGE);
							
							
						}
				
				
			}		
			if (i==j){
				
				JOptionPane.showMessageDialog(this.f, "Modifications enregistrees", "Succes",JOptionPane.INFORMATION_MESSAGE);
				this.f.dispose();
			
			}
			
			
			
		}
		
	}

}
