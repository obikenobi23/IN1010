public class Vanlig extends Legemiddel{
    public Vanlig(String navn, int pris, double virkemasse){
        super(navn, pris, virkemasse);
    }

    // Skriv ut skildringer
    public String beskrivelse(){
        return "Jeg er et \"vanlig\" legemiddel.";
    }
}
