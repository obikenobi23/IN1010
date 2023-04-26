public abstract class Legemiddel {
    protected String navn;
    protected static int nesteID = 1;
    protected int ID;// Øker med 1 hvor hvert objekt
    protected int pris;
    protected double virkemasse;// En verdi i mg for mengden av relevant virkestoff

    protected Legemiddel(String navn, int pris, double virkemasse){// Konstruktør
        this.navn = navn;
        this.pris=pris;
        this.virkemasse=virkemasse;
        ID = nesteID;
        nesteID++;// To legemiddler har ikke samme ID
    }

    // Hent gitte verdier
    public Integer hentID(){return ID;}
    public String hentNavn(){return navn;}
    public int hentPris(){return pris;}
    public double hentVirkestoff(){return virkemasse;}

    // Endre verdier
    public void settNyPris(int pris){this.pris = pris;}

    // Skriv ut skildringer
    public abstract String beskrivelse();
    public String toString(){
        return "ID: " + hentID() +
        " | Navn: " + hentNavn() +
        " | Pris: " + hentPris() +
        "| Virkemasse: " + hentVirkestoff() + ".";
    }
}
