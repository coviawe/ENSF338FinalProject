// package myLib.datastructures.linear;

public class CSLL extends SLL{
    
    public CSLL(){
        super();
        head.setNext(head);
    }

    public CSLL(SNode node){
        super(node);
        head.setNext(head);
    }

    @Override
    public void insertHead(SNode node){
        super.insertHead(node);
        tail.setNext(head);
    }

    @Override
    public void insertTail(SNode node){
        super.insertTail(node);
        tail.setNext(head);
    }

    @Override
    public void insert(SNode node, int position){
        super.insert(node, position);
        tail.setNext(head);
    }

    @Override
    public void deleteHead(){
        super.deleteHead();
        tail.setNext(head);
    }

    @Override
    public void deleteTail(){
        SNode secondToLast = head;
        while (secondToLast.getNext() != tail){
            secondToLast = secondToLast.getNext();
        }
        super.deleteTail();
        secondToLast.setNext(head);
    }

    @Override
    public void delete(SNode node){
        SNode prev = head;
        while (prev.getNext() != node){
            prev = prev.getNext();
        }
        super.delete(node);
        prev.setNext(node.getNext());
    }

    @Override
    public void clear(){
        super.clear();
        head.setNext(head);
    }


    
}
