import java.util.concurrent.locks.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Monitor1 {
    Lock laas;
    Condition ikkeTom;
    ArrayList<HashMap<String, Subsekvens>> register;
    boolean tom;

    public Monitor1() {
        SubsekvensRegister s = new SubsekvensRegister();
        laas = new ReentrantLock();
        ikkeTom = laas.newCondition();
        register = s.register;

    }

    public int settInn(HashMap<String, Subsekvens> hash) {
        laas.lock();
        try {
            register.add(hash);
            ikkeTom.signalAll();
            tom = false;
            return regLeng();
        } finally {
            laas.unlock();
        }
    }

    public HashMap<String, Subsekvens> taUt() {
        laas.lock();
        HashMap<String, Subsekvens> fjernet;

        try{
            while(tom) {
                ikkeTom.await();
            }
            fjernet = register.remove(0);
            if(regLeng() < 1) {
                tom = true;
            } else {
                tom = false;
            }
        } catch(NullPointerException n) {
            fjernet = null;
        } catch (InterruptedException i) {
            fjernet = null;
        } finally {
            laas.unlock();
        }
        return fjernet;
    }

    public static HashMap<String, Subsekvens> lesFilStat(String filnavn) {
        HashMap<String, Subsekvens> par = new HashMap<>();

        try{
            Scanner leser = new Scanner(new File(filnavn));

            while(leser.hasNextLine()) {
                Boolean fantLik = false;
                String data = leser.nextLine();

                for (int i = 0; i < data.length(); i++) {
                    fantLik = false;
                    try{
                        String input = data.substring(i, i + 3);

                        for (String j : par.keySet()) {
                            if(j.equals(input))
                                fantLik = true;
                        }

                        if(!fantLik) {
                            Subsekvens subsekvens = new Subsekvens(input, 1);
                            par.put(input, subsekvens);
                        }

                    } catch(StringIndexOutOfBoundsException s) {}
                }
            }

            leser.close();

        } catch (FileNotFoundException f) {
            System.err.println("Fant ikke fil");
            f.printStackTrace();
            // System.exit(1);
        }

        return par;

    }

    public static HashMap<String, Subsekvens> flett(HashMap<String, Subsekvens> hash1, HashMap<String, Subsekvens> hash2) {
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
