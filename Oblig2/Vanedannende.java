package Oblig2;

public class Vanedannende extends Legemiddel{
    private int styrke;

    public Vanedannende(String navn, int pris, double virkemasse, int styrke){
        super(navn, pris, virkemasse);
        this.styrke = styrke;
    }

    // Hent gitte verdier
    public Integer hentVanedannendeStyrke(){return styrke;}

    // Skriv ut skildringer
    public String beskrivelse(){
        return "Jeg er et vanedannende legemiddel.";
    }
    public String toString(){
        return "ID: " + hentID() + 
        ". Navn: " + hentNavn() + 
        ". Pris: " + hentPris() + 
        "kr. Virkemasse: " + hentVirkestoff() + 
        "mg. Styrke: " + hentVanedannendeStyrke() + ".";
    }
}
