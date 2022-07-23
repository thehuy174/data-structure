
public class Myqueue<T> {
    private Node<T> head;
    private Node<T> tail;
    // Constructor
    public Myqueue(){
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty(){
        return (this.head == null);
    }
    // xóa phần tử khỏi hàng đợi
    public T deQueue() throws Exception{
        if(isEmpty()) throw new Exception();
        T x = this.head.getInfo();
        this.head = this.head.next;
        if(this.head == null){
            this.tail = null;
        }
        return x;
    }
    // thêm 1 phần tử vào hàng đợi.
    public void enQueue(T item){
        Node<T> newNode = new Node<T>(item);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
    }
    //Hàm hiển thị giá trị info
    
    public void display() throws Exception{
        while(!isEmpty()) {
            System.out.println(deQueue()); 
        }
    }
    // xóa node
    public void deleteNode(){
        while(this.head != null){
           this.head = this.head.next; 
        }
        
    }
    
}
