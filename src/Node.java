/***
 * created by gp
 */
public class Node {

    private int data;

    private Node next;

    private Node previous;


    public Node(int data) {
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void printNode(Node node){

        System.out.println("node: " + node + " data: " + data + " Previous Node: " + previous + " Next Node: " + next);
    }
}

