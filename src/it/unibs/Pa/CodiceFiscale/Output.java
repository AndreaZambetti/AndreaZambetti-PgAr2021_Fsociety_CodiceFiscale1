package it.unibs.Pa.CodiceFiscale;

import javax.xml.transform.*;
import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Output {

   public static final String OutputXml ="./codiceFiscale.xml";

   public void stampa( ArrayList<Persona> p , String xml ) {
      XMLOutputFactory xmlof = null;
      XMLStreamWriter xmlw = null;
      try {
         xmlof = XMLOutputFactory.newInstance();
         xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(filename), “utf-8”);
         xmlw.writeStartDocument(“utf-8”, “1.0”);
      } catch (Exception e) {
         System.out.println("Errore nell'inizializzazione del writer:");
         System.out.println(e.getMessage());
      }

   }
   }

















     /* Document dom;
      Element e = null;

      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       try {
          DocumentBuilder  db = dbf.newDocumentBuilder();
          // CREATA UN ISTANZA
          dom = db.newDocument();

          // CREO IL ROOT ELEMENT
          for( int i = 0 ; i< p.size() ; i++) {
             Element rootEle = dom.createElement("persona");

             // CREAZIONE DEI ROOT
             e = dom.createElement("nome");
             e.appendChild(dom.createTextNode(p.get(i).getNome()));
             rootEle.appendChild(e);

             // CREAZIONE DEI ROOT
             e = dom.createElement("cognome");
             e.appendChild(dom.createTextNode(p.get(i).getCognome()));
             rootEle.appendChild(e);


             // CREAZIONE DEI ROOT
             e = dom.createElement("sesso");
             e.appendChild(dom.createTextNode(p.get(i).getSesso()));
             rootEle.appendChild(e);

             // CREAZIONE DEI ROOT
             e = dom.createElement("comuneNascita");
             e.appendChild(dom.createTextNode(p.get(i).getComuneNascita()));
             rootEle.appendChild(e);

             // CREAZIONE DEI ROOT
             e = dom.createElement("dataNascita");
             e.appendChild(dom.createTextNode(p.get(i).getData_nascita()));
             rootEle.appendChild(e);

             // CREAZIONE DEI ROOT
             e = dom.createElement("codiceFiscale");
             e.appendChild(dom.createTextNode(p.get(i).getCodice_fiscale()));
             rootEle.appendChild(e);


             // OUTPUT CONFRONTO CODICE FISCALE

             dom.appendChild(rootEle);
       }

          try{
             Transformer tr = TransformerFactory.newInstance().newTransformer();
             tr.setOutputProperty(OutputKeys.INDENT, "yes");
             tr.setOutputProperty(OutputKeys.METHOD, "xml");
             tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
             tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
//                tr.setOutputProperty("./xml.codiceFiscale.xml", "4");
//





             tr.transform(new DOMSource(dom),
                     new StreamResult(new FileOutputStream(xml)));

          } catch (TransformerException te) {
             System.out.println(te.getMessage());
          } catch (IOException ioe) {
             System.out.println(ioe.getMessage());
          }
       } catch (ParserConfigurationException pce) {
          System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
       }


   }
*/

      // PROVA OUTPUT

      /*try {
         FileOutputStream fos = new FileOutputStream(new File("./codiceFiscale.xml"));
         XMLEncoder encoder = new XMLEncoder(fos);
         encoder.writeObject(p1);
         encoder.close();
         fos.close();

      }catch (IOException ex){
         ex.printStackTrace();
      }*/




//
   }

