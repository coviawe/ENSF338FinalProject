package myLib.datastructures.trees;
import myLib.datastructures.nodes.TNode;

import java.util.Queue;
import java.util.LinkedList;


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
        BST bst = new BST();
        
        // Insert some values
        bst.insert(5);
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(7);
        bst.insert(6);
        bst.insert(9);
        
         // Print the tree
        System.out.println("BST tree after insertions (printInOrder method):");
        avl.printInOrder();
        System.out.println("BST tree after insertions (printBF method):");
        avl.printBF();

        System.out.println("Searching for Node with value of 7");
        //Check if node 7 exists
        TNode result = avl.search(7);
        if (result != null) {
            System.out.println("Found node with value " + result.getData() + " in BST tree.");
        } else {
            System.out.println("Node with this value not found in BST tree.");
        }
        

        System.out.println("Deleting Node with value of 7");
        // Delete a value
        avl.delete(7);

        System.out.println("Searching for Node with value of 7 again");

        result = avl.search(7);
        if (result != null) {
            System.out.println("Found node with value " + result.getData() + " in BST tree.");
        } else {
            System.out.println("Node with this value not found in BST tree.");
        }
        
        // Print the tree
        System.out.println("BST tree after deletions (printInOrder method):");
        avl.printInOrder();
        System.out.println("BST tree after deletions (printBF method):");
        avl.printBF();
        
    }
}
