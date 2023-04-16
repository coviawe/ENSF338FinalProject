package myLib.datastructures.nodes;

public class DNode {
    private int data;
    private DNode next = null;
    private DNode prev = null;
    
    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public DNode getNext() {
        return next;
    }
    
    public void setNext(DNode next) {
        this.next = next;
    }
    
    public DNode getPrev() {
        return prev;
    }
    
    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    // Main method for testing our DNode class
    public static void main(String[] args){
        // Create a new node
        System.out.println("Creating a new node with a data of 1...\n");
        DNode node = new DNode(1);
        System.out.println("The data of the created node is: " + node.getData()); // Output: 1
        System.out.println();

        // Change the data in the node
        System.out.println("Changing data of the node to 2...\n");
        node.setData(2);
        System.out.println("The data of the node has been updated to: " + node.getData()); // Output: 2
        System.out.println();

        // Create a new node and set it as the next node
        System.out.println("Creating a new node with a data of 3...\n");
        DNode node2 = new DNode(3);
        System.out.println("Setting the new node as the next node of the first node...\n");
        node.setNext(node2);
        System.out.println("The next node to the first node has a value of: " + node.getNext().getData()); // Output: 3
        System.out.println();

        // Create a new node and set it as the previous node
        System.out.println("Creating a new node with a data of 4...\n");
        DNode node3 = new DNode(4);
        System.out.println("Setting the new node as the previous node of the first node...\n");
        node.setPrev(node3);
        System.out.println("The previous node to the first node has a value of: " + node.getPrev().getData()); // Output: 4
        System.out.println();

        // Showing the current sequence of nodes
        System.out.println("Here is the current sequence of nodes");
        System.out.println("--------------------------------------");
        System.out.println(node.getPrev().getData() + " <-> " + node.getData() + " <-> " + node.getNext().getData()); // Output: 4 <-> 2 <-> 3
    }
}