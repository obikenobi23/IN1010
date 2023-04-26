package Uke1.Oblig0;

public class Bil3 {
    private String bilnr;

    public Bil3(String bilnummer) {
        bilnr = bilnummer;
    }
    
    public void skriv() {
        System.out.println("Dette er mitt bilnr: " + bilnr);
    }

    public String hentNummer() {
        return bilnr;
    }
}
