package Oblig2;

public class Spesialist extends Lege implements Godkjenningsfritak{
    String kontrollID;
    public Spesialist(String navn, String kontrollID){
        super(navn);
        this.kontrollID = kontrollID;
    }

    // Hent gitte verdier
    public String toString(){
        return "Navn: " + navn + 
        ". ID: " + kontrollID;
    }
    @Override
    public String hentKontrollID(){
        return kontrollID;
    }
}
