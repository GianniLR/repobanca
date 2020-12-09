package esercizio;

import packBanca.Banca;
import packBanca.LaBanca;
import packContenitore.DbContPrep;
import packContenitore.DbContenitore;

public class NewTest {

	public static void main(String[] args) {
		Banca banca=new LaBanca("BANCA", "Via Roma", "Milano", new DbContPrep());
		banca.aperturaConto("Filippo", "Jonshon");

	}

}
