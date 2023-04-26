public class Subsekvens {
    public final String streng;
    private int antall;

    public Subsekvens(String innstreng, int antall) {
        this.streng = innstreng;
        this.antall = antall;
    }

    // Hent info fra verdien antall
    public int hentAntall() {
        return antall;
    }
    public int plussAntall(int tall) {
        antall += tall;
        return antall;
    }
    public int minusAntall(int tall) {
        antall -= tall;
        return antall;
    }
    public String toString() {
        return "(" + streng + "," + antall + ")";
    }
}