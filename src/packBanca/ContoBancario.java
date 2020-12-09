package packBanca;

import java.io.Serializable;

public class ContoBancario implements Carta, Serializable{
	
	private double saldo;
	private String nome;
	private String cognome;
	private String iban;
	//private ContoBancario next;
	
	//Costruttore
	public ContoBancario(String nome, String cognome, String iban) {
		this.nome = nome;
		this.cognome = cognome;
		this.iban=iban;
	}
	

	public ContoBancario(double saldo, String nome, String cognome, String iban) {
		super();
		this.saldo = saldo;
		this.nome = nome;
		this.cognome = cognome;
		this.iban = iban;
	}


	//Metodi
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getIban() {
		return iban;
	}

	public boolean versa(double n) {
		if(n>0)
		{
			saldo=saldo+n;
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

	@Override
	public boolean preleva(double cifra) {
		if(cifra>saldo)
		{
			
			return false;
		}
		saldo=saldo-cifra;
		return true;
	}


	@Override
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double s) {
		saldo=s;
	}
	
	@Override
	public String toString()
	{
		return "Nome: "+getNome()+" Cognome: "+getCognome()+" IBAN: "+getIban()+" Saldo: "+getSaldo()+";";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoBancario other = (ContoBancario) obj;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}
	
	
}
