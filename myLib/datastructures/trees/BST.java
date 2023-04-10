public class BST {
    private TNode root;
    
    public BST() {
        root = null;
    }
    
    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }
    
    public BST(TNode obj) {
        this.root = obj;
    }
    
    public TNode getRoot() {
        return root;
    }
    
    public void setRoot(TNode root) {
        this.root = root;
    }
    
    public void insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null);
        if (root == null) {
            root = newNode;
        } else {
            TNode current = root;
            TNode parent;
            while (true) {
                parent = current;
                if (val < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        newNode.setParent(parent);
                        break;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        newNode.setParent(parent);
                        break;
                    }
                }
            }
        }
    }
    
    public void insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            TNode current = root;
            TNode parent;
            while (true) {
                parent = current;
                if (node.getData() < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(node);
                        node.setParent(parent);
                        break;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(node);
                        node.setParent(parent);
                        break;
                    }
                }
            }
        }
    }
    
    public void
