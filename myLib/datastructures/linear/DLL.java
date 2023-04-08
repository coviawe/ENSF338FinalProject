// package myLib.datastructures.linear;

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
}
