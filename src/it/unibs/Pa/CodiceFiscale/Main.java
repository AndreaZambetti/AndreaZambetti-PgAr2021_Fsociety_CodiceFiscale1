package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLStreamException;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
		// TODO Auto-generated method stub

		//prova di chiamata del lettore
		LettoreXML.LeggiXML();
		LettoreXML.Leggi_codiciFiscali();

	}

}
