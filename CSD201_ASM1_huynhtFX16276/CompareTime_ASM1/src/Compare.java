import java.util.*;
public class Compare {
    // bubble sort
    public void timeBubbleSort(int[] arr){
        boolean isSorted;
        long timeStart = System.nanoTime();
        for(int i = 0; i < arr.length; i++){
            isSorted = false;
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
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
        long timeEnd = System.nanoTime();
        long time = timeEnd - timeStart;
        System.out.println("Bubble Sort:  " + time);
    }
    //Selection Sort
    public void timeSelectionSort(int[] arr){
        int minIndex = 0;
        boolean isSorted;
        long timeStart = System.nanoTime();
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
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            //If no two elements were swapped then break
            if (!isSorted) {
                break;
            }
        }
        long timeEnd = System.nanoTime();
        long time = timeEnd - timeStart;
        System.out.println("Selection Sort:  " + time);
    }
    //insertion Sort
    public void insertionSort(int[] arr){
        boolean isSorted;
        long timeStart = System.nanoTime();
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
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
        }
        long timeEnd = System.nanoTime();
        long time = timeEnd - timeStart;
        System.out.println("insertion Sort:  " + time);
    }
}
