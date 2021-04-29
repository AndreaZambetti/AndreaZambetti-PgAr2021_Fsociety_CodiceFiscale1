
    package it.unibs.Pa.CodiceFiscale;


    import javax.xml.stream.XMLStreamException;
    import java.util.ArrayList;

    public class Persona {

        private int id;
        private String nome;
        private String cognome;
        private String sesso;
        private String comuneNascita;
        private String data_nascita;
        private String codice_fiscale;

        public Persona() {

        }

        public Persona(String codice_fiscale) {
            this.codice_fiscale = codice_fiscale;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCognome() {
            return cognome;
        }

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

        public String getSesso() {
            return sesso;
        }

        public void setSesso(String sesso) {
            this.sesso = sesso;
        }

        public String getComuneNascita() {
            return comuneNascita;
        }

        public void setComuneNascita(String comuneNascita) {
            this.comuneNascita = comuneNascita;
        }

        public String getData_nascita() {
            return data_nascita;
        }

        public void setData_nascita(String data_nascita) {
            this.data_nascita = data_nascita;
        }

        public String getCodice_fiscale() {
            return codice_fiscale;
        }

        public void setCodice_fiscale(String codice_fiscale) {
            this.codice_fiscale = codice_fiscale;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", cognome='" + cognome + '\'' +
                    ", sesso='" + sesso + '\'' +
                    ", comuneNascita='" + comuneNascita + '\'' +
                    ", data_nascita='" + data_nascita + '\'' +
                    '}';
        }



        public String creaParteCognome() {
            StringBuffer parteCognome = new StringBuffer();
            int cont = 0;
            /*caso cognome minore di 3 lettere*/
            if (cognome.length() < 3) {

                while (parteCognome.length() < 3) {

                    for (int i = 0; i < cognome.length() && parteCognome.length() <= cognome.length(); i++) {
                        parteCognome.append(String.format("%s", cognome.charAt(i)));
                    }

                    parteCognome.append("X");
                }
                cont = 3;
            }
            /*caso normale*/
            for (int i = 0; i < cognome.length(); i++) {
                if (cont == 3) break;
                if (cognome.charAt(i) != 'A' && cognome.charAt(i) != 'E' &&
                        cognome.charAt(i) != 'I' && cognome.charAt(i) != 'O' &&
                        cognome.charAt(i) != 'U') {
                    parteCognome.append(String.format("%s", cognome.charAt(i)));
                    cont++;
                }
            }
            /* nel casoci siano meno di 3 consonanti*/
            while (cont < 3) {
                for (int i = 0; i < cognome.length(); i++) {
                    if (cont == 3) break;
                    if (cognome.charAt(i) == 'A' || cognome.charAt(i) == 'E' ||
                            cognome.charAt(i) == 'I' || cognome.charAt(i) == 'O' ||
                            cognome.charAt(i) == 'U') {
                        parteCognome.append(String.format("%s", cognome.charAt(i)));
                        cont++;
                    }
                }
            }
            return new String(parteCognome);
        }


        public String creaParteNome() {
            StringBuffer parteNome = new StringBuffer();

            /*lettere nome*/
            int cont = 0;
            /*caso nome minore di 3 lettere*/
            if (nome.length() < 3) {

                while (parteNome.length() < 3) {

                    for (int i = 0; i < nome.length() && parteNome.length() <= nome.length(); i++) {
                        parteNome.append(String.format("%s", nome.charAt(i)));
                    }

                    parteNome.append("X");
                }
                cont = 3;
            }
            /*trovo il numero di consonanti*/
            int consonanti = 0;
            for (int i = 0; i < nome.length(); i++) {
                if (cont == 3) break;

                if (nome.charAt(i) != 'A' && nome.charAt(i) != 'E' &&
                        nome.charAt(i) != 'I' && nome.charAt(i) != 'O' &&
                        nome.charAt(i) != 'U') {

                    consonanti++;
                }
            }
            /*lo faccio solo se le consonanti sono almeno 4 e prendo la prima, la terza e la quarta*/
            if (consonanti >= 4) {
                int posizioneConsonante = 0;
                for (int i = 0; i < nome.length(); i++) {
                    if (cont == 3) break;

                    if (nome.charAt(i) != 'A' && nome.charAt(i) != 'E' &&
                            nome.charAt(i) != 'I' && nome.charAt(i) != 'O' &&
                            nome.charAt(i) != 'U') {

                        if (posizioneConsonante!= 1) {
                            parteNome.append(String.format("%s", nome.charAt(i)));
                            cont++;
                        }
                        posizioneConsonante++;
                    }

                }
                /*se le consonanti sono meno di 4*/
            } else if (consonanti<4){

                for (int i = 0; i < nome.length(); i++) {
                    if (cont == 3) break;
                    if (nome.charAt(i) != 'A' && nome.charAt(i) != 'E' &&
                            nome.charAt(i) != 'I' && nome.charAt(i) != 'O' &&
                            nome.charAt(i) != 'U') {
                        parteNome.append(String.format("%s", nome.charAt(i)));
                        cont++;
                    }
                }
                /* se ci sono meno di 3 consonanti*/
                while (cont < 3) {
                    for (int i = 0; i < nome.length(); i++) {
                        if (cont == 3) break;
                        if (nome.charAt(i) == 'A' || nome.charAt(i) == 'E' ||
                                nome.charAt(i) == 'I' || nome.charAt(i) == 'O' ||
                                nome.charAt(i) == 'U') {
                            parteNome.append(String.format("%s", nome.charAt(i)));
                            cont++;
                        }
                    }
                }

            }
            return new String(parteNome);

        }


        public String creaParteAnnoMese(){
            StringBuffer parteAnnoMese = new StringBuffer();

            /*parte anno di nascita*/
            parteAnnoMese.append(data_nascita.charAt(2));
            parteAnnoMese.append(data_nascita.charAt(3));

            /*parte mese di nascita*/
            int mese = 0;
            if (data_nascita.charAt(5)== '0') mese = Integer.parseInt(data_nascita.substring(6,7));
            else mese = Integer.parseInt(data_nascita.substring(5,7));
            switch (mese) {
                case 1:
                    parteAnnoMese.append("A");
                    break;
                case 2:
                    parteAnnoMese.append("B");
                    break;
                case 3:
                    parteAnnoMese.append("C");
                    break;
                case 4:
                    parteAnnoMese.append("D");
                    break;
                case 5:
                    parteAnnoMese.append("E");
                    break;
                case 6:
                    parteAnnoMese.append("H");
                    break;
                case 7:
                    parteAnnoMese.append("L");
                    break;
                case 8:
                    parteAnnoMese.append("M");
                    break;
                case 9:
                    parteAnnoMese.append("P");
                    break;
                case 10:
                    parteAnnoMese.append("R");
                    break;
                case 11:
                    parteAnnoMese.append("S");
                    break;
                case 12:
                    parteAnnoMese.append("T");
                    break;

            }

            return new String(parteAnnoMese);
        }



        public String creaParteGiornoSesso(){
            StringBuffer parteGiornoSesso = new StringBuffer();

            if (sesso.charAt(0) == 'M'){
                parteGiornoSesso.append(data_nascita.substring(8,10));
            } else {
                int giorno = Integer.parseInt(data_nascita.substring(8,10));
                giorno += 40;
                parteGiornoSesso.append(giorno);
            }

            return new String(parteGiornoSesso);
        }






        public String creaParteComune(){
            StringBuffer parteComune = new StringBuffer();
            ArrayList<Comune> Lista_Comuni = new ArrayList<Comune>();
            try {
                Lista_Comuni = LettoreXML.leggi_Comune();
            } catch (XMLStreamException e) {

            }
            for (int i=0; i<Lista_Comuni.size(); i++){
                if (this.comuneNascita.equals(Lista_Comuni.get(i).getNome()))
                    return Lista_Comuni.get(i).getCodice();
            }
            //operazione di default in caso il comune non sia indicato
            return Lista_Comuni.get(0).getCodice();
        }









        public String creaCodiceFiscaleFinale(){

            StringBuffer codiceFiscale = new StringBuffer();
            codiceFiscale.append(creaParteCognome()+creaParteNome()+creaParteAnnoMese()+creaParteGiornoSesso()+ creaParteComune());
            String tutturututto = new String(codiceFiscale);

            int sommaDeiDispari= 0;
            for (int i=0; i<tutturututto.length(); i+=2){
                switch (tutturututto.charAt(i)) {
                    case '0':
                        sommaDeiDispari += 1;
                        break;
                    case '1':
                        sommaDeiDispari += 0;
                        break;
                    case '2':
                        sommaDeiDispari += 5;
                        break;
                    case '3':
                        sommaDeiDispari += 7;
                        break;
                    case '4':
                        sommaDeiDispari += 9;
                        break;
                    case '5':
                        sommaDeiDispari += 13;
                        break;
                    case '6':
                        sommaDeiDispari += 15;
                        break;
                    case '7':
                        sommaDeiDispari += 17;
                        break;
                    case '8':
                        sommaDeiDispari += 19;
                        break;
                    case '9':
                        sommaDeiDispari += 21;
                        break;
                    case 'A':
                        sommaDeiDispari += 1;
                        break;
                    case 'B':
                        sommaDeiDispari += 0;
                        break;
                    case 'C':
                        sommaDeiDispari += 5;
                        break;
                    case 'D':
                        sommaDeiDispari += 7;
                        break;
                    case 'E':
                        sommaDeiDispari += 9;
                        break;
                    case 'F':
                        sommaDeiDispari += 13;
                        break;
                    case 'G':
                        sommaDeiDispari += 15;
                        break;
                    case 'H':
                        sommaDeiDispari += 17;
                        break;
                    case 'I':
                        sommaDeiDispari += 19;
                        break;
                    case 'J':
                        sommaDeiDispari += 21;
                        break;
                    case 'K':
                        sommaDeiDispari += 2;
                        break;
                    case 'L':
                        sommaDeiDispari += 4;
                        break;
                    case 'M':
                        sommaDeiDispari += 18;
                        break;
                    case 'N':
                        sommaDeiDispari += 20;
                        break;
                    case 'O':
                        sommaDeiDispari += 11;
                        break;
                    case 'P':
                        sommaDeiDispari += 3;
                        break;
                    case 'Q':
                        sommaDeiDispari += 6;
                        break;
                    case 'R':
                        sommaDeiDispari += 8;
                        break;
                    case 'S':
                        sommaDeiDispari += 12;
                        break;
                    case 'T':
                        sommaDeiDispari += 14;
                        break;
                    case 'U':
                        sommaDeiDispari += 16;
                        break;
                    case 'V':
                        sommaDeiDispari += 10;
                        break;
                    case 'W':
                        sommaDeiDispari += 22;
                        break;
                    case 'X':
                        sommaDeiDispari += 25;
                        break;
                    case 'Y':
                        sommaDeiDispari += 24;
                        break;
                    case 'Z':
                        sommaDeiDispari += 23;
                        break;
                }
            }



            int sommaDeiPari= 0;
            for (int i=1; i<tutturututto.length(); i+=2) {
                switch (tutturututto.charAt(i)) {
                    case '0':
                        sommaDeiPari += 0;
                        break;
                    case '1':
                        sommaDeiPari += 1;
                        break;
                    case '2':
                        sommaDeiPari += 2;
                        break;
                    case '3':
                        sommaDeiPari += 3;
                        break;
                    case '4':
                        sommaDeiPari += 4;
                        break;
                    case '5':
                        sommaDeiPari += 5;
                        break;
                    case '6':
                        sommaDeiPari += 6;
                        break;
                    case '7':
                        sommaDeiPari += 7;
                        break;
                    case '8':
                        sommaDeiPari += 8;
                        break;
                    case '9':
                        sommaDeiPari += 9;
                        break;
                    case 'A':
                        sommaDeiPari += 0;
                        break;
                    case 'B':
                        sommaDeiPari += 1;
                        break;
                    case 'C':
                        sommaDeiPari += 2;
                        break;
                    case 'D':
                        sommaDeiPari += 3;
                        break;
                    case 'E':
                        sommaDeiPari += 4;
                        break;
                    case 'F':
                        sommaDeiPari += 5;
                        break;
                    case 'G':
                        sommaDeiPari += 6;
                        break;
                    case 'H':
                        sommaDeiPari += 7;
                        break;
                    case 'I':
                        sommaDeiPari += 8;
                        break;
                    case 'J':
                        sommaDeiPari += 9;
                        break;
                    case 'K':
                        sommaDeiPari += 10;
                        break;
                    case 'L':
                        sommaDeiPari += 11;
                        break;
                    case 'M':
                        sommaDeiPari += 12;
                        break;
                    case 'N':
                        sommaDeiPari += 13;
                        break;
                    case 'O':
                        sommaDeiPari += 14;
                        break;
                    case 'P':
                        sommaDeiPari += 15;
                        break;
                    case 'Q':
                        sommaDeiPari += 16;
                        break;
                    case 'R':
                        sommaDeiPari += 17;
                        break;
                    case 'S':
                        sommaDeiPari += 18;
                        break;
                    case 'T':
                        sommaDeiPari += 19;
                        break;
                    case 'U':
                        sommaDeiPari += 20;
                        break;
                    case 'V':
                        sommaDeiPari += 21;
                        break;
                    case 'W':
                        sommaDeiPari += 22;
                        break;
                    case 'X':
                        sommaDeiPari += 23;
                        break;
                    case 'Y':
                        sommaDeiPari += 24;
                        break;
                    case 'Z':
                        sommaDeiPari += 25;
                        break;

                }
            }

            int sommaTotale = sommaDeiDispari+sommaDeiPari;
            int resto = sommaTotale % 26;

            switch (resto){
                case 0:
                    codiceFiscale.append("A");
                    break;
                case 1:
                    codiceFiscale.append("B");
                    break;
                case 2:
                    codiceFiscale.append("C");
                    break;
                case 3:
                    codiceFiscale.append("D");
                    break;
                case 4:
                    codiceFiscale.append("E");
                    break;
                case 5:
                    codiceFiscale.append("F");
                    break;
                case 6:
                    codiceFiscale.append("G");
                    break;
                case 7:
                    codiceFiscale.append("H");
                    break;
                case 8:
                    codiceFiscale.append("I");
                    break;
                case 9:
                    codiceFiscale.append("J");
                    break;
                case 10:
                    codiceFiscale.append("K");
                    break;
                case 11:
                    codiceFiscale.append("L");
                    break;
                case 12:
                    codiceFiscale.append("M");
                    break;
                case 13:
                    codiceFiscale.append("N");
                    break;
                case 14:
                    codiceFiscale.append("O");
                    break;
                case 15:
                    codiceFiscale.append("P");
                    break;
                case 16:
                    codiceFiscale.append("Q");
                    break;
                case 17:
                    codiceFiscale.append("R");
                    break;
                case 18:
                    codiceFiscale.append("S");
                    break;
                case 19:
                    codiceFiscale.append("T");
                    break;
                case 20:
                    codiceFiscale.append("U");
                    break;
                case 21:
                    codiceFiscale.append("V");
                    break;
                case 22:
                    codiceFiscale.append("W");
                    break;
                case 23:
                    codiceFiscale.append("X");
                    break;
                case 24:
                    codiceFiscale.append("Y");
                    break;
                case 25:
                    codiceFiscale.append("Z");
                    break;

            }

            return new String(codiceFiscale);
        }





    }
