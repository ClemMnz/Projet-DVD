package fr.eni_ecole.jdbc_dvd.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	
	private String codeClient;
	private String titre; 
	private String nom; 
	private String prenom; 
	private String adresse_rue; 
	private String code_postal; 
	private String ville; 
	private String num_telephone; 
	private Date date_naissance; 
	private boolean enfants ;
	
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse_rue() {
		return adresse_rue;
	}
	public void setAdresse_rue(String adresse_rue) {
		this.adresse_rue = adresse_rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getNum_telephone() {
		return num_telephone;
	}
	public void setNum_telephone(String num_telephone) {
		this.num_telephone = num_telephone;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void  setDateNaissance (Date date_naissance){
		//this.setDateNaissance(new SimpleDateFormat("dd/MM/yyyy").parse(date_naissance));
		this.date_naissance= date_naissance;
	}
	
	public boolean isEnfants() {
		return enfants;
	}
	public void setEnfants(boolean enfants) {
		this.enfants = enfants;
	}

	
	public Client(String codeClient, String titre, String nom, String prenom, String adresse_rue, String code_postal,
			String ville, String num_telephone, Date date_naissance, boolean enfants) {
	
		this.codeClient = codeClient;
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse_rue = adresse_rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.num_telephone = num_telephone;
		this.date_naissance = date_naissance;
		this.enfants = enfants;
	}
	@Override
	public String toString() {
		return "Client [codeClient=" + codeClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse_rue="
				+ adresse_rue + ", code_postal=" + code_postal + ", ville=" + ville + ", num_telephone=" + num_telephone
				+ ", date_naissance=" + date_naissance + ", enfants=" + enfants + "]";
	}
	
	
}
