package Oblig2;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

abstract public class Resept {
    protected static int nesteID = 0;
    protected int ID;
    protected int pasientID;
    protected Lege utskrivendeLege;
    protected int reit;
    protected Legemiddel middelReferanse;
    protected boolean gyldig;

    protected Resept(int pasientID, Lege utskrivendeLege, int reit, Legemiddel middelReferanse){
        this.pasientID = pasientID;
        this.utskrivendeLege=utskrivendeLege;
        this.reit=reit;
        this.middelReferanse=middelReferanse;

        ID = nesteID;
        nesteID ++;

        if (reit > 0) gyldig = true;
        else gyldig = false;
    }

    // Hent gitte verdier
    public Integer hentMiddelID(){return middelReferanse.hentID();}
    public Integer hentPasientID(){return pasientID;}
    public String hentLege(){return utskrivendeLege.navn;}
    public int hentReit(){return reit;}
    public String hentLegemiddel(){return middelReferanse.hentNavn();}
    public Integer hentPris(){return middelReferanse.hentPris();}
    public boolean erGyldig(){return gyldig;}
    private void oppdaterGyldig(){
        if(reit > 0){
            gyldig = true;
        }else{
            gyldig = false;
        }
    }

    // Overskriv toString()-metoden
    public String toString(){
        return "Legemiddelets navn: " + middelReferanse.hentNavn() + 
        ", legemiddelets ID: " + middelReferanse.hentID() + 
        ", resepttype: " + farge() + 
        ", pasient-ID: " + hentPasientID() + 
        ", lege: " + hentLege() + 
        ", reit: " + hentReit() + 
        ", pris: " + prisAaBetale();
    }

    // Interaksjonsmetoder
    public boolean bruk(){
        if(gyldig == true){
            // System.out.println("Du har brukt resepten en gang.");
            reit--;
            oppdaterGyldig();
            return true;
        } else{
            System.out.println("Resepten kan ikke brukes, og må fornyes.");
            return false;
        }
    }

    public void ookReit(int ookning) {
        reit += ookning;

        if(reit > 0) {
            gyldig = true;
        }
    }

    // Abstrakte metoder
    abstract public String farge();
    
}        
