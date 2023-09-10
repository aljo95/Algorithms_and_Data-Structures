
package com.mycompany.sortandsearch;

import java.util.Random;

/**
 * @author 
 */
public class Main {
    
    //array = 200 random sorted values, indx = 10000 random values unsorted (0-999)
    
    private static void linear(int[] array, int[] indx) {
        boolean linearResult;
        for (int i=0; i<indx.length; i++) {
            linearResult = Linear.search(array, indx[i]);       
        }                                                   
    }
    
    private static void binary(int[] array, int[] indx) {
        boolean binaryResult;
	for (int i = 0; i < indx.length ; i++) {
	    binaryResult = Binary.search(array, indx[i]);
	}
    }
    
    private static int[] sorted(int n) {    // n = 100 first time
	Random rnd = new Random();	
	int[] array = new int[n];
	int nxt = rnd.nextInt(10);

	for (int i = 0; i < n ; i++) {      //array 100 elements random values but sorted
	    array[i] = nxt;
	    nxt += rnd.nextInt(10) + 1 ;
	}	
	return array;
    }
       
    private static int[] keys(int loop, int n) {
	Random rnd = new Random();	
	int[] indx = new int[loop];
	for (int i = 0; i < loop ; i++) {
	    indx[i] = rnd.nextInt(n*5);
	}	
	return indx;
    }
    
    private static int[] unsorted(int n) { 
        
        int[] unsortedArray = new int [n];
        Random rnd = new Random();
    
        for (int i=0; i<unsortedArray.length; i++) {
            unsortedArray[i] = rnd.nextInt(n*10);
            for (int j=0; j<i; j++) {
                if (unsortedArray[i] == unsortedArray[j]) {
                    unsortedArray[i] = rnd.nextInt(n*10);
                    i--;
                }
            }
        }
        return unsortedArray;
    }
    
    private static void linearUnsorted(int[] array, int[] indx) {
        boolean res;
        for (int i=0; i<indx.length; i++) {       //0 - 9999, 10000 times
            res = search_unsorted(array, indx[i]);
        }
    }
    
    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        
        int[] sizes = {100 ,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

	System.out.printf("# searching through an array of length n, time in ns\n");
	System.out.printf("#%7s%16s%8s%8s", "n", "unsorted", "linear", "binary");
	for ( int n : sizes) {

	    int loop = 10000;
	    
	    int[] array = sorted(n);    //generate sorted array of size n
	    int[] indx = keys(loop, n); //generate array with 10000 random keys in range 0 to n*5
            /* */
            int [] unsortedArray = unsorted(n); //generate unsorted array of size n
            /* */

	    System.out.printf("\n%8d", n);    

	    int k = 1000;
	    
            /******************UNSORTED****************************************/
            double min = Double.POSITIVE_INFINITY;
            
            for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		linearUnsorted(unsortedArray, indx);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }

            //System.out.println("nano time: " + min);
	    System.out.printf("%16.0f" , (min/loop));
            
            /**********************LINEAR************************************/
            
            min = Double.POSITIVE_INFINITY;

	    for (int i = 0; i < k; i++) {           
		long t0 = System.nanoTime();
		linear(array, indx);            
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min) //min will be updated with shortest value each time
		    min = t;
	    }
            //System.out.println("nano time: " + min);
	    System.out.printf("%8.0f", (min/loop));	
              
            /*************************BINARY*********************************/
            
	    min = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		binary(array, indx);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }

            //System.out.println("nano time: " + min);
	    System.out.printf("%8.0f" , (min/loop));
	}
    }
}
