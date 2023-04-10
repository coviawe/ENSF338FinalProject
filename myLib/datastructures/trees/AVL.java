public class AVL extends BST {
    public AVL() {
        super();
    }

    public AVL(int val) {
        super(val);
    }

    public AVL(TNode obj) {
        super(obj);
        if (obj != null) {
            this.root = balance(obj);
        }
    }

    private TNode balance(TNode node) {
        if (node == null) {
            return null;
        }

        node.setLeft(balance(node.getLeft()));
        node.setRight(balance(node.getRight()));
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.getLeft()) >= 0) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (balance < -1) {
            if (getBalance(node.getRight()) <= 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private int getBalance(TNode node) {
        if (node == null) {
            return 0;
        } else {
            return height(node.getLeft()) - height(node.getRight());
        }
    }

    private TNode rotateLeft(TNode node) {
        TNode right = node.getRight();
        node.setRight(right.getLeft());
        right.setLeft(node);
        return right;
    }

    private TNode rotateRight(TNode node) {
        TNode left = node.getLeft();
        node.setLeft(left.getRight());
        left.setRight(node);
        return left;
    }

    private int height(TNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.getLeft());
            int rightHeight = height(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    @Override
    public void insert(int val) {
        super.insert(val);
        this.root = balance(this.root);
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        this.root = balance(this.root);
    }

    @Override
    public void delete(int val) {
        super.delete(val);
        this.root = balance(this.root);
    }
}
