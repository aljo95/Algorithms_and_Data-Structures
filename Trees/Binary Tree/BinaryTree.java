
package com.mycompany.binarytree;

import java.util.Iterator;

public class BinaryTree implements Iterable<Integer> {
    
    Node root;
    
    public BinaryTree() {
        root = null;
    }
    
    public void add(Integer key, Integer value) {
        if (root == null) {
            root = new Node(key, value);
        }
        else {
            root.add(key, value);
        }
    }
    
    public Node createBalanced(int[] arr, int start, int end) {
        
        if (start > end) return null;
        int mid = (start + end) / 2;
        
        Node root = new Node(arr[mid], arr[mid]);
        
        root.left = createBalanced(arr, start, mid-1);
        root.right = createBalanced(arr, mid+1, end);

        return root;
    }
    
    public BinaryTree returnTree(Node balancedRoot) {
        BinaryTree balancedTree = new BinaryTree();
        balancedTree.root = balancedRoot;
        return balancedTree;
    }
    
    public Iterator<Integer> iterator() {
        return new TreeIterator(this.root);
    }
    
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;
        
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
        
        private void add(Integer key, Integer value) {

            if (this.key == key) {
                this.value = value;
                return;
            }
            if (this.key > key) {
                if (this.left != null)
                    this.left.add(key, value);
                else
                    this.left = new Node(key, value);
            } else {
                if (this.right != null) 
                    this.right.add(key, value);
                else
                    this.right = new Node(key, value);
            }
        }
    }
        
    // Find and return the value associated with a key
    public Integer lookup(Integer key) {
        Node current = this.root;
        while(current != null) {
            if(current.key == key) 
                return current.value;
            if(current.key < key)
                current = current.right;
            else //if current.key > key
                current = current.left;
        }
        return null;    //Integer return type instead of int
    }
}
