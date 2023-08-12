/*
 *  Simple List and Node creator
 */

package ListCreator;

public class ListAndNodeCreator {

    public Node head;

    public static class Node {

        public Node next;

        public Object data;

        //constructor
        public Node(Object data) {
            this.data = data;
            next = null;
        }
    }
}