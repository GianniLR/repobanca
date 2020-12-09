package esercizio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import packBanca.ContoBancario;
import packBanca.LaBanca;
import packContenitore.Contenitore;
import packContenitore.ContenitoriList;
import packContenitore.ContiContainer;

public class ListTest {

	public static void main(String[] args) {
		List<ContoBancario> list= new LinkedList<ContoBancario>();
		Contenitore contenitore=new ContenitoriList(list);
		LaBanca banca= new LaBanca("La Banca","Via Milano 75", "Milano", contenitore);
		String iban=banca.aperturaConto("Mario", "Rossi");
		banca.versa(iban, 1000);
		System.out.println(banca);
		banca.chiusuraConto(iban);
		System.out.println(banca);
		

	}

}
