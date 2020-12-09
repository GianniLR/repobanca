package packContenitore;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import packBanca.CartaDiCredito;
import packBanca.ContoBancario;

public class ContenitoreFile implements Contenitore {
	private String nome;
	
	public ContenitoreFile(String nome) {
		this.nome = nome;
	}

	@Override
	public void aggiungiContoBancario(ContoBancario conto) {
		DataOutputStream out;
		try {
			out=new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(this.nome,true)));
			if(conto instanceof CartaDiCredito)
			{
				CartaDiCredito carta=(CartaDiCredito)conto;
				out.writeDouble(carta.getSaldo());
				out.writeUTF(carta.getIban());
				out.writeUTF(carta.getNome());
				out.writeUTF(carta.getCognome());
				out.writeDouble(carta.getFido());
			}
			else {
				out.writeDouble(conto.getSaldo());
				out.writeUTF(conto.getIban());
				out.writeUTF(conto.getNome());
				out.writeUTF(conto.getCognome());
				out.writeDouble(-1);
			}
			
			//out.writeUTF("] \n");
			
			out.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ContoBancario getContoBancario(String iban) {
		ContoBancario cb= new ContoBancario(" "," ",iban);
		ContoBancario ris=null;
		
		try {
			DataInputStream in=new DataInputStream(
					new BufferedInputStream(
					new FileInputStream(this.nome)));
			
			do {
				double saldo=in.readDouble();
				String iban_dato=in.readUTF();
				String nome=in.readUTF();
				String cognome=in.readUTF();
				double fido=in.readDouble();
				
				if(fido==-1) {
					ris= new ContoBancario(saldo,iban_dato,nome,cognome);
				}
				else {
					ris= new CartaDiCredito(iban_dato,nome,cognome,saldo,fido);
				}
				
				if(cb.equals(ris)) 
				{
					break;
				}
			}while(in.available()>0);
			
			in.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ris;
	}


	@Override
	public void rimuoviContoBancario(String iban) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ContoBancario[] getConti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<ContoBancario> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
