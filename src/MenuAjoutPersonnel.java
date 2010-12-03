
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	
public class MenuAjoutPersonnel implements ActionListener{


		JDialog f;
		JTextField txt1;
		JTextField txt2;
	

		public MenuAjoutPersonnel(Controleur myControler,JFrame g){
			
			
			f  = new JDialog(g,"Ajouter un personnel",true);
			Container content = f.getContentPane();
			content.setLayout(new GridLayout(3,1));
			//premier couple label+text
			JPanel pan1 = new JPanel();
			content.add(pan1);
			pan1.setLayout(new FlowLayout(FlowLayout.LEFT));
			pan1.add(new JLabel("Nom : "));
			txt1 = new JTextField(37);
			pan1.add(txt1);
			//deuxieme couple label+text
			JPanel pan2 = new JPanel();
			content.add(pan2);
			pan2.setLayout(new FlowLayout(FlowLayout.LEFT));
			pan2.add(new JLabel("Prenom : "));
			txt2=new JTextField(35);
			pan2.add(txt2);
//			Creation du listener
		
			
			//Ajout des boutons dans le panel 3
			JPanel pan3 = new JPanel();
			content.add(pan3);
			pan3.setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton b1=new JButton("Fermer");
			b1.setActionCommand("b1");
			b1.addActionListener(this);
			pan3.add(b1);
			JButton b2=new JButton("Afficher");
			b2.setActionCommand("b2");
			b2.addActionListener(this);
			pan3.add(b2);

			
			f.setBounds(0,0,500,150);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	public void actionPerformed(ActionEvent ae){
			
			if (ae.getActionCommand().equals("b1")){

			}
			if (ae.getActionCommand().equals("b2")){

	}
	}
	}


