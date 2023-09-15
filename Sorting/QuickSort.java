
public class QuickSort {

    public static void swap(int[] a, int l, int h){
        int temp=a[l];
        a[l]=a[h];
        a[h]=temp;
    }

    public static int partition(int[] arr, int lo, int hi) {

        // pivot choice     
        int pivot = arr[hi];               

        int indx = lo - 1;                

        for (int k = lo; k < hi; k++) {  
            if (arr[k] < pivot) {        
                indx++;                 
                swap(arr, indx, k);         
            }
        }

        //last
        swap(arr, indx+1, hi);  

        return indx+1;       
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int partition = partition(arr, lo, hi); // = 1

            sort(arr, lo, partition-1); //arr, 0, 0, not passing if (lo < hi)

            sort(arr, partition+1, hi); //arr, 2, 3, not passing if, we are done.
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        
        int[] array = {4, 2, 3};
        printArr(array);
        System.out.println();
        sort(array, 0, array.length-1);
        printArr(array);
    }
}
