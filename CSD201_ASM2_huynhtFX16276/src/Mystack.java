
import java.util.EmptyStackException;

public class Mystack<T> {
    private Node<T> head;
    // Constructor
    public Mystack() {
        this.head = null;
    }
    public boolean isEmpty(){
        return (this.head == null);
    }
    // loại bỏ phần tử ở trong stack
    public T pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        T x = this.head.getInfo();
        this.head = this.head.next;
        return x;
    }
    //thêm phần tử vào trong stack
    public void push(T item){
        head = new Node(item,head);
    }
    //Hàm hiển thị giá trị info
    
    public void display(){
        while(!isEmpty()){
            System.out.println(pop()); 
        }
    }
    // Hàm xóa node
    public void deleteNode(){
        while(this.head != null){
           this.head = this.head.next; 
        }
        
    }
}
