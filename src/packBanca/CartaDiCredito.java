package packBanca;

public class CartaDiCredito extends ContoBancario implements Carta {
	//private ContoBancario next;
	private double fido;
	//private final double COPIA_FIDO;
	
	public CartaDiCredito(String nome, String cognome, String iban, double fido) {
		super(nome,cognome,iban);
		this.fido=fido;
		//COPIA_FIDO=fido;
	}
	
	public CartaDiCredito(String nome, String cognome, String iban,double saldo, double fido) {
		super(saldo,nome,cognome,iban);
		this.fido=fido;
		//COPIA_FIDO=fido;
	}
	public double getFido() {
		return fido;
	}


	public double getSaldo() {
		return super.getSaldo()+fido;
	}

	@Override
	public boolean versa(double cifra) {
		/*if(fido==0 && cifra<COPIA_FIDO)
		{
			fido=cifra;
		}
		else if(fido<COPIA_FIDO) {
			if(cifra+fido<=COPIA_FIDO) {
				fido=cifra;
			}
			else {
				fido=(cifra-fido);
				super.versa(cifra);
			}
			
		}*/
		super.versa(cifra);
		return true;
	}

	@Override
	public boolean preleva(double cifra) {
		double saldo_reale=getSaldo()-fido;

		if(fido==0)
		{
			return false;
		}
		else if(saldo_reale==0 && fido>cifra)
		{
			fido-=cifra;
			return true;
		}
		else if(saldo_reale<cifra && fido>(cifra-saldo_reale))
		{
			double app=cifra-saldo_reale;
			fido-=app;
			cifra-=app;
			setSaldo(saldo_reale-cifra);
		}
		
		else
		{
			super.preleva(cifra);
		}
		
		return true;
	
	}
	
	@Override
	public String toString()
	{
		return "Nome: "+getNome()+" Cognome: "+getCognome()+" IBAN: "+getIban()+" Saldo: "+super.getSaldo()+" Fido: "+fido+";";
	}
	
	

}
