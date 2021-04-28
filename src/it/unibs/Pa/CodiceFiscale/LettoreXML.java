package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.util.ArrayList;

public class LettoreXML {

    public static ArrayList<String> CodiciFiscali = new ArrayList<String>();

    public ArrayList<String> getCodiciFiscali() {
        return CodiciFiscali;
    }

    public static void LeggiXML() throws XMLStreamException //XMLStreamException aggiunto per correggere errore
                                                      //xmlr.hasNext all'interno del while
    {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String codiciFiscali = "codiciFiscali.xml";
        //String comuni = "comuni.xml";
        //String inputPersone = "inputPersone.xml";

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(codiciFiscali, new FileInputStream(codiciFiscali));
        } catch (Exception e) {
            System.out.println("Errore nell'inzializzazione del reader");
            System.out.println(e.getMessage());
        }

        //l'istruzione nel while dava errore: add exception to method signatur
        //Ho usato la correzione automatica del sistema cliccando sull'errore
        while (xmlr.hasNext()) {
            switch (xmlr.getEventType()) {
                case XMLStreamConstants.START_DOCUMENT:
                    System.out.println("Start Read Doc " + codiciFiscali);
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    //System.out.println("Tag " + xmlr.getLocalName());
                    for (int i = 0; i < xmlr.getAttributeCount(); i++) {
                        System.out.print(xmlr.getAttributeLocalName(i));
                        System.out.println(xmlr.getAttributeValue(i));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    //System.out.println("END-Tag" + xmlr.getLocalName());
                    break;
                case XMLStreamConstants.COMMENT:
                    System.out.println("//commento " + xmlr.getText());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (xmlr.getText().trim().length() > 0) {
                        //System.out.println("-> " + xmlr.getText());
                        CodiciFiscali.add(xmlr.getText()); //salva in un arraylist
                    }
                    break;
            }
            xmlr.next();
        }
    }

    public static void Leggi_codiciFiscali(){
        for (int i=0; i<CodiciFiscali.size(); i++)
            System.out.println(i + ") " + CodiciFiscali.get(i));
    }
}