import java.util.ArrayList;
import java.util.Collections;


public class MergeSortVariant {

    public static void sort(int[] org) {
        if (org.length == 0) return;
        int[] aux = new int[org.length];
        for (int i=0; i<org.length; i++) {
                aux[i] = org[i];
        }
        sort(org, aux, 0, org.length-1);
    }

    public static void sort(int[] org, int[]aux, int lo, int hi) {

        if (lo != hi) {   
            int mid = (lo+hi)/2; 
                                                
            sort(aux, org, lo, mid);           
            sort(aux, org, mid+1, hi);         

            merge(org, aux, lo, mid, hi); 
        }
    }

    // MERGE
    public static void merge(int[] org, int[] aux, int lo, int mid, int hi) {

        // merging time
        int i = lo;         //index first part                  
        int j = mid+1;      //index second part

        //for all indices from lo to hi             
        for (int k=lo; k<=hi; k++) {                
            if (i > mid) {
                org[k] = aux[j];      
                j++;                              
            }
            else if (j > hi) {                  
                org[k] = aux[i];
                i++;
            } 
            else if (aux[i] < aux[j]) {            
                org[k] = aux[i];          
                i++;
            }
            else if (aux[i] > aux[j]){          
                org[k] = aux[j];
                j++;
            }
        }               
    }        

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

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = unsorted(137);
        printArray(arr);
        sort(arr);
        printArray(arr);
        

        /*
        double result = 0;
        for (int i = 200; i <= 1600; i += 100) {
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
        */
    }
}
