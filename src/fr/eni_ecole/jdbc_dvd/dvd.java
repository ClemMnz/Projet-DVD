package fr.eni_ecole.jdbc_dvd;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;


import fr.eni_ecole.jdbc_dvd.dao.ClientDao;
import fr.eni_ecole.jdbc_dvd.dao.FactureDao;
import fr.eni_ecole.jdbc_dvd.model.Client;

public class dvd{

	public static void main(String[] args) {
		
		ClientDao dao = new ClientDao();
		FactureDao factDao = new FactureDao();
		// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
		
		try {
			Client client = new Client("MEN001", "Mme", "Méjjjez","Clémence", "16 Allée des Asturies","35000", "Rennes", "0654124145",new Date(1988-01-01),true); 
			System.out.println(dao.update(client));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			System.out.println(factDao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			System.out.println(factDao.selectbyId(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
