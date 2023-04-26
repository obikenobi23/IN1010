import java.util.HashMap;

public class LeseTrad implements Runnable{
    String filnavn;
    Monitor1 monitor;
    HashMap<String, Subsekvens> hash;

    public LeseTrad(Monitor1 m, String filnavn) {
        this.filnavn = filnavn;
        monitor = m;
    }

    @Override
    public void run() {
        // String[] filArray = filnavn.split("/");
        hash = SubsekvensRegister.lesFilStat(filnavn);
        monitor.settInn(hash);
        // System.out.println(filnavn + " er ferdig");
    }
}
