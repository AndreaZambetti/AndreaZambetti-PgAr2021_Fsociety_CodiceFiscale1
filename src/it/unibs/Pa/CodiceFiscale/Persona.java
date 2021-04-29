package it.unibs.Pa.CodiceFiscale;

public class persona {

    private int id;
    private String nome;
    private String cognome;
    private String sesso;
    private String comuneNascita;
    private int dataNascita;
    private String codice;

    // COSTRUTTORE PER ANDARE A CREARE DEGLI ARRAY LIST
    public persona(int id, String nome, String cognome, String sesso, String comuneNascita, int dataNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.comuneNascita = comuneNascita;
        this.dataNascita = dataNascita;
    }

    // costruttore per il  inserire il codice
    public persona(String codice) {
        this.codice = codice;
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

    public int getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(int dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void creaCodiceFiscale(String cognome) {

        StringBuffer codice = new StringBuffer();
        codice.append("codice fiscale:  ");

        if (this.cognome.length() > 2) {
            for (int i = 0; i < cognome.length(); i++) {
                int consonanti = 0;
                if (this.cognome.charAt(i) > 'A' && this.cognome.charAt(i) < 'Z' && this.cognome.charAt(i) != 'A' && this.cognome.charAt(i) != 'E' && this.cognome.charAt(i) != 'I' && this.cognome.charAt(i) != 'O' && this.cognome.charAt(i) != 'U') {
                    codice.append(String.format("%s", this.cognome.charAt(i)));
                    consonanti++;
                    System.out.println("codice: " + codice);
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", sesso='" + sesso + '\'' +
                ", comuneNascita='" + comuneNascita + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }


    public String creaCodiceFiscale() {
        StringBuffer codice = new StringBuffer();
        //codice.append("codice fiscale:  ");

        if (this.cognome.length() > 2) {
            int consonanti = 0;
            for (int i = 0; i < cognome.length() && consonanti < 3; i++) {
                if (this.cognome.charAt(i) >= 'A' && this.cognome.charAt(i) <= 'Z' && this.cognome.charAt(i) != 'A' && this.cognome.charAt(i) != 'E' && this.cognome.charAt(i) != 'I' && this.cognome.charAt(i) != 'O' && this.cognome.charAt(i) != 'U') {
                    codice.append(String.format("%s", this.cognome.charAt(i)));
                    consonanti++;

                }
            }
            if (consonanti < 3) {
                int vocali = 0;
                for (int j = 0; j < cognome.length() && codice.length()<3; j++) {
                    if (this.cognome.charAt(j) >= 'A' && this.cognome.charAt(j) <= 'Z' && this.cognome.charAt(j) == 'A' || this.cognome.charAt(j) == 'E' || this.cognome.charAt(j) == 'I' || this.cognome.charAt(j) == 'O' || this.cognome.charAt(j) == 'U') {
                        codice.append(String.format("%s", this.cognome.charAt(j)));
                        vocali++;
                    }
                }
            }

        }

        return new String(codice);//System.out.println(codice);
        //return null;

    }


// METODO PER IL CONFRONTO ( APPENA SARA IMPLEMENTATO I
    public void confrontoCodice(   String codiceCreato ){

        if ( codice == codiceCreato ){
            System.out.println(codiceCreato);
        }else
            System.out.println("ASSENTE");

    }
}
