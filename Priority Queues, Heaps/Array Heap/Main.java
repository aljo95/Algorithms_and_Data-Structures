
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    
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
    
    
    
    
    
    
    
    
    
    
    
    public static void add(Integer[] heapArr, Integer value) {
        if (heapArr[0] == null) {
            heapArr[0] = value;
            return;
        }
        
        int k = 0;
        while(heapArr[k] != null) {                     // [2, 3, 4] value = 1
            k++;    
        }                                               // k = 3
        
        heapArr[k] = value;                             // [2, 3, 4, 1]
        
        int n;
        int temp;
        while (k != 0) {            // k = 3 -> 1       // [2, 1, 4, 3]
                                    // K = 1 -> 0       // [1, 2, 4, 3]
            if (k % 2 == 0) 
                n = (k-2)/2;
            else
                n = (k-1)/2;
                
            if (heapArr[k] < heapArr[n]) {
                temp = heapArr[k];
                heapArr[k] = heapArr[n];
                heapArr[n] = temp;
            } else if (heapArr[k] > heapArr[n]) {
                return;
            }
            k = n;
            
        }
        
    }
    
    
    public static Integer remove(Integer[] heapArr) {
        
        if (heapArr[0] == null) {
            System.out.println("Empty, nothing to remove. Returning null.");
            return null;
        }
        
        Integer rootValue = heapArr[0];
        if (heapArr[1] == null && heapArr[2] == null) {
            heapArr[0] = null;
            return rootValue;
        }
        
        
        int k = 1;                           // = 4
        while(heapArr[k] != null && k<heapArr.length-1) {             // [2, 3, 4, 5, 6]
            k++;                                                        // [6, 3, 4, 5, null ... ]
        }    
        k--;
        System.out.println("K: --- " + k);
        int lastValue = heapArr[k];
        heapArr[0] = lastValue;
        heapArr[k] = null;
        
        int temp;
        int n = 0;
        
        while (n != k-1) {                          // k = 4
                                                    // 1: [3, 6, 4, 5, .... ]
            int leftBranch = (n*2)+1;
            int rightBranch = (n*2)+2;
            
            if (heapArr[leftBranch] != null && heapArr[rightBranch] == null) {
                if (heapArr[n] > heapArr[leftBranch]) {
                    temp = heapArr[n];
                    heapArr[n] = heapArr[leftBranch];
                    heapArr[leftBranch] = temp;
                } else {
                    return rootValue;
                }
                n = leftBranch;
            }
            else if (heapArr[leftBranch] == null && heapArr[rightBranch] != null) {
                if (heapArr[n] > heapArr[rightBranch]) {
                    temp = heapArr[n];
                    heapArr[n] = heapArr[rightBranch];
                    heapArr[rightBranch] = temp;
                } else {
                    return rootValue;
                }
                n = rightBranch;
            }
            else if (heapArr[leftBranch] < heapArr[rightBranch]) {  
                if (heapArr[n] > heapArr[leftBranch]) {
                    temp = heapArr[n];
                    heapArr[n] = heapArr[leftBranch];
                    heapArr[leftBranch] = temp;
                } else {
                    return rootValue;
                }
                n = leftBranch;
            } else {
                if (heapArr[n] > heapArr[rightBranch]) {
                    temp = heapArr[n];
                    heapArr[n] = heapArr[rightBranch];
                    heapArr[rightBranch] = temp;
                } else {
                    return rootValue;
                }
                n = rightBranch;
            }
        }
        
        return rootValue;
    }
    
    

    public static void main(String[] args) {
        
        
        System.out.println("----------BENCHMARK START----------");
        
        for (int i=200; i<=4000; i=i*2) {
            
            
            double result = 0;
            double finalresult = 0;
            
            for (int k=0; k<10000; k++) {
                
                ArrayHeap benchArr = new ArrayHeap(i);
                int[] unsortedArr = unsortedUniques(i);
                
                benchArr.add(1);
                benchArr.remove();
                
                for (int j=0; j<i; j++) {
                    long t0 = System.nanoTime();
                    benchArr.add(unsortedArr[j]);
                    long t1 = System.nanoTime();
                    result += (t1 - t0);
                }
                
                for (int j=0; j<i; j++) {
                    long t0 = System.nanoTime();
                    benchArr.remove();
                    long t1 = System.nanoTime();
                    result += (t1 - t0);
                }
            }
            result = (result/i);
            finalresult = (result)/10000;  //microseconds
            System.out.println("(" + i + ", " + finalresult + ")");
        }
    }
}
