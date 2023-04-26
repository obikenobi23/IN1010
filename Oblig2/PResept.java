package Oblig2;

public class PResept extends Hvitresept{
    public PResept(int pasientID, Lege utskrivendeLege, int reit, Legemiddel middelReferanse){
        super(pasientID, utskrivendeLege, reit, middelReferanse);
        if (middelReferanse.hentPris() >= 108){
            rabatt = 108;
        } else{
            rabatt = middelReferanse.hentPris();
        }
    }
}
