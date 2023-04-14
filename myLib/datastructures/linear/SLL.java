package myLib.datastructures.linear;
import myLib.datastructures.nodes.SNode;

public class SLL {
    protected SNode head;
    protected SNode tail;
    protected int size;

    public SLL(){
        head = null;
        size = 0;
    }

    public SLL(SNode node){
        head = node;
        size = 1;
    }

    public void insertHead(SNode node){ 
        if (head == null){
            head = node;
            tail = node;
            size = 1;
        } 
        else {
            node.setNext(head);
            head = node;
            size++;
        }
    }

    public void insertTail(SNode node){
        if (tail == null){
            head = node;
            tail = node;
            size = 1;
        } 
        else {
            tail.setNext(node);
            tail = node;
            size++;
        }
    }

    public void insert(SNode node, int position){
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

        SNode current = head;
        for (int i = 1; i < position - 1; i++){
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }

    public void sortedInsert(SNode node){
        if (!isSorted()){
            sort();
        }
        if (head == null || node.getData() < head.getData()){
            insertHead(node);
            return;
        }
        SNode current = head;
        while (current.getNext() != null && current.getNext().getData() < node.getData()){
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }

    public SNode search(SNode node){
        SNode current = head;
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
        head = head.getNext();
        size--;
        if (head == null){
            tail = null;
        }
    }

    public void deleteTail(){
        if (tail == null){
            System.out.println("The list is empty.");
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
            size--;
            return;
        }

        SNode current = head;
        while (current.getNext() != tail){
            current = current.getNext();
        }
        current.setNext(null);
        tail = current;
        size--;
    }

    public void delete(SNode node){
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

        SNode current = head;
        while (current != null){
            if (current.getNext().equals(node)){
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void sort() {
        if (!isSorted()) {
            SNode current = head;
            while (current != null) {
                SNode next = current.getNext();
                current.setNext(null);
                sortedInsert(current);
                current = next;
            }
        }
    }
    
    public boolean isSorted(){
        if (head == null || head.getNext() == null){
            return true;
        }
        SNode current = head;
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
        SNode current = head;
        while (current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    // Main method for testing our SLL class
    public static void main(String[] args) {
        // Create a new empty list
        System.out.println("Creating a new empty Singly Linked List...\n");
        SLL list = new SLL();
        list.print(); // Output: List length: 0, List is empty.
        System.out.println();

        // Insert into an empty list
        System.out.println("Inserting into an empty list...\n");
        SNode node1 = new SNode(5);
        list.insert(node1, 1);
        list.print(); // Output: List length: 1, List is sorted., List content: 5
        System.out.println();

        // Do a sequence of insertions
        System.out.println("Making a sequence of insertions...\n");
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(8);
        SNode node4 = new SNode(4);
        SNode node5 = new SNode(3);
        
        list.insertHead(node2);
        list.print(); // Output: List length: 2, List is sorted., List content: 2 5
        System.out.println();

        list.insertTail(node3);
        list.print(); // Output: List length: 3, List is sorted., List content: 2 5 8
        System.out.println();

        list.sortedInsert(node4);
        list.print(); // Output: List length: 4, List is sorted., List content: 2 4 5 8
        System.out.println();

        list.insert(node5, 4);
        list.print(); //Output List length: 5, List is not sorted., List content: 2 4 5 3 8
        System.out.println();

        // Fully clear the list by a sequence of deletes
        System.out.println("Deleting the list...\n");
        list.delete(node2);
        list.print(); // Output: List length: 4, List is sorted., List content: 4 5 3 8
        System.out.println();

        list.deleteTail();
        list.print(); // Output: List length: 3, List is sorted., List content: 4 5 3
        System.out.println();

        list.deleteHead();
        list.print(); // Output: List length: 2, List is sorted., List content: 5 3
        System.out.println();

        list.delete(node1);
        list.print(); // Output: List length: 1, List is sorted., List content: 3
        System.out.println();

        list.deleteHead();
        list.print(); // Output: List length: 0, List is empty. 
        System.out.println();

        // Do another insert to make sure the list is empty again after clearing it
        System.out.println("Inserting into an empty list again...\n");
        SNode node6 = new SNode(3);
        list.insertHead(node6);
        list.print(); // Output: List length: 1, List is sorted., List content: 3
        System.out.println();

        // Searching for a node
        System.out.println("Updating the list again...\n");
        SNode node7 = new SNode(7);
        list.insert(node7, 2);
        list.print(); // Output: List length: 2, List is sorted., List content: 3 7
        System.out.println();

        System.out.println("Searching for the \"node6\" test object within the list...\n");
        int finder = list.search(node6).getData();
        System.out.println("The search found that node6's data is: " + finder); // Output: 3
        System.out.println();

        // Checking if the list can be cleared
        System.out.println("Clearing the list...\n");
        list.clear();
        list.print(); // Output: List length: 0, List is empty.
    }
}
