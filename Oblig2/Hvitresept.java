package Oblig2;

abstract public class Hvitresept extends Resept{
    int rabatt = middelReferanse.hentPris();
    public Hvitresept(int pasientID, Lege utskrivendeLege, int reit, Legemiddel middelReferanse){
        super(pasientID, utskrivendeLege, reit, middelReferanse);
    }

    // Hent gitte verdier
    public String farge() {
        return "Hvit resept";
    }
    public int prisAaBetale() {
        return middelReferanse.hentPris() - rabatt;
    }
}
