package Oblig2;

public class Blaaresept extends Resept{
    private float rabatt = middelReferanse.hentPris() * 0.75f;
    public Blaaresept(int pasientID, Lege utskrivendeLege, int reit, Legemiddel middelReferanse){
        super(pasientID, utskrivendeLege, reit, middelReferanse);
    }

    // Hent gitte verdier
    public String farge(){return "Blå resept";}
    public float prisAaBetale() {
        return middelReferanse.hentPris() - rabatt;
    }
}
