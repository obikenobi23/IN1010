import java.util.*;

public class Aapning extends HvitRute{
	public Aapning(int rad, int kol, Labyrint brett) {
		super(rad, kol, brett);
	}

	@Override// Kun for bugtesting. Endre tegnet for å se om åpningene eksisterer
	public String toString() {
		return ".";
	}

	@Override
	public ArrayList<Rute> finn(Rute fra) {
		ArrayList<Rute> slutt = new ArrayList<>();
		slutt.add(this);
		return slutt;
	}
}
