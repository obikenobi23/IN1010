import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hovedprogram {
    public static void main(String[] args) {
        Dataklynge saga = new Dataklynge();

        Scanner fil = null;

        try {
            fil = new Scanner(new File("dataklynge.txt"));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        while (fil.hasNextLine() && fil.hasNextInt()) {
            int antall = fil.nextInt();
            int prosessorer = fil.nextInt();
            int minne = fil.nextInt();

            for (int i = 0; i < antall; i++) {
                Node node = new Node(prosessorer, minne);
                saga.plasserNode(node);
                // System.out.println(node);
            }
        }
        fil.close();

        System.out.println();
        
        System.out.print("Noder med minst 512 GB: ");
        System.out.println(saga.noderMedNokMinne(512));

        System.out.print("Noder med minst 1024 GB: ");
        System.out.println(saga.noderMedNokMinne(1024));

        
        System.out.print("Noder med minst 2048 GB: ");
        System.out.println(saga.noderMedNokMinne(2048));

        System.out.print("Totalt antall prosessorer: ");
        System.out.println(saga.antProsessorer());

        System.out.print("Antall rack: ");
        System.out.println(saga.rekkeLengde());
    }
}
