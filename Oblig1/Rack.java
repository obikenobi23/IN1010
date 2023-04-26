public class Rack {
    public Node[] kabinett = new Node[12];

    public Rack(){
        Node node0 = new Node(0,0);
        for (int i = 0; i < 12; i++)
            kabinett[i] = node0;
    }    

    public boolean leggTilNode(Node objekt) {
        if (objekt.giMinne() <= 1024*4 && objekt.giProsessor() <= 16){
            for (int i = 0; i < 12; i++){
                if (kabinett[i].giMinne() == 0 && kabinett[i].giProsessor() == 0) {
                    kabinett[i] = objekt;
                    return true;
                }
            }
        }
        return false;
    }

    public Node[] hentArray() {
        return kabinett;
    }

    public int antProsessorer(){
        int antProsessorer = 0;
        for (Node
         i:kabinett){
            antProsessorer += i.giProsessor();
        }
        return antProsessorer;
    }

    public int NoderMedNokMinne(int paakrevdMinne){
        int antTreff = 0;
        Node[] array = hentArray();
        for (Node i : array) {//Let gjennom alle noder i alle racks
            if (i.giMinne() >= paakrevdMinne) {
                // System.out.println("Nodetreff");
                antTreff++;
            }
        }
    return antTreff;
    }
}
