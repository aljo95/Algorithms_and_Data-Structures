
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        for (int i=0; i<array.length-1; i++) {          
            int candidate = i;                          
            for (int j=i+1; j<array.length; j++) {
                if(array[j] < array[candidate]) 
                    candidate = j;                      
            }
            int temp = array[i];
            array[i] = array[candidate];
            array[candidate] = temp;
        }
        return array;
    }

    private static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    // Generate UNIQUE random numbers for array of length n. Numbers are in range 0 to n*10 (excluded)
    /* 
    private static int[] unsorted(int n) {
        int[] unsortedArray = new int [n];
        Random rnd = new Random();

        for (int i=0; i<unsortedArray.length; i++) {
            unsortedArray[i] = rnd.nextInt(n*10);
            for (int j=0; j<i; j++) {
                if (unsortedArray[i] == unsortedArray[j]) {
                    unsortedArray[i] = rnd.nextInt(n*10);
                    i--;
                }
            }
        }
        return unsortedArray;
    }
    */

    // Easier way to generate unsorted unique numbers
    private static int[] unsorted(int n) { 
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<n; i++) list.add(i);
        Collections.shuffle(list);
        int[] randomArray = new int[n];
        for (int i=0; i<n; i++) {
            randomArray[i] = list.get(i);
        }
        return randomArray;
    }

    // Generate sorted unique numbers
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static void main(String[] args) {

        double result = 0;
        for (int i = 100; i <= 1600; i += 100) { 
            double min = Double.MAX_VALUE;
            for (int j = 0; j < 10000; j++) { 
                int[] arr = unsorted(i);
                //int[] arr = sorted(i);
                long t0 = System.nanoTime();
                selectionSort(arr);
                long t1 = System.nanoTime();
                result = (t1 - t0);
                if (result < min) min = result;
            }
            System.out.println(i + " " + min);
        }
    }
}
