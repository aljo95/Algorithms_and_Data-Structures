
package com.mycompany.binarytree;

import com.mycompany.binarytree.BinaryTree.Node;

public class Stack<T> {
    
    Node[] stackArray;
    int size;
    int pointer = -1;
    Node[] tempArr;
    
    public Stack() {
        
        size = 4;
        
        stackArray = new Node[size]; // starting size 4
    }
    
    public void push(Node x) {
        
        if (pointer+1 == stackArray.length) {
            
            tempArr = new Node[size];
            
            for (int i=0; i<stackArray.length; i++) {
                tempArr[i] = stackArray[i];
            }
            
            size = size*2;
            stackArray = new Node[size];
            
            for (int i=0; i<tempArr.length; i++) {
                stackArray[i] = tempArr[i];
            }
            
            pointer++;
            stackArray[pointer] = x;
        } else {
            pointer++;
            stackArray[pointer] = x;
        }
    }
    
    public Node pop() {
        
        if (pointer == -1) {
            System.out.println("Empty stack, nothing to pop!");
            return null;
        }
        
        if (pointer < size / 4) {
            tempArr = new Node[size];  
            
            for (int i=0; i<tempArr.length; i++) {
                tempArr[i] = stackArray[i];
            }
            
            size = size / 2;
            stackArray = new Node[size];
            
            for (int i=0; i<stackArray.length; i++) {
                stackArray[i] = tempArr[i];
            }
            
            pointer--;
            return stackArray[pointer+1];
        } else {
            pointer--;
            return stackArray[pointer+1];
        }
    }
    public boolean emptyCheck() {
        if (pointer == -1) return false;
        
        return true;
    }
}

