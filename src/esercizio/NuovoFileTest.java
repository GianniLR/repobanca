package esercizio;

import packBanca.LaBanca;
import packContenitore.ContenitoreFile;
import packContenitore.ObjectContenitore;

public class NuovoFileTest {
	public static void main(String[] args) {
		
		LaBanca banca= new LaBanca("La Banca","Via Milano 75", "Milano", (new ObjectContenitore("oggetti_conti.data")));
		String iban=banca.aperturaConto("nome", "cognome");
		String iban1=banca.aperturaConto("Carlo", "Verdi");
		
	}

}
