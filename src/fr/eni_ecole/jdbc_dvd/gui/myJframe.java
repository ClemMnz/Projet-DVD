package fr.eni_ecole.jdbc_dvd.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class myJframe extends JFrame {

	private JPanel contentPane;
	private JPanel panneau;
	private JButton boutonQuitter; 
	private JTable table;
	private JPanel deuxiemePann;


/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myJframe frame = new myJframe();
					frame.setVisible(true);
					frame.setTitle("Ma super fenêtre");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public myJframe() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 689);
		contentPane = new JPanel();
		panneau= new Panneau();
		deuxiemePann= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(Color.LIGHT_GRAY);
	    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
	    getContentPane().add(getPanneau());
	    getContentPane().add(getBoutonQuitter());
	    getContentPane().add(getDeuxiemePann());
	    
	    boutonQuitter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			 System.exit(0);
			}
	    	
	    });
	
	}
	private void initComponents() {
	
	}
	
	public JPanel getPanneau() {
		if(panneau== null) {
			panneau = new Panneau();
			panneau.setBackground(new Color(240, 230, 140));
			panneau.add(getTable(), BorderLayout.SOUTH);
		
		}
		return panneau;
	}

	public JPanel getDeuxiemePann() {
		if(deuxiemePann==null){
			deuxiemePann.setLayout(new BorderLayout(0, 0));
			deuxiemePann.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			deuxiemePann.setLayout(new BoxLayout(deuxiemePann, BoxLayout.X_AXIS));
			deuxiemePann= new DeuxiemePann();
	}
		return deuxiemePann;
	}
	public JButton getBoutonQuitter() {
		if(boutonQuitter==null){
		boutonQuitter= new JButton("Quitter");
		boutonQuitter.setHorizontalAlignment(SwingConstants.TRAILING);
		boutonQuitter.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return boutonQuitter; 
	}


	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			
		}
		return table;
	}
}
