import java.util.Random;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {    // arr[] = {64, 25, 12, 22, 11} i=0
                                                        //         {11, 25, 12, 22, 64} i=1
        for (int i=0; i<array.length-1; i++) {          //               i
            int candidate = i;                          //          11, 12, 25, 22, 64 osv.
            for (int j=i; j<array.length; j++) {
                if(array[j] < array[candidate]) candidate = j;  //Now j is the index with smallest value
            }
            int temp = array[candidate];
            array[candidate] = array[i];
            array[i] = temp;
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

    double result = 0;
        //run 1000 times to test time
    for (int i=100; i<=1000; i+=100) {
        double min = Double.MAX_VALUE;
        
        for (int j=0; j<10000; j++) {
            int[] arr = unsorted(i);    //gives array of length 100, 200, 300 ..., 1000
                        //prints the return
            long t0 = System.nanoTime();
            //printArray(selectionSort(arr));  //calls insertions sort with the array(s) prints
            selectionSort(arr);
            long t1 = System.nanoTime();
            result = (t1-t0);
            if (result < min) min = result;
        }
        System.out.println(i + ": " + result);

    }



    }
}