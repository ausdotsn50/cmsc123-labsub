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
    // Tree traversal
    // Account root as max
    static int findMax(Node node) {
        if (node == null || node.data == -1) {
            return Integer.MIN_VALUE;
        }
 
        int max = node.data;
        int lMax = findMax(node.left);
        int rMax = findMax(node.right);
        
        // rmax > lmax
        if (lMax > rMax && lMax > max) {
            max = lMax;
        }
        else if(rMax > max) {
            max = rMax;
        }
        return max;
    }

    static int findMin(Node node) {
        if (node == null || node.data == -1) {
            return Integer.MAX_VALUE;
        }
 
        int min = node.data;
        int lMin = findMin(node.left);
        int rMin = findMin(node.right);
        
        if(lMin < rMin && lMin < min) {
            min = lMin;
        } 
        else if(rMin < min) {
            min = rMin;
        }

        return min;
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
        int max = findMax(bt.getRoot());
        int min = findMin(bt.getRoot());
        
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        scn.close();
    }
}
