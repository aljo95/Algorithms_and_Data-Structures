public class MergeSort {
    
    public static void sort(int[] org) {
        if (org.length == 0) return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length-1);
    }






    // SORT
    public static void sort(int[] org, int[]aux, int lo, int hi) {

        if (lo != hi) {
            int mid = (lo+hi)/2;

            //sort first and second halves
            sort(org, aux, lo, mid);
            sort(org, aux, mid+1, hi);

            //merge
            merge(org, aux, lo, mid, hi);
        }
    }









    // MERGE
    public static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        
        // copy values from org to aux
        for (int i=0; i<org.length; i++) {
            aux[i] = org[i];
        }

        // merging time
        int i = lo;         //index first part
        int j = mid+1;      //index second part

        //for all indices from lo to hi
        for (int k=lo; k<=hi; k++) {
            if (i > mid) {
                org[i] = aux[j];
                j++;
            }
            else if (j > hi) {
                org[i] = aux[i];
                i++;
            } 
            else if (aux[i] < aux[j]) {
                org[i] = aux[i];
                i++;
            }
            else {
                org[i] = aux[j];
                j++;
            }
        }

    }



    public static void main(String[] args) {

    }
}
