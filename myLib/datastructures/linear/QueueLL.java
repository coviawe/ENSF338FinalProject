package myLib.datastructures.linear;
import myLib.datastructures.nodes.SNode;

public class QueueLL extends SLL{
    public QueueLL(){
        super();
    }

    public void enqueue(SNode node){
        super.insertTail(node);
    }

    public SNode dequeue(){
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

    @Override
    public void print(){
        System.out.println("Queue Length: " + size + "\n");
        if (empty()){
            System.out.println("Queue is empty.\n");
        }
        else {
            int i = 1;
            System.out.println("Queue Content");
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

    // Override some methods that don't apply to queues with empty body methods
    @Override
    public void insertHead(SNode node) {
        // Empty body to avoid misuse of method in a queue
    }

    @Override
    public void insert(SNode node, int position) {
        // Empty body to avoid misuse of method in a queue
    }

    @Override
    public void sortedInsert(SNode node) {
        // Empty body to avoid misuse of method in a queue
    }

    @Override
    public void delete(SNode node) {
        // Empty body to avoid misuse of method in a queue
    }

    @Override
    public void deleteTail() {
        // Empty body to avoid misuse of method in a queue
    }

    @Override
    public void sort() {
        // Empty body to avoid misuse of method in a queue
    }
    
    // Main method for testing our QueueLL class
    public static void main(String[] args){
        // Create a new queue
        System.out.println("Creating a new queue...");
        QueueLL queue = new QueueLL();
        queue.print(); // Output: Queue Length = 0.  Queue is empty.

        // Insert (enqueue) into an empty queue
        System.out.println("Inserting into an empty queue...");
        SNode node1 = new SNode(145);
        queue.enqueue(node1);
        queue.print(); // Output: Queue Length = 1. Index: 1 | Data: 145

        // Do a sequence of insertions (enqueues)
        System.out.println("Making a sequence of insertions...\n");
        SNode node2 = new SNode(444);
        SNode node3 = new SNode(73);
        SNode node4 = new SNode(51);
        SNode node5 = new SNode(338);

        queue.enqueue(node2);
        queue.print(); // Output: Queue Length = 2. Index: 1 | Data: 145 etc.
        
        queue.enqueue(node3);
        queue.print(); // Output: Queue Length = 3. Index: 1 | Data: 145 etc.

        queue.enqueue(node4);
        queue.print(); // Output: Queue Length = 4. Index: 1 | Data: 145 etc.

        queue.enqueue(node5);
        queue.print(); // Output: Queue Length = 5. Index: 1 | Data: 145 etc.

        // Making a quick peek at the front of the queue
        System.out.println("Peeking at the front of the queue...");
        SNode temp = queue.peek(); // Should return the node with data 145
        System.out.println("Peeked node data: " + temp.getData() + "\n"); // Output: Peeked node data: 145

        // Fully clear the queue by making a sequence of deletions (dequeues)
        System.out.println("Clearing the queue by a sequence of deletions...\n");
        queue.dequeue();
        queue.print(); // Output: Queue Length = 4. Index: 1 | Data: 444 etc.

        queue.dequeue();
        queue.print(); // Output: Queue Length = 3. Index: 1 | Data: 73 etc.

        queue.dequeue();
        queue.print(); // Output: Queue Length = 2. Index: 1 | Data: 51 etc.

        queue.dequeue();
        queue.print(); // Output: Queue Length = 1. Index: 1 | Data: 338 etc.

        queue.dequeue();
        queue.print(); // Output: Queue Length = 0.  Queue is empty.

        // Do another insert (enqueue) to make sure the queue is empty again after clearing it
        System.out.println("Inserting into an empty queue again...\n");
        SNode node6 = new SNode(999);
        queue.enqueue(node6);
        queue.print(); // Output: Queue Length = 1. Index: 1 | Data: 999

        // Making another quick peek at the front of the queue
        System.out.println("Peeking at the front of the queue again...\n");
        temp = queue.peek(); // Should return the node with data 999
        System.out.println("Peeked node data: " + temp.getData() + "\n"); // Output: Peeked node data: 999

        // Searching for a node
        System.out.println("Updating the queue again...\n");
        SNode node7 = new SNode(381);
        queue.enqueue(node7);
        queue.print(); // Output: Queue Length = 2. Index: 1 | Data: 999 etc.

        System.out.println("Searching for \"node6\" in the queue...\n");
        int finder = queue.search(node6).getData(); // Should return 999
        System.out.println("The search found that node 6's data is: " + finder);
        System.out.println();

        // Checking if the queue can be cleared
        System.out.println("Clearing the queue...\n");
        queue.clear();
        queue.print(); // Output: Queue Length = 0.  Queue is empty.
    }
}
