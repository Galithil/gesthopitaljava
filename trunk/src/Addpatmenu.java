import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.*;


public class Addpatmenu implements ActionListener{
	

	JDialog f;
	JTextField nom;
	JTextField prenom;
	JTextField adresse;
	JTextField tel;
	JTextField numSecu;
	Controleur myControler;

	public Addpatmenu(JFrame g, Controleur theControler){
		
		myControler=theControler;
		f  = new JDialog(g,"Ajouter un patient",true);
		Container content = f.getContentPane();
		content.setLayout(new GridLayout(11,1));
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
		//troisieme couple label+text
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("Adresse : "));
		pan = new JPanel();
		content.add(pan);
		adresse=new JTextField(20);
		pan.add(adresse);
		//quatrieme couple label+text
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("Telephone : "));
		pan = new JPanel();
		content.add(pan);
		tel=new JTextField(20);
		pan.add(tel);
		//cinquieme couple label+text
		pan = new JPanel();
		content.add(pan);
		pan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("numero de Securite Sociale : "));
		pan = new JPanel();
		content.add(pan);
		numSecu=new JTextField(20);
		pan.add(numSecu);
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
			
			if(myControler.ajouterPatient(nom.getText(), prenom.getText(), adresse.getText(), tel.getText(), numSecu.getText()) == 1){
			
				JOptionPane.showMessageDialog(this.f, "Modifications enregistrees", "Succes",JOptionPane.INFORMATION_MESSAGE);
				this.f.dispose();
				
				
			}else{
				
				JOptionPane.showMessageDialog(this.f, "Ce patient existe deja", "Erreur",JOptionPane.ERROR_MESSAGE);
				
				
			}
			
		}
		
	}

}
