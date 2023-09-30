
package com.mycompany.queuewithlast;


public class Queue {
    
    Node head;
    Node last;
    
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
    
    
    
    
    public void add(Integer item) {
        
        if (this.head == null){
            this.head = new Node(item, null);       // 1> 2> null
            this.last = this.head;
            return;
        }
        
        this.last.next = new Node(item, null);
        this.last = this.last.next;
    }
    
    
    
    //be careful when removing the last element? Since this.head and this.last points to the same i guess?
    public Integer remove() {
        
        Integer returnValue = null;
        if (this.head == null)
            return null;
        
        if (this.head == this.last) {
            returnValue = this.head.item;
            this.head = this.last = null;
        } else {
            returnValue = this.head.item;
            this.head = this.head.next;
        }
        return returnValue;
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
