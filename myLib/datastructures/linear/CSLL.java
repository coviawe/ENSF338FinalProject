package myLib.datastructures.linear;
import myLib.datastructures.nodes.SNode;

public class CSLL extends SLL{
    
    public CSLL(){
        super();
    }

    public CSLL(SNode node){
        super(node);
        head.setNext(head);
    }

    @Override
    public void insertHead(SNode node){
        super.insertHead(node);
        tail.setNext(head);
    }

    @Override
    public void insertTail(SNode node){
        super.insertTail(node);
        tail.setNext(head);
    }

    @Override
    public void insert(SNode node, int position){
        super.insert(node, position);
        tail.setNext(head);
    }

    @Override
    public void deleteHead(){
        if (head == null){
            System.out.println("List is empty.");
            return;
        }
        if (head == tail){
            head = null;
            tail = null;
            size = 0;
            return;
        }
        head = head.getNext();
        tail.setNext(head);
        size--;
    }

    @Override
    public void deleteTail(){
        super.deleteTail();
        tail.setNext(head);
    }

    @Override
    public void delete(SNode node) {
        super.delete(node);
        tail.setNext(head);
    }
    
    @Override
    public void sortedInsert(SNode node){
        super.sortedInsert(node);
        tail.setNext(head);
    }

    @Override
    public void sort(){
        if (!isSorted()){
            SNode current = head;
            SNode next = null;
            int temp;
            while (current.getNext() != head){
                next = current.getNext();
                while (next != head){
                    if (current.getData() > next.getData()){
                        temp = current.getData();
                        current.setData(next.getData());
                        next.setData(temp);
                    }
                    next = next.getNext();
                }
                current = current.getNext();
            }
        } 
    }

    @Override
    public boolean isSorted(){
        if (head == null || head.getNext() == null){
            return true;
        }
        SNode current = head;
        while (current.getNext() != head){
            if (current.getData() > current.getNext().getData()){
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    @Override
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
        SNode node = head;
        while (node != null){
            System.out.print(node.getData() + " ");
            node = node.getNext();
            if (node == head){
                break;
            }
        }
        System.out.println();
    }

    // Main method for testing our CSLL class
    public static void main(String[] args){
        // Create a new empty list
        System.out.println("Creating a new empty Circular Singly Linked List...\n");
        CSLL list = new CSLL();
        list.print(); //Output: List length: 0, List is empty
        System.out.println();

        // Insert into an empty list
        System.out.println("Inserting into an empty list...\n");
        SNode node1 = new SNode(11);
        list.insert(node1, 1);
        list.print(); //Output: List length: 1, List is sorted., List content: 11
        System.out.println();

        // Do a sequence of insertions
        System.out.println("Making a sequence of insertions...\n");
        SNode node2 = new SNode(22);
        SNode node3 = new SNode(2023);
        SNode node4 = new SNode(19);
        SNode node5 = new SNode(712);

        list.insertHead(node2);
        list.print(); //Output: List length: 2, List is not sorted., List content: 22 11
        System.out.println();

        list.insertTail(node3);
        list.print(); //Output: List length: 3, List is not sorted., List content: 22 11 2023
        System.out.println();

        list.sortedInsert(node4);
        list.print(); //Output: List length: 4, List is sorted., List content: 11 19 22 2023
        System.out.println();

        list.insert(node5, 4);
        list.print(); //Output: List length: 5, List is sorted., List content: 11 19 22 712 2023
        System.out.println();

        // Fully clear the list by a sequence of deletes
        System.out.println("Deleting the list...\n");
        list.delete(node4);
        list.print(); //Output: List length: 4, List is sorted., List content: 11 22 712 2023
        System.out.println();

        list.deleteHead();
        list.print(); //Output: List length: 3, List is sorted., List content: 22 712 2023
        System.out.println();

        list.deleteTail();
        list.print(); //Output: List length: 2, List is sorted., List content: 22 712
        System.out.println();

        list.delete(node5);
        list.print(); //Output: List length: 1, List is sorted., List content: 22
        System.out.println();

        list.deleteHead();
        list.print(); //Output: List length: 0, List is empty.
        System.out.println();

        // Do another insert to make sure the list is empty again after clearing it
        System.out.println("Inserting into an empty list again...\n");
        SNode node6 = new SNode(77);
        list.insertHead(node6);
        list.print(); //Output: List length: 1, List is sorted., List content: 77
        System.out.println();

        // Searching for a node
        System.out.println("Updating the list again...\n");
        SNode node7 = new SNode(7);
        list.insert(node7, 2);
        list.print(); // Output: List length: 2, List is sorted., List content: 77 7
        System.out.println();

        System.out.println("Searching for the \"node6\" test object within the list...\n");
        int finder = list.search(node6).getData();
        System.out.println("The search found that node6's data is: " + finder); // Output: 77
        System.out.println();

        // Checking if the list can be cleared
        System.out.println("Clearing the list...\n");
        list.clear();
        list.print(); // Output: List length: 0, List is empty.
    }
}
