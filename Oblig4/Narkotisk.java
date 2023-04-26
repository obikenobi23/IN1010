public class Narkotisk extends Legemiddel{
    private int styrke;
    public Narkotisk(String navn, int pris, double virkemasse, int styrke){
        super(navn, pris, virkemasse);
        this.styrke = styrke;
    }

    // Hent gitte verdier
    public Integer hentNarkotiskStyrke(){return styrke;}

    // Skriv ut skildringer
    public String beskrivelse(){
        return "Jeg er et narkotisk stoff.";
    }
    public String toString(){
        return "ID: " + hentID() +
        " | Navn: " + hentNavn() +
        " | Pris: " + hentPris() +
        "kr | Virkemasse: " + hentVirkestoff() +
        "mg | Styrke: " + hentNarkotiskStyrke() + ".";
    }
}
