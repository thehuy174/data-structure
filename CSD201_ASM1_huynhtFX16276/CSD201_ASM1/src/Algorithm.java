import java.io.*;
import java.util.Scanner;

public class Algorithm {
    Scanner sc = new Scanner(System.in);
    public int length(){
        return sc.nextInt();
    }
    // method display program
    public void menu(){
        System.out.println();
        System.out.println("+-------------------Menu------------------+");
        System.out.println("|      1.Input                            |");
        System.out.println("|      2.Output                           |");
        System.out.println("|      3.Bubble sort                      |");
        System.out.println("|      4.Selection sort                   |");
        System.out.println("|      5.Insertion sort                   |");
        System.out.println("|      6.Search > value                   |");
        System.out.println("|      7.Search = value                   |");
        System.out.println("|      0.Exit                             |");
        System.out.println("+-------------------Menu------------------+");
        System.out.println();
    }
     //Writing the array read from input array arr to file
    public void writeFile(String fileName, double[] arr) {
        try {
            FileOutputStream fs = new FileOutputStream(fileName);
            DataOutputStream ds = new DataOutputStream(fs);
            for (int i = 0; i < arr.length; i++) {
                ds.writeDouble(arr[i]);
            }
            fs.close();
            ds.close();
            System.out.println("Complete");
        }catch (IOException e){
            System.out.println("File write failed");
        }
    }
     //Reading the file then input to the array arr
    public double[] readFile(String fileName, int n) {
        double[] arr = new double[n];
        try {
            FileInputStream fs = new FileInputStream(fileName);
            DataInputStream ds = new DataInputStream(fs);
            for(int i = 0; i < arr.length; i++){
                arr[i] = ds.readDouble();
            }
            fs.close();
            ds.close();
        }catch (IOException e){
            System.err.println("File read failed");
        }
        return arr;
    }
    //Prints the array
    public void display(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
    //Sorting the input array arr using Bubble Sort algorithm.
    public double[] bubbleSort(double[] arr){
        boolean isSorted;
        for(int i = 0; i < arr.length; i++){
            isSorted = false;
            for (int j = 0; j < arr.length -1; j++){
                if(arr[j] > arr[j + 1]){
                    // swap arr[j] and arr[j+1]
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = true;
                }
            }
            //If no two elements were swapped then break
            if (!isSorted) {
                break;
            }
            display(arr);
           System.out.println();
        }
        return arr;
    }
    //Sorting the input array arr using Selection Sort algorithm.
    public double[] selectionSort(double[] arr){
        int minIndex = 0;
        boolean isSorted;
        for(int i = 0; i < arr.length; i++){
            // Find the minimum element in unsorted array
            minIndex = i;
            isSorted = false;
            for (int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                    isSorted = true;
                }
            }
            // Swap the found minimum element with the first element
            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            //If no two elements were swapped then break
            if (!isSorted) {
                break;
            }
            display(arr);
            System.out.println();
        }
        return arr;
    }
    // Sorting the input array arr using insertion Sort algorithm.
    public double[] insertionSort(double[] arr){
        boolean isSorted;
        for(int i = 1; i < arr.length; i++){
            double key = arr[i];
            int j = i - 1;
            isSorted = false;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while ( j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
                isSorted = true;
            }
            arr[j + 1] = key;
            //If no two elements were swapped then break
            if (!isSorted) {
                break;
            }
            display(arr);
            System.out.println();
        }
        return arr;
    }
    // linear search
    public void search(double[] arr, double value){
        int number = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > value){
                number = i;
                writeFileOutputInt("../OUTPUT4.txt", number);
                System.out.print(number + " ");
            }
        }
    }
    // binary search
    public void binarySearch (double[] arr, int left, int right, double value){
        int num = 0;
        left = 0;
        right = arr.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {

            // Check if x is present at mid
            if (arr[mid] == value) {
                num = mid;
                writeFileOutputInt("../OUTPUT5.txt", num);
                System.out.print(num + " ");
                break;

                // If x greater, ignore left half
            }else if (arr[mid] < value) {
                left = mid + 1;

                // If x is smaller, ignore right half
            }else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        if ( left > right ){
            System.out.print("Element is not found!");
        }
    }
    //Writing the array read from input array arr to file case 3, 4, 5
    public void writeFileOutput(String fileName, double[] arr) {
        try {
            FileWriter fw = new FileWriter(fileName);
            for (int i = 0; i < arr.length; i++) {
                fw.write(String.valueOf(arr[i]));
            }
            fw.close();
            System.out.println("Complete");
        }catch (IOException e){
            System.out.println("File write failed");
        }
    }
    //Writing the array read from input array arr to file case 6, 7
    public void writeFileOutputInt(String fileName, int arr) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(String.valueOf(arr));
            fw.close();
        }catch (IOException e){
            System.out.println("File write failed");
        }
    }
    // bubble sort case 7
    public double[] bubbleSortBinary(double[] arr){
        boolean isSorted;
        for(int i = 0; i < arr.length; i++){
            isSorted = false;
            for (int j = 0; j < arr.length -1; j++){
                if(arr[j] > arr[j + 1]){
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = true;
                }
            }
            //If no two elements were swapped then break
            if (!isSorted) {
                break;
            }
        }
        return arr;
    }
}
