public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T>{
    public void leggTil(T x) {
        Node nyNode = new Node(x);
        Node naaNode = start;

        if(start == null) {
            start = nyNode;
            siste = nyNode;
        } else {

            for (int i = 0; i <= stoerrelse(); i++) {
                if(! (naaNode instanceof Node)) {
                    siste.settNeste(nyNode);
                    nyNode.settForrige(siste);
                    siste = nyNode;
                    return;
                }
                if(nyNode.verdi.compareTo(naaNode.verdi) == 0) {
                    naaNode.settNeste(nyNode);
                    nyNode.settForrige(naaNode);
                    if(naaNode == start) {// Ett element
                        start.neste = nyNode;
                        return;
                    } if(naaNode == siste){
                        siste = nyNode;
                        return;
                    }
                    return;

                } else if(nyNode.verdi.compareTo(naaNode.verdi) < 0) {
                    nyNode.settNeste(naaNode);
                    naaNode.settForrige(nyNode);
                    if(naaNode == start){
                        start = nyNode;
                        return;
                    }
                    return;

                }else if(nyNode.verdi.compareTo(naaNode.verdi) > 0 && ! (naaNode.neste instanceof Node)) {
                        nyNode.settForrige(siste);
                        siste.settNeste(nyNode);
                        siste = nyNode;
                        return;
                }

                naaNode = naaNode.neste;
            }
        }
    }
}
