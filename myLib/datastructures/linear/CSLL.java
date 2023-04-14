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
        super.deleteHead();
        tail.setNext(head);
    }

    @Override
    public void deleteTail(){
        SNode secondToLast = head;
        while (secondToLast.getNext() != tail){
            secondToLast = secondToLast.getNext();
        }
        super.deleteTail();
        secondToLast.setNext(head);
    }

    @Override
    public void delete(SNode node){
        SNode prev = head;
        while (prev.getNext() != node){
            prev = prev.getNext();
        }
        super.delete(node);
        prev.setNext(node.getNext());
    }

    @Override
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
        tail.setNext(head);
        size++;
    }

    @Override
    public boolean isSorted(){
        if (head == null || head.getNext() == head){
            return true;
        }
        SNode current = head;
        while (current != head){
            if (current.getData() > current.getNext().getData()){
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    @Override
    public void clear(){
        super.clear();
        head.setNext(head);
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
        list.print(); //Output: List length: 0, List is sorted., List content:
        System.out.println();

        // Insert into an empty list
        System.out.println("Inserting into an empty list...\n");
        SNode node1 = new SNode(11);
        list.insert(node1, 1);
        list.print(); //Output: List length: 1, List is sorted., List content: 11
        System.out.println();

        SNode node2 = new SNode(22);
        list.sortedInsert(node2);
        list.print(); //Output: List length: 2, List is sorted., List content: 11 22

    }
}
