

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.spec.NamedParameterSpec;
import java.util.Scanner;
import java.util.stream.Stream;

public class OperationToProduct {
    Node node = new Node();
    String[] arr = new String[0];
    Scanner sc = new Scanner(System.in);
    // Hàm đọc từ file lưu vào list
    public void getAllItemsFromFile(String fileName, Mylist<Product> list) {
        
        try(Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.UTF_8)){//đưa về dạng chuẩn utf8
            stream.forEach(line ->{
                //line là từng dòng trong file

                arr = line.trim().split(", ");
                String bcode = arr[0];
                String title = arr[1];
                String quantity = arr[2];
                String price = arr[3];
                // thêm vào list
                list.insertToTail(new Product(bcode, title, Integer.parseInt(quantity), Double.parseDouble(price)));

            });
            System.out.println("complete");
        } catch (Exception e) {
            System.out.println("Read file failed");;
        }
    }
    // hàm đọc từ file lưu vào stack
    public void getAllItemsFromFile(String fileName, Mystack<Product> stack) {
        try(Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.UTF_8)){//đưa về dạng chuẩn utf8
            stream.forEach(line ->{
                //line là từng dòng trong file

                arr = line.trim().split(", ");
                String bcode = arr[0];
                String title = arr[1];
                String quantity = arr[2];
                String price = arr[3];
                // thêm vào stack
                stack.push(new Product(bcode, title, Integer.parseInt(quantity), Double.parseDouble(price)));

            });
            System.out.println("complete");
        } catch (Exception e) {
            System.out.println("Read file failed");;
        }
    }
    // hàm đọc từ file lưu vào queue
    public void getAllItemsFromFile(String fileName, Myqueue<Product> queue){
        try(Stream<String> stream = Files.lines(Paths.get(fileName),StandardCharsets.UTF_8)){//đưa về dạng chuẩn utf8
            stream.forEach(line ->{
                //line là từng dòng trong file

                arr = line.trim().split(", ");
                String bcode = arr[0];
                String title = arr[1];
                String quantity = arr[2];
                String price = arr[3];
                // thêm vào queue
                queue.enQueue(new Product(bcode, title, Integer.parseInt(quantity), Double.parseDouble(price)));

            });
            System.out.println("complete");
        } catch (Exception e) {
            System.out.println("Read file failed");;
        } 
    }
    
    
    // Hàm ghi dữ liệu vào file
    public void writeAllItemsToFile(String fileName, Mylist<Product> list){
        
        try (FileWriter fw = new FileWriter(new File(fileName), StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(fw)) {
            Node<Product> current = list.getHead();
            while(current != null){
                writer.write(current.getInfo().getBcode() + ", ");
                writer.write(current.getInfo().getTitle() + ", ");
                writer.write(current.getInfo().getQuantity() + ", ");
                writer.write(current.getInfo().getPrice() + "");
                writer.write("\n");
                current = current.getNext();
            }
            writer.flush();
            fw.close();
            writer.close();
            System.out.println("Successfully!");
        }catch (Exception e){
            System.out.println("File write failed");
        }
    }
    //Hàm tìm kiếm sản phẩm theo ID
    public String searchByCode(Mylist<Product> list, String id){
        Node<Product> current = list.head;
        
        while(current != null){
            if(current.getInfo().getBcode().equals(id)){
                return String.format("%10s |%15s |%10d |%10.1f", current.getInfo().getBcode(),
                        current.getInfo().getTitle(), current.getInfo().getQuantity(), current.getInfo().getPrice());
            }
            current = current.getNext();
        }
        return String.format("%s", -1);
    }
    //Hàm xóa sản phẩm theo ID
    public void deleteByCode(Mylist<Product> list, String id){
         
        Node<Product> temp = list.getHead(), prev = null; 
      
        // Nếu node head bằng id thì xóa
        if (temp != null && temp.getInfo().getBcode().equals(id)){ 
            list.head = list.head.next; // chuyển node head 
   
        // Tìm kiếm phần tử cần xóa
        }else {
            while (temp != null && temp.getInfo().getBcode().equals(id) == false){
            prev = temp; 
            temp = temp.next; 
            }
            // Nếu không có id trong danh sách thì return 
            if (temp == null) return; 

            // Bỏ liên kết nút khỏi danh sách 
            prev.next = temp.next;
        }
    }
    // Hàm sắp xếp sản phẩm theo ID
    public void sortByCode(Node<Product> current){
        if(current != null){
            Node<Product> currentNext = current.getNext();
    
            while(currentNext != null){
                if(current.getInfo().getBcode().compareTo(currentNext.getInfo().getBcode()) > 0){
                    Product temp = current.getInfo();
                    current.setInfo(currentNext.getInfo());
                    currentNext.setInfo(temp);
                }
                currentNext = currentNext.getNext();
            }
            sortByCode(current.getNext());
        }
    }
    // Hàm thuật toán chuyển đổi 1 số nguyên ở hệ đếm thập phân sang nhị phân ( Ta chia liên tiếp số nguyên
    // đó cho 2 đến bao giờ thương bằng 0 thì dừng lại, kết quả của phép chuyển đổi là phần dư của các phép
    // chia theo thứ tự ngược lại)
    public void convertToBinary(int x){
        int num = 0;
        if(x == 0) {
            return;
        }else {
            num = x % 2;
            convertToBinary(x/2);
            System.out.print(num);
        }
    }
}

