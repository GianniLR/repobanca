package packContenitore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import packBanca.CartaDiCredito;
import packBanca.ContoBancario;

public class DbContPrep implements Contenitore{
	private static final String USERNAME="root";
	private static final String PASSWORD="rootpassword";
	private static final String COLL= "jdbc:mysql://localhost/banca";
	private static final String QUERY = "INSERT INTO banca.contocarta ( IBAN , Nome , Cognome , Saldo , Fido , Status ) "
			+ "VALUES ( ? , ? , ? , ? , ? , ? )";

	@Override
	public ContoBancario getContoBancario(String iban) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiungiContoBancario(ContoBancario cb) {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(COLL, USERNAME, PASSWORD);
			PreparedStatement prep= conn.prepareStatement(QUERY);
			
			if (cb instanceof CartaDiCredito) 
			{
				CartaDiCredito carta = inserisciConto(cb, prep);
				prep.setDouble(5, carta.getFido());
				prep.setString(6, "Aperto");
			} 
			else 
			{
				inserisciConto(cb,prep);
				prep.setDouble(5, -1);
				prep.setString(6, "Aperto");
			}

			boolean ris1= prep.execute();
			if(!ris1)
			{
				System.out.println("Insert succcesfull");
			}
			
			
			prep.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private CartaDiCredito inserisciConto(ContoBancario cb, PreparedStatement prep) throws SQLException {
		CartaDiCredito carta = (CartaDiCredito) cb;
		prep.setString(1, carta.getIban());
		prep.setString(2, carta.getNome());
		prep.setString(3, carta.getCognome());
		prep.setDouble(4, carta.getSaldo());
		return carta;
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
