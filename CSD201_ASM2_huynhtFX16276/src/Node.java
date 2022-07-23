
public class Node<T> {
    private T info;
    public Node next;
    // Constructor
    public Node(T item) {
        this.info = item;
    }
    public Node(){
        
    }
    
    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }
    //get và set
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
