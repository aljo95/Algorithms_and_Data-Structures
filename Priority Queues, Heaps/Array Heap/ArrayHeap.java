

public class ArrayHeap {
    
    Integer[] heapArray;
    int size;
    int k = -1;
    
    public ArrayHeap(int size) {
        this.size = size;
        heapArray = new Integer[this.size];
    }
    
    
    public void printArr() {
        for (int i=0; i<heapArray.length; i++) {
            System.out.println(heapArray[i]);
        }
    }
    
    
    
    public void add(Integer value) {
        if (heapArray[0] == null) {
            heapArray[0] = value;
            k++;
            return;
        }                                       
        
        k++;
        heapArray[k] = value;  
        
        int n;
        int current = k;
        int temp;
        while (current != 0) {            // k = 3 -> 1       // [2, 1, 4, 3]
                                    // K = 1 -> 0       // [1, 2, 4, 3]
            if (current % 2 == 0) 
                n = (current-2)/2;
            else
                n = (current-1)/2;
                
            if (heapArray[current] < heapArray[n]) {
                temp = heapArray[current];
                heapArray[current] = heapArray[n];
                heapArray[n] = temp;
            } else if (heapArray[current] > heapArray[n]) {
                return;
            }
            current = n;
            
        }
        
    }
    
    
    
    
    
    
    
    public Integer remove() {
        
        if (heapArray[0] == null) {
            System.out.println("Empty, nothing to remove. Returning null.");
            return null;
        }
        
        Integer rootValue = heapArray[0];
        if (heapArray[1] == null && heapArray[2] == null) {
            heapArray[0] = null;
            k--;
            return rootValue;
        }
        
        int lastValue = heapArray[k];       // = 6
        heapArray[0] = lastValue;
        heapArray[k] = null;
        k--;
        
        int temp;
        int n = 0;
        //int current = k;
        
        while (n != k) {                                    // k = 4
                                                            // 1: [6, 3, 4, 5, ...]
            int leftBranch = (n*2)+1;                       // 2: [3, 6, 4, 5, ...], n = 1
            int rightBranch = (n*2)+2;                      // 3: [3, 5, 4, 6, ...], n = 3
            
            if (leftBranch > k) {
                return rootValue;
            }
            
            if (heapArray[leftBranch] != null && heapArray[rightBranch] == null) {
                if (heapArray[n] > heapArray[leftBranch]) {
                    temp = heapArray[n];
                    heapArray[n] = heapArray[leftBranch];
                    heapArray[leftBranch] = temp;
                } else {
                    return rootValue;
                }
                n = leftBranch;
            }
            else if (heapArray[leftBranch] == null && heapArray[rightBranch] != null) {
                if (heapArray[n] > heapArray[rightBranch]) {
                    temp = heapArray[n];
                    heapArray[n] = heapArray[rightBranch];
                    heapArray[rightBranch] = temp;
                } else {
                    return rootValue;
                }
                n = rightBranch;
            }
            else if (heapArray[leftBranch] < heapArray[rightBranch]) {  
                if (heapArray[n] > heapArray[leftBranch]) {
                    temp = heapArray[n];
                    heapArray[n] = heapArray[leftBranch];
                    heapArray[leftBranch] = temp;
                } else {
                    return rootValue;
                }
                n = leftBranch;
            } else {
                if (heapArray[n] > heapArray[rightBranch]) {
                    temp = heapArray[n];
                    heapArray[n] = heapArray[rightBranch];
                    heapArray[rightBranch] = temp;
                } else {
                    return rootValue;
                }
                n = rightBranch;
            }
        }
        
        return rootValue;
    }   
}