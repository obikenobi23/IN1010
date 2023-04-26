package Oblig3;

public abstract interface Liste<T> {
    int stoerrelse ();
    void leggTil (T x);
    T hent ();
    T fjern ();
}
