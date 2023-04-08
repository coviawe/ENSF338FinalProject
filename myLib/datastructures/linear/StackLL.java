// package myLib.datastructures.linear;

public class StackLL extends SLL{
    public StackLL(){
        super();
    }

    public void push(SNode node){
        super.insertHead(node);
    }

    public SNode pop(){
        SNode node = head;
        super.deleteHead();
        return node;
    }

    public SNode peek(){
        return head;
    }

    // Override some methods that don't apply to stacks with empty body methods
    @Override
    public void insertTail(SNode node) {
        // Do nothing
    }

    @Override
    public void insert(SNode node, int position) {
        // Do nothing
    }

    @Override
    public void sortedInsert(SNode node) {
        // Do nothing
    }

    @Override
    public SNode search(SNode node) {
        // Do nothing
        return null;
    }

    @Override
    public void deleteTail() {
        // Do nothing
    }

    @Override
    public void delete(SNode node) {
        // Do nothing
    }

    @Override
    public void sort() {
        // Do nothing
    }
}
