package myLib.datastructures.nodes;

public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    public TNode() {
        data = 0;
        left = null;
        right = null;
        parent = null;
        balance = 0;
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.balance = balance;
        parent = P;
        left = L;
        right = R;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getLeft() {
        return left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public TNode getRight() {
        return right;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public TNode getParent() {
        return parent;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void print() {
        System.out.println("Node: " + data + " Balance: " + balance);
    }

    public String toString() {
        return String.valueOf(data);
    }
}
