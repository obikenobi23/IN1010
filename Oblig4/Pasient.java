public class Pasient {
    String navn;
    String fNummer;
    protected static int nesteID = 1;
    protected int pasientID;
    protected int antResepter; //antall resepter pasienten har


    IndeksertListe<Resept> resepter = new IndeksertListe<>();


    public Pasient(String navn, String fNummer){
        this.navn = navn;
        this.fNummer = fNummer;

        pasientID = nesteID;
        nesteID ++;
    }

    // Resept ting
    public void leggTilResept(Resept nyResept) {
      resepter.leggTil(nyResept);
      antResepter++;
    }
    
    public int hentReseptAntall() //henter frem antall resepter pasienten har
    {
        return antResepter;
    }

    // Hent gitte verdier
    public IndeksertListe<Resept> hentReseptListe(){return resepter;}
    public String hentNavn(){return navn;}
    public String hentFNummer(){return fNummer;}


    public String toString(){return "PasientID: " + pasientID + " | " + navn + " | fnr" + fNummer + "\n";}

    public int hentID(){return pasientID;}

}
