// package myLib.datastructures.linear;

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

        if (position == size){
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
        while (current.getNext() != null && !current.getNext().equals(node)){
            current = current.getNext();
        }
        if (current.getNext() != null){
            current.setNext(current.getNext().getNext());
            size--;
            if (current.getNext() == null){
                tail = current;
            }
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
        //Check this later
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
        SNode current = head;
        while (current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();

    }
}
