import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Oblig5Del1 {
    public static void main(String[] args) {
        SubsekvensRegister test = new SubsekvensRegister();
        String filermappe = args[0];
        
        try {
            Scanner filnavnLiten = new Scanner(new File(filermappe + "/metadata.csv"));
            int antlinjer = 0;
            
            HashMap<String, Subsekvens> hash;
            String daarligNavn;
            String filnavn;

            while(filnavnLiten.hasNextLine()) {
                antlinjer++;
                daarligNavn = filnavnLiten.nextLine();
                filnavn = daarligNavn.split(",")[0];
                hash = SubsekvensRegister.lesFilStat(args[0] + "/" + filnavn);
                test.settInn(hash);
            }

            test(test, antlinjer);

        } catch(FileNotFoundException f) {
            System.out.println("Kan ikke lese sti");
            System.exit(1);
        }
    }


    static void test(SubsekvensRegister s, int antlinjer) {
        // Test 1: Antall hashmaps
        System.out.print("Test 1...");

        if(s.regLeng() == antlinjer) {
            System.out.println("Alt OK");
        } else {
            System.out.println("Antall hashmaps er " + s.regLeng());
        }


        // Test 2: Heltallsverdien i alle hashpar er 1
        System.out.print("Test 2...");

        boolean feil2 = false;

        for (HashMap<String, Subsekvens> i : s.register) {
            for(Subsekvens j : i.values()) {
                if(j.hentAntall() != 1) {
                    feil2 = true;
                }
            }            
        }

        if(!feil2) {
            System.out.println("Alt OK");
        } else {
            System.out.println("Feil i hashmap antall");
        }


        // Test 3: Riktig fletting
        System.out.print("Test 3...");

        for(int i = 0; i < antlinjer - 1; i++) {
            s.settInn(SubsekvensRegister.flett(s.taUt(), s.taUt()));
        }

        if(s.regLeng() == 1) {
            System.out.println("Alt OK");
        } else {
            System.out.println("Fletting feilet. " + "Størrelse er " + s.regLeng());
        }

        // Test 4: Vis største
        System.out.print("Test 4...");

        int storsteTall = Integer.MIN_VALUE;
        Subsekvens storsteSub = new Subsekvens("TOM SUBSTRENG", storsteTall);
        for(Subsekvens sub : s.register.get(0).values()) {
            if(sub.hentAntall() > storsteTall) {
                storsteTall = sub.hentAntall();
                storsteSub = sub;
            }
        }
        System.out.println(storsteSub);

        // Test 5: taUt virker
        System.out.print("Test 5...");

        HashMap<String, Subsekvens> rett = s.register.get(0);

        if(s.taUt() == rett && s.regLeng() == 0) {
            System.out.println("Alt OK");
        } else {
            System.out.println("taUt virker ikke");
        }
    }
}
