import java.util.concurrent.locks.*;
import java.util.HashMap;
import java.util.ArrayList;
// import java.util.Scanner;
// import java.io.File;
// import java.io.FileNotFoundException;

public class Monitor2{
    Condition kanFlette;
    Lock laas = new ReentrantLock();
    SubsekvensRegister s;
    ArrayList<HashMap<String, Subsekvens>> register;


    public Monitor2() {
      s = new SubsekvensRegister();
      register = s.register;
			kanFlette = laas.newCondition();
    }


    public ArrayList<HashMap<String,Subsekvens>> taUtTo() {

			laas.lock();
			ArrayList<HashMap<String, Subsekvens>> fjernet = new ArrayList<>();

			try{
				while(register.size() < 2) {
					kanFlette.await();
				}
				fjernet.add(register.remove(0));
				fjernet.add(register.remove(0));
				// if(regLeng() >= 2) {
					//     kanFlette.signalAll();
					// }

				} catch(NullPointerException n) {
					fjernet = null;
				} catch (InterruptedException i) {
					fjernet = null;
				} finally {
					laas.unlock();
				}
				return fjernet;
    }

    public int settInn(HashMap<String, Subsekvens> hash) {
			laas.lock();

			try {
				register.add(hash);

				if(register.size() >= 2)
				kanFlette.signalAll();
				return regLeng();
			} finally {
				laas.unlock();
			}
    }

    public HashMap<String, Subsekvens> flett(HashMap<String, Subsekvens> hash1, HashMap<String, Subsekvens> hash2){

			HashMap<String, Subsekvens> nyHash = new HashMap<>();

			boolean funnet;
			boolean unik;

			for (String s : hash1.keySet()) {
				funnet = false;
				for (String t : hash2.keySet()) {

					if(s.equals(t)) {
						funnet = true;
						int nyVerdi = hash1.get(s).hentAntall() + hash2.get(t).hentAntall();
						Subsekvens nySubsekvens = new Subsekvens(s, nyVerdi);
						nyHash.put(s, nySubsekvens);
						break;
					}
				}
				if(!funnet){
					nyHash.put(s, hash1.get(s));
				}
			}

			for (String t : hash2.keySet()) {
				unik = true;
				for (String s : hash1.keySet()) {
					if(t.equals(s)) {
						unik = false;
					}
				}
				if(unik) {
					nyHash.put(t, hash2.get(t));
				}
			}

			return nyHash;
    }

    public int regLeng() {
      return register.size();
    }
}
