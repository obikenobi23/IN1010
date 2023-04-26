import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Legesystem{

    private static void printOversikt(){
			System.out.println();
			System.out.println("Dette er alle legene i systemet:");
			for(int i = 0; i < legeListe.stoerrelse(); i++) {
				System.out.println(legeListe.hent(i).toString());
			}
			System.out.println();

			System.out.println("Dette er alle resepter i systemet:");
			for(int i = 0; i < reseptListe.stoerrelse(); i++) {
				System.out.println(reseptListe.hent(i).toString());
				System.out.println();
			}
			System.out.println();


			System.out.println("Dette er alle pasienter i systemet:");
			for(int i = 0; i < pasientListe.stoerrelse(); i++) {
				System.out.println(pasientListe.hent(i).toString());
			}
			System.out.println();

			System.out.println("Dette er alle legemidler i systemet:");
			for(int i = 0; i < legemiddelListe.stoerrelse(); i++) {
				System.out.println(legemiddelListe.hent(i).toString());
			}
			System.out.println();

		}  // E3
    private static void leggTil(){

			System.out.println("Hva vil du legge til?");
			System.out.println("1: Lege");
			System.out.println("2: Spesialist");
			System.out.println("3: Legemiddel");
			System.out.println("4: Pasient");
			System.out.println("5: Resepter");

			String knapp2 = "";
			Scanner lesKnapp = new Scanner(System.in);
			knapp2 = lesKnapp.nextLine();

			if(knapp2.equals("1")){// lagLege()
				System.out.println("Du valgte aa legge til en lege. Vennligst skriv inn parametre eller \"-\" for aa avslutte.");
				System.out.println("Parametre: navn");

				String prompt = "";
				Scanner lesPrompt = new Scanner(System.in);
				prompt = lesPrompt.nextLine();

				if(prompt.equals("-")) {
					return;
				}
				lagLege(prompt);

			} else if(knapp2.equals("2")){// lagSpesialist()
				System.out.println("Du valgte aa legge til en spesialist. Vennligst skriv inn parametre eller \"-\" for aa avslutte.");
				System.out.println("Parametre: navn,kontrollID");

				String prompt = "";
				Scanner lesPrompt = new Scanner(System.in);
				prompt = lesPrompt.nextLine();
				if(prompt.equals("-")) {
					return;
				}
				// ArrayList<String> rekke = new ArrayList<>();
				String[] rekkeArray = prompt.split(",");
				// for(String i : rekkeArray) {
				// 	rekke.add(i);
				// }
				lagSpesialist(rekkeArray[0], rekkeArray[1]);
				// rekke.clear();
			} else if(knapp2.equals("3")){// Legemiddel
				System.out.println("Du valgte aa legge til et legemiddel. Du maa naa velge type legemiddel. Skriv 1 for vanlig, 2 for vanedannende eller 3 for narkotisk.");

				String middelType = "";
				Scanner lesMiddel = new Scanner(System.in);
				middelType = lesMiddel.nextLine();

				if(middelType.equals("1")) {// lagVanlig()
					System.out.println("Du valgte aa opprette et vanlig legemiddel. Vennligst skriv inn parametre (komma, ikke mellomrom) eller \"-\" for aa avslutte.");
					System.out.println("Parametre: navn,pris,masse av virkestoff");

					String prompt = "";
					Scanner lesPrompt = new Scanner(System.in);
					prompt = lesPrompt.nextLine();

					if(prompt.equals("-")) {
						return;
					}
					String[] rekkeArray = prompt.split(",");

					String stringPris = rekkeArray[1];
					int leggTilPris = Integer.parseInt(stringPris);
					String stringVirkemasse = rekkeArray[2];
					Double leggTilVirkemasse = Double.parseDouble(stringVirkemasse);
					lagVanlig(rekkeArray[0], leggTilPris, leggTilVirkemasse);

				} else if(middelType.equals("2")) {// lagVanedannende()
						System.out.println("Du valgte aa opprette et vanedannende legemiddel. Vennligst skriv inn parametre (komma, ikke mellomrom) eller \"-\" for aa avslutte.");
						System.out.println("Parametre: navn,pris,masse av virkestoff,styrke");

						String prompt = "";
						Scanner lesPrompt = new Scanner(System.in);
						prompt = lesPrompt.nextLine();

						if(prompt.equals("-")) {
							return;
						}

						String[] rekkeArray = prompt.split(",");

						String stringPris = rekkeArray[1];
						int leggTilPris = Integer.parseInt(stringPris);
						String stringVirkemasse = rekkeArray[2];
						Double leggTilVirkemasse = Double.parseDouble(stringVirkemasse);
						String stringStyrke = rekkeArray[3];
						int leggTilStyrke = Integer.parseInt(stringStyrke);
						lagVanedannende(rekkeArray[0], leggTilPris, leggTilVirkemasse, leggTilStyrke);

				} else if(middelType.equals("3")) {// lagNarkotisk()
						System.out.println("Du valgte aa opprette et narkotisk legemiddel! Vennligst skriv inn parametre (komma, ikke mellomrom) eller \"-\" for aa avslutte.");
						System.out.println("Parametre: navn,pris,masse av virkestoff,styrke");

						String prompt = "";
						Scanner lesPrompt = new Scanner(System.in);
						prompt = lesPrompt.nextLine();

						if(prompt.equals("-")) {
							return;
						}

						String[] rekkeArray = prompt.split(",");

						String stringPris = rekkeArray[1];
						int leggTilPris = Integer.parseInt(stringPris);
						String stringVirkemasse = rekkeArray[2];
						double leggTilVirkemasse = Double.parseDouble(stringVirkemasse);
						String stringStyrke = rekkeArray[3];
						int leggTilStyrke = Integer.parseInt(stringStyrke);
						lagNarkotisk(rekkeArray[0], leggTilPris, leggTilVirkemasse, leggTilStyrke);
				} else {
					System.out.println("Ugyldig tall.");
				}
			} else if(knapp2.equals("4")) {// Pasient
				System.out.println("Du valgte aa legge til en pasient. Vennligst skriv inn parametre eller \"-\" for aa avslutte.");
				System.out.println("Parametre: navn,foodselsnummer");

				String prompt = "";
				Scanner lesPrompt = new Scanner(System.in);
				prompt = lesPrompt.nextLine();

				if(prompt.equals("-")) {
					return;
				}
				String[] rekkeArray = prompt.split(",");
				lagPasient(rekkeArray[0], rekkeArray[1]);

			} else if(knapp2.equals("5")) {// Resept :'(
			System.out.println("Du valgte aa legge til en resept. Du maa naa velge typen resept. Skriv 1 for hvit resept, 2 for militaer resept, 3 for P-resept eller 4 for blaa resept.");

			String reseptType = "";
			Scanner lesResept = new Scanner(System.in);
			reseptType = lesResept.nextLine();

			if(reseptType.equals("1")) {// skrivHvitresept
				System.out.println("Du valgte aa opprette en hvit resept. Vennligst skriv inn parametre (komma, ikke mellomrom) eller \"-\" for aa avslutte.");
				System.out.println("Parametre: navn paa lege,legemiddel,pasientreferanse,reit");

				String prompt = "";
				Scanner lesPrompt = new Scanner(System.in);
				prompt = lesPrompt.nextLine();

				if(prompt.equals("-")) {
					return;
				}
				String[] rekkeArray = prompt.split(",");

				// Finn lege for resepten
				String stringLegenavn = rekkeArray[0];
				Lege riktigLege = null;
				Lege naaLege;

				for(int i = 0; i < legeListe.stoerrelse(); i++){
					naaLege = legeListe.hent(i);
					if(naaLege.hentNavn().equals(stringLegenavn)) {
						riktigLege = naaLege;
					}
				}
					// Finn referanse til legemiddel
					String stringMiddel = rekkeArray[1];
					Legemiddel riktigMiddel = null;
					Legemiddel naaMiddel;

					for(int i = 0; i < legemiddelListe.stoerrelse(); i++){
						naaMiddel = legemiddelListe.hent(i);
						if(naaMiddel.hentNavn().equals(stringMiddel)) {
							riktigMiddel = naaMiddel;
						}
					}

					// Finn referanse til pasient
					String stringPasient = rekkeArray[2];
					Pasient riktigPasient = null;
					Pasient naaPasient;

					for(int i = 0; i < pasientListe.stoerrelse(); i++) {
						naaPasient = pasientListe.hent(i);
						if(naaPasient.hentNavn().equals(stringPasient)) {
							riktigPasient = naaPasient;
						}
					}
					// Finn reit
					String stringReit = rekkeArray[3];
					int leggTilReit = Integer.parseInt(stringReit);

					if(riktigLege instanceof Lege && riktigMiddel instanceof Legemiddel && riktigPasient instanceof Pasient){
						try{
						riktigLege.skrivHvitresept(riktigMiddel, riktigPasient, leggTilReit);
					} catch (UlovligUtskrift e) {
						e.printStackTrace();
					}
					} else {
						System.out.println("Noe gikk galt.");
					}

				// String stringLegemiddel = rekkeArray[1];
				//
				//
				// String stringPris = rekkeArray[1];
				// int leggTilPris = Integer.parseInt(stringPris);
				// String stringVirkemasse = rekkeArray[2];
				// Double leggTilVirkemasse = Double.parseDouble(stringVirkemasse);
				// lagVanlig(rekkeArray[0], leggTilPris, leggTilVirkemasse);

			} else if(reseptType.equals("2")) {// Militaer resept
				System.out.println("Du valgte aa opprette en militaer resept. Vennligst skriv inn parametre (komma, ikke mellomrom) eller \"-\" for aa avslutte.");
				System.out.println("Parametre: navn paa lege,legemiddel,pasientreferanse");

				String prompt = "";
				Scanner lesPrompt = new Scanner(System.in);
				prompt = lesPrompt.nextLine();

				if(prompt.equals("-")) {
					return;
				}
				String[] rekkeArray = prompt.split(",");

				// Finn lege for resepten
				String stringLegenavn = rekkeArray[0];
				Lege riktigLege = null;
				Lege naaLege;

				for(int i = 0; i < legeListe.stoerrelse(); i++) {
					naaLege = legeListe.hent(i);
					if(naaLege.hentNavn().equals(stringLegenavn)) {
						riktigLege = naaLege;
					}
				}
					// Finn referanse til legemiddel
					String stringMiddel = rekkeArray[1];
					Legemiddel riktigMiddel = null;
					Legemiddel naaMiddel;

					for(int i = 0; i < legemiddelListe.stoerrelse(); i++) {
						naaMiddel = legemiddelListe.hent(i);
						if(naaMiddel.hentNavn().equals(stringMiddel)) {
							riktigMiddel = naaMiddel;
						}
					}

					// Finn referanse til pasient
					String stringPasient = rekkeArray[2];
					Pasient riktigPasient = null;
					Pasient naaPasient;

					for(int i = 0; i < pasientListe.stoerrelse(); i++) {
						naaPasient = pasientListe.hent(i);
						if(naaPasient.hentNavn().equals(stringPasient)) {
							riktigPasient = naaPasient;
						}
					}

					if(riktigLege instanceof Lege && riktigMiddel instanceof Legemiddel && riktigPasient instanceof Pasient){
						try{
							riktigLege.skrivMilResept(riktigMiddel, riktigPasient);
						} catch (UlovligUtskrift e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Noe gikk galt.");
					}



				// String stringLegemiddel = rekkeArray[1];


				// String stringPris = rekkeArray[1];
				// int leggTilPris = Integer.parseInt(stringPris);
				// String stringVirkemasse = rekkeArray[2];
				// Double leggTilVirkemasse = Double.parseDouble(stringVirkemasse);
				// lagVanlig(rekkeArray[0], leggTilPris, leggTilVirkemasse);

			} else if(reseptType.equals("3")) {// P-resept
				System.out.println("Du valgte aa opprette en P-resept resept. Vennligst skriv inn parametre (komma, ikke mellomrom) eller \"-\" for aa avslutte.");
				System.out.println("Parametre: navn paa lege,legemiddel,pasientreferanse,reit");

				String prompt = "";
				Scanner lesPrompt = new Scanner(System.in);
				prompt = lesPrompt.nextLine();

				if(prompt.equals("-")) {
					return;
				}
				String[] rekkeArray = prompt.split(",");

				// Finn lege for resepten
				String stringLegenavn = rekkeArray[0];
				Lege riktigLege = null;
				Lege naaLege;

				for(int i = 0; i < legeListe.stoerrelse(); i++) {
					naaLege = legeListe.hent(i);
					if(naaLege.hentNavn().equals(stringLegenavn)) {
						riktigLege = naaLege;
					}
				}

					// Finn referanse til legemiddel
					String stringMiddel = rekkeArray[1];
					Legemiddel riktigMiddel = null;
					Legemiddel naaMiddel;

					for(int i = 0; i < legemiddelListe.stoerrelse(); i++) {
						naaMiddel = legemiddelListe.hent(i);
						if(naaMiddel.hentNavn().equals(stringMiddel)) {
							riktigMiddel = naaMiddel;
						}
					}

					// Finn referanse til pasient
					String stringPasient = rekkeArray[2];
					Pasient riktigPasient = null;
					Pasient naaPasient;

					for(int i = 0; i < pasientListe.stoerrelse(); i++) {
						naaPasient = pasientListe.hent(i);
						if(naaPasient.hentNavn().equals(stringPasient)) {
							riktigPasient = naaPasient;
						}
					}

					// Finn reit
					String stringReit = rekkeArray[3];
					int leggTilReit = Integer.parseInt(stringReit);


					if(riktigLege instanceof Lege && riktigMiddel instanceof Legemiddel && riktigPasient instanceof Pasient){
						try{
							riktigLege.skrivPResept(riktigMiddel, riktigPasient, leggTilReit);
						} catch (UlovligUtskrift e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Noe gikk galt.");
					}


			} else if(reseptType.equals("4")) {// Blaa resept
				System.out.println("Du valgte aa opprette en blaa resept. Vennligst skriv inn parametre (komma, ikke mellomrom) eller \"-\" for aa avslutte.");
				System.out.println("Parametre: navn paa lege,legemiddel,pasientreferanse,reit");

				String prompt = "";
				Scanner lesPrompt = new Scanner(System.in);
				prompt = lesPrompt.nextLine();

				if(prompt.equals("-")) {
					return;
				}
				String[] rekkeArray = prompt.split(",");

				// Finn lege for resepten
				String stringLegenavn = rekkeArray[0];
				Lege riktigLege = null;
				Lege naaLege;

				for(int i = 0; i < legeListe.stoerrelse(); i++){
					naaLege = legeListe.hent(i);
					if(naaLege.hentNavn().equals(stringLegenavn)) {
						riktigLege = naaLege;
					}
				}
					// Finn referanse til legemiddel
					String stringMiddel = rekkeArray[1];
					Legemiddel riktigMiddel = null;
					Legemiddel naaMiddel;
					for(int i = 0; i < legemiddelListe.stoerrelse(); i++){
						naaMiddel = legemiddelListe.hent(i);
						if(naaMiddel.hentNavn().equals(stringMiddel)) {
							riktigMiddel = naaMiddel;
						}
					}
					// Finn referanse til pasient
					String stringPasient = rekkeArray[2];
					Pasient riktigPasient = null;
					Pasient naaPasient;

					for(int i = 0; i < pasientListe.stoerrelse(); i++){
						naaPasient = pasientListe.hent(i);
						if(naaPasient.hentNavn().equals(stringPasient)) {
							riktigPasient = naaPasient;
						}
					}

					// Finn reit
					String stringReit = rekkeArray[3];
					int leggTilReit = Integer.parseInt(stringReit);

					if(riktigLege instanceof Lege && riktigMiddel instanceof Legemiddel && riktigPasient instanceof Pasient){
						try{
							riktigLege.skrivBlaaResept(riktigMiddel, riktigPasient, leggTilReit);
						} catch (UlovligUtskrift e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Noe gikk galt.");
					}


			} else {
				System.out.println("Ugyldig tall");
			}
		}
	}

		// E6: Totalt antall utskrevne resepter paa vanedannende legemidler V
    // Totalt antall utskrevne resepter paa narkotiske legemidler
		// Statistikk om mulig misbruk av narkotika skal vises paa følgende maate:
		// List opp navnene paa alle leger (i alfabetisk rekkefølge) som har skrevet ut minst en resept paa narkotiske legemidler, og antallet slike resepter per lege.
		// List opp navnene paa alle pasienter som har minst en gyldig resept paa narkotiske legemidler og, for disse, skriv ut antallet per pasient.
    private static void printStatistikk(){
			System.out.println();
			int antVane = 0;
			int antNark = 0;

			// Totalt antall utskrevne resepter paa vanedannende og narkotisk
			for(int i = 0; i < reseptListe.stoerrelse(); i++) {
				if (reseptListe.hent(i).middelReferanse instanceof Vanedannende)
					antVane += 1;
				else if (reseptListe.hent(i).middelReferanse instanceof Narkotisk)
					antNark += 1;
			}

			System.out.println("Antall vanedannende resepter: " + antVane);
			System.out.println("Antall narkotiske resepter: " + antNark);

			// Navn paa alle leger som har skrevet ut resept paa narkotiske legemidler, og antallet de har skrevet ut
			Koe<Lege> narkLeger = new Koe<>();
			Koe<Integer> antResepter = new Koe<>();
			Lege naaLege;
			int antRes;

			for(int i = 0; i < legeListe.stoerrelse(); i++) {
				naaLege = legeListe.hent(i);
				antRes = 0;
				Resept[] liste = naaLege.hentReseptliste();
				for (Resept j : liste) {
						narkLeger.leggTil(naaLege);
					if(j.hentLegemiddelObjekt() instanceof Narkotisk) {

						antRes += 1;
					}
				}
				antResepter.leggTil(antRes);
			}

			for(int j = narkLeger.stoerrelse(); 0 < j && j == narkLeger.stoerrelse(); j--){
				if(antResepter.hent() > 0) {
					System.out.println(narkLeger.fjern().hentNavn() + " har skrevet ut "  + antResepter.fjern() + " resepter paa narkotiske stoffer.");
				} else{
					narkLeger.fjern();antResepter.fjern();
				}
			}

			// Pasienter med narkotiske resepter, og antallet de har
			Koe<Pasient> narkPasienter = new Koe<>();
			antResepter = new Koe<>();
			Pasient naaPasient;

			for(int i = 0; i < pasientListe.stoerrelse(); i++) {
				naaPasient = pasientListe.hent(i);
				antRes = 0;
				IndeksertListe<Resept> liste = naaPasient.hentReseptListe();
				for (Resept j : liste) {
					if(j.hentLegemiddelObjekt() instanceof Narkotisk) {
						if(antRes == 0) {
							narkPasienter.leggTil(naaPasient);
						}
						antRes += 1;
					}
				}
				antResepter.leggTil(antRes);
			}

			for(int j = 0; j < narkPasienter.stoerrelse(); j++){
				System.out.println(narkPasienter.fjern() + " har "  + antResepter.fjern() + " resepter paa narkotiske stoffer registrert paa sitt navn.");
			}
			System.out.println();
		}
        private static void skrivTilFil(){      // E7
            String filnavn = "datafil.txt"; // evt la bruker besstemme filnavn?
            PrintWriter f = null;
            try {
                f = new PrintWriter(filnavn);
            } catch (Exception e) {
                System.out.println("Klarte ikke opprette filen " + filnavn);
                System.exit(1);
            }

            f.println("# Pasienter (navn, fnr)");
            for(Pasient pasient : pasientListe){
                f.println(pasient.hentNavn() + "," + pasient.hentFNummer());
            }
            f.println("# Legemidler (navn,type,pris,virkestoff,[styrke]");
            for(Legemiddel legemiddel : legemiddelListe){
                String navn = legemiddel.hentNavn();
                String type = "";
                if (legemiddel instanceof Narkotisk){type = "narkotisk";}
                if (legemiddel instanceof Vanedannende){type = "vanedannende";}
                if (legemiddel instanceof Vanlig){type = "vanlig";}
                // evt fange opp hvis legemiddel av en eller annen grunn ikke er noen av delene?
                f.println(navn + "," + type);
            }
            f.println("# Leger (navn,kontrollid / 0 hvis vanlig lege)");
            for(Lege lege : legeListe){
                String navn = lege.hentNavn();
                String kontrollID = "0";
                if (lege instanceof Spesialist){
                    Spesialist spesialist = (Spesialist)lege;
                    kontrollID = spesialist.hentKontrollID();}
                f.println(navn + "," + kontrollID);
            }
            f.println("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])");
            for(Resept resept : reseptListe){
                int legemiddelNummer = resept.hentMiddelID();
                String legeNavn = resept.hentLege();
                int pasientID = resept.hentPasient().hentID();
                int reit = resept.hentReit();
                String type = "";
                if (resept instanceof Blaaresept){type = "blaa";}
                else if (resept instanceof PResept){type = "p";}
                else if (resept instanceof MilResept){type = "militaer";}
                else if (resept instanceof Hvitresept){type = "hvit";}
                // evt fange opp dersom resept av en eller annen grunn ikke passer noen av typene

                f.println(legemiddelNummer + "," + legeNavn + "," + pasientID + "," + type + reit);
        }
    f.close();
    }


    static IndeksertListe<Pasient> pasientListe = new IndeksertListe<>();
    static IndeksertListe<Legemiddel> legemiddelListe = new IndeksertListe<>();
    static IndeksertListe<Lege> legeListe = new IndeksertListe<>();
    static IndeksertListe<Resept> reseptListe = new IndeksertListe<>();

    private static void lesFraFil(String filnavn){ // E1
      Scanner sc = null;
      try {
        sc = new Scanner(new File(filnavn));
      } catch (FileNotFoundException e) {
        System.out.println("Finner ikke" + filnavn);
        return;
      }
      String metodenavn = "";

      while (sc.hasNextLine()){
        String linje = sc.nextLine().strip();
        if ( linje.contains("#")) { //hvis linje da er ny metode
          metodenavn = linje.substring(1);
        } else { // da vil linje f.eks være Jens Hans Olsen,11111143521
          //Koe<String> oppdelt = new Koe<>(); // maa dele opp slik at har de individuelle argumentene som metoden / konstruktør skal ha
          if (metodenavn.contains("Pasienter (navn, fnr)")) {
            String[] delt = linje.split(",");
            Pasient nyPas = new Pasient(delt[0], delt[1]);
            pasientListe.leggTil(nyPas);

          } else if (metodenavn.contains("Legemidler (navn,type,pris,virkestoff,[styrke])")) {
            //maa da sjekke andre ord for aa vite om det er vanedannende, vanlig, narkotisk
            String[] delt = linje.split(",");
            if (delt[1].contains("vanlig")) {
                String navn = delt[0];
                int pris = Integer.parseInt(delt[2]);
                double virkemasse = Double.parseDouble(delt[3]);
                Vanlig nyVanlig = new Vanlig(navn, pris, virkemasse);
                legemiddelListe.leggTil(nyVanlig);
								// System.out.println("La til legemiddel (Vanlig)");

            } else if (delt[1].contains("vanedannende")) {
                String navn = delt[0];
                int pris = Integer.parseInt(delt[2]);
                double virkemasse = Double.parseDouble(delt[3]);
                int styrke = Integer.parseInt(delt[4]);
                Vanedannende nyVane = new Vanedannende(navn, pris, virkemasse, styrke);
                legemiddelListe.leggTil(nyVane);
								// System.out.println("La til legemiddel (Vanedannende)");

            } else if (delt[1].contains("narkotisk")) {
              //public Narkotisk(String navn, int pris, double virkemasse, int styrke){
                String navn = delt[0];
                int pris = Integer.parseInt(delt[2]);
                double virkemasse = Double.parseDouble(delt[3]);
                int styrke = Integer.parseInt(delt[4]);
                Narkotisk nyNarkotika = new Narkotisk(navn, pris, virkemasse, styrke);
                legemiddelListe.leggTil(nyNarkotika);
								// System.out.println("La til legemiddel (Narkotisk)");
            }

          } else if (metodenavn.contains("Leger (navn,kontrollid / 0 hvis vanlig lege)")) {
            String[] delt = linje.split(",");
            //leger, her maa man sjekke kontrollid er 0 eller ikke for aa se om spesialist eller ikke
            if (delt[1].equals("0")) {
              Lege  nyLege = new Lege(delt[0]);
              legeListe.leggTil(nyLege);
            } else {
              Spesialist nySpes = new Spesialist(delt[0], delt[1]);
              legeListe.leggTil(nySpes);
            }

          }else if (metodenavn.contains("Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])")) {
            String[] delt = linje.split(",");
            Lege riktigLege = legeListe.hent(1);// Dette maa endres!!!!
            Legemiddel riktigLegemiddel = legemiddelListe.hent(1);// De skal initieres som nullverdier
            Pasient riktigPasient = pasientListe.hent(1);


            //skal bruke skrivResept i lege, trenger da riktig legeobjekt, riktig legemiddel objekt, pasient objekt
						// Sammenlikne legenavn med listen over alle leger
            for (int i = 0; i < legeListe.stoerrelse(); i++) {
              Lege legeObjekt = legeListe.hent(i);
              if (legeObjekt.hentNavn().contains(delt[1])) {
                riktigLege = legeObjekt;
                break;
              }
            }
						// Sammenlikne legemiddelets navn med listen over alle legemidler
            for (int i = 0; i < legemiddelListe.stoerrelse(); i++) {
              Legemiddel middelObjekt = legemiddelListe.hent(i);
              int legemiddelID = Integer.parseInt(delt[0]);
              if (middelObjekt.hentID() == legemiddelID) {
                riktigLegemiddel = middelObjekt;
                break;
              }
            }
						// Sammenlikne pasientID med listen over alle pasienter
            for (int i = 0; i < pasientListe.stoerrelse(); i++) {
              Pasient pasientObjekt = pasientListe.hent(i);
              int pasID = Integer.parseInt(delt[2]);
              if (pasientObjekt.pasientID == pasID ) { // bytt til hentID()
                riktigPasient = pasientObjekt;
                break;
              }
            }
						//
            if (riktigLege instanceof Lege && riktigLegemiddel instanceof Legemiddel && riktigPasient instanceof Pasient) {
							// for(String i : delt) {
							// 	System.out.print(i + ", ");
							// } System.out.println();
              if (delt[3].contains("p")) {// For P-resepter
                int reit = Integer.parseInt(delt[4]);
                try {
                  Resept nyResept = riktigLege.skrivPResept(riktigLegemiddel, riktigPasient, reit);
                  reseptListe.leggTil(nyResept);
		  riktigPasient.leggTilResept(nyResept); // legger til resepten i pasient-klassens resept liste
									// System.out.println("La til PResept");
                } catch (UlovligUtskrift e) {
                  e.printStackTrace();
                }

              } else if ( delt[3].contains("militaer")) {// For militeerresepter
                try {
                  Resept nyResept = riktigLege.skrivMilResept(riktigLegemiddel, riktigPasient);
                  reseptListe.leggTil(nyResept);
		  riktigPasient.leggTilResept(nyResept); // legger til resepten i pasient-klassens resept liste
									// System.out.println("La til MilResept");
                } catch (UlovligUtskrift e) {
                  e.printStackTrace();
                }

              } else if (delt[3].contains("blaa")) {// For blaaresepter
                try {
                  int reit = Integer.parseInt(delt[4]);
                  Resept nyResept = riktigLege.skrivBlaaResept(riktigLegemiddel, riktigPasient, reit);
		  riktigPasient.leggTilResept(nyResept); // legger til resepten i pasient-klassens resept liste
                  reseptListe.leggTil(nyResept);
									// System.out.println("La til BlaaResept");
                } catch (UlovligUtskrift e) {
                  e.printStackTrace();
                }

              } else if (delt[3].contains("hvit")) {// For hvite resepter
                try {
                  int reit = Integer.parseInt(delt[4]);
                  Resept nyResept = riktigLege.skrivHvitresept(riktigLegemiddel, riktigPasient, reit);
		  riktigPasient.leggTilResept(nyResept); // legger til resepten i pasient-klassens resept liste
                  reseptListe.leggTil(nyResept);
									// System.out.println("La til HvitResept");
                } catch (UlovligUtskrift e) {
                  e.printStackTrace();
                }
              } else{
								System.out.println("Resept" + delt.toString() + "har falt i eter");
							}
            }
          }
        }
      }
      sc.close();
    }

    private static void skrivUtAlternativer(){
        System.out.println("Skriv nummeret til handlingen du vil utfoere + ENTER, eller q + ENTER for aa avslutte programmet");
        System.out.println("1: Skriv ut oversikt over leger, pasienter, legemidler, resepter");
        System.out.println("2: Legg til lege, pasient, resept, legemiddel");
        System.out.println("3: Bruk resept");
        System.out.println("4: Se statistikk");
        System.out.println("5: Skriv alle data til fil");
        System.out.print("");
    }
    public static void main(String[] args) {
      lesFraFil("legedata.txt");

        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (! input.equals("q")){
            skrivUtAlternativer();
            input = scanner.nextLine();
            if (input.equals("1")){printOversikt();}
            if (input.equals("2")){leggTil();}
            if (input.equals("3")){brukResept();}
            if (input.equals("4")){printStatistikk();}
            if (input.equals("5")){skrivTilFil();}
        }
        scanner.close();
        }


	// Deloppgave E4
	// Legg til funksjonalitet for aa la bruker legge til en lege, pasient, resept eller legemiddel. Resepter skal opprettes via en Lege sin skrivResept(). Pass paa at dere sjekker om det er mulig aa lage det ønskede objektet før det opprettes – for eksempel skal det ikke være tillatt aa lage en resept uten en gyldig utskrivende lege. Dersom brukeren oppgir ugyldig informasjon skal de informeres om dette.

	// Lag leger og spesialister
	public static Lege lagLege(String navn) {
		Lege nyLege = new Lege(navn);
		legeListe.leggTil(nyLege);
		return nyLege;
	} public static Spesialist lagSpesialist(String navn, String kontrollID) {
		Spesialist nySpesialist = new Spesialist(navn, kontrollID);
		legeListe.leggTil(nySpesialist);
		return nySpesialist;
	}

	public static Pasient lagPasient(String navn, String fNummer) {
		Pasient nyPasient = new Pasient(navn, fNummer);
		pasientListe.leggTil(nyPasient);
		return nyPasient;
	}

	// Skriv resepter
	// public Hvitresept skrivHvitresept(Legemiddel middel, Pasient pasient, int reit) {
	// 	return this.skrivHvitresept(middel, pasient, reit);
	// } public MilResept skrivMilResept(Legemiddel middel, Pasient pasient) {
	// 	return this.skrivMilResept(middel, pasient);
	// } public PResept skrivPResept(Legemiddel middel, Pasient pasient, int reit) {
	// 	return this.skrivPResept(middel, pasient, reit);
	// } public Blaaresept skrivBlaaresept(Legemiddel middel, Pasient pasient, int reit) {
	// 	return this.skrivBlaaresept(middel, pasient, reit);
	// }

	// Lag legemidler
	public static Vanlig lagVanlig(String navn, int pris, double virkemasse) {
		Vanlig nyttVanlig = new Vanlig(navn, pris, virkemasse);
		return nyttVanlig;
	} public static Vanedannende lagVanedannende(String navn, int pris, double virkemasse, int styrke) {
		Vanedannende nyttVanedannende = new Vanedannende(navn, pris, virkemasse, styrke);
		return nyttVanedannende;
	} public static Narkotisk lagNarkotisk(String navn, int pris, double virkemasse, int styrke) {
		Narkotisk nyttNarkotisk = new Narkotisk(navn, pris, virkemasse, styrke);
		return nyttNarkotisk;
	}

//Deloppgave E5
	//Legger til mulighet til aa bruke et resept

	public static void brukResept(){
    System.out.println(" "); // disse er kun lagt inn fordi jeg syntes det gjør utskriftet mer oversiktlig.
    System.out.println("Hvilken pasient vil du se resepter for?");

    for(int i = 0; i < pasientListe.stoerrelse(); i++) { //iterer gjennom pasientListe og bruker toString metoden for aa skrive ut alle
      System.out.print(i + ": " + pasientListe.hent(i).toString());
    }

    System.out.println(" ");

    Scanner scanlan = new Scanner(System.in);
    int input;
		int pasientIndeks;

    if (scanlan.hasNextInt() == true)
    {
      input = scanlan.nextInt(); //tar inn et heltall



        if (input >= 0 && input < pasientListe.stoerrelse())
          {
            pasientIndeks = input;



           Pasient pasientValgt = pasientListe.hent(pasientIndeks); //henter inn ønsket pasient fra heltallet
           System.out.println("Valgt pasient: " + pasientValgt.toString());
           System.out.println("Antall resepter hos valgt pasient: " + pasientValgt.hentReseptAntall());
           System.out.println(" ");
           System.out.println("Hvilken resept vil du bruke?");


           for(int i = 0; i < pasientValgt.hentReseptAntall(); i++)  //iterer gjennom pasientListe og bruker toString metoden for aa skrive ut alle
          {
            String medisin = pasientValgt.hentReseptListe().hent(i).hentLegemiddel();
            int reit = pasientValgt.hentReseptListe().hent(i).hentReit();
            System.out.print(i + ": " + medisin + " | antall reit: " + reit);
          }
           System.out.println(" ");

           int tastaInn;
           int reseptIndeks;

           if (scanlan.hasNextInt() == true)
          {
            tastaInn = scanlan.nextInt(); //tar inn et heltall



            if (tastaInn >= 0 && tastaInn < pasientValgt.hentReseptAntall())
            {
              reseptIndeks = tastaInn;



           Resept reseptValgt = pasientValgt.hentReseptListe().hent(reseptIndeks);

           reseptValgt.bruk();

           System.out.println(" ");
              }
              else
              {
                System.out.print("Du velger resept ved aa taste inn det heltallet du ser foran reseptlistingen paa skjermen /n" );
              }
            }
            else
            {
              System.out.print("Du velger resept ved aa taste inn det heltallet du ser foran reseptlistingen paa skjermen/n");
            }
          }
          else
          {
          System.out.print("Du velger pasient ved aa taste inn det heltallet du ser foran pasientlistingen paa skjermen /n" );
         }
         }
         else
        {
          System.out.print("Du velger pasient ved aa taste inn det heltallet du ser foran pasientlistingen paa skjermen/n");
        }

      }




}
