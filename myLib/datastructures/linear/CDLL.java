package myLib.datastructures.linear;
import myLib.datastructures.nodes.DNode;

public class CDLL extends DLL {
    public CDLL(){
        super();
    }
    
    public CDLL(DNode node){
        super(node);
        head.setNext(node);
        head.setPrev(node);
    }

    @Override
    public void insertHead(DNode node){
        if (head == null) {
            super.insertHead(node);
            tail = node;
            tail.setNext(head);
            head.setPrev(tail);
        } else {
            super.insertHead(node);
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    @Override
    public void insertTail(DNode node){
        if (tail == null) {
            super.insertTail(node);
            head = node;
            head.setPrev(tail);
            tail.setNext(head);
        } else {
            super.insertTail(node);
            tail.setNext(head);
            head.setPrev(tail);
        }
    }

    @Override
    public void insert(DNode node, int position) {
        if (position <= 0 || position > size + 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertHead(node);
            return;
        }

        if (position == size + 1) {
            insertTail(node);
            return;
        }
        super.insert(node, position);
        tail.setNext(head);
        head.setPrev(tail);
    }

    @Override
    public void deleteHead() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        head = head.getNext();
        head.setPrev(tail);
        tail.setNext(head);
        size--;
    }

    @Override
    public void deleteTail() {
        if (tail == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        tail = tail.getPrev();
        tail.setNext(head);
        head.setPrev(tail);
        size--;
    }

    @Override
    public void delete(DNode node) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (head.equals(node)) {
            deleteHead();
            return;
        }

        if (tail.equals(node)) {
            deleteTail();
            return;
        }

        super.delete(node);
        tail.setNext(head);
        head.setPrev(tail);
    }

    @Override
    public void sort() {
        if (head == null) {
            return;
        }
        DNode current = head;
        DNode next = null;
        int temp;
        while (current.getNext() != head) {
            next = current.getNext();
            while (next != head) {
                if (current.getData() > next.getData()) {
                    temp = current.getData();
                    current.setData(next.getData());
                    next.setData(temp);
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
    }

    @Override
    public void sortedInsert(DNode node) {
        if (!isSorted()){
            sort();
        }
        if (head == null || node.getData() < head.getData()){
            insertHead(node);
            return;
        }
        DNode current = head;
        while (current.getNext() != head && current.getNext().getData() < node.getData()){
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
        node.setPrev(current);
        current.getNext().setPrev(node);
    
        if(current == tail){
            tail = node;
        }
        size++;   
    }
    
    @Override
    public boolean isSorted() {
        if (head == null) {
            return true;
        }
        DNode current = head;
        for (int i = 0; i < size - 1; i++) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    @Override
    public void print() {

        System.out.println("List length: " + size);
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (isSorted()) {
            System.out.println("List is sorted.");
        } else {
            System.out.println("List is not sorted.");
        }

        System.out.print("List content: ");
        DNode current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    // Main method for testing our CDLL class
    public static void main(String[] args){
        // Create a new empty list
        System.out.println("Creating a new empty Circular Doubly Linked List...\n");
        CDLL list = new CDLL();
        list.print(); // Output: List length: 0, List is empty.
        System.out.println();

        // Insert into an empty list
        System.out.println("Inserting into an empty list...\n");
        DNode node1 = new DNode(15);
        list.insert(node1, 1);
        list.print(); // Output: List length: 1, List is sorted., List content: 15
        System.out.println();

        // Do a sequence of insertions
        System.out.println("Making a sequence of insertions...\n");
        DNode node2 = new DNode(20);
        DNode node3 = new DNode(10);
        DNode node4 = new DNode(5);
        DNode node5 = new DNode(25);

        list.insertHead(node2);
        list.print(); // Output: List length: 2, List is not sorted., List content: 20 15
        System.out.println();

        list.sortedInsert(node3);
        list.print(); // Output: List length: 3, List is sorted., List content: 10 15 20
        System.out.println();

        list.insertTail(node4);
        list.print(); // Output: List length: 4, List is not sorted., List content: 10 15 20 5
        System.out.println();

        list.insert(node5, 3);
        list.print(); // Output: List length: 5, List is not sorted., List content: 10 15 25 20 5
        System.out.println();

        // FUlly clear the list by a sequence of deletions
        System.out.println("Deleting the list...\n");
        list.delete(node5);
        list.print(); // Output: List length: 4, List is not sorted., List content: 10 15 20 5
        System.out.println();

        list.deleteTail();
        list.print(); // Output: List length: 3, List is sorted., List content: 10 15 20
        System.out.println();

        list.deleteHead();
        list.print(); // Output: List length: 2, List is sorted., List content: 15 20
        System.out.println();

        list.deleteHead();
        list.print(); // Output: List length: 1, List is sorted., List content: 20
        System.out.println();

        list.deleteHead();
        list.print(); // Output: List length: 0, List is empty.
        System.out.println();

        // Do another insert to make sure the list is emoty again after clearing it
        System.out.println("Inserting into an empty list again...\n");
        DNode node6 = new DNode(99);
        list.insertHead(node6);
        list.print(); // Output: List length: 1, List is sorted., List content: 99
        System.out.println();

        // Searching for a node
        System.out.println("Updating the list again...\n");
        DNode node7 = new DNode(77);
        list.sortedInsert(node7);
        list.print(); // Output: List length: 2, List is sorted., List content: 77 99
        System.out.println();

        System.out.println("Searching for node 6 within the list ...");
        int finder = list.search(node6).getData();
        System.out.println("The search found that node 6's data is: " + finder);
        System.out.println();

        // Checking id the list can be cleared
        System.out.println("Clearing the list...");
        list.clear();
        list.print(); // Output: List length: 0, List is empty.
    }
}
