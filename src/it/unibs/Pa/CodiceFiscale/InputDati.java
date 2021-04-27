package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileInputStream;

public class InputDati {

    private void LeggiXML() throws XMLStreamException //XMLStreamException aggiunto per correggere errore
                                                      //xmlr.hasNext all'interno del while
    {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("codiciFiscali", new FileInputStream("codiciFiscali"));
        } catch (Exception e) {
            System.out.println("Errore nell'inzializzazione del reader");
            System.out.println(e.getMessage());
        }

        //l'istruzione nel while dava errore: add exception to method signatur
        //Ho usato la correzione automatica del sistema cliccando sull'errore
        while (xmlr.hasNext()) {
            switch (xmlr.getEventType()) {
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("Start Read Doc " + "codiciFiscali");
                break;
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("Tag" + xmlr.getLocalName());
                    for (int i = 0; i < xmlr.getAttributeCount(); i++)
                        System.out.println(xmlr.getAttributeLocalName(i)/*, xmlr.getAttributeValue(i)*/);
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
        }
    }
}