
package com.mycompany.treewithqueue;

import com.mycompany.treewithqueue.BinaryTree.Node;
import com.mycompany.treewithqueue.Queue;
import java.util.Iterator;

public class TreeIterator implements Iterator<Integer> {
    
    private Queue.Node next;
    private Queue queue;

    public TreeIterator(BinaryTree.Node root) {
        
        queue = new Queue();
        
        if (root == null)
            next = null;
        else  {
            queue.add(root); 
            //next = queue.new Node(root, null);
        }
    }
    
    @Override
    public boolean hasNext() {   
        return queue.head != null;
    }
    
    @Override
    public Integer next() {
        
        next = queue.remove();                                                        
                                      
        if (next.currentNode.left != null) queue.add(next.currentNode.left);
        if (next.currentNode.right != null) queue.add(next.currentNode.right); 
    
        return next.currentNode.value;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
