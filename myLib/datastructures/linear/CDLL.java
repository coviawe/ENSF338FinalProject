// package myLib.datastructures.linear;

public class CDLL extends DLL {
    public CDLL(){
        super();
    }
    
    public CDLL(DNode node){
        super(node);
        node.setNext(node);
        node.setPrev(node);
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
    public void clear() {
        super.clear();
        tail.setNext(head);
        head.setPrev(tail);
    }
}
