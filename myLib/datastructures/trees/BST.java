public class BST {
    protected TNode root;
    
    public BST() {
        this.root = null;
    }
    
    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }
    
    public BST(TNode obj) {
        this.root = obj;
    }
    
    public TNode getRoot() {
        return this.root;
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
    
    public void delete(int val) {
        if (root == null) {
        System.out.println("The tree is empty.");
        return;
        }
    
        TNode curr = root;
        TNode parent = null;
        boolean isLeftChild = false;
    
        // find the node to be deleted
        while (curr != null && curr.getData() != val) {
            parent = curr;
            if (val < curr.getData()) {
                curr = curr.getLeft();
                isLeftChild = true;
            } else {
                curr = curr.getRight();
                isLeftChild = false;
            }
        }
    
    // if the node was not found
        if (curr == null) {
            System.out.println("Value not found in the tree.");
            return;
        }
    
    // if the node has no children
        if (curr.getLeft() == null && curr.getRight() == null) {
            if (curr == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
    // if the node has one child
        else if (curr.getRight() == null) {
            if (curr == root) {
                root = curr.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(curr.getLeft());
            } else {
                parent.setRight(curr.getLeft());
            }
        } else if (curr.getLeft() == null) {
            if (curr == root) {
                root = curr.getRight();
            } else if (isLeftChild) {
                parent.setLeft(curr.getRight());
            } else {
                parent.setRight(curr.getRight());
            }
        }
    // if the node has two children
        else {
            TNode successor = getSuccessor(curr);
            if (curr == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(curr.getLeft());
        }
    }

// helper method to get the successor of a given node
    private TNode getSuccessor(TNode node) {
        TNode successorParent = node;
        TNode successor = node;
        TNode curr = node.getRight();
    
        while (curr != null) {
            successorParent = successor;
            successor = curr;
            curr = curr.getLeft();
        }
    
        if (successor != node.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }
    
        return successor;
    }
}
