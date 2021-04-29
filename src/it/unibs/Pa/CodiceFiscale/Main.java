package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws XMLStreamException {

		 String nome = " DIEGO";
		 String cognome = "MARTINELLI";
		 String sesso = "M";
		 String comune = "BRESCIA";
		 String anno = "2001-12-16";



		Persona p1 = new Persona(nome, cognome , sesso , comune, anno );

		System.out.println(p1.creaCodiceFiscaleFinale());

	}
}
