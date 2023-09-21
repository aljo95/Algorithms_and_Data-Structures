
package com.mycompany.doublylinkedlist;


public class Main {

    public static void main(String[] args) {
        
        /*
        DoublyList testList = new DoublyList();
        testList.add(1);
        testList.add(2);
        
        System.out.println(testList);           //CHANGE CELL CLASS BACK TO PRIVATE !!!!!!!!!!!
        System.out.println(testList.first);
        System.out.println(testList.first.tail);
        System.out.println(testList.first.tail.head);           // 1
        System.out.println(testList.first.head);                // 2, the head
        System.out.println(testList.first.tail.previous.head);  // 2, previous of 1
        
        System.out.println("Length: " + testList.length());
        
        
        System.out.println("##############################");
        DoublyList testList2 = new DoublyList();
        testList2.add(1);
        testList2.add(2);
        System.out.println("Length of list2: " + testList2.length());

        
        //Testing Remove
        System.out.println("##############################");
        //testList2.remove(1);
        //System.out.println("Length of list2: " + testList2.length());
        
        //Testing unlink
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        //Cell c = new Cell(1, null, null);
        DoublyList testList3 = new DoublyList();
        testList3.add(10);
        testList3.add(20);
        testList3.add(30);
        
        System.out.println("Length of list3: " + testList3.length());
        
        testList2.unlink(testList3.first.tail); //should go from    30 - 20 - 10 to 30 - 10
        
        System.out.println("Length of list3: " + testList3.length());
        System.out.println(testList3.first.head);       //30
        System.out.println(testList3.first.tail.head);  //10
        
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        // Create method to insert a cell at start like add but with cell instead of int
        
        DoublyList listForCells = new DoublyList();
        DoublyList.Cell  newCell = listForCells.new Cell(11, null, null);
        listForCells.insertCell(newCell);
        System.out.println(listForCells.first.head);
        System.out.println("Length of cell list: " + listForCells.length());
        
        newCell = listForCells.new Cell(22, null, null);
        listForCells.insertCell(newCell);
        System.out.println(listForCells.first.head);
        System.out.println(listForCells.first.tail.head);
        System.out.println("Length of cell list: " + listForCells.length());
        
        newCell = listForCells.new Cell(33, null, null);
        listForCells.insertCell(newCell);
        System.out.println(listForCells.first.head);
        System.out.println(listForCells.first.tail.head);
        System.out.println(listForCells.first.tail.tail.head);
        System.out.println("Length of cell list: " + listForCells.length());
        */
        
        
        //UNLINK TESTING
        DoublyList newList = new DoublyList();
        DoublyList.Cell newCell = newList.new Cell(10, null, null);
        
        //Inserting
        newList.insertCell(newCell);
        newCell = newList.new Cell(20, null, null);
        newList.insertCell(newCell);
        newCell = newList.new Cell(30, null, null);
        newList.insertCell(newCell);
        newCell = newList.new Cell(40, null, null);
        newList.insertCell(newCell);
        
        System.out.println(newList.length());
        System.out.println(newList.first.head);
        System.out.println(newList.first.tail.head);
        System.out.println(newList.first.tail.tail.head);
        System.out.println(newList.first.tail.tail.tail.head);
        
        //Unlinking
        newList.unlink(newList.first.tail); // Should remove 30, next check all tails and previous so they are correct
        newList.unlink(newList.first);
        System.out.println(newList.length());
        System.out.println(newList.first.head);
        System.out.println(newList.first.tail.head);
        //System.out.println(newList.first.tail.tail.head);
        
        System.out.println("-----------Testing tails and prevs-------------");
        System.out.println(newList.first);
        
        System.out.println(newList.first.previous);
        System.out.println(newList.first.head);
        System.out.println(newList.first.tail);
        
        System.out.println(newList.first.tail.previous);
        System.out.println(newList.first.tail.head);
        System.out.println(newList.first.tail.tail);
        
        System.out.println("ONE LEFT!");
        newList.unlink(newList.first);
        System.out.println(newList.first.previous);
        System.out.println(newList.first.head);
        System.out.println(newList.first.tail);
        
        System.out.println("ZERO LEFT!");
        newList.unlink(newList.first);
        System.out.println(newList.first);
        
        
    }
    
}
