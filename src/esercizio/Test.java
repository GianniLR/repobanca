package esercizio;

import java.util.Arrays;

import packBanca.LaBanca;
import packContenitore.Contenitore;
import packContenitore.ContiContainer;

public class Test {

	public static void main(String[] args) {
		/*
		LaBanca banc=new LaBanca("La Banca", "Via Milano 75", "Milano");
		String iban1=banc.aperturaConto("Mario", "Rossi");
		double soldi1=banc.disp(iban1);
		banc.versa(iban1, 1000);
		banc.toString(iban1);
		System.out.println("SALDO DISPONIBILE PRIMA DEL PRELIEVO: "+banc.disp(iban1));
		banc.preleva(iban1, 500);
		System.out.print("IBAN: "+iban1);
		System.out.println(" - SALDO DISPONIBILE CONTO: "+banc.disp(iban1));
//		System.out.println(banc);
		
		System.out.println("---------------------------------------------");
		
		String iban2=banc.aperturaCarta("Anna", "Verde");
		double soldi2=banc.disp(iban2);
		banc.versa(iban2, 1000);
		banc.toString(iban2);
		System.out.println("SALDO DISPONIBILE PRIMA DEL PRELIEVO: "+banc.disp(iban2));
		banc.preleva(iban2, 1500);
		System.out.print("IBAN: "+iban2);
		System.out.println(" - SALDO DISPONIBILE CARTA: "+banc.disp(iban2));
		banc.toString(iban2);
		*/
		
		/*
		LaBanca banca= new LaBanca("La Banca","Via Milano 75", "Milano", new ContiContainer(10));
		String iban1=banca.aperturaConto("Mario", "Rossi");
		banca.versa(iban1, 1000);
		banca.toString(iban1);
		System.out.println("SALDO DISPONIBILE PRIMA DEL PRELIEVO: "+banca.disp(iban1));
		banca.preleva(iban1, 500);
		System.out.print("IBAN: "+iban1);
		System.out.println(" - SALDO DISPONIBILE CONTO: "+banca.disp(iban1));
//		System.out.println(banc);
		
		System.out.println("---------------------------------------------");
		
		String iban2=banca.aperturaCarta("Anna", "Verde");
		banca.versa(iban2, 1000);
		banca.toString(iban2);
		System.out.println("SALDO DISPONIBILE PRIMA DEL PRELIEVO: "+banca.disp(iban2));
		banca.preleva(iban2, 1500);
		System.out.print("IBAN: "+iban2);
		System.out.println(" - SALDO DISPONIBILE CARTA: "+banca.disp(iban2));
		banca.toString(iban2);
		
		System.out.println(Arrays.toString(banca.conti()));
		*/
	}

}
