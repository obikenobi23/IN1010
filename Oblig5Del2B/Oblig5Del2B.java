import java.util.Scanner;
// import java.util.HashMap;
// import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Oblig5Del2B {
    public static void main(String[] args) {
        
        Monitor2 monitor = new Monitor2();
        
        try {
            
            String filnavn;
            Thread nyTrad;
            
            Scanner filnavnLiten = new Scanner(new File(args[0] + "/metadata.csv"));

            // String directory = args[0].split("/")[0] + "/";
            String directory = args[0];

            while(filnavnLiten.hasNextLine()) {
                filnavn = filnavnLiten.nextLine().split(",")[0];
                nyTrad = new Thread(new LeseTrad(monitor, directory + "/" + filnavn));
                nyTrad.start();
            }


        } catch(FileNotFoundException f) {
            System.out.println("Kan ikke lese sti");
            f.printStackTrace();
        }

        for(int i = 0; i < 8; i++) {
            FletteTrad fletter = new FletteTrad(monitor);
            fletter.run();
        }




        // Skriv ut det flettede hashmapet
        System.out.println("Flettet HashMap");
        for(Subsekvens s : monitor.register.get(0).values()) {
            System.out.println(s);
        }
    }
}
