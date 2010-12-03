
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.util.Enumeration;

public class Rempersmenu implements ActionListener{
	
	
	JDialog f;
	JComboBox logins;
	Controleur myControler;
	String plop[] = new String[500];
	
	public Rempersmenu(JFrame g, Controleur theControler){
	
		myControler=theControler;
		
		f  = new JDialog(g,"Retirer un membre du personnel",true);
		Container content = f.getContentPane();
		content.setLayout(new GridLayout(2,1));
		
		JPanel pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("Categorie : "));
		//Attention, code qui pique les yeux. Keys renvoie une Enumeration<string>
		//et je veux un tableau de strings pour faire une JComboBox
		
		Enumeration<String> alllogins = myControler.listePersonnel.keys();
		int i;
		for (i=0;alllogins.hasMoreElements();i++){
			plop[i]=alllogins.nextElement();
			
		}
		logins=new JComboBox(plop);
		pan.add(logins);
		//et les boutons de validation
		pan = new JPanel();
		content.add(pan);
		JButton back = new JButton("Annuler");
		back.setActionCommand("cancel");
		back.addActionListener(this);
		pan.add(back);
		JButton ok = new JButton("Retirer");
		ok.setActionCommand("save");
		ok.addActionListener(this);
		pan.add(ok);
		
		
		
		f.setBounds(100,100,300,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}

	
	
	public void actionPerformed(ActionEvent arg0) {

		if (arg0.getActionCommand().equals("cancel")){
			
			this.f.dispose();
			
		}else if(arg0.getActionCommand().equals("save")){
			
			myControler.supprimerPersonnel(logins.getSelectedItem().toString());
				JOptionPane.showMessageDialog(this.f, "Modifications enregistrees", "Succes",JOptionPane.INFORMATION_MESSAGE);
				this.f.dispose();
				
				
			
			
		}
		
	}

}
