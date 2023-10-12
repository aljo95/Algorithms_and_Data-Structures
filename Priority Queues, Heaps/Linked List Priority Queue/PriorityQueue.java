
public class PriorityQueue {
    
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
    
    
    // Constant add()
    public void add(int key) {
        if (first == null) {
            first = new Node(key, null);
        } else { 
            Node newCell = new Node(key, null);
            newCell.next = first;
            first = newCell;
        }
    }
    
    public Integer remove() {
        
        if (first == null) {
            System.out.println("Nothing to remove. Queue is empty.");
            return null;
        }
        
        Node lowest = first;
        
        if (first.next == null) {
            first = null;
            return lowest.data;
        }
        
        Node previous = first; 
        Node current = first;
        
        while(current.next != null) {
            if (current.next.data < lowest.data) {
                previous = current;
                lowest = current.next;
            }
            current = current.next;
        }

        if (lowest.data == first.data) {
            first = first.next;
        }
     
        previous.next = lowest.next;
        return lowest.data;
    }
    
}
