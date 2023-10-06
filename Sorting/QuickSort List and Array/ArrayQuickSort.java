import java.util.Random;

public class ArrayQuickSort {

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] array, int l, int h) {

        int pivot = array[l];
        //System.out.println("Pivot: " + pivot);

        int indx = h;

        for (int i=h; i>l; i--) {     // int i = l+1 or just i = l ?
            if (pivot < array[i]) {
                swap(array, i, indx);
                indx--;
            }
            
        }
        swap(array, l, indx);

        

        return indx;

    }

    public static void sort(int[] array, int l, int h) {

        if (h > l) {
            
            int mid = partition(array, l, h);
            //System.out.println("mid: " + mid);

            sort(array, l, mid-1);
            sort(array, mid+1, h);

        }



    }






    public static void main(String[] args) {
        
        int[] arrUnsorted = {3, 1, 4, 9, 5, 2};

        sort(arrUnsorted, 0, arrUnsorted.length-1);

        for (int i=0; i<arrUnsorted.length; i++) {
            System.out.println(arrUnsorted[i]);
        }


        System.out.println("-----------------------");

        int[] gigaArr = new int[99];
        Random rnd = new Random();

        for (int i=0; i<99; i++) {
            gigaArr[i] = rnd.nextInt(1000);
        }

        sort(gigaArr, 0, gigaArr.length - 1);

        for (int i=0; i<gigaArr.length; i++) {
            System.out.print(gigaArr[i] + " ");
        }


    }
    
}