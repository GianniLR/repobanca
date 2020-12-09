package packBanca;



public interface Banca extends Iterable<ContoBancario>{
	
	public String aperturaConto (String nome, String cognome);
	public String aperturaCarta (String nome, String cognome);
	public double disp(String iban);
	public boolean preleva(String iban, double cifra);
	public boolean versa(String iban, double cifra);
	//public ContoBancario[] conti();
	public String chiusuraConto(String iban);
	

}
