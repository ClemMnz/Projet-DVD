package fr.eni_ecole.jdbc_dvd.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import fr.eni_ecole.jdbc_dvd.dao.ClientDao;
import fr.eni_ecole.jdbc_dvd.gui.TableClientModel;
import fr.eni_ecole.jdbc_dvd.model.Client;

public class TableClientModel extends AbstractTableModel {

	
	private final String[] columnNames = {"Code Client", "Nom", "Prénom", "Ville"};
	private ArrayList<Client> clients;
	ClientDao cli= new ClientDao(); 
	public TableClientModel() {
		upDateData(); 
	}

	private void upDateData() {
		
		try {
			clients=cli.selectAll();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fireTableDataChanged();
		
	}

	@Override
	public int getRowCount() {
		return clients.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object result = null;
		
		if(rowIndex < clients.size()) {
			switch (columnIndex) {
			case 0:
				result = clients.get(rowIndex).getCodeClient();
				break;
			case 1:
				result = clients.get(rowIndex).getNom();
				break;
			case 2:
				result = clients.get(rowIndex).getPrenom();
				break;
			case 3:
				result= clients.get(rowIndex).getVille();
			default:
				break;
			}
		}
		
		return result;
	}
	
	
	
	
}
