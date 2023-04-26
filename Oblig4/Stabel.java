public class Stabel<T> extends Lenkeliste<T> {
    // Legg til elementer foran i listen
    @Override
    public void leggTil(T x){
        Node nyNode = new Node(x);
        if(start==null){
            start = nyNode;
            siste = nyNode;
            return;
        }
        Node flyttet = start;// Lagre noden som skal erstattes
        start=nyNode;// Erstatt
        start.neste=flyttet;// Samme som over
        flyttet.forrige=start;// Knytt gamle første til nye første
    }
}
