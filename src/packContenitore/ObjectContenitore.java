package packContenitore;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import packBanca.ContoBancario;


public class ObjectContenitore implements Contenitore {
	private String nome;
	

	public ObjectContenitore(String nome) {
		this.nome = nome;
	}

	@Override
	public ContoBancario getContoBancario(String iban) {
		Map<String,ContoBancario> map = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.nome)));
			map = (Map<String, ContoBancario>) in.readObject();
			
			System.out.println("Ho caricato la lista: " + map);
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return map.get(iban);
	}

	@Override
	public void aggiungiContoBancario(ContoBancario cb) {
		// Scrittura di un oggetto
		try {
			
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.nome)));
			Map<String,ContoBancario> mappa =  (Map<String, ContoBancario>) in.readObject();
			mappa.put(cb.getIban(), cb);

			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(this.nome)));
			
			System.out.println("Salvo la lista: " + mappa);
			out.writeObject(mappa);

			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void rimuoviContoBancario(String iban) {
try {
			
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.nome)));
			Map<String,ContoBancario> mappa =  (Map<String, ContoBancario>) in.readObject();
			mappa.remove(iban);

			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(this.nome)));
			
			System.out.println("Rimuovo la lista: " + mappa);
			out.writeObject(mappa);

			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ContoBancario[] getConti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<ContoBancario> iterator() {
		Map<String,ContoBancario> map = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.nome)));
			map = (Map<String, ContoBancario>) in.readObject();
			
			System.out.println("Ho caricato la lista: " + map);
			in.close();
			return map.values().iterator();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
