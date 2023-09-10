
package com.mycompany.identicals;

import java.util.Random;

public class Main {                                 
    
    // Linear unsorted.  Time O(n^2).
    private static double search(int n) {
       
        Random rnd = new Random();
        int[] array = new int[n];
        double min = Double.POSITIVE_INFINITY;

        for (int i = 0; i < n; i++) {
            array[i] = rnd.nextInt(n*2);            
        }

        int[] keys = new int[n];                 

        for (int k = 0; k < n; k++) {
            keys[k] = rnd.nextInt(n*2);
        }

        int sum = 0;     // if we want to keep track of duplicate amount
        
        for (int k = 0; k<1000; k++) {
            long t0 = System.nanoTime();
            for (int i = 0; i < n; i++) {
                int key = keys[i];
                for (int j = 0; j < n; j++) {
                    if (key == array[j]) {
                        sum++;
                        break;
                    }
                }
            }
            long t1 = System.nanoTime();
            double result = (t1 - t0);
            if (result < min) min = result;
        }
        return min;
    }
    
    // Using binary search. Two sorted arrays of same length.  Time O(n*log(n))
    private static double binarySearch(int n) {
        
        int loop = n;
        
        int[] array = sorted(n);   
        
        int[] keys = sorted(loop);     
        int sum = 0;
        double result=0;
        double min = Double.POSITIVE_INFINITY;
        
        for (int k = 0; k<10000; k++) {
            long t0 = System.nanoTime();
            for (int i = 0; i < loop; i++) {
                int key = keys[i];
                
                boolean res = Binary.search(array, key);
                if (res == true) sum++;
            }
            long t1 = System.nanoTime();
            result = (t1 - t0);
            if (result < min) min = result;
        }
        return min;
    }
    
    // Final optimized version. Time O(n)
    private static double finalVersion(int n) {
        
        int[] array = sorted(n);
        
        double min = Double.POSITIVE_INFINITY;

        int[] keys = sorted(n);

        int sum = 0;
        
        for (int k = 0; k<10000; k++) {
            int secondArrPointer = 0;
            long t0 = System.nanoTime();  
            for (int i = 0; i < n; i++) {
               
                int firstArray = keys[i];
                int secondArray = array[secondArrPointer];
                
                if (secondArray < firstArray && secondArrPointer < array.length - 1) {
                    secondArrPointer++;
                    i--;
                }
                if (secondArray == firstArray) {
                    sum++;
                }
                //if (secondArray > firstArray) we just move forward with i++, 
                //which the loop does itself
            }
            long t1 = System.nanoTime();
            double result = (t1 - t0);
            if (result < min) min = result;
        }
        return min;
    }
    
    // Generating random integers, sorted, in array of length n.
    private static int[] sorted(int n) { 
	Random rnd = new Random();
	int[] array = new int[n];
	int nxt = rnd.nextInt(10);

	for (int i = 0; i < n ; i++) {      
	    array[i] = nxt;               
	    nxt += rnd.nextInt(10) + 1 ;
	}	
	return array;
    }
    
    public static void main(String[] args) {
        
        //unsorted linear
        for (int i=100; i<=1600; i = i+100) {
            System.out.println(search(i));
        }
        
        //binary search 
        for (int i=100; i<=1600; i = i+100) {
            
            System.out.println(binarySearch(i));
        }
        
        //final version
        for (int i=100; i<=1600; i = i+100) {
            System.out.println(finalVersion(i));
        }
    }
}
