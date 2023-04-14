package myLib.datastructures.linear;
import myLib.datastructures.nodes.DNode;

public class DLL {
    protected DNode head;
    protected DNode tail;
    protected int size;
    
    public DLL(){
        head = null;
        tail = null;
        size = 0;
    }

    public DLL(DNode node){
        head = node;
        tail = node;
        size = 1;
    }

    public void insertHead(DNode node){
        if (head == null){
            head = node;
            tail = node;
            size = 1;
        }
        else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
            size++;
        }
    }

    public void insertTail(DNode node){
        if (tail == null){
            head = node;
            tail = node;
            size = 1;
        }
        else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            size++;
        }
    }

    public void insert(DNode node, int position){
        if (position <= 0 || position > size + 1){
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1){
            insertHead(node);
            return;
        }

        if (position == size + 1){
            insertTail(node);
            return;
        }

        DNode current = head;
        for (int i = 1; i < position; i++){
            current = current.getNext();
        }
        node.setNext(current);
        node.setPrev(current.getPrev());
        current.getPrev().setNext(node);
        current.setPrev(node);
        size++;
    }

    public void sortedInsert(DNode node){
        if (!isSorted()){
            sort();
        }
        if (head == null || node.getData() < head.getData()){
            insertHead(node);
            return;
        }
        DNode current = head;
        while (current.getNext() != null && current.getNext().getData() < node.getData()){
            current = current.getNext();
        }
        node.setNext(current.getNext());
        if (current.getNext() != null) {
            current.getNext().setPrev(node);
        } else {
            tail = node;
        }
        node.setPrev(current);
        current.setNext(node);
        size++; 
    }

    public DNode search(DNode node){
        DNode current = head;
        while (current != null){
            if (current.equals(node)){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteHead(){
        if (head == null){
            System.out.println("The list is empty.");
            return;
        }
        if (head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }
        head = head.getNext();
        head.setPrev(null);
        size--;
    }

    public void deleteTail(){
        if (tail == null){
            System.out.println("The list is empty.");
            return;
        }
        if (head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }
        tail = tail.getPrev();
        tail.setNext(null);
        size--;
    }

    public void delete(DNode node){
        if (head == null){
            System.out.println("The list is empty.");
            return;
        }

        if (head.equals(node)){
            deleteHead();
            return;
        }

        if (tail.equals(node)){
            deleteTail();
            return;
        }

        DNode current = head;
        while (current != null){
            if (current.equals(node)){
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void sort() {
            if (head == null || head.getNext() == null) {
                // List is empty or has only one element
                return;
            }
            
            DNode current = head.getNext();
            while (current != null) {
                DNode next = current.getNext();
                sortedInsert(current);
                current = next;
            }
    }
    
    public boolean isSorted(){
        if (head == null || head.getNext() == null){
            return true;
        }
        DNode current = head;
        while (current.getNext() != null){
            if (current.getData() > current.getNext().getData()){
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
        //Check this later
    }

    public void print(){
        System.out.println("List length: " + size);
        if (head == null){
            System.out.println("List is empty.");
            return;
        }

        if (isSorted()){
            System.out.println("List is sorted.");
        }
        else {
            System.out.println("List is not sorted.");
        }

        System.out.print("List content: ");
        DNode current = head;
        while (current != null){
            System.out.print(current.getData() + " ");
        current = current.getNext();
        }
        System.out.println();
    }

    // Main method for testing our DLL class
    public static void main(String[] args){
        // Create a new empty list
        System.out.println("Creating a new empty Doubly Linked List...\n");
        DLL list = new DLL();
        list.print(); // Output: List length: 0, List is sorted., List content:
        System.out.println();

        // Insert into an empty list
        System.out.println("Inserting into an empty list...\n");
        DNode node1 = new DNode(15);
        list.insert(node1, 1);
        list.print(); // Output: List length: 1, List is sorted., List content: 15
        System.out.println();

        // Do a sequence of insertions
        System.out.println("Making a sequence of insertions...\n");
        DNode node2 = new DNode(10);
        DNode node3 = new DNode(20);
        DNode node4 = new DNode(7);
        DNode node5 = new DNode(25);

        list.sortedInsert(node2);
        list.print(); // Output: List length: 2, List is sorted., List content: 10 15
        System.out.println();

        list.insert(node3, 1);
        list.print(); // Output: List length: 3, List is not sorted., List content: 20 10 15
        System.out.println();

        list.insertHead(node4);
        list.print(); // Output: List length: 4, List is not sorted., List content: 7 20 10 15
        System.out.println();

        list.insertTail(node5);
        list.print(); // Output: List length: 5, List is not sorted., List content: 7 20 10 15 25
        System.out.println();

        // Fully clear the list by a sequence of deletions
        System.out.println("Deleting the list...\n");
        list.delete(node4);
        list.print(); // Output: List length: 4, List is not sorted., List content: 20 10 15 25
        System.out.println();

        list.deleteHead();
        list.print(); // Output: List length: 3, List is sorted., List content: 10 15 25
        System.out.println();

        list.delete(node2);
        list.print(); // Output: List length: 2, List is sorted., List content: 15 25
        System.out.println();

        list.deleteTail();
        list.print(); // Output: List length: 1, List is sorted., List content: 15
        System.out.println();

        list.delete(node1);
        list.print(); // Output: List length: 0, List is sorted., List content:
        System.out.println();

        // Do another insert to make sure the list is empty again after clearing it
        System.out.println("Inserting into an empty list again...\n");
        DNode node6 = new DNode(27);
        list.insertHead(node6);
        list.print(); // Output: List length: 1, List is sorted., List content: 27
        System.out.println();

        // Searching for a node
        System.out.println("Updating the list again...\n");
        DNode node7 = new DNode(30);
        list.insertHead(node7);
        list.print(); // Output: List length: 2, List is not sorted., List content: 30 27
        System.out.println();

        System.out.println("Searching for the \"node6\" test object within the list...\n");
        int finder = list.search(node6).getData();
        System.out.println("The search found that node6's data is: " + finder);
        System.out.println();

        // Checking if the lst can be cleared
        System.out.println("Clearing the list...\n");
        list.clear();
        list.print(); // Output: List length: 0, List is sorted., List content: 
    }
}
