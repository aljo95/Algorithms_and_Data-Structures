
package com.mycompany.doublylinkedlist;

public class DoublyList {
    
    Cell first;
    
    // Constructor to generate a list with values from 0 to
    /*
    DoublyList(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {      
            last = new Cell(i, last);     
        }                                     
        first = last;                      
    }*/
    
    // ADD TO START OF LIST
    public void add(int key) {
        if (this.first == null) {
            this.first = new Cell(key, null, null);
        } else {                                                    //first only have null<-[1]->null
            Cell newCell = new Cell(key, null, null);               // newcell:   null<-[2]-><-[1]->null
            newCell.tail = this.first;
            this.first.previous = newCell;
            
            this.first = newCell;
        }
    }
    
    // RETURN LENGTH OF LIST; SAME AS FOR SINGLY LINKED LISTS ?
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
    public void remove(int item) {    // [null < 1 >< 2 >< 3 > null]
        Cell next = this.first; 
        
        while (next != null) {
            if (next.head == item) {
                if (this.first.head == item) {
                    this.first = this.first.tail;
                    if (this.first != null)
                        this.first.previous = null;
                    return;
                } else {
                    next.previous.tail = next.tail;
                    return;
                }
            }
            next = next.tail;
        }
    }
    
    public void nullCell(Cell c) {
        c.previous = null;
        //c.head = null;
        c.tail = null;
        
    }
    
    
    public void unlink(Cell c) {
        
        if (c == this.first) {
            if (this.first.tail != null) {
                this.first = this.first.tail;
                this.first.previous = null;
            } else {
                this.first = null;      // null < 1 >< 2 >< 3 > null 
            }                           //error at line 92 when only two elements and removing the last one!
        } else {                 
           
            c.previous.tail = c.tail;
            if (c.tail != null)
                c.tail.previous = c.previous;
        }
       // c = null; //?
    }
    public void insertCell(Cell c) {
        Cell next = this.first;
        if (this.first == null) 
            this.first = c;
        else {
            this.first = c;
            c.tail = next;
            next.previous = c;
        }
    }
    
    
    public class Cell {
        int head;
        Cell previous;
        Cell tail;
        
        Cell(int val, Cell prev,Cell tl) {
            head = val;
            previous = prev;
            tail = tl;
        }
    }
}
