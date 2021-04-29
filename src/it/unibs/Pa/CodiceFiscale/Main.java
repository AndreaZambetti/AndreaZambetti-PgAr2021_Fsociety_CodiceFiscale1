package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;

import static it.unibs.Pa.CodiceFiscale.LettoreXML.*;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
		// TODO Auto-generated method stub
		LettoreXML lett = new LettoreXML();
		ArrayList <Persona> lista_persone = new ArrayList<Persona>();
		lista_persone = lett.LeggiXML();
		for (int i=0; i<lista_persone.size(); i++){
			System.out.println(lista_persone.get(i).getNome() + " " + lista_persone.get(i).getCognome() +
					" (" + lista_persone.get(i).getSesso() + ")		" + lista_persone.get(i).getData_nascita() +
					"	" + lista_persone.get(i).getComuneNascita());
		}
	}
}
