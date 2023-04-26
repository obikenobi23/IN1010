package Uke1.Oblig0;

public class BilBruk3 {
    public static void main(String[] args) {
        Bil3 Hudson = new Bil3("2HP");
        Hudson.skriv();
        //System.out.println("Dette er mitt bilnr: " + Hudson.hentNummer());

        Person Jennifer = new Person(Hudson);

        //System.out.println(Jennifer.sinBil());
        Jennifer.sinBil();
    }
}
