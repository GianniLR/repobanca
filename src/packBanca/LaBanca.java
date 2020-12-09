package packBanca;

import java.util.Arrays;
import java.util.Iterator;

import packContenitore.Contenitore;

public class LaBanca implements Banca{
	
	private String nome;
	private String indirizzo;
	private String citta;
	private final static String IBAN="IT0000";
	private int contconti=0;
	
	private Contenitore conti;

	public LaBanca(String nome, String indirizzo, String citta, Contenitore conti) {
		
		this.nome=nome;
		this.indirizzo=indirizzo;
		this.citta=citta;
		this.conti=conti;
	}
	
	public LaBanca(String nome, String indirizzo, String citta) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}



	public LaBanca() {
		
	}

	@Override
	public String aperturaConto(String nome, String cognome) {
		//conti1= (Contenitore)new ContoBancario(nome, cognome, IBAN+contconti+"CB");
		conti.aggiungiContoBancario(new ContoBancario(nome,cognome,IBAN+contconti+"CB"));
		contconti++;
		return IBAN+(contconti-1)+"CB";
	}

	@Override
	public String aperturaCarta(String nome, String cognome) {
		conti.aggiungiContoBancario(new CartaDiCredito(nome,cognome,IBAN+contconti+"CB",4000));
		contconti++;
		return IBAN+(contconti-1)+"CC";
	}

	//Disponibilità
	@Override
	public double disp(String iban) {
		return conti.getContoBancario(iban).getSaldo();
	}

	@Override
	public boolean preleva(String iban, double cifra) {
		//System.out.println(index(iban));
		conti.getContoBancario(iban).preleva(cifra);
		return true;
	}

	@Override
	public boolean versa(String iban, double cifra) {
		//System.out.println(index(iban));
		conti.getContoBancario(iban).versa(cifra);
		return true;
	}

	
	

	//Chiudere il conto
	@Override
	public String chiusuraConto(String iban) {
		conti.rimuoviContoBancario(iban);
		return "Conto chiuso.";
	}
	
	//@Override
	public ContoBancario[] conti() {
		return conti.getConti();
	}

	@Override
	public String toString() {
		return "LaBanca [nome=" + nome + ", indirizzo=" + indirizzo + ", citta=" + citta + ", contconti=" + contconti
				+ ", conti=" + Arrays.toString(conti.getConti()) + "]";
	}

	//Iteratore
	@Override
	public Iterator<ContoBancario> iterator() {
		return conti.iterator();
	}
	
	
}
