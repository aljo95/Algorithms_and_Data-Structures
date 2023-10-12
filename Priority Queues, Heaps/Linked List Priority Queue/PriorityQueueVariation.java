
public class PriorityQueueVariation {
    
    Node first;
    
        public class Node {
        int data;
        Node next;
        
        Node(int val, Node tl) {
            data = val;
            next = tl;
        }
    }
        
    public int length() {
        int c = 0;
        
        Node current = first;
        while(current != null) {
            c++;
            current = current.next;
        }
        return c;
    }    
    
    
    // Linear add
    public void add(int key) {
        if (first == null) {
            first = new Node(key, null);
            return;
        }
        
        if (key < first.data) {
            first = new Node(key, first);
            return;
        }
        
        Node previous = first;
        Node current = first;
        while (current != null) {
            if (current.data > key) {                                   
                break; 
            }
            previous = current;
            current = current.next;
        }
        previous.next = new Node(key, current);
    }
    
    // Constant remove
    public Integer remove() {
        
        if (first == null) {
            System.out.println("Nothing to remove. Returning null.");
            return null;
        }
        
        Integer returnValue = first.data;
        first = first.next;
        
        return returnValue;
    }
}
