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
}
