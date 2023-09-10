
package com.mycompany.sortandsearch;

public class Binary {

    static boolean search(int[] array, int i) {
        
        int min = 0;
        int max = array.length - 1;
        while(true) {
            int mid = (min + max) / 2;
            
            if (array[mid] == i) return true;
        
            if ((array[mid] > i) & (mid > min)) max = mid - 1;
            else if ((array[mid] < i) & (mid < max)) min = mid + 1;
            else return false;
            
        }
    }
}
