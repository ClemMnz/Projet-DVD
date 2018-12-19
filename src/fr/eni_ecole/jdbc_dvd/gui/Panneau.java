package fr.eni_ecole.jdbc_dvd.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;



public class Panneau extends JPanel {

	
	
	private JLabel lblAffichageDesClients;
	private JScrollPane scrollPane;
	private JTable tableClient;
	private TableClientModel model;
	
	
	public Panneau() {
		initComponents();
		setBackground(Color.PINK);
		setBorder(new EmptyBorder(100, 100, 100,100));
		add(getLblAffichageDesClients());
		setLayout(new BorderLayout());
		add(getScrollPane());
		
		//add(getTableClient());
	}
	private void initComponents() {
		
		}
	

	public JLabel getLblAffichageDesClients() {
		if(lblAffichageDesClients == null) {
			lblAffichageDesClients = new JLabel("Liste des clients");
			lblAffichageDesClients.setForeground(Color.WHITE);
		}
		return lblAffichageDesClients;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTableClient());
		}
		return scrollPane;
	}
	private JTable getTableClient() {
		if(tableClient == null) {
			tableClient = new JTable(getModel());
			//tableClient.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
		return tableClient;
	}
	private TableClientModel getModel() {
		if(model == null) {
			model = new TableClientModel();
		}
		return model;
	}

	

}
