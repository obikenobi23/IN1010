public class PResept extends Hvitresept{
    public PResept(Pasient pasient, Lege utskrivendeLege, int reit, Legemiddel middelReferanse){
        super(pasient, utskrivendeLege, reit, middelReferanse);
        if (middelReferanse.hentPris() >= 108){
            rabatt = 108;
        } else{
            rabatt = middelReferanse.hentPris();
        }
    }

		@Override
		public String farge() {
			return "Hvit resept (Presept)";
		}
}
