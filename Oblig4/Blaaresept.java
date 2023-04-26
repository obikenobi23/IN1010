public class Blaaresept extends Resept{
    private float rabatt = middelReferanse.hentPris() * 0.75f;
    public Blaaresept(Pasient pasient, Lege utskrivendeLege, int reit, Legemiddel middelReferanse){
        super(pasient, utskrivendeLege, reit, middelReferanse);
    }

    // Hent gitte verdier
    public String farge(){return "Blaa resept";}
    public int prisAaBetale() {
        return Math.round(middelReferanse.hentPris() - rabatt);
    }

		public String toString(){
        return "Legemiddelets navn: " + middelReferanse.hentNavn() +
        "\nlegemiddelets ID: " + middelReferanse.hentID() +
        "\nresepttype: " + farge() +
        "\npasient-ID: " + hentPasient().hentNavn() +
        "\nlege: " + hentLege() +
        "\nreit: " + hentReit() +
        "\npris: " + prisAaBetale();
    }
}
