import java.util.*;
import java.io.*;

public class HvitRute extends Rute{
	public HvitRute(int rad, int kol, Labyrint brett) {
		super(rad, kol, brett);
	}

	@Override
	public ArrayList<Rute> finn(Rute fra) {// Rekursiv kalling fram til åpningen oppdages. Eventuelle funnede åpninger retureres opp gjennom rekursjonen

		ArrayList<Rute> ruter = new ArrayList<>();// Returverdi
		ArrayList<Rute> leggTilDisse = new ArrayList<>();// Inndata fra rekursjon

		// Metoden returnerer en ArrayList, så den kan ikke sende sin egen innverdi rett ut
		if(nord != fra && nord != null) {
			leggTilDisse = nord.finn(this);

			for(Rute R : leggTilDisse) {
				ruter.add(R);
			}
		}
		if(ost != fra && ost != null) {
			leggTilDisse = ost.finn(this);

			for(Rute R : leggTilDisse) {
				ruter.add(R);
			}
		}
		if(sor != fra && sor != null) {
			leggTilDisse = sor.finn(this);

			for(Rute R : leggTilDisse) {
				ruter.add(R);
			}
		}
		if(vest != fra && vest != null) {
			leggTilDisse = vest.finn(this);

			for(Rute R : leggTilDisse) {
				ruter.add(R);
			}
		}

		return ruter;
	}

	@Override
	public String toString() {
		return ".";
	}
}
