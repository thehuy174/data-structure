import java.util.Scanner;

public class Main_Sort {
    //Main stream controls the program
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Algorithm algorithm = new Algorithm();
        //Display the program menu
        int n = 0;
        while (true) {
            algorithm.menu();
            System.out.print("Choice : ");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("good bye !");
                break;
            }
            String fileName = "../INPUT.txt";
            String fileName1 = "../OUTPUT1.txt";
            String fileName2 = "../OUTPUT2.txt";
            String fileName3 = "../OUTPUT3.txt";
            //select the function
            switch (choice){
                case 1: //Enter an array element
                    do {
                        System.out.print("Input number of elements (number <= 20): ");
                        n = algorithm.length();
                    }while (n < 0 || n > 20);
                    double[] arr = new double[n];
                    System.out.println("Input Elements:");
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = sc.nextDouble();
                    }
                    algorithm.writeFile(fileName, arr);
                    break;
                case 2: // Write to file
                    System.out.println("Read from file");
                    System.out.print("Array a: ");
                    double[] a = algorithm.readFile(fileName, n);
                    algorithm.display(a);
                    System.out.println();
                    break;
                case 3: // bubble sort
                    System.out.println("Bubble sort");
                    a =  algorithm.readFile(fileName, n);
                    double[] b = algorithm.bubbleSort(a);
                    algorithm.writeFileOutput(fileName1, b);
                    break;
                case 4: // selection sort
                    System.out.println("Selection sort");
                    a =  algorithm.readFile(fileName, n);
                    double[] s = algorithm.selectionSort(a);
                    algorithm.writeFileOutput(fileName2, s);
                    break;
                case 5: // insertion sort
                    System.out.println("Insertion sort");
                    a =  algorithm.readFile(fileName, n);
                    double[] i = algorithm.insertionSort(a);
                    algorithm.writeFileOutput(fileName3, i);
                    break;
                case 6: // linear search
                    System.out.println("Linear Search");
                    System.out.print("Input value: ");
                    double value = sc.nextDouble();
                    System.out.print("Index is: ");
                    a =  algorithm.readFile(fileName, n);
                    algorithm.search(a, value);
                    System.out.println();
                    break;
                case 7: // binary search
                    a = algorithm.readFile(fileName, n);
                    double[] Sort = algorithm.bubbleSortBinary(a);
                    System.out.println("Binary Search");
                    System.out.print("Input value: ");
                    double valueBinary = sc.nextDouble();
                    System.out.print("Index is: ");
                    algorithm.binarySearch(Sort,0, a.length - 1, valueBinary);
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
