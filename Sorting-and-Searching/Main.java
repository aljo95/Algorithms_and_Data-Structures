package com.mycompany.sortandsearch;

import java.util.Random;

/**
 * @author Alexander Johansson
 */

public class Main {
    
    private static void linear(int[] array, int[] indx) {
        System.out.println("");
        for (int i=0; i<indx.length; i++) {       //0 - 9999, 10000 times
            Linear.search(array, indx[i]);
        }
    }
    
    
    private static void binary(int[] array, int[] indx) {
		for (int i = 0; i < indx.length ; i++) {
			Binary.search(array, indx[i]);
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
    
    
    
    
    
    
    
    //loop=10000 or (10), n=100 first time
    private static int[] keys(int loop, int n) {
		Random rnd = new Random();	
		int[] indx = new int[loop];
		for (int i = 0; i < loop ; i++) {
			indx[i] = rnd.nextInt(n*5); //get value 0-499
		}	
		return indx;
    }
    
    
    
    
    
    
    
    
    
    

    public static void main(String[] args) {
        
        int[] sizes = {100}; //,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

		System.out.printf("# searching through an array of length n, time in ns\n");
		System.out.printf("#%7s%8s%8s\n", "n", "linear", "binary");
		for ( int n : sizes) {

			int loop = 10000;
				//int loop = 10;
			
			int[] array = sorted(n);
			int[] indx = keys(loop, n);

			System.out.printf("%8d", n);    //100

			int k = 1000;
			
			double min = Double.POSITIVE_INFINITY;

			for (int i = 0; i < k; i++) {
			long t0 = System.nanoTime();
			linear(array, indx);
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min)
				min = t;
			}
				System.out.println("nano time: " + min);
			System.out.printf("%8.0f", (min/loop));	//time per each "loop" loop=10000     
				/*
			min = Double.POSITIVE_INFINITY;
			
			for (int i = 0; i < k; i++) {
			long t0 = System.nanoTime();
			binary(array, indx);
			long t1 = System.nanoTime();
			double t = (t1 - t0);
			if (t < min)
				min = t;
			}

			System.out.printf("%8.0f\n" , (min/loop));
				*/
		}
    }
    
}
