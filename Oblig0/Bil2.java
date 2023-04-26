package Uke1.Oblig0;

public class Bil2 {
    private String bilnr;

    public Bil2(String bilnummer) {
        bilnr = bilnummer;
    }
    
    public void skriv() {
        System.out.println("Dette er mitt bilnr: " + bilnr);
    }
}
