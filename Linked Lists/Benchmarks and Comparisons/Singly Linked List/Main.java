
package com.mycompany.linkedlist;

public class Main {
    
    public static int[] arrayAllocate(int i) {
        return new int[i];
    }
    
    
    
    
    public static int[] arrayAppend(int[] a, int[] b) {
        
        int totalLength = a.length + b.length;
        int[] totalArray = new int[totalLength];
        int indx = 0;
        for (int item: a) {
            totalArray[indx] = item;
            indx++;
        }
        for (int item: b) {
            totalArray[indx] = item;
            indx++;
        }
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
        
        //STACK TESTING!
        System.out.println("##--------------------##");
        LinkedList stackList = new LinkedList(0);
        stackList.push(1);
        stackList.push(2);
        stackList.push(3);
        //stackList.add(1);
        //stackList.add(2);
        stackList.pop();
        stackList.pop();
        System.out.println(stackList.getValue(0));  // with push=1 with add=2
        //System.out.println(stackList.getValue(1));  // with push=2 with add=1
        //System.out.println(stackList.getValue(2));
        System.out.println("Length: " + stackList.length());
        System.out.println("##--------------------##");
        
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6, 7};
        int[] resArr = arrayAppend(arr1, arr2);
        for (int item: resArr) {
            System.out.print(item + ", ");
        }
        System.out.println();
        
        
        
        
        // TESTING TIME!
        // Appending arrays
        /*
        System.out.println("---------------------");
        System.out.println("TESTING ARRAY START!");
        for (int i = 100; i <= 1600; i = i + 100) {
            double min = Double.MAX_VALUE;
            for (int k = 0; k < 10000; k ++) {
                int[] a = new int[i];
                int[] b = new int[100];
                long t0 = System.nanoTime();
                arrayAppend(a, b);
                long t1= System.nanoTime();
                double result = (t1 - t0);
                if (result < min) min = result;
            }
            System.out.println(i + " " + min);
        }
        System.out.println("TESTING ARRAY END");
        System.out.println("---------------------");
        */
        
        //append list
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
        
        
        // building list time
        
        for (int i = 2000; i <= 10000; i = i + 2000) {
            double min = Double.MAX_VALUE;
            for (int k = 0; k < 10000; k ++) {
                long t0 = System.nanoTime();
                LinkedList testList = new LinkedList(i);
                long t1= System.nanoTime();
                double result = (t1 - t0);
                if (result < min) min = result;
            }
            System.out.println(i + " " + min);
        }
        
        
        
        
        
        /*
        for (int i = 2000; i <= 10000; i = i + 2000) {
            double min = Double.MAX_VALUE;
            for (int k = 0; k < 10000; k ++) {
                long t0 = System.nanoTime();
                    int[] arr = arrayAllocate(i);
                long t1= System.nanoTime();
                double result = (t1 - t0);
                if (result < min) min = result;
            }
            System.out.println(i + " " + min);
        }
        /*
        double min = Double.MAX_VALUE;
        for (int k = 0; k < 10000; k++) {
            long t0 = System.nanoTime();
            int[]arr = arrayAllocate(6000);
            long t1 = System.nanoTime();
            double result = (t1 - t0);
            if (result < min) min = result;
        }
        System.out.println("200 " + min);
        */
    }
}
