import java.util.*;
import java.io.*;

public abstract class Rute {
	private int rad;
	private int kolonne;
	Rute nord;
	Rute ost;
	Rute sor;
	Rute vest;
	Labyrint brett;

	public Rute(int rad, int kol, Labyrint brett) {
		this.brett = brett;
		this.rad = rad;
		kolonne = kol;
		finnNaboer();

	}

	private void finnNaboer() {
		for(Rute[] r : brett.brett){
			for(Rute k : r) {
				if(k instanceof Rute) {// Siden rutene legges inn etter tur vil mange av elementene være tomme. De må ikke behandles

					if(k.hentK() == kolonne - 1 && k.hentR() == rad) {
						nord = k;
						k.sor = this;
					} else if(k.hentK() == kolonne + 1 && k.hentR() == rad) {
						sor = k;
						k.nord = this;
					} else if(k.hentR() == rad - 1 && k.hentK() == kolonne) {
						vest = k;
						k.ost = this;
					} else if(k.hentR() == rad + 1 && k.hentK() == kolonne) {
						ost = k;
						k.vest = this;
					}}}}}

	public ArrayList<Rute> finn(Rute fra) {
		return null;
	}

	public ArrayList<Rute> finn() {// Sett i gang rekursjonen fra startfeltet: kalles fra startruten
		ArrayList<Rute> svar = new ArrayList<>();
		ArrayList<Rute> leggTilDisse = new ArrayList<>();

		if(this instanceof Aapning)
			svar.add(this);

		if(nord instanceof HvitRute){
			leggTilDisse = nord.finn(this);

			for(Rute R : leggTilDisse){
				svar.add(R);
			}
		}

		if(ost instanceof HvitRute){
			leggTilDisse = ost.finn(this);

			for(Rute R : leggTilDisse){
				svar.add(R);
			}
		}

		if(sor instanceof HvitRute){
			leggTilDisse = sor.finn(this);

			for(Rute R : leggTilDisse){
				svar.add(R);
			}
		}
		if(vest instanceof HvitRute){
			leggTilDisse = vest.finn(this);

			for(Rute R : leggTilDisse){
				svar.add(R);
			}
		}

		return svar;
	}

	public int hentK() {
		return kolonne;
	} public int hentR() {
		return rad;
	}
}
