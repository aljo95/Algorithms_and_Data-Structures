
package com.mycompany.linkedlist;

public class LinkedList {
    
    Cell first;
    
    // Constructor to generate a list with values from 0 to n
    LinkedList(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {  
            last = new Cell(i, last); 
        }                              
        first = last;    
    }
    
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
    
    // Add item as first cell in list
    public void add(int key) {
        if (this.first == null) {
            this.first = new Cell(key, null);
        } else {
            Cell newCell = new Cell(key, null);
            newCell.tail = this.first;
            this.first = newCell;
        }
    }
    
    // Return length of list
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
    
    // Search through list for a cell with specific value 
    public boolean search(int item) {
        Cell next = this.first;
        while (next != null) {
            if (next.head == item) return true;
            next = next.tail;
        }
        return false;
    }
    
    // Delete a cell by its int value (item)
    public void remove(int item) {
        Cell next = this.first.tail; 
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
    
    public void push(int item) {
        if (this.first == null) {
            this.first = new Cell(item, null);
        } else {
            Cell newCell = new Cell(item, null);
            Cell next = this.first;
            while (next.tail != null) {
                next = next.tail;
            }
            next.tail = newCell;
        }
    }
    
    public void pop() {
        if (this.first == null) return;
        if (this.first.tail == null) { 
            this.first = null;
            return;
        } else {
            Cell previous = this.first; 
            Cell next = this.first.tail;
        
            while (next.tail != null) {
                previous = next;
                next = next.tail;
            }
            //pop the cell (previous)
            previous.tail = null;
        }
    }
    
    public void unlink(Cell c) {        //special case if c is first
        Cell previous = this.first;
        Cell next = this.first;
        
        while(next != null) {
            if (next == c) {
                if (next == this.first) {
                    this.first = next.tail;
                    return;
                } else {
                    previous.tail = next.tail;
                    return;
                }
            }
            previous = next;
            next = next.tail;
        }
    }
    
    public void insertCell(Cell c) {
        Cell next = this.first;
        if (this.first == null)
            this.first = c;
        else {
            this.first = c;
            c.tail = next;
        }
    }
    
    public Cell selectCell(int indx) {
        int count = 0;
        Cell c = this.first;
        
        while(count != indx) {
            c = c.tail;
            count++;
        }
        return c;
    }
    
    public class Cell {
        int head;
        Cell tail;
        
        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }
}
