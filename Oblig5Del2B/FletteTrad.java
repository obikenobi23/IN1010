import java.util.HashMap;
import java.util.ArrayList;

public class FletteTrad implements Runnable{
    Monitor2 monitor;// Endres til Monitor2 etterpå
    ArrayList<HashMap<String, Subsekvens>> array;
    HashMap<String, Subsekvens> hash;
    HashMap<String, Subsekvens> map;
    HashMap<String, Subsekvens> nyHash;

    public FletteTrad(Monitor2 m) {
        monitor = m;
    }

    @Override
    public void run() {
      while (monitor.regLeng() >= 2) {

      array = monitor.taUtTo();

      hash = array.get(0);
      map = array.get(1);

      nyHash = monitor.flett(hash, map);
      // nyhash = SubsekvensRegister.flett()
      monitor.settInn(nyHash);
      // System.out.println("Flett ferdig");
      System.out.println(monitor.regLeng());
    }
    return;
  }
}
