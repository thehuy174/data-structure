import java.util.Random;
import java.util.Scanner;

public class CompareTime {
    // main flow controls the program
    public static void main(String[] args){
        Compare compare = new Compare();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number items of Array: ");
        int n = sc.nextInt();
        int num = 0;
        //Creates an array of n elements with random values
        int[] arr1 = new int[n];
        for(int i = 0; i < arr1.length; i++){
            Random r = new Random();
            num = r.nextInt(n + 1);
            arr1[i] = num;
        }
        System.out.println("Compare the run times of the 3 algorithms of Random Array: ");
        compare.timeBubbleSort(arr1);
        compare.timeSelectionSort(arr1);
        compare.insertionSort(arr1);
        // create array reverse sort ( descending )
        int[] arr2 = new int[n];
        num = n;
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = num;
            num--;
        }
        System.out.println("Compare the run times of the 3 algorithms of Descending Array: ");
        compare.timeBubbleSort(arr2);
        compare.timeSelectionSort(arr2);
        compare.insertionSort(arr2);

        // create array sorted ( ascending )
        int[] arr3 = new int[n];
        for(int i = 0; i < arr3.length; i++){
            arr3[i] = i + 1;
        }
        System.out.println("Compare the run times of the 3 algorithms of Ascending Array: ");
        compare.timeBubbleSort(arr3);
        compare.timeSelectionSort(arr3);
        compare.insertionSort(arr3);
    }
}
