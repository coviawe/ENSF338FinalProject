// package myLib.datastructures.linear;

public class QueueLL extends SLL{
    public QueueLL(){
        super();
    }

    public void enqueue(SNode node){
        super.insertTail(node);
    }

    public SNode dequeue(){
        SNode node = null;
        if (head == null){
            System.out.println("Queue is empty.");
        }
        else {
            node = head;
            head = head.getNext();
            size--;
        }
        return node;
    }

    public void printQueue(){
        print();
    }

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
    public void sort() {
        // Empty body to avoid misuse of method in a queue
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }   
}
