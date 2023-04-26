package Oblig2;

public class TestLegemiddel {
    public static void main(String[] args) {
        //Test av klassen Vanlig
        Vanlig Paracet = new Vanlig("Paracet", 49, 20.0d);

        System.out.println("Tester Vanlig...");

        if(Paracet.hentNavn() == "Paracet") {
            System.out.print("Riktig navn. ");
        } else {
            System.out.print("Feil navn. ");
        }

        if(Paracet.hentID() == 1 && 
            Paracet.hentPris() == 49 && 
            Paracet.hentVirkestoff() == 20.0) {
            System.out.println("Riktig ID, pris og virkemasse.");
        } else {
            System.out.println("Feil ID, pris eller virkemasse");
        }

        Paracet.settNyPris(30);

        if(Paracet.hentPris() == 30) {
            System.out.println("Prisendring virker.");
        } else {
            System.out.println("Prisendring virker ikke.");
        }

        if(Paracet.beskrivelse() == "Jeg er et \"vanlig\" legemiddel.") {
            System.out.println("Beskrivelse virker.");
        } else {
            System.out.println("Beskrivelse virker ikke.");
        }

        System.out.println(Paracet.toString());

        System.out.println();
        System.out.println();



        //Test av klassen Vanedannende
        Vanedannende SangeneFraFrozen = new Vanedannende("Sanger", 99, 35.0d, 10000);

        System.out.println("Tester Vanedannende...");

        if(SangeneFraFrozen.hentNavn() == "Sanger") {
            System.out.print("Riktig navn. ");
        } else {
            System.out.print("Feil navn. ");
        }

        if(SangeneFraFrozen.hentID() == 2 && 
        SangeneFraFrozen.hentPris() == 99 && 
        SangeneFraFrozen.hentVirkestoff() == 35.0 &&
        SangeneFraFrozen.hentVanedannendeStyrke() == 10000) {
            System.out.println("Riktig ID, pris, virkemasse og styrke.");
        } else {
            System.out.println("Feil ID, pris, virkemasse eller styrke");
        }

        SangeneFraFrozen.settNyPris(5000);

        if(SangeneFraFrozen.hentPris() == 5000) {
            System.out.println("Prisendring virker.");
        } else {
            System.out.println("Prisendring virker ikke.");
        }

        if(SangeneFraFrozen.beskrivelse() == "Jeg er et vanedannende legemiddel.") {
            System.out.println("Beskrivelse virker.");
        } else {
            System.out.println("Beskrivelse virker ikke.");
        }

        System.out.println(SangeneFraFrozen.toString());

        System.out.println();
        System.out.println();

        // Tester klassen Narkotisk
        Narkotisk Morfin = new Narkotisk("Morfin", 0, 45.0d, 10);

        System.out.println("Tester Narkotisk...");

        if(Morfin.hentNavn() == "Morfin") {
            System.out.print("Riktig navn. ");
        } else {
            System.out.print("Feil navn. ");
        }

        if(Morfin.hentID() == 3 && 
        Morfin.hentPris() == 0 && 
        Morfin.hentVirkestoff() == 45.0 &&
        Morfin.hentNarkotiskStyrke() == 10) {
            System.out.println("Riktig ID, pris, virkemasse og styrke.");
        } else {
            System.out.println("Feil ID, pris, virkemasse eller styrke");
        }

        Morfin.settNyPris(420);

        if(Morfin.hentPris() == 420) {
            System.out.println("Prisendring virker.");
        } else {
            System.out.println("Prisendring virker ikke.");
        }

        if(Morfin.beskrivelse() == "Jeg er et narkotisk stoff.") {
            System.out.println("Beskrivelse virker.");
        } else {
            System.out.println("Beskrivelse virker ikke.");
        }

        System.out.println(Morfin.toString());

    }
}
