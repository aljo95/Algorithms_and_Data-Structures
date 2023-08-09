
 // Definition for singly-linked list.
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val);
    this.next = (next===undefined ? null : next);
}
 
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

const addTwoNumbers = function(l1, l2) {
    let List = new ListNode(0);
    let head = List;    // head of linked list
    let sum = 0;
    let carry = 0;      // carry over for when sum >= 10

    while(l1 || l2 || sum>0){   // simple calculation logics
        if(l1){
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2){
            sum += l2.val;
            l2 = l2.next;
        }
        if(sum >= 10){
            carry = 1;
            sum = sum - 10;
        }

        head.next = new ListNode(sum);  // head.next -> List.next = new ListNode
        head = head.next;               // increment head position in list
        sum = carry;
        carry = 0;

    }
    return List.next;
};



/* -------------- Test Cases -------------- */

let head;
//pushToList appends new nodes to existing node
function pushToList(data) {
    var newNode = new ListNode(data);
    
    newNode.next = null;

    var last = head;
    while (last.next != null) {
        last = last.next;   //traverse to the last node
    }
    last.next = newNode;
    return;
}

/* Case One */

let List1 = new ListNode(2);    // First node
head = List1;
pushToList(4);                  // Appending new nodes
pushToList(3);                  // Appending new nodes

let List2 = new ListNode(5);
head = List2;
pushToList(6);
pushToList(4);
                                            // Test number 1:
console.log("\nFirst test: ", addTwoNumbers(List1, List2));   // Output values: 7, 0, 8


/* Case Two */

List1 = new ListNode(0);
List2 = new ListNode(0);
console.log("\nSecond test: ", addTwoNumbers(List1, List2));   // Output value: 0


/* Case Three */

List1 = new ListNode(9);
head = List1;
pushToList(9);
pushToList(9);
pushToList(9);
pushToList(9);
pushToList(9);
pushToList(9);

List2 = new ListNode(9);
head = List2;
pushToList(9);
pushToList(9);
pushToList(9);

console.log("\nThrid test: ", addTwoNumbers(List1, List2)); // Output values: 8, 9, 9, 9, 0, 0, 0, 1
