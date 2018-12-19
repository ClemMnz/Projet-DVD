package fr.eni_ecole.jdbc_dvd.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeuxiemePann extends JPanel {
	
	private JButton boutonAjouter;
	private JButton boutonSupprimer;
	private JTextField champNom; 
	private JTextField champPrenom;
	
	
	public DeuxiemePann() {
		initComponent();
		add(getBoutonSupprimer());
		add(getBoutonAjouter());
		add(getChampPrenom());
		add(getChampNom()); 
		boutonAjouter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		boutonSupprimer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	
	}
	private void initComponent() {
		// TODO Auto-generated method stub
		
	}
	public JButton getBoutonSupprimer() {
		
		if(boutonSupprimer == null) {
			boutonSupprimer = new JButton("Supprimer");
			
		}
		return boutonSupprimer;
	}
	
	
	public JButton getBoutonAjouter() {
		if(boutonAjouter == null) {
			boutonAjouter = new JButton("Ajouter");
		}
		return boutonAjouter;
	}
	public JTextField getChampNom() {
		if(champNom==null){
			champNom= new JTextField(10);
		}
		
		return champNom;
	}
	public JTextField getChampPrenom() {
		if(champPrenom==null){
			champPrenom= new JTextField(10);
		}
		return champPrenom;
	}
	

}
