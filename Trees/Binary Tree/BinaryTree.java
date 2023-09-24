
package com.mycompany.binarytree;

public class BinaryTree {
    
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
            
            System.out.println("------------");
            System.out.println(this.key);
            System.out.println(this.value);
            System.out.println("------------");
            
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
}




















