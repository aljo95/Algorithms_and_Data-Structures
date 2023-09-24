
package com.mycompany.binarytree;

public class Main {

    public static void main(String[] args) {
        
        BinaryTree testTree = new BinaryTree();
        testTree.add(0, 0);
        testTree.add(1, 1);
        testTree.add(2, 2);
        
        System.out.println(testTree.root.key);
        System.out.println(testTree.root.value);
        
        System.out.println(testTree.root.left);
        //System.out.println(testTree.root.right.key);
        
        
        
        
    }
    
}
