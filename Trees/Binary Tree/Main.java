
package com.mycompany.binarytree;

import com.mycompany.binarytree.BinaryTree.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    
    
    private static int[] unsorted(int n) { 
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<n; i++) list.add(i);
        Collections.shuffle(list);
        int[] randomArray = new int[n];
        for (int i=0; i<n; i++) {
            randomArray[i] = list.get(i);
        }
        return randomArray;
    }

    public static void main(String[] args) {
        
	
	BinaryTree tree = new BinaryTree();
	tree.add(5,105);
	tree.add(2,102);
	tree.add(7,107);
	tree.add(1,101);
	tree.add(8,108);
	tree.add(6,106);
	tree.add(3,103);

	// Can iterate over three depth-first thanks to implementation of iterator class
	for (int i : tree)
		System.out.println("next value " + i);
	}
        
        /*************** LOOKUP BENCHMARKING ***************/
        /*      
        int[] arr = unsorted(1000); //return array of size 10 with 0-9 values unsorted
        BinaryTree benchmarkTree = new BinaryTree();
        
        for (int i = 0; i < 1000; i++) {
            benchmarkTree.add(arr[i], i);
        }
        
        long t0 = 0;
        long t1 = 0;
        Random rnd = new Random();

        for (int i=200; i<=4000; i=i+200) {
            
            double min = Double.MAX_VALUE;
            double result = 0;
            int[] arr = new int[i];
            
            //create sorted array of size i, to then create balanced tree!
            for (int j=0; j<i; j++) {
                arr[j] = j;
            }
            
            //Generate tree
            Node rootNode = benchmarkTree.createBalanced(arr, 0, arr.length-1);
            //benchmarkTree = benchmarkTree.returnTree(rootNode);
            benchmarkTree.root = rootNode;
            
            //measure time it takes for 100 random searches
            for (int k = 0; k<100000; k++) {
                t0 = System.nanoTime();
                for (int l=0; l<100; l++) {
                    int randomValue = rnd.nextInt(i);
                    benchmarkTree.lookup(randomValue);
                }
                t1 = System.nanoTime();
                result = (t1 - t0);
                if (result < min) 
                    min = result;
            }
            System.out.println(i + " " + min/100);
        } */
    }
}
