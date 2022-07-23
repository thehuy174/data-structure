
public class Mylist<T> {
    public Node<T> head;
    private Node<T> tail;
    // Constructor
    public Mylist() {
    }

    public Mylist(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }
    // get và set
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    
    public boolean isEmpty(){
        return(head == null);
    }
    // thêm phần tử vào tail
    public void insertToTail(T item){
        Node<T> newNode = new Node<T>(item);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
    }
    // xóa node
    public void deleteNode(){
        while(this.head != null){
           this.head = this.head.getNext(); 
        } 
    }
    //Hàm hiển thị giá trị info của node p
    public void visit(Node<T> p){
        System.out.println(p.getInfo());
    }
    
    // Hàm in thông tin sản phẩm
    public void display(){
        Node<T> current = head;
        while (current != null) {           
            visit(current);
            current = current.getNext();
        }
    }
    
}
