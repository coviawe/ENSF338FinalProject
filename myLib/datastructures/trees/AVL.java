package myLib.datastructures.trees;

package myLib.datastructures.tree;

public class AVL extends BST {

    public AVL() {
        super();
    }

    public AVL(int val) {
        super(val);
    }

    public AVL(TNode obj) {
        super(obj);
        balance(this.root);
    }

    public void setRoot(TNode root) {
        super.setRoot(root);
        balance(this.root);
    }

    private void balance(TNode node) {
        if (node == null) {
            return;
        }
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                rightRotate(node);
            } else {
                leftRotate(node.left);
                rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                leftRotate(node);
            } else {
                rightRotate(node.right);
                leftRotate(node);
            }
        }
        balance(node.parent);
    }

    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private void leftRotate(TNode node) {
        TNode rightChild = node.right;
        TNode parent = node.parent;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.left = node;
        node.parent = rightChild;
        rightChild.parent = parent;
        if (parent == null) {
            this.root = rightChild;
        } else if (parent.right == node) {
            parent.right = rightChild;
        } else {
            parent.left = rightChild;
        }
    }

    private void rightRotate(TNode node) {
        TNode leftChild = node.left;
        TNode parent = node.parent;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.right = node;
        node.parent = leftChild;
        leftChild.parent = parent;
        if (parent == null) {
            this.root = leftChild;
        } else if (parent.right == node) {
            parent.right = leftChild;
        } else {
            parent.left = leftChild;
        }
    }

    @Override
    public void insert(int val) {
        super.insert(val);
        balance(this.root);
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        balance(this.root);
    }

    // Bonus:
    @Override
    public void delete(int val) {
        TNode nodeToDelete = search(val);
        if (nodeToDelete == null) {
            System.out.println("Value " + val + " not found in tree.");
            return;
        }
        TNode parent = nodeToDelete.parent;
        super.delete(val);
        balance(parent);
    }

}

