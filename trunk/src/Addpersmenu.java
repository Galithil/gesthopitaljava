import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;



public class Addpersmenu implements ActionListener{

	
	JDialog f;
	JTextField nom;
	JTextField prenom;
	JComboBox typeP;
	JPasswordField pw;
	Controleur myControler;

	public Addpersmenu(JFrame g, Controleur theControler){
		
		myControler=theControler;
		f  = new JDialog(g,"Ajouter un membre du personnel",true);
		Container content = f.getContentPane();
		content.setLayout(new GridLayout(8,1));
		//premier couple label+text
		JPanel pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("Nom : "));
		pan = new JPanel();
		content.add(pan);
		nom = new JTextField(20);
		pan.add(nom);
		//deuxieme couple label+text
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("Prenom : "));
		pan = new JPanel();
		content.add(pan);
		prenom=new JTextField(20);
		pan.add(prenom);
		//Label type + liste
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("Categorie : "));
		typeP=new JComboBox(Personnel.getListetypeutilisateur());
		pan.add(typeP);
		//password
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("Mot de passe : "));
		pan = new JPanel();
		content.add(pan);
		pw=new JPasswordField(20);
		pan.add(pw);
		//boutons
		pan = new JPanel();
		content.add(pan);
		JButton back = new JButton("Annuler");
		back.setActionCommand("cancel");
		back.addActionListener(this);
		pan.add(back);
		JButton ok = new JButton("Enregistrer");
		ok.setActionCommand("save");
		ok.addActionListener(this);
		pan.add(ok);
		
		f.setBounds(100,100,300,350);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("cancel")){
			
			this.f.dispose();
			
		}else if(arg0.getActionCommand().equals("save")){
			//Alors comme le champ password renvoie un char[] au lieu d'un string (ce qui est tres malin)
			//on est obliges de le passer en string avant d'appeler la fonction
			String passwd = new String(pw.getPassword());
			if(myControler.ajouterPersonnel(nom.getText(), prenom.getText(), typeP.getSelectedItem().toString(), passwd) == 1){
			
				JOptionPane.showMessageDialog(this.f, "Modifications enregistrees", "Succes",JOptionPane.INFORMATION_MESSAGE);

				this.f.dispose();
				
				
			}else{
				
				JOptionPane.showMessageDialog(this.f, "Ce membre du personnel existe deja", "Erreur",JOptionPane.ERROR_MESSAGE);
				
				
			}
			
		}
		
	}
}