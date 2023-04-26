package Oblig2;

public class Hovedprogram {
    public static void main(String[] args) {
        // Opprett objekter
        Vanlig Paracet = new Vanlig("Paracet", 49, 20.0d);
        Vanedannende SangeneFraFrozen = new Vanedannende("Sanger", 99, 35.0d, 10000);
        Narkotisk Morfin = new Narkotisk("Morfin", 0, 45.0d, 10);
    
        Lege Jens = new Lege("Jens");
        Spesialist Maren = new Spesialist("Maren", "Ja");

        MilResept ForInfluensa = new MilResept(42, Jens, Paracet);
        PResept SikkertUlovlig = new PResept(16, Maren, 5, Morfin);
        Blaaresept blaa = new Blaaresept(420, Jens, 666, Paracet);

        // Skriv ut info om objektene
        System.out.println(Jens.toString());
        System.out.println(Maren.toString());

        System.out.println(Paracet.toString());
        System.out.println(SangeneFraFrozen.toString());
        System.out.println(Morfin.toString());

        System.out.println(ForInfluensa.toString());
        System.out.println(SikkertUlovlig.toString());
        System.out.println(blaa.toString());
    }
}
