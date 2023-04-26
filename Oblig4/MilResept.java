public class MilResept extends Hvitresept{
    public MilResept(Pasient pasient, Lege utskrivendeLege, Legemiddel middelReferanse){
        super(pasient, utskrivendeLege, 3, middelReferanse);
        rabatt = middelReferanse.hentPris();
        this.reit = 3;
    }

		@Override
		public String farge() {
			return "Hvit resept (militaer)";
		}
}
