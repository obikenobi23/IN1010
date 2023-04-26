import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

// En filleser som tar inn ett argument: filsti for en
// fil som inneholder en labyrint og metadata.
// Labyrinten skal ha # for vegger og . for veier.
// Metadata er en linje med to tall og et mellomrom,
// første tall er antall rader, andre er antall kolonner.

public class Oblig6 {
	public static void main(String[] args) {
		String filnavn = args[0];

		try {
			Scanner labyrintleser = new Scanner(new File(filnavn));


			String[] grovLengder = labyrintleser.nextLine().split(" ");// Metadata tas inn som streng.
			int[] lengder = new int[grovLengder.length];

			for(int i = 0; i < grovLengder.length; i++) {
				lengder[i] = Integer.parseInt(grovLengder[i]);// Metadata parses til heltall for å brukes i programmet. Antall rader er første tall antall kolonner er andre tall.
			}

			int antRader = lengder[0];
			int antKolonner = lengder[1];

			// Initialisering før lesing av labyrinten her

			Labyrint labyrint = new Labyrint(antRader, antKolonner);// En todimensjonal array som skal lagre ett objekt av Rute-klassen per kartesisk koordinat.
			String grovLabLinje;//Henter inn hver tekstlinje av labyrintfilen etter tur.
			ArrayList<String> labLinje = new ArrayList<>();// Hvert enkelt tegn legges inn som element her.
			int instRad = 0;
			int instKolonne = 0;
			Aapning aa;
			HvitRute hr;
			SortRute sr;
			int id;

			while(labyrintleser.hasNextLine()) {// Her leses selve labyrinten

				grovLabLinje = labyrintleser.nextLine();

				for(int i = 0; i < antKolonner; i++) {
					labLinje.add(grovLabLinje.substring(i, i+1));// Legg inn hvert enkelt tegn fra linjen

				}

				for(String s : labLinje){// Behandle hvert enkelt tegn.
					// System.out.println("instRad: " + instRad + " rader: " + antRader + " instKolonne: " + instKolonne + " kolonner: " + antKolonner);

					id = identifiserRute(s, instRad, antRader, instKolonne, antKolonner);

					if(id == 0) {// Opprett et objekt av Rute-klassen, spseifikk underklasse etter tegnet som behandles.
						sr = new SortRute(instRad, instKolonne, labyrint);
						labyrint.leggTilRute(sr);
					} else if(id == 1) {
						hr = new HvitRute(instRad, instKolonne, labyrint);
						labyrint.leggTilRute(hr);
					} else if(id == 2) {
						aa = new Aapning(instRad, instKolonne, labyrint);
						labyrint.leggTilRute(aa);
					} else {// Burde jeg brukt catch her? Ja
						System.out.println("Feil i ruteidentifisering");
						System.exit(1);
					}

					instKolonne++;
				}

				//Nullstilling til neste iterasjon
				labLinje.clear();
				instKolonne = 0;
				instRad++;

			}//Fillesing er over


			boolean fant = false;
			boolean feilmelding;
			ArrayList<Rute> svar = new ArrayList<>();

			while(!fant) {
				feilmelding = false;
				System.out.println(labyrint);

				int[] svarFraBruker = mottaSvarFraBruker();

				for(Rute[] r : labyrint.brett) {
					for(Rute k : r) {

						if(k.hentR() == svarFraBruker[0] && k.hentK() == svarFraBruker[1] && k instanceof HvitRute) {
							fant = true;
							svar = k.finn();
							break;
						} else if(k.hentR() == svarFraBruker[0] && k.hentK() == svarFraBruker[1] && k instanceof SortRute) {
							svar = null;
							System.out.print("\n\n\n\n\n\n\n\n\n\n");
							System.out.println("Kan ikke starte fra en vegg");
							feilmelding = true;
						}
					}
					if(fant == true)
					break;
				}

				if (!fant && !feilmelding) {
					System.out.println("Fant ikke en rute med riktig koordinat");
				}
			}

				if(svar.size() > 0){
					System.out.println("Dette er de funnede utveisrutene:");
					for(Rute R : svar) {
						System.out.println("Rad " + R.hentR() + " kolonne " + R.hentK());
					}
				} else {
					System.out.println("Ingen aapninger fra det gitte koordinatet");
				}



		// Fange feil
		} catch(FileNotFoundException f) {
			System.err.println("Fant ikke fil");
			f.printStackTrace();
			System.exit(1);
		} catch(Exception e) {// En catch-all for alle andre unntak
			e.printStackTrace();
			System.exit(1);
		}
	}


	static int identifiserRute(String s, int instRad, int rader, int instKolonne, int kolonner) {
		int rad = instRad;
		int kolonne = instKolonne;


		if(s.equals(".")){

			if(rad == 0 || rad == rader - 1 || kolonne == 0 || kolonne == kolonner - 1){// Ruten er en aapning
				return 2;
			}
			else// Ruten er hvit (en vei)
				return 1;

		} else if(s.equals("#")){// Ruten er sort(en vegg)
			return 0;

		} else{// Kunne jeg brukt en catch? ja, kanskje
			System.err.println("Ukjent tegn i lesing av labyrint\nOblig6/Hovedprogram:identifiserRute()");
			System.exit(1);
			return -1;// Kompilatoren krevde en returverdi på hvert fall. Dette fallet kan ikke nås.
		}
	}

	private static int[] mottaSvarFraBruker() {// Hent svar på formen "rad kolonne", som angir startpunkt. Senere skal dette leses mot en eksisterende Rute
		System.out.println("Skriv inn en startrute på formen rad[mellomrom]kolonne. Skriv \'q\' i stedet for aa avslutte.");
		System.out.println("\'0 0\' er øverst til venstre. Tallet til venstre oker nedover, tallet til hoyre oker bortover.");
		Scanner input = new Scanner(System.in);
		String svaret = input.nextLine();
		if(svaret.equals("q")){
			System.exit(0);
		}

		String[] svarArray = svaret.split(" ");
		int[] svarRiktigFormat = new int[2];

		// System.out.println(svarArray[0] + " " + svarArray[1]);

		for(int i = 0; i < svarRiktigFormat.length; i++){
			svarRiktigFormat[i] = Integer.parseInt(svarArray[i]);
		}


		return svarRiktigFormat;
	}
}
