
import java.util.Scanner;


public class ASM2_Main {
    static Scanner sc = new Scanner(System.in);
    // Hàm hiển thị menu
    public static void showMenu() {

    System.out.println("Choose one of this options:");

    System.out.println("Product list:");

    System.out.println("1. Load data from file and display");

    System.out.println("2. Input & add to the end.");

    System.out.println("3. Display data");

    System.out.println("4. Save product list to file.");

    System.out.println("5. Search by ID");

    System.out.println("6. Delete by ID");

    System.out.println("7. Sort by ID.");

    System.out.println("8. Convert to Binary");

    System.out.println("9. Load to stack and display");

    System.out.println("10. Load to queue and display.");

    System.out.println("0. Exit");

    }
    // Hàm hiển thị title
    public static void title(){
        System.out.printf("%7s |%20s |%15s |%15s ","ID", "Title", "Quantity", "price");
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
    }
    // Hàm add sản phẩm mới
    public static void addProduct(Mylist<Product> list){
        System.out.print("Input new ID: ");
        String id = sc.next();
        System.out.print("Input Product's Name: ");
        String name = sc.next();
        System.out.print("Input Product's quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Input Product's price: ");
        double price = sc.nextDouble();
        System.out.println("complete");
        System.out.println();
        list.insertToTail(new Product(id, name, quantity, price));
    }
    // Luồng chính chạy chương trình
    public static void main(String[] args) throws Exception {
        
        // Lưu lại tất cả output in ra màn hình vào file console_output.txt.
        System.setOut(new DoublePrintStream(System.out, "src/console_output.txt"));
        
        try { throw new RuntimeException("oulala");} catch(RuntimeException e) {}

        String fileName = "src/data.txt";
        // Tạo instance
        Mylist<Product> list = new Mylist<>();
        Mystack<Product> stack = new Mystack<>();
        Myqueue<Product> queue = new Myqueue<>();
        OperationToProduct op = new OperationToProduct();
        // Thực hiện chức năng chương trình
        do {  
            System.out.println();
            showMenu();
            System.out.print("choice: ");
            int choice = sc.nextInt();
            if(choice == 0){
                System.out.println("Good bye !");
                break;
            }
            switch (choice) {
                case 1:
                    list.deleteNode();
                    op.getAllItemsFromFile(fileName, list);
                    title();
                    list.display();
                    System.out.println();
                    break;
                case 2:
                    addProduct(list);
                    break;
                case 3:
                    title();
                    list.display();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    op.writeAllItemsToFile(fileName, list);
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.print("Input the ID to search : ");
                    String id = sc.next();
                    System.out.println();
                    System.out.print("Result: ");
                    String str = op.searchByCode(list, id);
                    System.out.println(str);
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    System.out.print("Input the ID to delete : ");
                    String deleteID = sc.next();
                    System.out.println();
                    op.deleteByCode(list, deleteID);
                    System.out.print("Deleted! ");
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
                    op.sortByCode(list.getHead());
                    System.out.println("Successfully!");
                    System.out.println();
                    break;
                case 8:
                    System.out.println();
                    System.out.print("Quantity: " + list.getHead().getInfo().getQuantity() + " => " + "(");
                    op.convertToBinary(list.getHead().getInfo().getQuantity());
                    System.out.print(")");
                    System.out.println();
                    break;
                case 9:
                    System.out.println();
                    stack.deleteNode();
                    op.getAllItemsFromFile(fileName, stack);
                    title();
                    stack.display();
                    System.out.println();
                    break;
                case 10:
                    System.out.println();
                    queue.deleteNode();
                    op.getAllItemsFromFile(fileName, queue);
                    title();
                    queue.display();
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (true);
 
        
    }
}
