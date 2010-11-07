

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class Basemenu implements ActionListener{

	public Controleur myControler;
	public JFrame fenetre ;
	public JPanel pan;
	
	public JTextField log;
	public JTextField pw;
	public JButton val;
	
	public Basemenu( Controleur aControler){
	
	myControler=aControler;
	fenetre=new JFrame();
	fenetre.setTitle("Gestionnaire Hopital");

	
	Container content = fenetre.getContentPane();
	content.setLayout(new GridLayout(3,1));
	JPanel pan1 = new JPanel();
	content.add(pan1);
	pan1.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	
	pan1.add(new JLabel("Login :"));
	log = new JTextField(37);
	pan1.add(log);
	
	JPanel pan2 = new JPanel();
	content.add(pan2);
	pan2.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	pan2.add(new JLabel("Password :"));
	
	pw = new JPasswordField(37);
	pan2.add(pw);
	
	JPanel pan3 = new JPanel();
	content.add(pan3);
	pan3.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	JButton val = new JButton("Valider");
	val.setActionCommand("valider");
	val.addActionListener(this);
	pan3.add(val);
	
	fenetre.setBounds(500,400,300,200);
	fenetre.setVisible(true);
	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("valider")){
			
			String givenpw=pw.getText();
			String givenlog=log.getText();
			
				if(myControler.listePersonnel.get(givenlog) == null){
				
				 JOptionPane.showMessageDialog(fenetre, "Le login n'existe pas", "Erreur",JOptionPane.ERROR_MESSAGE);
				
			}else if(myControler.listePersonnel.get(givenlog).password.equals(givenpw)){
				
				
				fenetre.dispose();
				new Gestmenu(myControler);
				
			}else {
				
				JOptionPane.showMessageDialog(fenetre, "Mauvais mot de passe", "Erreur",JOptionPane.ERROR_MESSAGE);
				
				
			}
		
			
			
		}
		
	}
	

	

}
