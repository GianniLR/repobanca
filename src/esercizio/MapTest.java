package esercizio;

import java.util.LinkedList;
import java.util.List;

import packBanca.ContoBancario;
import packBanca.LaBanca;
import packContenitore.Contenitore;
import packContenitore.ContenitoreMap;
import packContenitore.ContenitoriList;
import packContenitore.ContenitoreFile;

public class MapTest {

	public static void main(String[] args) {
		List<ContoBancario> list= new LinkedList<ContoBancario>();
		Contenitore contenitore=new ContenitoreMap();
		LaBanca banca= new LaBanca("La Banca","Via Milano 75", "Milano", contenitore);
		String iban=banca.aperturaConto("Mario", "Rossi");
		String iban1=banca.aperturaCarta("Luca", "Dario");
		String iban2=banca.aperturaCarta("Gianni", "La Russa");
		banca.versa(iban, 1000);
		System.out.println(banca);
		banca.chiusuraConto(iban);
		System.out.println(banca);

	}

}
