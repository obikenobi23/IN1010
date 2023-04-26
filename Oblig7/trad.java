public class trad implements Runnable {
  Kontroll kontroll;
  trad (Kontroll kontroll) {
    this.kontroll = kontroll;
  }
  public void run() {
    try {
      while(kontroll.hentStatus()) {
          kontroll.flyttSlange();
          Thread.sleep(1000);
      }
    } catch (InterruptedException e) {}
  }
}
