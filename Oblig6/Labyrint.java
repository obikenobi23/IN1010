public class Labyrint {
	private int rader;
	private int kolonner;
	Rute[][] brett;

	public Labyrint(int rad, int kol) {
		rader = rad;
		kolonner = kol;
		brett = new Rute[rader][kolonner];
	}

	public String toString() {
		String wtf = "\n";
		for(Rute[] r : brett) {
			for (Rute k : r) {
				// if(k instanceof HvitRute || k instanceof SortRute || k instanceof Aapning) {
					// System.out.print("rute");
					// wtf += ".------------------";
					wtf += k.toString();
				// }
			}
			wtf += "\n";
		}
		return wtf;
	}

	public void leggTilRute(Rute r) {
		for(int i = 0; i < rader; i++) {
			for(int j = 0; j < kolonner; j++) {
				if(!(brett[i][j] instanceof Rute)){
					brett[i][j] = r;
					return;
				}
			}
		}
	}

	public int hentRader() {
		return rader;
	} public int hentKolonner() {
		return kolonner;
	}
}
