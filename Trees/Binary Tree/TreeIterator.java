
package com.mycompany.binarytree;

import com.mycompany.binarytree.BinaryTree.Node;
import com.mycompany.binarytree.Stack;
import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    
    private Node next;
    private Stack stack;

    public TreeIterator(Node root) {
        
        stack = new Stack();
        
        if (root == null)
            next = null;
        else 
            stack.push(root);
    }
    
    @Override
    public boolean hasNext() {   
        return !stack.emptyCheck();
    }
     
    @Override
    public Integer next() {
        
        next = stack.pop();
        
        if (next.right != null) stack.push(next.right);
        if (next.left != null) stack.push(next.left);
    
        return next.value;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

