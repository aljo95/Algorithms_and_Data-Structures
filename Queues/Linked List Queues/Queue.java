
package com.mycompany.queue;


public class Queue {
    
    Node head;
    
    //CHANGE BACK TO PRIVATE LATER!!!!
    public class Node {
        
        Integer item;
        Node next;
        
        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }
    }
    
    public Queue() {
        
    }
    
    //add 
    public void add(Integer item) {
        
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
    
    
    
    
    public Integer remove() {
        if (this.head == null) {
            System.out.println("Nothing to remove");
            return null;
        }
        
        Node removedNode = this.head;
        this.head = removedNode.next;
        removedNode.next = null;            // necessary?
        return removedNode.item;
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
