package Oblig2;

public class MilResept extends Hvitresept{
    public MilResept(int pasientID, Lege utskrivendeLege, Legemiddel middelReferanse){
        super(pasientID, utskrivendeLege, 3, middelReferanse);
        rabatt = middelReferanse.hentPris();
        this.reit = 3;
    }
}