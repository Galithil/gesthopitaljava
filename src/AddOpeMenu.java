
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;
import java.util.Enumeration;


public class AddOpeMenu implements ActionListener{
	

	JDialog f;
	JComboBox type;
	JComboBox numss;
	Controleur myControler;
	String plop[] = new String[500];

	public AddOpeMenu(JFrame g, Controleur theControler){
		
		myControler=theControler;
		f  = new JDialog(g,"Ajouter une operation",true);
		Container content = f.getContentPane();
		content.setLayout(new GridLayout(5,1));
		//premier couple label+choix
		JPanel pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		pan.add(new JLabel("Type	 : "));
		pan = new JPanel();
		content.add(pan);
		
		type = new JComboBox(Operation.listeTypeOperation);
		pan.add(type);
		//combobox pour le numero de securite sociale
		pan= new JPanel();
		content.add(pan);
		pan.add(new JLabel("numero de securite sociale : "));
		pan = new JPanel();
		content.add(pan);
		
		//Attention, code qui pique les yeux. Keys renvoie une Enumeration<string>
		//et je veux un tableau de strings pour faire une JComboBox
		
		Enumeration<String> alllogins = myControler.listePatient.keys();
		int i;
		for (i=0;alllogins.hasMoreElements();i++){
			plop[i]=alllogins.nextElement();
			
		}
		numss=new JComboBox(plop);
		pan.add(numss);
		//boutons
		pan = new JPanel();
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		content.add(pan);
		JButton back = new JButton("Annuler");
		back.setActionCommand("cancel");
		back.addActionListener(this);
		pan.add(back);
		JButton ok = new JButton("Enregistrer");
		ok.setActionCommand("save");
		ok.addActionListener(this);
		pan.add(ok);
		
		f.setBounds(100,100,250,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("cancel")){
			
			this.f.dispose();
			
		}else if(arg0.getActionCommand().equals("save")){
			
			int retvalue=myControler.ajouterOperation(numss.getSelectedItem().toString(), myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche, type.getSelectedItem().toString());
			if( retvalue == 1){
			
				JOptionPane.showMessageDialog(this.f, "Modifications enregistrees", "Succes",JOptionPane.INFORMATION_MESSAGE);
				System.out.println(myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche);
				this.f.dispose();
				
				
			}else{
				System.out.println(retvalue);
				System.out.println(myControler.listePatient.get(numss.getSelectedItem().toString()).dateDerniereFiche.toString());
				System.out.println(myControler.listePatient.get(numss.getSelectedItem().toString()).listeFiche.keys().nextElement());
				JOptionPane.showMessageDialog(this.f, "Erreur fatale !", "Erreur",JOptionPane.ERROR_MESSAGE);
				
				
			}
			
		}
		
	}

}
