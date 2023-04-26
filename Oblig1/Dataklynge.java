import java.util.ArrayList;

public class Dataklynge {
    // public static ArrayList<Rack> klynge;

    ArrayList<Rack> klynge = new ArrayList<Rack>();
    
    // public Dataklynge(){

    // }
    
    public int antProsessorer() {
        int maksProsessor = 0;
        for (Rack i:klynge) {
            i.antProsessorer();

        }
        return maksProsessor;
    }
    
    public int noderMedNokMinne(int paakrevdMinne){
        int antTreff = 0;
        for (Rack i : klynge) {
            antTreff += i.NoderMedNokMinne(paakrevdMinne);
        }
        return antTreff;
    }

    // public void leggTilRack(Rack rekke) {
    //     klynge.add(rekke);
    // }

    public boolean plasserNode(Node objekt) {
        boolean erLagtTil = false;
        for (int i = 0; i < klynge.size(); i++) { //Let gjennom alle Rack-objektene
            if (klynge.get(i).leggTilNode(objekt)) {
                erLagtTil = true;
                return true; //Bryt metoden etter noden er lagt inn
            } //Legg til noden på et tomt sted
        }

        //Hvis dataklyngen er full, legg en ny rack. Så, legg til noden der.
        Rack nyRack = new Rack();
        klynge.add(nyRack);
        nyRack.leggTilNode(objekt);
        erLagtTil = true;
        return true;
    }

    public int rekkeLengde(){
        return klynge.size();
    }
}
