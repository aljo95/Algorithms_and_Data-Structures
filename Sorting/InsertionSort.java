import java.util.Random;

public class InsertionSort {


    public static int[] insertionSort(int[] array) {    // arr[] = {64, 25, 12, 22, 11} 
                                                        // arr[] = {25, 64, 12, 22, 11} 
        for (int i=1; i<array.length; i++) {          // arr[] = {25, 12, 64, 22, 11} 
                                                        // arr[] = {25, 64, 12, 22, 11}  
            for (int j=i-1; j>=0; j--) {

                if (array[j+1] < array[j]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }

            }
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



    public static void main(String[] args) {
/* 
        int[] arr = unsorted(10);
        printArray(arr);
        int[] sorted = insertionSort(arr);
        printArray(sorted);
*/

        
        double result = 0;
        for (int i=100; i<=1000; i+=100) {
            double min = Double.MAX_VALUE;
            
            for (int j=0; j<10000; j++) {
                int[] arr = unsorted(i);    //gives array of length 100, 200, 300 ..., 1000
                            //prints the return
                long t0 = System.nanoTime();
                //printArray(selectionSort(arr));  //calls insertions sort with the array(s) prints
                insertionSort(arr);
                long t1 = System.nanoTime();
                result = (t1-t0);
                if (result < min) min = result;
            }
            System.out.println(i + ": " + result);
    
        } 





    }
}
