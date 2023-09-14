import java.util.ArrayList;
import java.util.Collections;

public class MergeSort {
    
    public static void sort(int[] org) {
        if (org.length == 0) return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length-1);
    }






    // SORT
    public static void sort(int[] org, int[]aux, int lo, int hi) {

        if (lo != hi) {                         // ([4, 3], auxLength, 0, 1)
            int mid = (lo+hi)/2;    

            //sort first and second halves      // ALL OF THESE HAPPEN BEFORE THE MERGE FUNCTION!
            sort(org, aux, lo, mid);            // org, aux, 0, 0
            sort(org, aux, mid+1, hi);          // org, aux, 1, 1

            //merge                             // Will go "opposite order than sort"
            merge(org, aux, lo, mid, hi);       // 1: org, aux, 0, 0, 1
        }
    }









    // MERGE
    public static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        
        // copy values from org to aux
        for (int i=0; i<org.length; i++) {
            aux[i] = org[i];
        }


        //checking arrays
        /* 
        for(int i=0; i<aux.length; i++) {
            System.out.print(org[i]);
        }
        System.out.print(" values: " + lo + mid + hi);   
        System.out.println();
        */



        // merging time
        int i = lo;         //index first part                  
        int j = mid+1;      //index second part

        //for all indices from lo to hi             //1: [2, 0, 3, 1], lo=0, mid=0, hi=1
        for (int k=lo; k<=hi; k++) {                //so we are sotring 2, 0 -> 0, 2
            if (i > mid) {
                org[k] = aux[j];                    //2: [0, 2, 3, 1], lo=2, mid=2, hi=3    i=2, j=3
                j++;                                //  -> [0, 2, 1, 3]
            }
            else if (j > hi) {                      //last time?: [0, 2, 1, 3], lo=0, mid=1, hi=3     i=0, j=2
                org[k] = aux[i];
                i++;
            } 
            else if (aux[i] < aux[j]) {             //last 1.   i -> 1, k -> 1 [0, ...]
                org[k] = aux[i];                    //last 3.   i -> 2, k -> 3 [0, 1, 2, X]
                i++;
            }
            else if (aux[i] > aux[j]){              //last 2.   j -> 3, k -> 2 [0, 1, ...]
                org[k] = aux[j];
                j++;
            }
        }                                           //last 4. '(i > mid)' -> org[3] = aux[3] -> org[3] = 3

    }                                               // DONE ! 























// Generate UNIQUE random numbers for array of length n. Numbers are in range 0 to n*10 (excluded)
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

    private static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {

/* 
        int[] arr = unsorted(100);
        printArray(arr);
        sort(arr);
        printArray(arr);
*/

        
        double result = 0;
        for (int i = 100; i <= 1600; i += 100) {
            double min = Double.MAX_VALUE;
            
            for (int j=0; j<10000; j++) {
                int[] arr = unsorted(i); 
                long t0 = System.nanoTime();
                sort(arr);
                long t1 = System.nanoTime();
                result = (t1-t0);
                if (result < min) min = result;
            }
            System.out.println(i + " " + min);

        }







    }
}
