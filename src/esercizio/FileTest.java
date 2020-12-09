package esercizio;

import packBanca.LaBanca;
import packContenitore.ContenitoreFile;

public class FileTest {

	public static void main(String[] args) {
		LaBanca banca= new LaBanca("La Banca","Via Milano 75", "Milano", (new ContenitoreFile("contiBancari.data")));
		String iban=banca.aperturaConto("nome", "cognome");
		

	}

}
