
package com.mycompany.linkedlist;

public class Main {
    
    public static int[] arrayAllocate(int i) {
        return new int[i];
    }
    
    
    
    
    public static int[] arrayAppend(int[] a, int[] b) {
        
        int totalLength = a.length + b.length;
        int[] totalArray = new int[totalLength];        //a=[1, 2, 3]
        
        System.arraycopy(a, 0, totalArray, 0, a.length);
        System.arraycopy(b, 0, totalArray, a.length, b.length);
        
        /*
        for (int i=0; i<a.length; i++) {                //b=[4, 5, 6]
            totalArray[i] = a[i];                       //tot=[length=6]
        }
        
        for (int i=0; i<b.length; i++) {
            totalArray[a.length+i] = b[i];
        }*/
        return totalArray;
    }
    
    public static void main(String[] args) {
        

        
        LinkedList linkedList = new LinkedList(4);
        LinkedList list_to_append = new LinkedList(0);
        
        //linkedList.add(10);
        //linkedList.add(20);
        //linkedList.add(30);
        // GENERATE WITH FUNCTION!
        
        //System.out.println(linkedList);  //this is 20 because 20 is first now :)
        //System.out.println(linkedList.first.tail.head);
        //System.out.println(linkedList.first.tail.tail.head);
        
        /*
        int length = linkedList.length();
        System.out.println(length);
        
        boolean searchResult = linkedList.search(10);
        boolean searchResult2 = linkedList.search(15);
        System.out.println(searchResult);
        System.out.println(searchResult2);
        */
        
        
        System.out.println("---------------------");
        //REMOVE TESTING!
        System.out.println(linkedList.getValue(0));
        System.out.println(linkedList.getValue(1));
        System.out.println(linkedList.getValue(2));
        System.out.println(linkedList.getValue(3));
        linkedList.remove(3);   //Remove the cell with head value (x)
        
        System.out.println(linkedList.getValue(0));
        System.out.println(linkedList.getValue(1));
        System.out.println(linkedList.getValue(2));
        //System.out.println(linkedList.getValue(3));
        
        
        System.out.println("---------------------");
        
        
        //whit my new awesome method
        System.out.println(linkedList.length());
        System.out.println(list_to_append.length());

        System.out.println(linkedList.getValue(0)); //30
        System.out.println(linkedList.getValue(1)); //20
        System.out.println(linkedList.getValue(2)); //10
        
         System.out.println("---------------------");
         System.out.println("---------------------");
        int[] aa = {1, 2, 3};
        int[] bb = {4, 5, 6, 7};
        int[] res = arrayAppend(aa, bb);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
         System.out.println("---------------------");
         System.out.println("---------------------");
        
        System.out.println("---------------------");
        linkedList.append(list_to_append);
        System.out.println(linkedList.search(4));
        linkedList = new LinkedList(3);
        System.out.println(linkedList.search(4));
        
        /*
        // TESTING TIME!
        System.out.println("---------------------");
        for (int i = 100; i <= 1600; i = i + 100) {
            double min = Double.MAX_VALUE;
            for (int k = 0; k < 10000; k ++) {
                LinkedList a = new LinkedList(i);
                LinkedList b = new LinkedList(100);
                long t0 = System.nanoTime();
                a.append(b);
                long t1= System.nanoTime();
                double result = (t1 - t0);
                if (result < min) min = result;
            }
            System.out.println(i + " " + min);
        }
        */
        
        System.out.println("---------------------");
        
        for (int i = 1300; i <= 1600; i = i + 100) {
            double min = Double.MAX_VALUE;
            for (int k = 0; k < 1000; k ++) {
                long t0 = System.nanoTime();
                int[] arr = arrayAllocate(i);
                long t1= System.nanoTime();
                double result = (t1 - t0);
                if (result < min) min = result;
            }
            System.out.println(i + " " + min);
        }
    }
}
