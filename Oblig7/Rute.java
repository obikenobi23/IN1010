public class Rute {
  int kolonne;
  int rad;

  Rute (int rad, int kolonne) {
  this.kolonne = kolonne;
  this.rad = rad;
  }

  int hentRad() {
    return rad;
  }
  int hentKolonne() {
    return kolonne;
  }
}
