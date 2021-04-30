package it.unibs.Pa.CodiceFiscale;

public class Codice {
    private String Codice;
    private String valido;

    public Codice(String codice) {
        Codice = codice;
    }

    public String getCodice() {
        return Codice;
    }

    public void setCodice(String codice) {
        Codice = codice;
    }

    public String getValido() {
        return valido;
    }

    public void setValido(String valido) {
        this.valido = valido;
    }
}
