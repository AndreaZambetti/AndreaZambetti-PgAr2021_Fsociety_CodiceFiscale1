package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLStreamException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

	// CREAZIONE DEL CODICE FISCALE DELLE PERSONE NEL FILE DI INPUT PERSONE
	private static void creaCodiciPersone(ArrayList<Persona> lista_persone) {
		for ( int i = 0 ; i < lista_persone.size(); i++){
			String codiceFiscale = lista_persone.get(i).creaCodiceFiscaleFinale();
			lista_persone.get(i).setCodice_fiscale(codiceFiscale);
		}
	}

	public static void main(String[] args) throws XMLStreamException {
		// TODO Auto-generated method stub
		ArrayList<String> codiceDaLeggere = new ArrayList<String>();



     // METODO PER CREARE IL CODICE E INSERIRLO ALL INTERNO DELLA PERSONA





		ArrayList <Persona> lista_persone = new ArrayList<Persona>();
		lista_persone = LettoreXML.leggi_inputPersone();
		creaCodiciPersone(lista_persone);

		Persona lista_codice = new Persona();


		codiceDaLeggere = LettoreXML.leggiCodiciFiscali();
		int nonCe = 0;
		int ce = 0;
		for (int i=0; i<codiceDaLeggere.size(); i++){

			if (lista_codice.VerificaCodice(codiceDaLeggere.get(i))) {

			}else{


			}


		}




		ArrayList<Comune> lista_comuni = new ArrayList<Comune>();
		lista_comuni = LettoreXML.leggi_Comune();

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