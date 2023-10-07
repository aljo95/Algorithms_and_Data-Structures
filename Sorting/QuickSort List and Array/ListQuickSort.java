
public class ListQuickSort {
    
    Node head;
    Node end;

    public class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private void add(int addValue) {
        if (this.head == null) {
            this.head = new Node(addValue);
            this.end = this.head;
        } else {
            this.end.next = new Node(addValue);
            this.end = this.end.next;
        }
    }

    void printList(Node n) { 
        while (n != null) { 
            System.out.print(n.value); 
            System.out.print(" "); 
            n = n.next; 
        } 
        System.out.println();
    } 

    void length(Node n) {
        int c = 0;
        while (n != null) {
            c++;
            n = n.next;
        }
        System.out.println(c);
    }

    public void swap(Node i, Node j) {
        int temp = i.value;
        i.value = j.value;
        j.value = temp;
        return;
    }

	/* 
	 List methods end 
	 Quicksort functions begin
	*/
	
    Node[] partition(Node first, Node last) {

        Node pivot = first;
        Node storeindex = pivot;

        Node curr = null;
        Node iteratingNode = pivot.next;
        Node[] returnNodes = new Node[2];

        
        while(iteratingNode != null) { 
            if (pivot.value > iteratingNode.value) {
                curr = storeindex;
                swap(storeindex.next, iteratingNode);
                storeindex = storeindex.next;
            }
            iteratingNode = iteratingNode.next;
        }

        swap(storeindex, pivot); 

        returnNodes[0] = curr; 
        returnNodes[1] = storeindex.next;  
        return returnNodes;
    }

    void sort(Node first, Node last) {

        if (first != null && last != null && first != last && last.next != first) {
            Node[] mid = partition(first, last);
            sort(first, mid[0]);
            sort(mid[1], last);
        }
        return;
    }
}
