package com.mycompany.sortandsearch;

public class Linear {

    static boolean search(int[] array, int i) {
        
        if (array[array.length-1] < i) return false;
        
        for (int j=0; j<array.length; j++) {
           if (array[j] > i) return false;
           else if (array[j] == i) return true;
        }
        return false;
    }
}