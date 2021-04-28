package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class Main {

	public static void main(String[] args) throws XMLStreamException {
		// TODO Auto-generated method stub

		

		/*XMLInputFactory xmlif = null;
		XMLStreamReader xmlr = null;
		String codiciFiscali = "codiciFiscali.xml";
		String comuni = "comuni.xml";
		String inputPersone = "inputPersone.xml";

		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader(inputPersone, new FileInputStream(inputPersone));
		} catch (Exception e) {
			System.out.println("Errore nell'inzializzazione del reader");
			System.out.println(e.getMessage());
		}

		//l'istruzione nel while dava errore: add exception to method signatur
		//Ho usato la correzione automatica del sistema cliccando sull'errore
		while (xmlr.hasNext()) {

			switch (xmlr.getEventType()) {
				case XMLStreamConstants.START_DOCUMENT:
					System.out.println("Start Read Doc " + inputPersone);
					break;
				case XMLStreamConstants.START_ELEMENT:
					System.out.println("Tag " + xmlr.getLocalName());
					for (int i = 0; i < xmlr.getAttributeCount(); i++) {
						System.out.print(xmlr.getAttributeLocalName(i));
						System.out.println(xmlr.getAttributeValue(i));
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					System.out.println("END-Tag" + xmlr.getLocalName());
					break;
				case XMLStreamConstants.COMMENT:
					System.out.println("//commento " + xmlr.getText());
					break;
				case XMLStreamConstants.CHARACTERS:
					if (xmlr.getText().trim().length() > 0)
						System.out.println("-> " + xmlr.getText());
					break;
			}
			xmlr.next();
		}*/
	}

}
