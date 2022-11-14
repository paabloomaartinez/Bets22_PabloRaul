package domain;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class UserAdapter extends AbstractTableModel {
	private final Vector<ApustuAnitza> ListaApuestas;
	private Registered usuario;
	private String[] nombreDeLasColumnas = new String[] {"Event", "Question", "Event Date", "Bet (€)"};
	
	public UserAdapter(Registered user) {
		ListaApuestas = new Vector<ApustuAnitza>(user.getApustuAnitzak());
		this.usuario = user;
	}
	
	public int getRowCount() {
		return ListaApuestas.size();
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int col) {
		return nombreDeLasColumnas[col];
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0: return (Object)ListaApuestas.get(rowIndex).getApustuak();
		case 1: return (Object)ListaApuestas.get(rowIndex);
		case 2: return (Object)ListaApuestas.get(rowIndex).getData();
		case 3: return (Object)ListaApuestas.get(rowIndex).getBalioa();
		}
		return null;
	}
}
