package it.unibs.Pa.CodiceFiscale;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.util.ArrayList;

public class LettoreXML {

    public static ArrayList<String> ArrayDiLettura = new ArrayList<String>();
    public static ArrayList<String> CodiciFiscali = new ArrayList<String>();
    public static ArrayList<String> NomeComune = new ArrayList<String>();
    public static ArrayList<String> CodiceComune = new ArrayList<String>();
    public static ArrayList<String> NomePersona = new ArrayList<String>();
    public static ArrayList<String> CognomePersona = new ArrayList<String>();
    public static ArrayList<String> SessoPersona = new ArrayList<String>();
    public static ArrayList<String> NascitaPersona = new ArrayList<String>();
    public static ArrayList<String> ComunePersona = new ArrayList<String>();

    public ArrayList<String> getCodiciFiscali() {
        return CodiciFiscali;
    }

    /*XMLStreamException aggiunto per correggere errore
      xmlr.hasNext all'interno del while

      La seguente funzione legge uno dei file XML dopo che gli è stato indicato attraverso una selezione
      In seguito salva tutte le informazioni in un ArrayList generico*/
    public static void LeggiXML(int selezione) throws XMLStreamException
    {
        XMLInputFactory xmlif = null;
        XMLStreamReader xmlr = null;
        String FileXML;
        if (selezione == 1)
            FileXML = "codiciFiscali.xml";
        else if (selezione == 2)
            FileXML = "comuni.xml";
        else
            FileXML = "inputPersone.xml";

        try {
            xmlif = XMLInputFactory.newInstance();
            xmlr = xmlif.createXMLStreamReader(FileXML, new FileInputStream(FileXML));
        } catch (Exception e) {
            System.out.println("Errore nell'inzializzazione del reader");
            System.out.println(e.getMessage());
        }

        /*L'istruzione nel while dava errore: add exception to method signatur
        Ho usato la correzione automatica del sistema cliccando sull'errore*/
        while (xmlr.hasNext()) {
            switch (xmlr.getEventType()) {
                case XMLStreamConstants.START_DOCUMENT:
                    //System.out.println("Start Read Doc " + FileXML);
                    break;
                case XMLStreamConstants.START_ELEMENT:
                    //System.out.println("Tag " + xmlr.getLocalName());
                    for (int i = 0; i < xmlr.getAttributeCount(); i++) {
                        //System.out.print(xmlr.getAttributeLocalName(i));
                        //System.out.println(xmlr.getAttributeValue(i));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    //System.out.println("END-Tag" + xmlr.getLocalName());
                    break;
                case XMLStreamConstants.COMMENT:
                    //System.out.println("//commento " + xmlr.getText());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (xmlr.getText().trim().length() > 0) {
                        //System.out.println("-> " + xmlr.getText());
                        ArrayDiLettura.add(xmlr.getText()); //salva in un arraylist
                    }
                    break;
            }
            xmlr.next();
        }
    }

    /*I seguenti metodi richiamano il metodo LettoreXML indicando il file di interesse attraverso il selettore.
    * Dopo che LettoreXML ha completato la lettura i seguenti metodi utilizzano l'ArrayDiLettura che è stata compilata
    * per trasferire le informazioni in altre ArrayList create appositamente per questo, esempio:
    * Nel caso di comuni.xml l'ArrayDiLettura crea 16184 celle che contengono in modo alternato il nome di un comune
    * e il codice di un comune. In seguito il metodo Leggi_comuni separa queste informazioni in due rispettivi Array:
    * NomeComune e CodiceComune i quali avranno 8092 celle contenti nome e codice di un comune, legati attraverso
    * l'indice degli ArrayList.
    * Processo simile è usato per la lettura di inputPersone.xml.*/
    public static void Leggi_codiciFiscali() throws XMLStreamException {
        LettoreXML.LeggiXML(1);

        CodiciFiscali.addAll(ArrayDiLettura);
        ArrayDiLettura.clear();

        /*for (int i=0; i<CodiciFiscali.size(); i++)
            System.out.println(i + ") " + CodiciFiscali.get(i));*/
    }

    public static void Leggi_comuni() throws XMLStreamException {
        LettoreXML.LeggiXML(2);

        for(int i=0; i<ArrayDiLettura.size(); i++){
            if (i%2==0)
                NomeComune.add(ArrayDiLettura.get(i));
            if (i%2==1)
                CodiceComune.add(ArrayDiLettura.get(i));
        }
        ArrayDiLettura.clear();

        /*for (int i=0; i<NomeComune.size(); i++)
            System.out.println(i + ") " + NomeComune.get(i) + " -> " + CodiceComune.get(i));*/
    }

    public static void Leggi_Persone() throws XMLStreamException {
        LettoreXML.LeggiXML(3);

        for(int i=0; i<ArrayDiLettura.size(); i = i + 5){
            NomePersona.add(ArrayDiLettura.get(i));
            CognomePersona.add(ArrayDiLettura.get(i+1));
            SessoPersona.add(ArrayDiLettura.get(i+2));
            ComunePersona.add(ArrayDiLettura.get(i+3));
            NascitaPersona.add(ArrayDiLettura.get(i+4));
        }
        ArrayDiLettura.clear();

        /*for (int i=0; i<NomePersona.size(); i++)
            System.out.println(i + ") " + NomePersona.get(i) + " " + CognomePersona.get(i) +
                    " (" + SessoPersona.get(i) + ")  " + NascitaPersona.get(i) + "   " + ComunePersona.get(i));*/
    }
}