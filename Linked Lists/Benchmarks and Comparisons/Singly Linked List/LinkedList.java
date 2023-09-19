
package com.mycompany.linkedlist;

public class LinkedList {
    
    Cell first;
    
    // Constructor to generate a list with values from 0 to n
    LinkedList(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {       //last = (0, null)
            last = new Cell(i, last);       //last = (1, tl=(0, null))
        }                                   //last = (2, tl=(1, tl=(0, null)))  
        first = last;                       //first = (2, tl=(1, tl=(0, null)))  
    }

    
    //////////////////////////////////////////////////
    // Method to display number n list cell's value
    public int getValue(int n) {
        int count = 0;
        Cell next = this.first;
        while(count < n) {
            next = next.tail;
            count++;
        }
        //count is the position that n exists at
        return next.head;
    }
    
    
    
    
    // ADD ITEM AS THE FIRST CELL IN LIST
    public void add(int key) {
        if (this.first == null) {
            this.first = new Cell(key, null);
        } else {
            Cell newCell = new Cell(key, null);
            newCell.tail = this.first;
            this.first = newCell;
        }
    }
    
    // RETURN LENGTH OF LIST
    public int length() {
        int count = 0;
        Cell next = this.first;
        if (next == null) return 0;
        else count++;
        
        while(next.tail != null) {
            next = next.tail;
            count++;
        }
        return count;
    }
    /*
    public int length() {
        int count = 0;
        LinkedList next = this;
        while (next != null) {
            count++;
            next = next.first.tail;
        }
    }*/
    
    // SEARCH THROUGH LIST FOR A CELL WITH SPECIFIC VALUE
    public boolean search(int item) {
        Cell next = this.first;
        while (next != null) {
            if (next.head == item) return true;
            next = next.tail;
        }
        return false;
    }
    
    // DELETE A CELL
    public void remove(int item) {
        Cell next = this.first.tail;       // [1 > 2 > 3]
        Cell previous = this.first; 
        
        if (previous.head == item) {
            this.first = next;
        }
        
        while (next != null) {
           
            if (next.head == item) {
                previous.tail = next.tail;
                break;
            }
            previous = next;
            next = next.tail;
            
        }
    }
    
    // Append a sequence to the end of a list
    public void append (LinkedList b) {
        Cell cellToAppend = b.first;
        Cell next = this.first;
        while (next.tail != null) {
            next = next.tail;
        }
        next.tail = b.first;
        
    }
    
    
    
    
    private class Cell {
        int head;
        Cell tail;
        
        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }
}
