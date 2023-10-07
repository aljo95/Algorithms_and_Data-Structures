
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayQuickSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] array, int lo, int hi) {

        int pivot = array[lo];

        int indx = lo+1;
        for (int i=lo+1; i<=hi; i++) {
            if (array[i] < pivot) {
                swap(array, indx, i);
                indx++;
            }
        }
        
        swap(array, lo, indx-1);
        return indx;

    }

    public static void sort(int[] array, int lo, int hi) {

        if (hi > lo) {
            int mid = partition(array, lo, hi);

            sort(array, lo, mid-1);
            sort(array, mid, hi);
        }
    }
    
    
    public static int[] unsortedUniques(int n) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        
        int[] returnArr = new int[n];
        
        for (int i=0; i<n; i++) {
            returnArr[i] = list.get(i);
        }
        return returnArr;
    }

    public static void main(String[] args) {
        
        double resArr = 0;
        double resList = 0;
        
	// Benchmarking array vs list quicksort
        for (int i = 100; i <= 1600; i=i+100) {
            
            resArr = 0;
            resList = 0;
            
            for (int k=0; k<1000; k++) {
                ListQuickSort list = new ListQuickSort();
                int[] unsorted = unsortedUniques(i);

                for (int j=0; j<unsorted.length; j++) {
                    list.add(unsorted[j]);
                }

                long t0 = System.nanoTime();
                sort(unsorted, 0, unsorted.length-1);
                long t1 = System.nanoTime();
                resArr += (t1-t0);
                //System.out.print(resArr);

                long t2 = System.nanoTime();
                list.sort(list.head, list.end);
                long t3 = System.nanoTime();
                resList += (t3-t2);
                //System.out.print(" " + resList);
                //System.out.println();
            }
            resArr = (resArr/1000);
            resList = (resList/1000);
            System.out.print(i + " " + resArr + " " + resList + "\n");
            
        }


        System.out.println("-------- ONLY ARRAY ----------");

        // Checking runtime for larger values for array quicksort
        for (int i = 10000; i <= 100000; i=i+10000) {
            resArr = 0;

            for (int k=0; k<1000; k++) {

                int[] unsorted = unsortedUniques(i);
                long t0 = System.nanoTime();
                sort(unsorted, 0, unsorted.length-1);
                long t1 = System.nanoTime();
                resArr += (t1-t0);

            }
            resArr = (resArr/1000)/1000; // /1000 to get microseocnds xD
            System.out.println(i + " " + resArr);
        }
    }
}
