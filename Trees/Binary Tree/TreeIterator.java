
package com.mycompany.binarytree;

import com.mycompany.binarytree.BinaryTree.Node;
import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    
    private Node next;
    //private Stack<Node> stack;
    Stack stack = new Stack();
    int count = 0;

    public TreeIterator(Node root) {
        //constructor here: put into stack?
        //use push or just add to an array?
        
        //only this in constructor: stack.push(root node) ?
        
        System.out.println("XXXXXXXXXXXXXXXXXX");
        System.out.println(root.value);
        System.out.println("XXXXXXXXXXXXXXXXXX");
        
        if (root != null)
            stack.push(root);
        
        if (root.left != null)
            next = root.left;
        else if (root.right != null)
            next = root.right;
        else
            next = null;
        
        
    }
    
    @Override   //override because we override java.util.Iterator's methods to make our own
    public boolean hasNext() {
        
        //should do 'return !stack.emptyCheck(); and swap
        //true and false around in the method xDDDD
        return stack.emptyCheck();
        
    }
     
    @Override
    public Integer next() {
        
        Node currentNode = stack.pop();
        
        if (currentNode.right != null) stack.push(currentNode.right);
        if (currentNode.left != null) stack.push(currentNode.left);
    
        return currentNode.value;
    }
    
    
    
    
    
    
    
    
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
