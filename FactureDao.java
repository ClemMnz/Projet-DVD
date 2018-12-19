package fr.eni_ecole.jdbc_dvd.dao;
import static fr.eni_ecole.jdbc_dvd.dao.IFactureContract.TABLE_FACTURE;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.TABLE_CLIENT;
import static fr.eni_ecole.jdbc_dvd.dao.IClientContract.COL_CLIENT_CODE ;
import static fr.eni_ecole.jdbc_dvd.dao.IFactureContract.COL_FACTURE_NUM; 
import static fr.eni_ecole.jdbc_dvd.dao.IFactureContract.COL_FACTURE_CODE_CLI;
import static fr.eni_ecole.jdbc_dvd.dao.IFactureContract.COL_FACTURE_DATEFACT;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni_ecole.jdbc_dvd.jdbc.connection.PoolConnection;
import fr.eni_ecole.jdbc_dvd.model.Client;
import fr.eni_ecole.jdbc_dvd.model.Facture;
import fr.eni_ecole.jdbc_dvd.dao.ClientDao;
import fr.eni_ecole.jdbc_dvd.model.Facture;

public class FactureDao {

	private final String SELECT_ALL = "SELECT * FROM " + TABLE_FACTURE +
			  " INNER JOIN " + TABLE_CLIENT + " ON " + 
			  TABLE_CLIENT + "." + COL_CLIENT_CODE +
			  " = " + TABLE_FACTURE + "." + COL_FACTURE_CODE_CLI;
	
	private final String SELECT_BY_ID= SELECT_ALL
			  +" WHERE "+ COL_FACTURE_NUM+" =?"; 
	
	private final String INSERT ="INSERT INTO " + TABLE_FACTURE + 
			  " VALUES("+
			  " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	public ArrayList<Facture> selectAll() throws SQLException {
		
		ArrayList<Facture> factures = new ArrayList<Facture>(); 
		Connection cnx = new PoolConnection().getConnection();
		
		PreparedStatement pStmt = cnx.prepareStatement(SELECT_ALL);
		
		
		ResultSet rs = pStmt.executeQuery();
		
		Facture facture = null;
		while(rs.next()) {
			factures.add(map(rs));
			
			
		}
		return factures;
	}
	
	public Facture selectbyId(int id) throws SQLException{

	
		Connection cnx = new PoolConnection().getConnection();
	
		PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
		pStmt.setInt(1, id);
		
		ResultSet rs = pStmt.executeQuery(); 
		
		Facture facture = null; 
		if(rs.next()) {
			facture = map(rs);
		}
		
		return facture; 
		
	}
	
	public Facture insert(Facture facture) throws SQLException {
		
		
		
		return facture;
		
		
	}
	
	public static Facture map(ResultSet rs) throws SQLException {
		Facture fact = null;
		
		int num= rs.getInt(COL_FACTURE_NUM);
		Date date = rs.getDate(COL_FACTURE_DATEFACT);
		Client client = ClientDao.map(rs); 
		
		fact = new Facture(num,client, date); 
		return fact; 
	}
	
	
	
}
