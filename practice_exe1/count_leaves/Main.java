import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    public int data;
    public Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class LevelOrderConstructor {
    private Node root;
    private ArrayList<Integer> treeInput;
    
    public LevelOrderConstructor() {
        this.treeInput = new ArrayList<Integer>(); 
    }

    public Node getRoot() {
        return root;
    }

    public ArrayList<Integer> getTreeInput() {
        return treeInput;
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
}

public class Main {
    // Checking left and right of a node to identify if it's a leaf
    public static int countLeaves(Node root) { 
        if (root == null || root.data == -1) {
            return 0;
        }

        // Level order tree includes a -1 input
        // Handle in countLeaves recursion
        if ((root.left == null || root.left.data == -1) 
                && (root.right == null || root.right.data == -1)) {
            // System.out.println(root.data); Print statement to identify the leaves of the tree
            return 1;
        }

        return countLeaves(root.left) 
                         + countLeaves(root.right);
    }
    public static void main(String[] args) {
        // Utils
        Scanner scn = new Scanner(System.in);
        LevelOrderConstructor bt = new LevelOrderConstructor();
        
        // User-input handling
        System.out.print("Enter tree values in level-order arrangement: ");
        
        int value = scn.nextInt();
        while(value != 0) {
            bt.getTreeInput().add(value);
            value = scn.nextInt();
        }
        
        System.out.println(bt.getTreeInput()); // See what you inputted
        bt.createLevelOrderTree(); // Level order tree create
        
        // Pre-order the tree
        int count = countLeaves(bt.getRoot());
        System.out.println("Leaves: " + count);

        scn.close();
    }
}
