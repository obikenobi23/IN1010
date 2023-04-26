import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubsekvensRegister {
    ArrayList<HashMap<String, Subsekvens>> register;


    public SubsekvensRegister() {
        register = new ArrayList<>();

    }

    public int settInn(HashMap<String, Subsekvens> hash) {

        register.add(hash);

        return regLeng();
    }

    public HashMap<String, Subsekvens> taUt() {
        HashMap<String, Subsekvens> fjernet;
        try{
            fjernet = register.remove(0);
        } catch (NullPointerException e) {
            fjernet = null;
        }

        return fjernet;
    }

    public static HashMap<String, Subsekvens> lesFilStat(String filnavn) {// Leser en fil og henter ut tre og tre tegn i hver linje. 
        HashMap<String, Subsekvens> par = new HashMap<>();

        try{
            Scanner leser = new Scanner(new File(filnavn));

            while(leser.hasNextLine()) {

                String data = leser.nextLine();

                if(data.length() < 3) {// Oppgaven ber meg stoppe programmet hvis en linje ikke inneholder en hel subsekvens. Ja ja.
                    System.exit(0);
                }

                Character erLiten = data.charAt(0);
                if(Character.isLowerCase(erLiten))// Luker ut tittellinjen amino_acid
                  continue;

                for (int i = 0; i < data.length(); i++) {// Itererer gjennom hele linjens lengde

                    try{
                        String input = data.substring(i, i + 3);// Henter en substring med tre tegn

                        if(!par.containsKey(input)) {// Legger inn alle subsekvense kun en gang
                          Subsekvens subsekvens = new Subsekvens(input, 1);
                          par.put(input, subsekvens);
                        }

                    } catch(StringIndexOutOfBoundsException s) {}
                    // Denne try-catchen sender while-løkken til neste linje.
                    // Jeg kunne fått for-løkken til å stoppe på data.length()-3.
                    // Men hva hadde vi ledd av da?
                }
            }
            leser.close();
        }catch (FileNotFoundException e) {
            System.out.println("Fant ikke fil: " + filnavn);
            e.printStackTrace();
            System.exit(1);
        }

        return par;
    }

    public static HashMap<String, Subsekvens> flett(HashMap<String, Subsekvens> hash1, HashMap<String, Subsekvens> hash2) {
        HashMap<String, Subsekvens> nyHash = new HashMap<>();

        // HashMap<String, Subsekvens> hash1 = SubsekvensRegister.taUt();
        // HashMap<String, Subsekvens> hash2 = taUt();

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
            unik = false;
            for (String s : hash1.keySet()) {
                if(t.equals(s)) {
                    unik = true;
                }
            }
            if(!unik) {
                nyHash.put(t, hash2.get(t));
            }
        }

        return nyHash;
    }

    public int regLeng() {
        return register.size();
    }

    public String toString() {
        for (HashMap<String,Subsekvens> hashMap : register) {
            for (Subsekvens sub : hashMap.values()) {
                System.out.println(sub);
            }
        }
        return "";
    }
}
