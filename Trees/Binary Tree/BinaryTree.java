
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

    @Override
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

        
        
        
        
        private void add(Integer key, Integer value) {      //called with 1, 1
            
            //.out.println("------------");
            //System.out.println("this=" + this.key + " current=" + key);
            //System.out.println("this=" + this.value + " current=" + value);
            //System.out.println("------------");
            
            if (this.key == key) {
                this.value = value;
                return;
            }
            if (this.key > key) {
                if (this.left != null)
                    this.left.add(key, value);
                else
                    this.left = new Node(key, value);
            } else {    //if this.key < key
                if (this.right != null) 
                    this.right.add(key, value);
                else
                    this.right = new Node(key, value);
            }
        }
    }
        
    //Search after key, return it's value (was key before makes no sense)
    public Integer lookup(Integer key) {
        Node current = this.root;
        while(current != null) {
            if(current.key == key) 
                return current.key;
            if(current.key < key)
                current = current.right;
            else //if current.key > key
                current = current.left;
        }
        return null;    //Integer return type instead of int
    }
}
