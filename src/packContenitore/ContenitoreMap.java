package packContenitore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import packBanca.ContoBancario;

public class ContenitoreMap implements Contenitore {
	//<Chiave, Valore>
	private Map<String,ContoBancario> conti=new HashMap<>();

	@Override
	public ContoBancario getContoBancario(String iban) {
		return conti.get(iban);
	}

	@Override
	public void aggiungiContoBancario(ContoBancario cb) {
		conti.put(cb.getIban(), cb);
		

	}

	@Override
	public void rimuoviContoBancario(String iban) {
		conti.remove(iban);

	}

	@Override
	public ContoBancario[] getConti() {
		return conti.values().toArray(new ContoBancario[conti.size()]);
	}

	@Override
	public Iterator<ContoBancario> iterator() {
		return conti.values().iterator();
	}

}
