package Uke1.Oblig0;

public class Person {
    private Bil3 eier;
    //private String eier;
    public Person(Bil3 bilen) {
        eier = bilen;
    }

    public void sinBil() {
        //System.out.println(eier.skriv());
        System.out.println(eier.hentNummer());
    }
}
