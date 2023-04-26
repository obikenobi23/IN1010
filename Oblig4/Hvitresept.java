public class Hvitresept extends Resept{
    int rabatt = middelReferanse.hentPris();
    public Hvitresept(Pasient pasient, Lege utskrivendeLege, int reit, Legemiddel middelReferanse){
        super(pasient, utskrivendeLege, reit, middelReferanse);
    }

    // Hent gitte verdier
    public String farge() {
        return "Hvit resept";
    }
    public int prisAaBetale() {
        return middelReferanse.hentPris() - rabatt;
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
