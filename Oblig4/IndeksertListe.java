public class IndeksertListe<T> extends Lenkeliste<T> {

    public void leggTil(int pos, T x){
        Node nyNode = new Node(x);
        // System.out.println(stoerrelse());

        if(0 <= pos && pos <= stoerrelse()){// Sjekk at posisjon er i gyldig område
            Node naaNode = start;
            for (int i = 0; i <= stoerrelse(); i++){// Let igjennom listen

                if (i == pos){// Legg inn node på riktig sted

                    if (stoerrelse() == 0) {// Tom liste
                        start = nyNode;
                        siste = nyNode;
                        // System.out.println("leggTil() tomliste: " + nyNode.verdi);
                        break;

                    } else if (naaNode == start && naaNode == siste && naaNode instanceof Node){// Ett element i listen
                        nyNode.settNeste(naaNode);// Denne må forbedres!!
                        naaNode.settForrige(nyNode);
                        start = nyNode;
                        // System.out.println("leggTil() ingen foran, ingen bak: " + nyNode.verdi);
                        break;

                    } else if(naaNode == start && naaNode instanceof Node) {// Sett inn start i lengre liste
                        nyNode.settNeste(naaNode);
                        naaNode.settForrige(nyNode);
                        start = nyNode;
                        // System.out.println("leggTil() start i lengre liste " + nyNode.verdi);
                        break;

                    } else if (naaNode instanceof Node && naaNode.forrige instanceof Node){// Ett element foran
                        // Bind inn nyNode
                        nyNode.settNeste(naaNode);
                        nyNode.settForrige(naaNode.forrige);
                        // Koble opp andre noder
                        naaNode.forrige.settNeste(nyNode);
                        naaNode.settForrige(nyNode);
                        // System.out.println("leggTil() har foran: " + nyNode.verdi);
                        break;

                    // } else if (naaNode == null) {
                    //     nyNode.settForrige(siste);
                    //     siste.settNeste(nyNode);
                    //     siste = nyNode;
                    //     System.out.println("leggTil() etter siste node " + nyNode.verdi);

                    } else {
                        // System.out.println("Feilmelding: leggTil() mislyktes.");
                        break;
                    }
                }

                if (naaNode.neste instanceof Node)
                    naaNode = naaNode.neste;
                else {
                    nyNode.settForrige(siste);
                    siste.settNeste(nyNode);
                    siste = nyNode;
                    // System.out.println("leggTil() etter siste node " + nyNode.verdi);
                    return;
                }
            }

        } else{
            throw new UgyldigListeindeks(pos);
        }
    }

    public void leggTil(T x) {

        Node nyNode = new Node(x);

        if (start==null){// Tom liste
            start = nyNode;
            siste = nyNode;
            // System.out.println("leggTil() ingen indeks " + nyNode.verdi);
            return;
        }
        if (start.neste == null) {// Liste med ett element
            start.neste = nyNode;
            nyNode.forrige = start;
            siste = nyNode;
            // System.out.println("leggTil() ingen indeks " + nyNode.verdi);
            return;
        }
        siste.neste = nyNode;
        nyNode.forrige = siste;
        siste = nyNode;
        // System.out.println("leggTil() ingen indeks " + nyNode.verdi);
    }


    public void sett(int pos, T x){
        Node nyNode = new Node(x);
        Node naaNode = start;
        if(0 <= pos && pos < stoerrelse()){
            for (int i = 0; i <= pos; i++){
                if(i == pos && naaNode instanceof Node){
                    // Legg inn foskjellige tilfeller: .neste og .forrige
                    if(naaNode == start && naaNode == siste) {
                        nyNode = start;
                        nyNode = siste;
                    }
                    else if(naaNode == start) {// Første element
                        nyNode.settNeste(start.neste);
                        start.neste.settForrige(nyNode);
                        nyNode = start;
                    } else if(naaNode == siste) {
                        siste.forrige.settNeste(nyNode);
                        nyNode.settForrige(siste.forrige);
                        nyNode = siste;
                    } else if(naaNode.neste instanceof Node && naaNode.forrige instanceof Node) {
                        nyNode.settNeste(naaNode.neste);
                        nyNode.settForrige(naaNode.forrige);

                        naaNode.neste.settForrige(nyNode);
                        naaNode.forrige.settNeste(nyNode);

                        if(naaNode.forrige == start) {
                            start.settNeste(nyNode);
                        } else if (naaNode.neste == siste) {
                            siste.settForrige(nyNode);
                        }
                    }
                    // naaNode = nyNode;
                    break;
                }
                naaNode=naaNode.neste;
            }
        } else
            throw new UgyldigListeindeks(pos);
    }

    public T hent(int pos){
        Node naaNode=start;
        if(0 <= pos && pos < stoerrelse()){
            for (int i = 0; i <= pos; i++){
                if(i==pos){
                    return naaNode.verdi;
                }
                naaNode=naaNode.neste;
            }
        }
    return null;
    }

    public T fjern(int pos){
        Node naaNode=start;

        if(0 <= pos && pos < stoerrelse()){
            for (int i = 0; i <= pos; i++){
                if(i == pos){
                    if(naaNode.neste instanceof Node && naaNode.forrige instanceof Node) {
                        naaNode.forrige.settNeste(naaNode.neste);
                        naaNode.neste.settForrige(naaNode.forrige);
                        // System.out.println("fjern()  mellom to " + naaNode);
                        return naaNode.verdi;
                    } else if(naaNode.neste instanceof Node) {
                        naaNode.neste.settForrige(null);
                        naaNode = start;
                        // System.out.println("fjern() " + naaNode.verdi);
                        return naaNode.verdi;
                    } else if(naaNode.forrige instanceof Node) {
                        naaNode.forrige.settNeste(null);
                        naaNode = siste;
                        // System.out.println("fjern() " + naaNode.verdi);
                        return naaNode.verdi;
                    } else
                        // System.out.println("Fant ikke indeks");
                        throw new UgyldigListeindeks(pos);

                }
                naaNode = naaNode.neste;
            }
        } else
            throw new UgyldigListeindeks(pos);
    // System.out.println("fjern() pos " + pos + " virket ikke");
    return null;
    }
}
