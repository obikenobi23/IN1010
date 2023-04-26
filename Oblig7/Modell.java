import java.util.ArrayList;

class Modell {
    GUI gui;
    Rute[][] brett= new Rute[12][12];
    int antTrekk= 0;
    boolean spilletErFerdig= false;

    String retning ;
    ArrayList<Rute> slange= new ArrayList<Rute>();
    ArrayList<Rute> skatt= new ArrayList<Rute>();

    int hentLengde() {
      return slange.size();
    }

    Modell (GUI g) {
      gui= g;
      for (int r= 0; r< 12; r++) {
        for (int k= 0; k< 12; k++) {
          brett[r][k]= new Rute(r,k);
        }
      }
      gui.ruteTilHode(5, 6);
      Rute rute = brett[5][6];
      slange.add(0,rute);
    }

    void oppdaterLengde() {
      gui.oppdaterLengde();
    }

		int trekk (int a, int b) {
			return (int)(Math.random()*(b-a+1))+a;
		}


		void settSkatt() {
			int kol = trekk(0,11);
			int rad = trekk(0,11);
			gui.bakgrunnTilSkatt(rad, kol);
		}

    void nySkatt() {
      int rad = trekk(0, 11);
      int kol = trekk(0,11);
      boolean finnesSlange = false;
      boolean annenSkatt = false;

      for (Rute r: slange) {
        int sRad = r.hentRad();
        int sKol = r.hentKolonne();
        if (sRad == rad && sKol == kol) {
          finnesSlange = true;
        }
      }
      for (Rute skattR:skatt) {
        int mRad= skattR.hentRad();
        int mKol= skattR.hentKolonne();
        if (mRad == rad && mKol == kol) {
          annenSkatt = true;
        }
      }
      if( finnesSlange == false && annenSkatt == false) {
        gui.bakgrunnTilSkatt(rad,kol);
        Rute skattRute = new Rute(rad, kol);
        skatt.add(0,skattRute);
      } else {
        nySkatt();
      }


    }

    ArrayList<Rute> hentSkatteliste() {
      return skatt;
    }

    Rute hentHode() {
      return slange.get(0);
    }
    ArrayList<Rute> hentSlange() {
      return slange;
    }
    Rute hentTupp() {
      int str= slange.size();
      return slange.get(str- 1);
    }
    void settHode(Rute rute) {
      slange.add(0, rute);
      int rad= rute.hentRad();
      int kolonne = rute. hentKolonne();
      gui.ruteTilHode(rad, kolonne);
    }
    void settKropp(Rute rute) {
      int rad= rute.hentRad();
      int kolonne = rute.hentKolonne();
      gui.ruteTilKropp(rad, kolonne);
    }
    void fjernTupp(Rute rute) {
      int rad= rute.hentRad();
      int kolonne = rute. hentKolonne();
      gui.slangeTilBakgrunn(rad, kolonne);
      slange.remove(rute);
    }

    void retningHoyre() {
      retning = "H";
    }
    void retningVenstre() {
      retning = "V";
    }
    void retningOpp() {
      retning = "O";
    }
    void retningNed() {
      retning = "N";
    }


}
