package fr.eni_ecole.jdbc_dvd.model;

import java.util.Date;

public class Facture {
	private int num_facture; 
	private Client client; 
	private Date date_facture;
	
	public int getNum_facture() {
		return num_facture;
	}
	public void setNum_facture(int num_facture) {
		this.num_facture = num_facture;
	}
	
	
	public Date getDate_facture() {
		return date_facture;
	}
	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}
	
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public Facture(int num_facture, Date date_facture) {
	
		this.num_facture = num_facture;
		this.date_facture = date_facture;
	}
	public Facture(int num_facture, Client client, Date date_facture) {
	
		this.num_facture = num_facture;
		this.client = client;
		this.date_facture = date_facture;
	}
	@Override
	public String toString() {
		return "Facture [num_facture=" + num_facture + ", client=" + client + ", date_facture=" + date_facture + "]";
	}
	

	
}
