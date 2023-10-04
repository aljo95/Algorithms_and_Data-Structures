
public class ArrayQueue {
    
    int length = 4;
    Integer[] qArr;
    int k = 0;
    int i = 0;
    int n = length;
    //boolean firstAdd = true;
    
    public ArrayQueue() {
        qArr = new Integer[this.length];
    }
    
    public void add(int addValue) {
        
        qArr[k] = addValue;
        k++;                           // DONT NEED THIS on k, or i for example?
        k = k % n;      
        
        //firstAdd = false;
        
        //if true then make new array
        if (k == i) {           // WE WANT TO PUT IT "AFTER INCREMENTED" WHICH WILL SOLVE THE ISSUES IN Main.java 
            doubleArraySize();
        }
        
    }
    
    public Integer remove() {
        if (i == k) {
            System.out.println("Queue Empty. Can not remove.");
            return null;
        }
        Integer returnValue = qArr[i];
        qArr[i] = null;
        i++;
        i = i % n;
        return returnValue;
    }
    
    
    
    

    private void doubleArraySize() {
       
        length = this.qArr.length*2;
        
        Integer[] newArr = new Integer[length];
        int indx = 0;
        
        for (int j = i; j<n; j++) {
            newArr[indx] = this.qArr[j];
            indx++;
        }
        
        
        for (int l = 0; l<k; l++) {
            newArr[indx] = qArr[l];
            indx++;
        }
            
            
        //this.qArr = new Integer[this.length];
        this.qArr = newArr;
        
        this.i = 0;
        this.k = n;
        this.n = (n * 2);
    }
}
