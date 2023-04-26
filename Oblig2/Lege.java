package Oblig2;

public class Lege {
    String navn;
    public Lege(String navn){
        this.navn = navn;
    }

    // Hent gitte verdier
    public String hentNavn(){return navn;}
    public String toString(){return "Navn: " + navn;}
}
