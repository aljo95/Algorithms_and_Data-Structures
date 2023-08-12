import ListCreator.ListAndNodeCreator;
import ListCreator.ListAndNodeCreator.Node;

public class ReverseList {
    public static void main(String[] args) {

        /* Creating linked list object and adding three nodes */
        ListAndNodeCreator linkedList = new ListAndNodeCreator();
        linkedList.head = new Node(1);
        linkedList.head.next = new Node(2);
        linkedList.head.next.next = new Node(3);

        System.out.print(linkedList.head.data + " ");           // = 1
        System.out.print(linkedList.head.next.data + " ");      // = 2
        System.out.print(linkedList.head.next.next.data);       // = 3

        reverseList(linkedList);

        System.out.print("\n" + linkedList.head.data + " ");    // = 3
        System.out.print(linkedList.head.next.data + " ");      // = 2
        System.out.print(linkedList.head.next.next.data);       // = 1
    }

    /* Function to reverse linked list */
    public static void reverseList(ListAndNodeCreator linkedList) {
        Node infront = null;
        Node currentNode = linkedList.head;
        Node next;

        while (currentNode != null) {   // Values each iteration with example [1 -> 2 -> 3]:
            next = currentNode.next;    // next=2 -> 3 -> null
            currentNode.next = infront; 

            infront = currentNode;      // infront=null -> 1 -> 2 -> 3
            currentNode = next;          
        }
        
        // after loop the result will be "null, 2, 1"
        // infront will always hold the last value of the original list
        // set list.head = infront (last value now placed first)
        linkedList.head = infront;
    }
}