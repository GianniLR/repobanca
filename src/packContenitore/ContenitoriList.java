package packContenitore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import packBanca.ContoBancario;

public class ContenitoriList implements Contenitore {
	private List<ContoBancario> conti;
	
	public ContenitoriList(List<ContoBancario> conti) {
		this.conti = conti;
	}

	@Override
	public ContoBancario getContoBancario(String iban) {
		return conti.get(conti.indexOf(new ContoBancario(" "," ",iban)));
	}

	@Override
	public void aggiungiContoBancario(ContoBancario cb) {
		conti.add(cb);

	}

	@Override
	public void rimuoviContoBancario(String iban) {
		conti.remove(conti.indexOf(new ContoBancario(" "," ",iban)));
		
	}

	@Override
	public ContoBancario[] getConti() {
		return (ContoBancario[]) conti.toArray(new ContoBancario[conti.size()]);
	}

	@Override
	public Iterator<ContoBancario> iterator() {
		return conti.iterator();
	}
	

}
