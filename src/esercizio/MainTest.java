package esercizio;

import java.util.ArrayList;
import java.util.List;

import packBanca.Banca;
import packBanca.ContoBancario;
import packBanca.LaBanca;
import packContenitore.ContenitoriList;
import packContenitore.DbContPrep;

public class MainTest {

	public static void main(String[] args) {
		List<ContoBancario> list= new ArrayList<ContoBancario>();
		Banca banca=new LaBanca("BANCA", "Via Roma", "Milano", new ContenitoriList(list));
		banca.aperturaConto("Filippo", "Cognome");
		banca.aperturaConto("Anna", "Cognomelli");
		
		for (ContoBancario conto: banca) 
		{
			System.out.println(conto);
		}

	}

}
