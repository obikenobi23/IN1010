abstract public class Resept {
    protected static int nesteID = 0;
    protected int ID;
    protected Pasient pasient;
    protected Lege utskrivendeLege;
    protected int reit;
    protected Legemiddel middelReferanse;
    protected boolean gyldig;

    protected Resept(Pasient pasient, Lege utskrivendeLege, int reit, Legemiddel middelReferanse){
        this.pasient = pasient;
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
    public Pasient hentPasient(){return pasient;}
    public String hentLege(){return utskrivendeLege.navn;}
    public int hentReit(){return reit;}
    public String hentLegemiddel(){return middelReferanse.hentNavn();}
    public Integer hentPris(){return middelReferanse.hentPris();}
    public boolean erGyldig(){return gyldig;}
		public Legemiddel hentLegemiddelObjekt(){return middelReferanse;}
    private void oppdaterGyldig(){
        if(reit > 0){
            gyldig = true;
        }else{
            gyldig = false;
        }
    }

    // Interaksjonsmetoder
    public boolean bruk(){
        if(gyldig == true){
	    reit--; // foran print, så vi kan skrive ut gjenvaerende reit
            System.out.println("Brukte resept paa " + this.hentLegemiddel() + ". Antall gjenvaerende reit: " + reit);
            
            oppdaterGyldig();
            return true;
        } else{
            System.out.println("Resepten kan ikke brukes, den har ingen reit igjen.");
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
    abstract public int prisAaBetale();

}
