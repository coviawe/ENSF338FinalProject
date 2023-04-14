package myLib.datastructures.trees;
import myLib.datastructures.nodes.TNode;

import java.util.Queue;
import java.util.LinkedList;


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

    @Override
    public void setRoot(TNode root) {
        if (root.getLeft() != null || root.getRight() != null) {
            // Perform the same operations as in the overloaded constructor
            TNode newRoot = new TNode(root.getData(), height(root), null, null, null);
            if (root.getLeft() != null) {
                TNode newLeft = new TNode(root.getLeft().getData(), height(root.getLeft()), null, null, newRoot);
                newRoot.setLeft(newLeft);
            }
            if (root.getRight() != null) {
                TNode newRight = new TNode(root.getRight().getData(), height(root.getRight()), null, null, newRoot);
                newRoot.setRight(newRight);
            }
            root = newRoot;
        }
        super.setRoot(root);
    }

    @Override
    public TNode getRoot() {
        return super.getRoot();
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

    public void printInOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void printBF() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode currNode = queue.poll();
                System.out.print(currNode.getData() + " ");
                if (currNode.getLeft() != null) {
                    queue.add(currNode.getLeft());
                }
                if (currNode.getRight() != null) {
                    queue.add(currNode.getRight());
                }
            }
            System.out.println();
        }
    }

    public TNode search(int val) {
        TNode current = root;
        while (current != null) {
            if (current.getData() == val) {
                return current;
            } else if (current.getData() > val) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return null;
    }

    // Main method for testing our AVL tree
    public static void main(String[] args) {
        // Create a new AVL tree
        System.out.println("Creating a new AVL tree...\n");
        AVL avl = new AVL();
        TNode test = new TNode(); // Should initialize to null
        System.out.println("The \"printBF\" method says: ");
        avl.printBF(); // Should print "Tree is empty"
        System.out.println();
        System .out.println("The \"printInOrder\" method says: ");
        avl.printInOrder(); // Should print "Tree is empty"
        System.out.println();
        
        // Insert into the empty tree
        System.out.println("Inserting into the AVL tree...\n");
        avl.insert(5);
        System.out.println("AVL tree after insertions (\"printInOrder\" method):\n");
        avl.printInOrder(); // Should print "5"
        System.out.println();
        System.out.println("AVL tree after insertions (\"printBF\" method):\n");
        avl.printBF(); // Should print "5"
        System.out.println();

        // Do a sequence of insertions
        System.out.println("Making a sequence of insertions...\n");
        System.out.println("After the first set of insertions");
        avl.insert(3);
        avl.insert(1);
        avl.insert(test);

        System.out.println("AVL tree after insertions (\"printInOrder\" method):\n");
        avl.printInOrder(); // Should print "0 1 3 5" 
        System.out.println();
        System.out.println("AVL tree after insertions (\"printBF\" method):\n");
        avl.printBF(); // Should print "3, 1 5, 0"
        System.out.println();

        System.out.println("After the second set of insertions");
        avl.insert(4);
        avl.insert(7);
        avl.insert(6);
        avl.insert(9);

        System.out.println("AVL tree after insertions (\"printInOrder\" method):\n");
        avl.printInOrder(); // Should print "0 1 3 4 5 6 7 9"
        System.out.println();
        System.out.println("AVL tree after insertions (\"printBF\" method):\n");
        avl.printBF(); // Should print "3, 1 5, 0 4 7, 6 9"
        System.out.println();

        // Fully clear the tree by a sequence of deletions
        System.out.println("Clearing the tree by a sequence of deletions...\n");
        System.out.println("After the first set of deletions");
        avl.delete(7);
        avl.delete(5);
        avl.delete(3);
        avl.delete(1);

        System.out.println("AVL tree after deletions (\"printInOrder\" method):\n");
        avl.printInOrder(); // Should print "0 4 6 9"
        System.out.println();
        System.out.println("AVL tree after deletions (\"printBF\" method):\n");
        avl.printBF(); // Should print "4, 0 6, 9"
        System.out.println();

        System.out.println("After the second set of deletions");
        avl.delete(4);
        avl.delete(0);
        avl.delete(6);
        avl.delete(9);

        System.out.println("AVL tree after deletions (\"printInOrder\" method):\n");
        avl.printInOrder(); // Should print "Tree is empty"
        System.out.println();
        System.out.println("AVL tree after deletions (\"printBF\" method):\n");
        avl.printBF(); // Should print "Tree is empty"
        System.out.println();

        // Do another insert to make sure the tree is empty
        System.out.println("Inserting into the AVL tree again...\n");
        TNode test2 = new TNode();
        test2.setData(100);
        avl.insert(test2);
        System.out.println("AVL tree after insertion (\"printInOrder\" method):\n");
        avl.printInOrder(); // Should print "100"
        System.out.println();
        System.out.println("AVL tree after insertion (\"printBF\" method):\n");
        avl.printBF(); // Should print "100"
        System.out.println();

        // Search for a value in the tree
        System.out.println("Updating the tree again...\n");
        avl.insert(7);
        System.out.println("AVL tree after insertion (\"printInOrder\" method):\n");
        avl.printInOrder(); // Should print "7 100"
        System.out.println();
        System.out.println("AVL tree after insertion (\"printBF\" method):\n");
        avl.printBF(); // Should print "100, 7"
        System.out.println();

        System.out.println("Searching for Node with value of 7...\n");
        TNode result = avl.search(7); // Should return a node with value 7
        if (result != null) {
            System.out.println("Found node with value " + result.getData() + " in AVL tree.");
        } else {
            System.out.println("Node with this value not found in AVL tree.");
        }
        System.out.println();
        
        System.out.println("Deleting Node with value of 7...\n");
        avl.delete(7);
        
        System.out.println("Searching for Node with value of 7 again...\n");
        result = avl.search(7); // Should return null
        if (result != null) {
            System.out.println("Found node with value " + result.getData() + " in AVL tree.");
        } else {
            System.out.println("Node with this value not found in AVL tree.");
        }
        System.out.println();
        
        //Clearing the tree
        System.out.println("Clearing the tree...\n");
        avl.delete(100);
        System.out.println("AVL tree after deletion (\"printInOrder\" method):\n");
        avl.printInOrder(); // Should print "Tree is empty"
        System.out.println();
        System.out.println("AVL tree after deletion (\"printBF\" method):\n");
        avl.printBF(); // Should print "Tree is empty"
        System.out.println();
        System.out.println("The tree has been cleared.");
    }
}
