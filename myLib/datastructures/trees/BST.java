package myLib.datastructures.trees;

public class BST {
    private TNode root;

    public BST() {
        root = null;
    }

    public BST(int val) {
        root = new TNode(val, 0, null, null, null);
    }

    public BST(TNode obj) {
        root = obj;
    }

    public void setRoot(TNode node) {
        root = node;
    }

    public TNode getRoot() {
        return root;
    }

    public void insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null);
        if (root == null) {
            root = newNode;
            return;
        }
        TNode current = root;
        TNode parent = null;
        while (true) {
            parent = current;
            if (val < current.getData()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    newNode.setParent(parent);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    newNode.setParent(parent);
                    return;
                }
            }
        }
    }

    public void insert(TNode node) {
        if (root == null) {
            root = node;
            return;
        }
        TNode current = root;
        TNode parent = null;
        while (true) {
            parent = current;
            if (node.getData() < current.getData()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(node);
                    node.setParent(parent);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(node);
                    node.setParent(parent);
                    return;
                }
            }
        }
    }

    public void delete(int val) {
        TNode current = root;
        TNode parent = root;
        boolean isLeftChild = false;
        while (current.getData() != val) {
           

