
package com.mycompany.treewithqueue;

import com.mycompany.treewithqueue.BinaryTree.Node;

public class Queue {
    
    Node head;

    
    public class Node {
        
        public Node next;
        public BinaryTree.Node currentNode;
        
        public Node(BinaryTree.Node currentNode, Node list) {
            
            this.currentNode = currentNode;
            this.next = null;
        }
    }
        
    
    public Queue() {
        
    }
    
    //add 
    public void add(BinaryTree.Node item) {
        
        
        
        
        if (this.head == null){
            this.head = new Node(item, null);       // 1> 2> null
            return;
        }
        
        Node currentNode = this.head;
        while(currentNode.next != null)  {
            
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(item, null);
    }
    
    
    
    
    public Node remove() {
        if (this.head == null) {
            System.out.println("Nothing to remove");
            return null;
        }
        
        Node removedNode = this.head;
        this.head = removedNode.next;
        removedNode.next = null;            // necessary?
        return removedNode;
    }
    
    
    
        //LENGTH METHOD FOR CHECKING
    public int length() {
        if (this.head == null)
            return 0;
        
        int count = 1;
        Node next = this.head;
        while (next.next != null) {     // 1> 2> 3>null
            count++;
            next = next.next;
        }
        return count;
    }
    
    
}

