import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Gestmenu implements ActionListener{

	public JFrame fenetre;
	
	public Gestmenu(Controleur myControler){
	
		
		fenetre=new JFrame();
		fenetre.setTitle("Gestionnaire Hopital");

		
		Container content = fenetre.getContentPane();
		content.setLayout(new GridLayout(7,1));
		
		
		
		JPanel pan1 = new JPanel();
		content.add(pan1);
		pan1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addpers = new JButton("Ajouter un membre du personnel");
		addpers.setActionCommand("newpers");
		addpers.addActionListener(this);
		pan1.add(addpers);
		
		JPanel pan2 = new JPanel();
		content.add(pan2);
		pan2.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton rempers = new JButton("Retirer un membre du personnel");
		rempers.setActionCommand("delpers");
		rempers.addActionListener(this);
		pan2.add(rempers);
		
		JPanel pan3 = new JPanel();
		content.add(pan3);
		pan3.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addpat = new JButton("Ajouter un nouveau patient");
		addpat.setActionCommand("newpat");
		addpat.addActionListener(this);
		pan3.add(addpat);
		
		JPanel pan4 = new JPanel();
		content.add(pan4);
		pan4.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addfich = new JButton("Ajouter une fiche d'hospitalisation");
		addfich.setActionCommand("newfich");
		addfich.addActionListener(this);
		pan4.add(addfich);
		
		JPanel pan5 = new JPanel();
		content.add(pan5);
		pan5.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addope = new JButton("Entrer une operation");
		addope.setActionCommand("newope");
		addope.addActionListener(this);
		pan5.add(addope);
		
		JPanel pan6 = new JPanel();
		content.add(pan6);
		pan6.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addinf = new JButton("Ajouter des informations supplementaires");
		addinf.setActionCommand("newpat");
		addinf.addActionListener(this);
		pan6.add(addinf);

		
		JPanel pan7 = new JPanel();
		content.add(pan7);
		pan7.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton seefich = new JButton("Acceder a une fiche");
		seefich.setActionCommand("lookfich");
		seefich.addActionListener(this);
		pan7.add(seefich);

	
		fenetre.setBounds(300,300,300,600);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
	
		
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
	}
}
