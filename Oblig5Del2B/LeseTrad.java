import java.util.HashMap;

public class LeseTrad implements Runnable{
    String filnavn;
    Monitor2 monitor;
    HashMap<String, Subsekvens> hash;

    public LeseTrad(Monitor2 m, String filnavn) {
        this.filnavn = filnavn;
        monitor = m;
    }

    @Override
    public void run() {
        hash = SubsekvensRegister.lesFilStat(filnavn);
        monitor.settInn(hash);
        // System.out.println(filnavn + " er ferdig");
    }
}
