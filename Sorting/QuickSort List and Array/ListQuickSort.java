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

    void printList(Node n) 
    { 
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


    /***************LIST END*******************************/

    Node[] partition(Node first, Node last) {

        System.out.println("first: " + first.value + " last: " + last.value);


        //Node pivot = last;
        Node pivot = first;
        Node storeindex = pivot;

        Node curr = null;
        Node iteratingNode = pivot.next;
        Node[] returnNodes = new Node[2];

        
        while(iteratingNode != null) {                              // 3 > 1 > 5 > 4 >  null
            
            if (pivot.value > iteratingNode.value) {
                curr = storeindex;
                
                swap(storeindex.next, iteratingNode);
                storeindex = storeindex.next;
            }
            iteratingNode = iteratingNode.next;
        }
        System.out.println("eaea" + curr.value);
        swap(storeindex, pivot);                            //first: switch 3(pivot) and 1(storeindex)
        System.out.println("eaea" + curr.value);
        //curr = 3, 

        
        returnNodes[0] = curr;                  //first: curr = pivot = 1
        returnNodes[1] = storeindex.next;       //first: store.next = 5
        return returnNodes;
    }


    void sort(Node first, Node last) {

        if (first != null && last != null && first != last && last.next != first) {
            Node[] mid = partition(first, last);

            if (mid[0] != null) 
                System.out.println("mid[0] is: " + mid[0].value);
            else
                System.out.println("mid[0] is null");

            if (mid[1] != null) 
                System.out.println("mid[1] is: " + mid[1].value);
            else
                System.out.println("mid[1] is null");


            if (mid != null)
                sort(first, mid[0]);

            if (mid != null)
                sort(mid[1], last);
        }
        return;
    }


    /***************SORT END*******************************/
    public static void main(String[] args) {
        ListQuickSort list = new ListQuickSort();
        list.add(3); 
        list.add(1); 
        list.add(5); 
        list.add(4); 
        //list.add(6);
        //list.add(5); 

        list.printList(list.head);


        //Node returnedHeadNode = list.partition(list.head, list.end);
        //list.printList(returnedHeadNode);

        list.sort(list.head, list.end);
        list.printList(list.head);

    }
}
