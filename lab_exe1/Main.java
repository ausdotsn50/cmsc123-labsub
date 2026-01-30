/*
    During this lab exercise (Lab 1 for CMSC 123), only a hardcoded level-order binary tree was presented to the instructor.
    Additionally, the pre-order traversal algorithm worked for the test-cases given in the lab paper.

    Lab 1
    - This exercise required to input a level-order binary tree where you can have null(left & right children).
    - Moreover, a pre-order traversal must be applied after constructing the level-order binary tree.
    - One of the learning post this lab exercise was remembering data structures from CMSC 122: DSA I class where
        a queue can be used for the obstacle faced relating to a FIFO mechanism.
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

// Node data struct
class Node {
    public int data;
    public Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    ArrayList<Integer> treeInput;
    List<Integer> preOrderedTree;
    
    public BinaryTree() {
        this.treeInput = new ArrayList<Integer>(); 
        this.preOrderedTree = new ArrayList<>();
    }

    // Func part is generated
    // Function to create a level-order tree
    public void createLevelOrderTree() {
        root = new Node(treeInput.get(0));

        // Use queue as data struct for easy popping of Nodes that need children
        Queue<Node> appendChild = new LinkedList<>();
        appendChild.add(root);
        
        int index = 1; 
        while (!appendChild.isEmpty() && index < treeInput.size()) {
            Node current = appendChild.poll();

            if(current.data == -1) {
                continue;
            }

            // Append left child    
            if (index < treeInput.size()) {
                current.left = new Node(treeInput.get(index));
                appendChild.add(current.left);
                index++;
            }
            
            // Append right child 
            if (index < treeInput.size()) {
                current.right = new Node(treeInput.get(index));
                appendChild.add(current.right);
                index++;
            }
        }
    }

    // Pre-order algorithm works fine for the commented use-case below
    public void preOrder(Node node, List<Integer> preOrderedTree) {
        if (node == null)  {
            return;
        }

        if(node.data != -1 ) {
            preOrderedTree.add(node.data);
            preOrder(node.left, preOrderedTree);
            preOrder(node.right, preOrderedTree);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Utils
        Scanner scn = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        
        // User-input handling
        int valuesCount;
        System.out.print("How many values are you going to input? ");
        valuesCount = scn.nextInt();

        for(int i = 0; i < valuesCount; i++) {
            System.out.print("Enter a value: ");
            bt.treeInput.add(scn.nextInt());
        }

        System.out.println(bt.treeInput); // See what you inputted
        bt.createLevelOrderTree(); // Level order tree create
        
        // Pre-order the tree
        bt.preOrder(bt.root, bt.preOrderedTree); // Pre-order before printing

        System.out.println("This is the pre-ordered tree: " + bt.preOrderedTree);
        scn.close();
    }
}
