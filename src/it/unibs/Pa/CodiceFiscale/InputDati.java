package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class InputDati {

    private void LeggiXML() {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;

        try{
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader("codiciFiscali", new FileInputStream("codiciFiscali"));
        } catch (Exception e){
            System.out.println("Errore nell'inzializzazione del reader");
            System.out.println(e.getMessage());
        }


    }
}
