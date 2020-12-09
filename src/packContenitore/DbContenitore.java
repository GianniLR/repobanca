package packContenitore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import packBanca.CartaDiCredito;
import packBanca.ContoBancario;

public class DbContenitore implements Contenitore {

	private static final String insert = "INSERT INTO banca.contocarta (IBAN, Nome, Cognome, Saldo, Fido, Status)";

	public DbContenitore() {

	}

	@Override
	public ContoBancario getContoBancario(String iban) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiungiContoBancario(ContoBancario cb) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/banca", "root", "rootpassword");
			Statement state = conn.createStatement();
			if (cb instanceof CartaDiCredito) 
			{
				salvaCarta(cb, state);
			} else 
			{
				salvaConto(cb, state);
			}
			state.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void salvaConto(ContoBancario cb, Statement state) throws SQLException {
		boolean ris1;
		String query=insert;
		query += "VALUES (" + cb.getIban() + ", " + cb.getNome() + ", " + cb.getCognome() + ", " + cb.getSaldo()
				+ "Aperto" + ")";

		ris1 = state.execute(query);

		if (!ris1) 
		{
			System.out.println("Conto Inserito.");
		}
	}

	private void salvaCarta(ContoBancario cb, Statement state) throws SQLException {
		boolean ris1;
		String query=insert;
		CartaDiCredito carta = (CartaDiCredito) cb;

		query += "VALUES (" + carta.getIban() + ", " + carta.getNome() + ", " + carta.getCognome() + ", "
				+ carta.getSaldo() + ", " + carta.getFido() + "Aperto" + ")";

		ris1 = state.execute(query);

		if (!ris1) 
		{
			System.out.println("Carta Inserito.");
		}
	}

	@Override
	public void rimuoviContoBancario(String iban) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/banca", "root", "rootpassword");
			Statement state = conn.createStatement();

			String chiudi = "UPDATE banca.contocarta SET Status = 'Chiuso' WHERE (IBAN = "+iban+")";

			boolean ris1 = state.execute(chiudi);

			if (!ris1) {
				System.out.println("Conto/Carta con iban: "+iban+" è stato chiuso.");
			}

			state.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ContoBancario[] getConti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<ContoBancario> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
