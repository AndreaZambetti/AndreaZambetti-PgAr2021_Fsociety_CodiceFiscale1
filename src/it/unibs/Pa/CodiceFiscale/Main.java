package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLStreamException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

	// CREAZIONE DEL CODICE FISCALE DELLE PERSONE NEL FILE DI INPUT PERSONE
	private static void creaCodiciPersone(ArrayList<Persona> lista_persone, ArrayList<String> lista_codici) throws XMLStreamException {
		for ( int i = 0; i < lista_persone.size(); i++){
			String codiceFiscale = lista_persone.get(i).creaCodiceFiscaleFinale(lista_codici);
			lista_persone.get(i).setCodice_fiscale(codiceFiscale);
		}
	}

	public static void main(String[] args) throws XMLStreamException {
		// TODO Auto-generated method stub



        //LETTURA FILE XML DEI CODICI E DELLE PERSONE
		ArrayList <Persona> lista_persone = new ArrayList<Persona>();
		lista_persone = LettoreXML.leggi_inputPersone();
		ArrayList<String> lista_codici = new ArrayList<String>();
		lista_codici = LettoreXML.leggiCodiciFiscali();

		ArrayList<String> lista_codici_errati = new ArrayList<String>();
		Persona lista_temp = new Persona();
		for (int i=0; i<lista_codici.size(); i++){
			//trasferimento dei codici NON VALIDI nell'apposita List
			// e rimozione dalla List dei codici per il confronto
			if (!lista_temp.VerificaCodice(lista_codici.get(i))){
				lista_codici_errati.add(lista_codici.get(i));
				lista_codici.remove(i);
			}
		}

		creaCodiciPersone(lista_persone, lista_codici);

		/*Persona lista_temp = new Persona();



		ArrayList<Comune> lista_comuni = new ArrayList<Comune>();
		lista_comuni = LettoreXML.leggi_Comune();*/

		Output out = new Output();
		out.stampa(lista_persone,"fine");

	}



}



	/*// CREAZIONE PERSONE E INSERIMENTO NEL ARRAY
		ArrayList <Persona> lista_persone = new ArrayList<Persona>();
		lista_persone = LettoreXML.leggi_inputPersone();
		for (int i=0; i<lista_persone.size(); i++){
			System.out.println(lista_persone.get(i).getNome() + " " + lista_persone.get(i).getCognome() +
					" (" + lista_persone.get(i).getSesso() + ")		" + lista_persone.get(i).getData_nascita() +
					"	" + lista_persone.get(i).getComuneNascita());
		}

		// CREAZIONE COMUNE E INSERIMENTO NEL ARRAY LIST
		ArrayList < Comune > lista_comune = new ArrayList<Comune >();
		lista_comune  = LettoreXML.leggi_Comune();
		for (int i=0; i<lista_comune.size(); i++){
			System.out.println(lista_comune.get(i).getNome() + " " + lista_comune.get(i).getCodice() );

		}

		// LETTURA CODICE FISCALE
		ArrayList< String > lista_codiciFiscali = new ArrayList<String >();

		lista_codiciFiscali = LettoreXML.leggiCodiceFiscale();

		for ( int i = 0 ; i< lista_codiciFiscali.size(); i++){
			System.out.println(lista_codiciFiscali.get(i));

		}*/