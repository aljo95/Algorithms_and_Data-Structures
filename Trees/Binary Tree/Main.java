
package com.mycompany.binarytree;

public class Main {

    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);

        
        for (int i : tree) {
            System.out.println("value: " + i);
        }
        
        
        
        // LOOKUP BENCHMARKS!
        
        int res = tree.lookup(7);
        int res2 = tree.lookup(3);
        int res3 = tree.lookup(5);
        System.out.println(res + " " + res2 + " " + res3);      // 7 3 5
        
        
        
        
    }
    
}
