/*
    During this lab exercise (Lab 2 for CMSC 123), the full specifications for the laboratory were presented.

    Lab 1
    - Basically computes for the height of a tree given a user-input Node value.
*/
import java.util.Scanner;

public class Main {
    static int elem_to_leaf = -1;
    static void findElement(Node root, int value) {
        if(root == null) {
            return;
        }
        // You start traversing from the root
        if(root.value == value) {
            elem_to_leaf = getHeight(root);
        }
        findElement(root.left, value);
        findElement(root.right, value);
    }   

    static int getHeight(Node root) {
        if(root == null) {
            return -1;
        }

        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        InputTree tree = new InputTree();
        
        System.out.print("Enter the node you want to find: ");
        int value = scn.nextInt();

        // This function looks for the element in a tree
        findElement(tree, value);

        // Height of the tree
        int height = getHeight(tree);

        // Height from given element to leaf
        int real_height = height - elem_to_leaf;

        if(elem_to_leaf < 0) {
            System.out.println("Node not found");
        }
        else {
            System.out.println("Height of Node " + value + ": " + real_height);
        }

        scn.close();
    }
}