package com.mycompany.sortandsearch;

public class Linear {

    static void search(int[] array, int i) {

        for (int j=0; j<array.length; j++) {
           if (array[j] == i) {
                System.out.println("Linear search found key: " + i + " at index " + j + ".");
            }
        }
    }
}