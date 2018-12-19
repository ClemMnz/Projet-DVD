package fr.eni_ecole.jdbc_dvd.dao;

import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.TABLE_CLIENT;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_CODE;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_ADRESSE;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_CPO;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_NOM;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_PRENOM;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_VILLE;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_TITRE;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_NUM_TEL;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_DDN;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_ENFANTS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni_ecole.jdbc_dvd.jdbc.connection.PoolConnection;
import fr.eni_ecole.jdbc_dvd.model.Client;

public class ClientDao {

	private final String SELECT_ALL = "SELECT * FROM " + TABLE_CLIENT;
	
	private final String INSERT = "INSERT INTO " + TABLE_CLIENT + 
			  " VALUES("+
			  " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String DELETE="DELETE FROM "+ TABLE_CLIENT +" WHERE "+COL_CLIENT_CODE+" =?";

	private final String UPDATE="UPDATE "+ TABLE_CLIENT+ " SET "+
				COL_CLIENT_TITRE+"=? ,"+
				COL_CLIENT_NOM +" =? ," +
				COL_CLIENT_PRENOM +" =? ,"+
				COL_CLIENT_ADRESSE+" =? ,"+
				COL_CLIENT_CPO+" =? , "+
				COL_CLIENT_VILLE +" =?,"+
				COL_CLIENT_NUM_TEL+"=? ,"+
				COL_CLIENT_DDN+" =? ,"+
			    COL_CLIENT_ENFANTS+" =? " +" WHERE "+ COL_CLIENT_CODE +"=?";
	
	protected Connection cnx = null;
	
	public ArrayList<Client> selectAll() throws SQLException {
		ArrayList<Client> clients = new ArrayList<>();
	
		cnx = new PoolConnection().getConnection();
		
		PreparedStatement pStmt = cnx.prepareStatement(SELECT_ALL);
		
		ResultSet rs = pStmt.executeQuery();
		
		while(rs.next()) {
		
			clients.add(map(rs));
		}                                                                     
		
		rs.close();
		pStmt.close();
		cnx.close();
		
		return clients;
	}
	
	public static Client map(ResultSet rs) throws SQLException {
		Client client = null;
		
		String codeClient= rs.getString(COL_CLIENT_CODE);
		String titre= rs.getString(COL_CLIENT_TITRE);
		String prenom = rs.getString(COL_CLIENT_PRENOM);
		String nom = rs.getString(COL_CLIENT_NOM);
		String adresse_rue = rs.getString(COL_CLIENT_ADRESSE);
		String code_postal = rs.getString(COL_CLIENT_CPO);
		String ville = rs.getString(COL_CLIENT_VILLE);
		String num_telephone = rs.getString(COL_CLIENT_NUM_TEL);
		Date date_naissance= rs.getDate(COL_CLIENT_DDN);
		Boolean enfants= rs.getBoolean(COL_CLIENT_ENFANTS);
		
		client = new Client(codeClient,titre,prenom,nom,adresse_rue,code_postal,ville,num_telephone,date_naissance,enfants);
		
		return client;
	}
	public boolean insert(Client client) throws SQLException {		
		cnx = new PoolConnection().getConnection();
		
		PreparedStatement pStmt = cnx.prepareStatement(INSERT);
		pStmt.setString(1, client.getCodeClient());
		pStmt.setString(2, client.getTitre());
		pStmt.setString(3, client.getPrenom());
		pStmt.setString(4, client.getNom());
		pStmt.setString(5, client.getAdresse_rue());
		pStmt.setString(6, client.getCode_postal());
		pStmt.setString(7, client.getVille());
		pStmt.setString(8, client.getNum_telephone());
		pStmt.setDate(9, (Date) client.getDate_naissance());
		pStmt.setBoolean(10, client.isEnfants());
		
		int n = pStmt.executeUpdate();

		pStmt.close();
		cnx.close();
		
		return n > 0;
	}
	
	public boolean delete(Client client) throws SQLException {		
		cnx = new PoolConnection().getConnection();
		
		PreparedStatement pStmt = cnx.prepareStatement(DELETE);
		pStmt.setString(1, client.getCodeClient());

		int n = pStmt.executeUpdate();

		pStmt.close();
		cnx.close();
		
		return n > 0;
	}


	public boolean update(Client client)throws SQLException{
		cnx= new PoolConnection().getConnection(); 
		
		PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
		
		pStmt.setString(1, client.getTitre());
		pStmt.setString(2, client.getPrenom());
		pStmt.setString(3, client.getNom());
		pStmt.setString(4, client.getAdresse_rue());
		pStmt.setString(5, client.getCode_postal());
		pStmt.setString(6, client.getVille());
		pStmt.setString(7, client.getNum_telephone());
		pStmt.setDate(8, (Date) client.getDate_naissance());
		pStmt.setBoolean(9, client.isEnfants());
		pStmt.setString(10, client.getCodeClient());
		
		int n= pStmt.executeUpdate(); 
		
		pStmt.close();
		cnx.close(); 
		return n>0; 
		
		
	} 
	
	
}
