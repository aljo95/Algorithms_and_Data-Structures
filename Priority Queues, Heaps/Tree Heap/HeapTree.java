
public class HeapTree {
    Node root;
    
    public class Node {
        public Integer value;
        public Integer size;
        public Node left, right;
        
        public Node(Integer value) {
            this.value = value;
            this.size = 1;
            this.left = this.right = null;
        }
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node current = root;
        int temp;
        while (current != null) {
            current.size++;
            if (value < current.value) {
                temp = current.value;
                current.value = value;
                value = temp;
            }
            if (current.left == null) {
                current.left = new Node(value);
                return;
            } else if (current.right == null) {
                current.right = new Node(value);
                return; 
            }
            if (current.left.size > current.right.size) {
                current = current.right;
            } else {
                current = current.left;
            }
            
        }
    }
    
    public Integer remove() {
        if (root == null)
            return null;
        
        int rootValue = root.value; 
        if(root.size == 1) { 
            root = null;
            return rootValue;
        }
        
        Node current = root;
        
        while (current != null) { 
            current.size--;
            
            if (current.left == null) { 
                current.value = current.right.value;
                if (current.right.left == null && current.right.right == null) {
                    current.right = null;
                    return rootValue;
                } else {
                    current = current.right;
                }
            }
            else if (current.right == null) { 
                current.value = current.left.value;
                if (current.left.left == null && current.left.right == null) {
                    current.left = null;
                    return rootValue;
                } else {
                current = current.left;
                }
            }
            else if (current.left.value > current.right.value) { 
                current.value = current.right.value;
                if (current.right.left == null && current.right.right == null) {
                    current.right = null;
                    return rootValue;
                }
                else
                    current = current.right;
            }
            else { 
                current.value = current.left.value;
                if (current.left.left == null && current.left.right == null) {
                    current.left = null;
                    return rootValue;
                }
                else
                    current = current.left;
            }
        }
        return rootValue;
    }
    
    public Integer push(Integer incr) {
        
        if (root == null)
            return null;
        
        root.value = root.value + incr;
        
        if (root.size == 1) 
            return 1;
        
        Node current = root;
        int depthCounter = 1;
        int temp;
        while (current != null) {
            if (current.right == null) {
                if (current.left.value < current.value) {
                    temp = current.value;
                    current.value = current.left.value;
                    current.left.value = temp;
                    depthCounter++;
                }
                if (current.left.left == null && current.left.right == null) {
                    return depthCounter;
                }
                current = current.left;
            } 
            else if (current.left == null) {
                if (current.right.value < current.value) {
                    temp = current.value;
                    current.value = current.right.value;
                    current.right.value = temp;
                    depthCounter++;
                }
                if (current.right.left == null && current.right.right == null) {
                    return depthCounter;
                }
                current = current.right;
            } 
            else if (current.left.value > current.right.value) {
                if (current.right.value < current.value) {
                    temp = current.value;
                    current.value = current.right.value;
                    current.right.value = temp;
                    depthCounter++;
                }
                if (current.right.left == null && current.right.right == null) {
                    return depthCounter;
                }
                current = current.right;
            }
            else {
                if (current.left.value < current.value) {
                    temp = current.value;
                    current.value = current.left.value;
                    current.left.value = temp;
                    depthCounter++;
                }
                if (current.left.left == null && current.left.right == null) {
                    return depthCounter;
                }
                current = current.left;
            }
        }
        return depthCounter;
    }
}
