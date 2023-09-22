
package com.mycompany.linkedlist;

import java.util.Random;

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
        
        
        /*
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
        */
        
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
        */
        
        
        
        
        
        
        
        
        
            for (int sizes = 100; sizes <= 2000; sizes += 100) {
            
            LinkedList benchList = new LinkedList(0);
            LinkedList.Cell[] cellArray = new LinkedList.Cell[sizes];
            int[] benchArr = new int[1000];
            Random rnd = new Random();
            LinkedList.Cell cellReference;
            
            for (int i = 0; i<sizes; i++) {
                benchList.add(i);
                cellReference = benchList.selectCell(0);
                cellArray[sizes-1-i] = cellReference;
            } 
            
            for (int i = 0; i < 1000; i++) {
                benchArr[i] = rnd.nextInt(sizes);
            }
            
            double min = Double.MAX_VALUE;
            LinkedList.Cell c;
            for (int k = 0; k < 10000; k++) {
                
                long t0 = System.nanoTime();
                for (int i = 0 ; i<1000; i++) {
                    int index = benchArr[i];
                    c = cellArray[index];
                    benchList.unlink(c);
                    benchList.insertCell(c);
                }
                long t1 = System.nanoTime();
                double result = (t1 - t0);
                if (result < min)
                    min = result;
                
            }
            System.out.println(sizes + " " + min);
            
        }  
    }
}
