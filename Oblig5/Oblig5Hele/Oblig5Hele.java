import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Oblig5Hele {
  public static void main(String[] args) throws InterruptedException {// Datamappe som argument. Metadata er hardcodet inn. Dette kan endres ved å skrive args[1] over "/metadata"
	Monitor2 mtrue = new Monitor2();
	Monitor2 mfalse = new Monitor2();

	String filermappe = args[0] + "/metadata.csv";

	ArrayList<Thread> tradliste = new ArrayList<>();

	try{
		Scanner metaleser = new Scanner(new File(filermappe));

		System.out.println("Begynner aa lese filer...");

		while(metaleser.hasNextLine()) {
			String linje = metaleser.nextLine();
			String[] deling = linje.split(",");
			// System.out.println(linje);

			String filnavn = args[0] + "/" + deling[0];
			String erSyk = deling[1];

			Thread nyTrad;

			if(erSyk.equals("True")){
				nyTrad = new Thread(new LeseTrad(mtrue, filnavn));
				tradliste.add(nyTrad);
				nyTrad.start();

			}

			else if(erSyk.equals("False")){
				nyTrad = new Thread(new LeseTrad(mfalse, filnavn));
				tradliste.add(nyTrad);
				nyTrad.start();

			}
			// else {
				//   nyTrad = null;
				//   System.err.println("Feil i sannhet: metadata.csv");
				// }

			}

			// Synkroniser tråder
			for(Thread trad : tradliste) {
				trad.join();
			}

			tradliste.clear();

			System.out.println("Ferdig med aa lese filer");

			// Iterer over flettetrader. Synkroniser dem før neste sett med tråder
			ArrayList<Thread> sykeFletteliste = new ArrayList<>();

			System.out.println("Begynner aa flette...");

			for(int i = 0; i < 8; i++) {
				Thread fletter = new Thread(new FletteTrad(mtrue));
				sykeFletteliste.add(fletter);
				fletter.start();
			}

			for(Thread trad : sykeFletteliste) {
				trad.join();
			}
			sykeFletteliste.clear();

			System.out.println("Halvveis i aa flette...");

			// Neste sett med tråder.

			ArrayList<Thread> friskeFletteliste = new ArrayList<>();

			for (int i = 0; i < 8; i++) {
				Thread fletter = new Thread(new FletteTrad(mfalse));
				friskeFletteliste.add(fletter);
				fletter.start();
			}

			for(Thread flett : friskeFletteliste) {
				flett.join();
			}

			HashMap<String, Subsekvens> varsyk = mtrue.register.remove(0);
			HashMap<String, Subsekvens> varfrisk = mfalse.register.remove(0);
			ArrayList<Subsekvens> differanseliste = new ArrayList<>();

			for (String key : varsyk.keySet()) {
				Subsekvens syk = varsyk.get(key);
				Subsekvens frisk = varfrisk.get(key);

				if(frisk == null) {// Differanse = innhold i syk hvis
					//frisk ikke finnes
					differanseliste.add(syk);
				} else {
					if(syk.hentAntall() > frisk.hentAntall()) {
						int forskjell = syk.hentAntall() - frisk.hentAntall();
						Subsekvens diff = new Subsekvens(key, forskjell);
						differanseliste.add(diff);
					}
				}
			}

			System.out.println("Ferdig!");

			for(Subsekvens stordiff : differanseliste) {
				if(stordiff.hentAntall() >= 7) {
					System.out.println(stordiff);
				}
			}

			int storst = 0;
			Subsekvens storste = null;

			for(Subsekvens nokkel : differanseliste) {
				if(nokkel.hentAntall() > storst) {
					storst = nokkel.hentAntall();
					storste = nokkel;
				}
			}

			System.out.println("Storste verdi er " + storste);

		} catch (FileNotFoundException f) {
			System.err.println("Fant ikke fil:");
			f.printStackTrace();
		} catch(NullPointerException n) {

		}
	}
}
