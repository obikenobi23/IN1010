import java.util.Scanner;
import java.util.HashMap;
// import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Oblig5Del2A {
    public static void main(String[] args) {
            
        Monitor1 monitor = new Monitor1();
        
        try {
            
            String filnavn;
            Thread nyTrad;
            
            Scanner filnavnLiten = new Scanner(new File(args[0] + "/metadata.csv"));

            // String directory = args[0].split("/")[0];
            String directory = args[0];

            while(filnavnLiten.hasNextLine()) {
                filnavn = filnavnLiten.nextLine().split(",")[0];
                nyTrad = new Thread(new LeseTrad(monitor, directory + "/" + filnavn));
                nyTrad.run();
            }


        } catch(FileNotFoundException f) {
            System.out.println("Kan ikke lese sti");
            f.printStackTrace();
        }

        while(monitor.regLeng() != 1) {
            HashMap<String, Subsekvens> hash = monitor.taUt();
            HashMap<String, Subsekvens> map = monitor.taUt();
            monitor.settInn(Monitor1.flett(hash, map));
        }


        // Skriv ut det flettede hashmapet
        for(Subsekvens s : monitor.register.get(0).values()) {
            System.out.println(s);
        }
    }
}
