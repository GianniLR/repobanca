package packContenitore;

import java.util.List;

import packBanca.ContoBancario;

public class ContiContainer extends ContenitoriList {
	
	public ContiContainer(List<ContoBancario> conti) {
		super(conti);
		// TODO Auto-generated constructor stub
	}

	private ContoBancario[] conti;
	private int contconti=0;

//	public ContiContainer(int dim) {
//		this.conti = new ContoBancario[dim];
//	}

	@Override
	public ContoBancario getContoBancario(String iban) {
		return conti[index(iban)];
	}

	@Override
	public void aggiungiContoBancario(ContoBancario cb) {
		if(contconti==conti.length)
		{
			conti=aggiungiConti(new ContoBancario(cb.getNome(), cb.getCognome(),cb.getIban()));
		}
		conti[contconti]=new ContoBancario(cb.getNome(), cb.getCognome(),cb.getIban());
		contconti++;
	}
	
	// Aggiungere nuovi conti se il vecchio vettore è pieno
	public ContoBancario[] aggiungiConti(ContoBancario conto_da_aggiungere) {
		ContoBancario[] nuoviConti = new ContoBancario[contconti + 1];
		for (int i = 0; i < contconti - 1; i++) 
		{
			nuoviConti[i] = conti[i];
		}
		nuoviConti[contconti] = conto_da_aggiungere;

		return nuoviConti;
	}
	
	@Override
	public void rimuoviContoBancario(String iban) {
		if(index(iban)!=-1)
		{
			spostaArray(iban);
			
		}
	}

	private void spostaArray(String iban) {
		conti[index(iban)]=null;
		for(int i=index(iban); i<contconti; i++)
		{
			conti[i]=conti[i+1];
		}
		
		conti[contconti]=null;
	}
	
	private int index(String iban)
	{
		int indice=-1;
		for(int i=0; i<contconti;i++)
		{
			if(conti[i].getIban().compareTo(iban)==0)
			{
				indice= i;
			}
				
		}
		return indice;
	}

	@Override
	public ContoBancario[] getConti() {
		ContoBancario[] conti_tot=new ContoBancario[contconti];
		for (int i=0; i<contconti;i++)
		{
			conti_tot[i]=conti[i];
		}
		return conti_tot;
	}

}
