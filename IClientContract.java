package fr.eni_ecole.jdbc_dvd.dao;

public interface IClientContract {

	
public static final String TABLE_CLIENT = "CLIENTS";
	
	public static final String COL_CLIENT_CODE = "code_client";
	public static final String COL_CLIENT_TITRE = "titre";
	public static final String COL_CLIENT_PRENOM = "prenom";
	public static final String COL_CLIENT_NOM= "nom";
	public static final String COL_CLIENT_ADRESSE= "adresse_rue";
	public static final String COL_CLIENT_CPO = "code_postal";
	public static final String COL_CLIENT_VILLE = "ville";
	public static final String COL_CLIENT_NUM_TEL = "num_telephone";
	public static final String COL_CLIENT_DDN = "date_naissance";
	public static final String COL_CLIENT_ENFANTS = "enfants";
}
