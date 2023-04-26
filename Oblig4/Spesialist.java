public class Spesialist extends Lege implements Godkjenningsfritak{
    String kontrollID;
    public Spesialist(String navn, String kontrollID){
        super(navn);
        this.kontrollID = kontrollID;
    }

    // Hent gitte verdier
    public String toString(){
        return "Navn: " + navn +
        " | ID: " + kontrollID;
    }
    @Override
    public String hentKontrollID(){
        return kontrollID;
    }

		Blaaresept skrivBlaaResept(Legemiddel middel, Pasient pasient, int reit) throws UlovligUtskrift {
			Blaaresept resept = new Blaaresept(pasient, this, reit, middel);
			reseptliste.leggTil(resept);
			return resept;
		}
}
