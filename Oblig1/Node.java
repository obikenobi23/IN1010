public class Node {
    private int pros;
    private int minne;

    public Node(int prosessorer, int minnestoerelse) {
        pros = prosessorer;
        minne = minnestoerelse;
    }
    
    public int giProsessor() {
        return pros;
    }

    public int giMinne() {
        return minne;
    }
}
