package myLib.datastructures.linear;
import myLib.datastructures.nodes.SNode;

public class StackLL extends SLL{
    public StackLL(){
        super();
    }

    public void push(SNode node){
        super.insertHead(node);
    }

    public SNode pop(){
        SNode node = head;
        super.deleteHead();
        return node;
    }

    public SNode peek(){
        return head;
    }

    public boolean empty(){
        if (head == null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override public void print(){
        System.out.println("Stack Length: " + size + "\n");
        if (empty()){
            System.out.println("Stack is empty.\n");
        }
        else {
            int i = 1;
            System.out.println("Stack Content");
            System.out.println("------------------------");
            SNode current = head;
            while (current != null){
                System.out.println("Index: " + i + " | Data: " + current.getData());
                current = current.getNext();
                i++;
            }
            System.out.println("------------------------\n");
        }
    }

    // Override some methods that don't apply to stacks with empty body methods
    @Override
    public void insertTail(SNode node) {
        // Do nothing
    }

    @Override
    public void insert(SNode node, int position) {
        // Do nothing
    }

    @Override
    public void sortedInsert(SNode node) {
        // Do nothing
    }

    @Override
    public void deleteTail() {
        // Do nothing
    }

    @Override
    public void delete(SNode node) {
        // Do nothing
    }

    @Override
    public void sort() {
        // Do nothing
    }

    // Main method for testing our StackLL class
    public static void main(String[] args){
        // Create a new stack
        System.out.println("Creating a new stack...");
        StackLL stack = new StackLL();
        stack.print(); // Output: Stack Length = 0.  Stack is empty.

        // Insert (push) into an empty stack
        System.out.println("Inserting into an empty stack...\n");
        SNode node1 = new SNode(7);
        stack.push(node1);
        stack.print(); // Output: Stack Length = 1.  Stack content: Index: 1 | Data: 7

        // Do a sequence of insertions (pushes)
        System.out.println("Making a sequence of insertions...\n");
        SNode node2 = new SNode(3);
        SNode node3 = new SNode(5);
        SNode node4 = new SNode(2);
        SNode node5 = new SNode(9);

        stack.push(node2);
        stack.print(); // Output: Stack Length = 2.  Stack content: Index: 1 | Data: 3 etc...
        
        stack.push(node3);
        stack.print(); // Output: Stack Length = 3.  Stack content: Index: 1 | Data: 5 etc...
        
        stack.push(node4);
        stack.print(); // Output: Stack Length = 4.  Stack content: Index: 1 | Data: 2 etc...
        
        stack.push(node5);
        stack.print(); // Output: Stack Length = 5.  Stack content: Index: 1 | Data: 9 etc...

        // Making a quick peek at the top of the stack
        System.out.println("Peeking at the top of the stack...\n");
        SNode temp = stack.peek(); // Should return the node with data 5
        System.out.println("Peeked node data: " + temp.getData() + "\n"); // Output: Peeked node data: 5

        // Fully clear the stack by a sequence of deletions (pops)
        System.out.println("Clearing the stack by a sequence of deletions...\n");
        stack.pop();
        stack.print(); // Output: Stack Length = 4.  Stack content: Index: 1 | Data: 2 etc...

        stack.pop();
        stack.print(); // Output: Stack Length = 3.  Stack content: Index: 1 | Data: 5 etc...

        stack.pop();
        stack.print(); // Output: Stack Length = 2.  Stack content: Index: 1 | Data: 3 etc...

        stack.pop();
        stack.print(); // Output: Stack Length = 1.  Stack content: Index: 1 | Data: 7

        stack.pop();
        stack.print(); // Output: Stack Length = 0.  Stack is empty.

        // Do another insert (push) to make sure the stack is empty again after clearing it
        System.out.println("Inserting into an empty stack again...\n");
        SNode node6 = new SNode(1);
        stack.push(node6);
        stack.print(); // Output: Stack Length = 1.  Stack content: Index: 1 | Data: 1

        // Making another quick peek at the top of the stack
        System.out.println("Peeking at the top of the stack again...\n");
        temp = stack.peek(); // Should return the node with data 1
        System.out.println("Peeked node data: " + temp.getData() + "\n"); // Output: Peeked node data: 1

        // Searching for a node
        System.out.println("Updating the stack again...\n");
        SNode node7 = new SNode(4);
        stack.push(node7);
        stack.print(); // Output: Stack Length = 2.  Stack content: Index: 1 | Data: 4 etc...
        
        System.out.println("Searching for \"node6\" in the stack...\n");
        int finder = stack.search(node6).getData(); // Should return 1
        System.out.println("The search found that node 6's data is: " + finder);
        System.out.println();

        // Checking if the stack can be cleared
        System.out.println("Clearing the stack...\n");
        stack.clear();
        stack.print(); // Output: Stack Length = 0.  Stack is empty.
    }
}
