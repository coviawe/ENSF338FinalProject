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
}
