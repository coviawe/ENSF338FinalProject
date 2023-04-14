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


    
   

    public static void main(String[] args) {
        AVL avl = new AVL();
        
        // Insert some values
        avl.insert(5);
        avl.insert(3);
        avl.insert(1);
        avl.insert(4);
        avl.insert(7);
        avl.insert(6);
        avl.insert(9);
        
         // Print the tree
        System.out.println("AVL tree after insertions (printInOrder method):");
        avl.printInOrder();
        System.out.println("AVL tree after insertions (printBF method):");
        avl.printBF();

        System.out.println("Searching for Node with value of 7");
        //Check if node 7 exists
        TNode result = avl.search(7);
        if (result != null) {
            System.out.println("Found node with value " + result.getData() + " in AVL tree.");
        } else {
            System.out.println("Node with this value not found in AVL tree.");
        }
        

        System.out.println("Deleting Node with value of 7");
        // Delete a value
        avl.delete(7);

        System.out.println("Searching for Node with value of 7 again");

        result = avl.search(7);
        if (result != null) {
            System.out.println("Found node with value " + result.getData() + " in AVL tree.");
        } else {
            System.out.println("Node with this value not found in AVL tree.");
        }
        
        // Print the tree
        System.out.println("AVL tree after deletions (printInOrder method):");
        avl.printInOrder();
        System.out.println("AVL tree after deletions (printBF method):");
        avl.printBF();
        
        
    }
}
