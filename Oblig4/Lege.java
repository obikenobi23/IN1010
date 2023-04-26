public class Lege implements Comparable<Lege>{
    protected String navn;
    IndeksertListe<Resept> reseptliste = new IndeksertListe<>();
    public Lege(String navn){
        this.navn = navn;
    }

    // Hent gitte verdier
    public String hentNavn(){return navn;}
    public String toString(){return "Navn: " + navn;}

    // Hent info fra reseptlisten
    public Resept[] hentReseptliste() {
        Resept[] array = new Resept[reseptliste.stoerrelse()];
        for (int i = 0; i < array.length; i++) {
            array[i] = reseptliste.hent(i);
        }
        return array;
    }

    public Resept hentResept(int indeks) {
        Resept riktigResept = reseptliste.hent(indeks);
        return riktigResept;
    }

    // Sortering
    @Override
    public int compareTo(Lege lege) {
				String subjektNavn = this.navn;
				String objektNavn = lege.navn;
        char[] subjekt = new char[subjektNavn.length()];
        char[] objekt = new char[objektNavn.length()];

				for(int i = 0; i < subjektNavn.length(); i++) {// Del navnet som skal sammenliknes
					subjekt[i] = subjektNavn.charAt(i);
				}
				for(int i = 0; i < objektNavn.length(); i++) {// Del navnet som kommer fra parametret
					objekt[i] = lege.navn.charAt(i);
				}

        for (int i = 0; i < subjekt.length; i++) {
					if(subjekt[i] < objekt[i]) {
						return 1;
					} else if(subjekt[i] > objekt[i]) {
						return -1;
					}
        }
        return 0;
    }

		
		// Opprette resepter
		Hvitresept skrivHvitresept(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift {
			if(middel instanceof Narkotisk) {
				throw new UlovligUtskrift(this, middel);
			}
			Hvitresept resept = new Hvitresept(pasient, this, reit, middel);
			reseptliste.leggTil(resept);
			return resept;
		}
		MilResept skrivMilResept(Legemiddel middel, Pasient pasient) throws UlovligUtskrift {
			if(middel instanceof Narkotisk) {
				throw new UlovligUtskrift(this, middel);
			}
			MilResept resept = new MilResept(pasient, this, middel);
			reseptliste.leggTil(resept);
			return resept;
		}
		PResept skrivPResept(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift {
			if(middel instanceof Narkotisk) {
				throw new UlovligUtskrift(this, middel);
			}
			PResept resept = new PResept(pasient, this, reit, middel);
			reseptliste.leggTil(resept);
			return resept;
		}

		Blaaresept skrivBlaaResept(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift {
			if(middel instanceof Narkotisk) {
				throw new UlovligUtskrift(this, middel);
			}
			Blaaresept resept = new Blaaresept(pasient, this, reit, middel);
			reseptliste.leggTil(resept);
			return resept;
		}
}
