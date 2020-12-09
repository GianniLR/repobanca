package packContenitore;

import packBanca.ContoBancario;

public interface Contenitore extends Iterable<ContoBancario>{
	ContoBancario getContoBancario(String iban);
	void aggiungiContoBancario(ContoBancario cb);
	void rimuoviContoBancario(String iban);
	ContoBancario[] getConti();
}
