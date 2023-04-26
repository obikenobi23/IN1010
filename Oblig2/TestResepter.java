package Oblig2;

public class TestResepter {
    public static void main(String[] args) {
        //Nødvendige objekter for å teste resepter
        Lege Jens = new Lege("Jens");
        Vanlig Paracet = new Vanlig("Paracet", 40, 20.0d);
        Vanedannende Opiat = new Vanedannende("Opiat", 500, 35.5d, 3);

        

        // Test MilResept
        MilResept ForInfluensa = new MilResept(42, Jens, Paracet);

        System.out.println("Tester MilResept...");
        
        if (ForInfluensa.hentPasientID() == 42 && 
            ForInfluensa.hentLege() == "Jens" &&
            ForInfluensa.hentLegemiddel() == "Paracet" && 
            ForInfluensa.hentReit() == 3 &&
            ForInfluensa.erGyldig() == true) {
                System.out.println("Parametre stemmer. Reit og gyldig stemmer.");
        } else {
            System.out.println("Enten parameter, reit eller gyldig stemmer ikke.");
        }

        ForInfluensa.bruk();
        ForInfluensa.bruk();
        ForInfluensa.bruk();

        if(ForInfluensa.erGyldig() == false) {
            System.out.println("Bruk virker.");
        } else {
            System.out.println("Bruk virker ikke.");
        }

        ForInfluensa.ookReit(1);

        if(ForInfluensa.erGyldig() == true && ForInfluensa.hentReit() == 1) {
            System.out.println("Øke reit virker.");
        } else {
            System.out.println("Øke reit virker ikke.");
        }

        if(ForInfluensa.farge() == "Hvit resept" &&
            ForInfluensa.prisAaBetale() == 0) {
                System.out.println("Farge og pris å betale virker.");
        } else {
            System.out.println("Farge eller pris å betale virker ikke.");
        }

        System.out.println();
        System.out.println();




        // Test PRestept
        PResept idk = new PResept(16, Jens, 5, Opiat);

        System.out.println("Tester PResept...");

        if (idk.hentPasientID() == 16 && 
        idk.hentLege() == "Jens" &&
        idk.hentLegemiddel() == "Opiat" && 
        idk.hentReit() == 5 &&
        idk.erGyldig() == true) {
            System.out.println("Parametre stemmer. Reit og gyldig stemmer.");
        } else {
            System.out.println("Enten parameter, reit eller gyldig stemmer ikke.");
        }

        for (int i = 0; i < 5; i++) {
            idk.bruk();
        }

        if(idk.erGyldig() == false) {
            System.out.println("Bruk virker.");
        } else {
            System.out.println("Bruk virker ikke.");
        }

        idk.ookReit(1);

        if(idk.erGyldig() == true && idk.hentReit() == 1) {
            System.out.println("Øke reit virker.");
        } else {
            System.out.println("Øke reit virker ikke.");
        }

        if(idk.farge() == "Hvit resept" &&
        idk.prisAaBetale() == 500 - 108) {
                System.out.println("Farge og pris å betale virker.");
        } else {
            System.out.println("Farge eller pris å betale virker ikke.");
        }

        System.out.println();
        System.out.println();





        // Test Baaresept
        Blaaresept blaa = new Blaaresept(420, Jens, 666, Paracet);

        System.out.println("Test Blaaresept");

        if (blaa.hentPasientID() == 420 && 
        blaa.hentLege() == "Jens" &&
        blaa.hentLegemiddel() == "Paracet" && 
        blaa.hentReit() == 666 &&
        blaa.erGyldig() == true) {
            System.out.println("Parametre stemmer. Reit og gyldig stemmer.");
        } else {
            System.out.println("Enten parameter, reit eller gyldig stemmer ikke.");
        }

        for (int i = 0; i < 666; i++) {
            blaa.bruk();
        }

        if(blaa.erGyldig() == false) {
            System.out.println("Bruk virker.");
        } else {
            System.out.println("Bruk virker ikke.");
        }

        blaa.ookReit(1);

        if(blaa.erGyldig() == true && blaa.hentReit() == 1) {
            System.out.println("Øke reit virker.");
        } else {
            System.out.println("Øke reit virker ikke.");
        }

        if(blaa.farge() == "Blå resept" &&
        blaa.prisAaBetale() == 40 * 0.25f) {
            System.out.println("Farge og pris å betale virker.");
        } else {
            System.out.println("Farge eller pris å betale virker ikke.");
        }
    }
}
