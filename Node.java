public class Node {
    
    public double xCord;
    public double yCord;
    public Node next;

    public Node (double x, double y, Node next) {
        xCord = x;
        yCord = y;
        this.next = next;
    }
}
