package myLib.datastructures.nodes;

public class SNode {
    private int data;
    private SNode next = null;
    
    public SNode(int data) {
        this.data = data;
        this.next = null;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public SNode getNext() {
        return next;
    }
    
    public void setNext(SNode next) {
        this.next = next;
    }

    // Main method for testing our SNode class
    public static void main(String[] args) {
        // Create a new node
        System.out.println("Creating a new node with a data of 5...\n");
        SNode node = new SNode(5);
        System.out.println("The data of the created node is: " + node.getData()); // Output: 5
        System.out.println();

        // Change the data in the node
        System.out.println("Changing data of the node to 10...\n");
        node.setData(10);
        System.out.println("The data of the node has been updated to: " + node.getData()); // Output: 10
        System.out.println();

        // Create a new node and set it as the next node
        System.out.println("Creating a new node with a data of 15...\n");
        SNode node2 = new SNode(15);
        System.out.println("Setting the new node as the next node of the first node...\n");
        node.setNext(node2);
        System.out.println("The next node to the first node has a value of: " + node.getNext().getData()); // Output: 15
        System.out.println();

        // Showing the current sequence of nodes
        System.out.println("Here is the current sequence of nodes");
        System.out.println("--------------------------------------");
        System.out.println(node.getData() + " -> " + node.getNext().getData()); // Output: 10 -> 15
    }
}
