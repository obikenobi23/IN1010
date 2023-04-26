public class TestHovedprogram {
    public static void main(String[] args) {
        Node node1 = new Node (4,512);
        Node node2 = new Node(8,1024);
        Dataklynge saga = new Dataklynge();

        for (int i = 0; i < 450; i++)
            saga.plasserNode(node1);

        for (int j = 0; j < 16; j++)
            saga.plasserNode(node2);

        System.out.print("Noder med minst 128 GB: ");
        System.out.println(saga.noderMedNokMinne(128));
        
        System.out.print("Noder med minst 512 GB: ");
        System.out.println(saga.noderMedNokMinne(512));

        System.out.print("Noder med minst 1024 GB: ");
        System.out.println(saga.noderMedNokMinne(1024));

        System.out.print("antProsessorer: ");
        System.out.println(saga.antProsessorer());

        System.out.print("Antall rack: ");
        System.out.println(saga.rekkeLengde());
        
    }
}
