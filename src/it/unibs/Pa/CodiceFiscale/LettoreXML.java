package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.util.ArrayList;

public class LettoreXML {
    
    public  ArrayList LeggiXML() throws XMLStreamException {
        ArrayList<Persona> persone = new ArrayList<Persona>();
        Persona pers;
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String FileXML = "inputPersone.xml";

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(FileXML, new FileInputStream(FileXML));
        } catch (Exception e) {
            System.out.println("Errore nell'inzializzazione del reader");
            System.out.println(e.getMessage());
        }

        /*L'istruzione nel while dava errore: add exception to method signatur
        Ho usato la correzione automatica del sistema cliccando sull'errore*/
        pers = new Persona();
        while (xmlr.hasNext()) {
            switch (xmlr.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    if (xmlr.getLocalName().equals("nome")) {
                        xmlr.next();
                        pers.setNome(xmlr.getText());
                    } else if (xmlr.getLocalName().equals("cognome")) {
                        xmlr.next();
                        pers.setCognome(xmlr.getText());
                    } else if (xmlr.getLocalName().equals("sesso")) {
                        xmlr.next();
                        pers.setSesso(xmlr.getText());
                    } else if (xmlr.getLocalName().equals("comune_nascita")) {
                        xmlr.next();
                        pers.setComuneNascita(xmlr.getText());
                    } else if (xmlr.getLocalName().equals("data_nascita")) {
                        xmlr.next();
                        pers.setData_nascita(xmlr.getText());
                    }
                break;
                case XMLStreamConstants.END_ELEMENT:
                    if( xmlr.getLocalName().equals("persona")) {
                        persone.add(pers);
                    }
                break;

                default:
                    break;
            }
            xmlr.next();
        }

        return persone;
    }




    /*I seguenti metodi richiamano il metodo LettoreXML indicando il file di interesse attraverso il selettore.
    * Dopo che LettoreXML ha completato la lettura i seguenti metodi utilizzano l'ArrayDiLettura che è stata compilata
    * per trasferire le informazioni in altre ArrayList create appositamente per questo, esempio:
    * Nel caso di comuni.xml l'ArrayDiLettura crea 16184 celle che contengono in modo alternato il nome di un comune
    * e il codice di un comune. In seguito il metodo Leggi_comuni separa queste informazioni in due rispettivi Array:
    * NomeComune e CodiceComune i quali avranno 8092 celle contenti nome e codice di un comune, legati attraverso
    * l'indice degli ArrayList.
    * Processo simile è usato per la lettura di inputPersone.xml.*/
    /*public static void Leggi_codiciFiscali() throws XMLStreamException {
        LettoreXML.LeggiXML(1);

        CodiciFiscali.addAll(ArrayDiLettura);
        ArrayDiLettura.clear();

        for (int i=0; i<CodiciFiscali.size(); i++)
            System.out.println(i + ") " + CodiciFiscali.get(i));
    }*/

    /*public static void Leggi_comuni() throws XMLStreamException {
        LettoreXML.LeggiXML(2);

        for(int i=0; i<ArrayDiLettura.size(); i++){
            if (i%2==0)
                NomeComune.add(ArrayDiLettura.get(i));
            if (i%2==1)
                CodiceComune.add(ArrayDiLettura.get(i));
        }
        ArrayDiLettura.clear();

        for (int i=0; i<NomeComune.size(); i++)
            System.out.println(i + ") " + NomeComune.get(i) + " -> " + CodiceComune.get(i));
    }*/

    /*public static void Leggi_Persone() throws XMLStreamException {
        LettoreXML.LeggiXML(3);

        for(int i=0; i<ArrayDiLettura.size(); i = i + 5){
            NomePersona.add(ArrayDiLettura.get(i));
            CognomePersona.add(ArrayDiLettura.get(i+1));
            SessoPersona.add(ArrayDiLettura.get(i+2));
            ComunePersona.add(ArrayDiLettura.get(i+3));
            NascitaPersona.add(ArrayDiLettura.get(i+4));
        }
        ArrayDiLettura.clear();

        for (int i=0; i<NomePersona.size(); i++)
            System.out.println(i + ") " + NomePersona.get(i) + " " + CognomePersona.get(i) +
                    " (" + SessoPersona.get(i) + ")  " + NascitaPersona.get(i) + "   " + ComunePersona.get(i));
    }*/
}