import java.util.Iterator;

abstract class Lenkeliste<T> implements Liste<T> {
    // Definér Node
    protected Node start, siste;

    protected class Node {
        Node neste, forrige;
        T verdi;

        public Node(T verdi) {
            this.verdi = verdi;
        }

        void settNeste(Node n) {
            this.neste = n;
        }

        void settForrige(Node n){
            this.forrige = n;
        }
    }

    public class LenkelisteIterator implements Iterator<T>{
        private Node naaNode = start;
        @Override
        public boolean hasNext(){
            return naaNode != null;
        }
        @Override
        public T next(){
            Node returNode = naaNode;
            naaNode = naaNode.neste;
            return returNode.verdi;
        }
    }
    
    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }

    // Gi størrelsen til lista
    public int stoerrelse(){
        Node node = start;
        int stoerrelse = 0;
        while (node instanceof Node){
            stoerrelse++;
            node = node.neste;
        }
        return stoerrelse;
    }

    // Legg til et nytt element i slutten av lista
    public void leggTil(T x){
        Node nyNode = new Node(x);

        if (start==null){// Tom liste
            start = nyNode;
            siste = nyNode;
            return;
        }
        if (start.neste == null) {// Liste med ett element
            start.neste = nyNode;
            nyNode.forrige = start;
            siste = nyNode;
            return;
        }
        siste.neste = nyNode;
        nyNode.forrige = siste;
        siste = nyNode;
    }

    // Hent det første elementet i lista
    public T hent(){
        return start.verdi;
    }

    // Fjern det første elementet i lista
    public T fjern() {

        if (start == null) {// Tom liste
            throw new UgyldigListeindeks(-1);
        } else if (start.neste == null) {// Ett element i liste
            Node fjernet = start;
            start = null;
            siste = null;
            return fjernet.verdi;
        } else if (start.neste == siste) {//To elementer i liste
            Node fjernet = start;
            start = siste;
            start.settNeste(null);
            siste.settForrige(null);
            return fjernet.verdi;
        } else if (start.neste instanceof Node) {// Fler enn to elementer i liste
            Node fjernet = start;
            start = start.neste;
            return fjernet.verdi;
        }

        throw new UgyldigListeindeks(-1);
    }

    public String toString() {
        Node nesteNode = start;
        String streng = "";

        while (nesteNode instanceof Node){
            streng += nesteNode.toString() + " ";
        }
        return streng;
    }
}
