package myLib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;
    
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }
    
    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.balance = balance;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public TNode getLeft() {
        return left;
    }
    
    public void setLeft(TNode left) {
        this.left = left;
    }
    
    public TNode getRight() {
        return right;
    }
    
    public void setRight(TNode right) {
        this.right = right;
    }
    
    public TNode getParent() {
        return parent;
    }
    
    public void setParent(TNode parent) {
        this.parent = parent;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public void print() {
        System.out.println("Data: " + this.data + ", Balance: " + this.balance);
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.data);
    }

    // Main method for testing our TNode class
    public static void main(String[] args){
        // Create a new node
        System.out.println("Creating a new node...\n");
        TNode node = new TNode();
        System.out.println("Setting the data of the node to 30...\n");
        node.setData(30);
        System.out.println("The data of the created node is: " + node.getData()); // Output: 30
        System.out.println();

        // Create a new node to use as the left node
        System.out.println("Creating a new node with a data of 20...\n");
        TNode leftKid = new TNode();
        leftKid.setData(20);
        System.out.println();

        // Create a new node to use as the right node
        System.out.println("Creating a new node with a data of 40...\n");
        TNode rightKid = new TNode();
        rightKid.setData(40);
        System.out.println();

        // Setting the first node as the parent of the new nodes
        System.out.println("Setting the first node as the parent of the new nodes...\n");  
        leftKid.setParent(node);
        rightKid.setParent(node);
        System.out.println("The parent of the left node is: " + leftKid.getParent().getData()); // Output: 30
        System.out.println("The parent of the right node is: " + rightKid.getParent().getData()); // Output: 30
        System.out.println();

        // Setting the new nodes as the left and right children of the first node
        System.out.println("Setting the new nodes as the left and right children of the first node...\n");
        node.setLeft(leftKid);
        node.setRight(rightKid);
        System.out.println("The left child of the first node is: " + node.getLeft().getData()); // Output: 20
        System.out.println("The right child of the first node is: " + node.getRight().getData()); // Output: 40
        System.out.println();

        // Changing the balance of the nodes
        System.out.println("Changing the balance of the nodes...\n");
        node.setBalance(1);
        leftKid.setBalance(3);
        rightKid.setBalance(2);
        System.out.println("The balance of the first node is: " + node.getBalance()); // Output: 1
        System.out.println();
        System.out.println("The balance of the left node is: " + leftKid.getBalance()); // Output: 3
        System.out.println();
        System.out.println("The balance of the right node is: " + rightKid.getBalance()); // Output: 2
        System.out.println();

        // Printing the parent and children nodes
        System.out.println("Printing the parent node...\n");
        node.print(); // Output: Data: 30, Balance: 1
        System.out.println();
        System.out.println("Printing the left child node...\n");
        leftKid.print(); // Output: Data: 20, Balance: 3
        System.out.println();
        System.out.println("Printing the right child node...\n");
        rightKid.print(); // Output: Data: 40, Balance: 2
        System.out.println();





    }
}
