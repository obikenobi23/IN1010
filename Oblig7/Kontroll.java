import java.util.ArrayList;

class Kontroll {
    GUI gui;
    Modell modell;
    trad slangeTrad;

    int lengde= 1;

    Kontroll () {
      gui = new GUI(this);
      modell = new Modell(gui);
      slangeTrad = new trad(this);

      for (int ant= 0; ant< 10; ant++) {
        modell.nySkatt();
      }
    }

    int hentLengde() {
      return lengde;
    }

    boolean fortsett = true;
    boolean hentStatus() {
      return fortsett;
    }

    void flyttSlange() {
      Rute hode = modell.hentHode();
      Rute ende = modell.hentTupp();
      int rad = hode.hentRad();
      int kolonne = hode.hentKolonne();
      if (modell.retning=="V") {
        if (kolonne == 0) {
          avsluttSpillet();
        } else {
          int nyKol = kolonne - 1;
          Rute hodet = new Rute(rad, nyKol);
          modell.settKropp(hode);
          muligTrekk(hodet);
          modell.settHode(hodet);
          if (!kanTaSkatt()) {
            modell.fjernTupp(ende);
          }
        }
      } else if (modell.retning=="H") {
        if (kolonne == 11) {
          avsluttSpillet();
        } else {
          int nyKol = kolonne + 1;
          Rute hodet = new Rute(rad, nyKol); //nytt hode
          modell.settKropp(hode);
          muligTrekk(hodet);
          modell.settHode(hodet);
          if (!kanTaSkatt()) {
            modell.fjernTupp(ende);
          }
        }
      } else if (modell.retning == "O") {
        if (rad== 0) {
          avsluttSpillet();
        } else {
          int nyRad = rad - 1;
          Rute hodet = new Rute(nyRad, kolonne);
          modell.settKropp(hode);
          muligTrekk(hodet);
          modell.settHode(hodet);
          if (kanTaSkatt() == false) {
            modell.fjernTupp(ende);
          }
        }
      } else if (modell.retning =="N") {
        if (rad == 11) {
            avsluttSpillet();
        } else {
          int nyRad = rad + 1;
          Rute hodet = new Rute(nyRad, kolonne);
          modell.settKropp(hode);
          muligTrekk(hodet);
          modell.settHode(hodet);
          if (kanTaSkatt() == false) {
            modell.fjernTupp(ende);
          }
        }
      }
    }

    void muligTrekk(Rute nyttHode) {
      ArrayList<Rute> slange = modell.hentSlange();
      if (slange.size()> 1) {
        slange.remove(nyttHode);
        for (Rute slangedel: slange) {
          if (nyttHode.hentRad()== slangedel.hentRad() && nyttHode.hentKolonne()==slangedel.hentKolonne()) {
            avsluttSpillet();
          }
        }
      }
    }

    boolean kanTaSkatt() {
	    ArrayList<Rute> skatt = modell.hentSkatteliste();
	    Rute hode = modell.hentHode();
	    for (Rute r: skatt) {
	      int mRad = r.hentRad();
	      int mKol = r.hentKolonne();
	      if (mRad ==hode.hentRad() && mKol == hode.hentKolonne()) {
	      	lengde ++;
	      	modell.oppdaterLengde();
	      	gui.skattTilBakgrunn(mRad, mKol);
	      	modell.nySkatt();
	      	return true;
	      }
	    }
	    return false;
    }

    void startSpillet () {
      new Thread(slangeTrad).start();
    }
    void avsluttSpillet () {
      fortsett = false;
    }
    void lukkSpillet() {
      System.exit(0);
    }
    void retningHoyre() {
      modell.retningHoyre();
    }
    void retningVenstre() {
      modell.retningVenstre();
    }
    void retningOpp() {
      modell.retningOpp();
    }
    void retningNed() {
    	modell.retningNed();
    }
}
