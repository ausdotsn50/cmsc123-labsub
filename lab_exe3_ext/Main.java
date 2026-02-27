import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        List<Integer> bstElements = new ArrayList<>();
        
        // BST to be tested
        // Choose BST here:
        InputBST_01 inputOne = new InputBST_01();
        InputBST_02 inputTwo = new InputBST_02();

        // Validate predefined tree
        if(isValidBST(inputOne)) {
            System.out.println("The input is: Valid BST.");

            boolean running = true;
            while(running) {
                int choice;
                System.out.println("1 - Find kth value | 2 - Exit");
                System.out.print("Enter a number: ");
                choice = scn.nextInt();

                switch (choice) {
                    case 1:
                        // Traverse BST with a random traversal method for Binary trees in general
                        // Usage of additional data struct for easier identification of kth element + addtl storage
                        traverseBST(inputTwo, bstElements); 
                        int sizeOfBST = bstElements.size(); // bstElements is updated, you can check for its size

                        int kthVal;
                        do {
                            System.out.print("Enter a value k: ");
                            kthVal = scn.nextInt();
                            
                            if(sizeOfBST < kthVal || kthVal < 1) {
                                System.out.println("Invalid value for k");
                            }

                        } while (sizeOfBST < kthVal || kthVal < 1);
                        
                        System.out.println("Searching for the #" + kthVal + " largest value in the valid BST...");
                        Collections.sort(bstElements, Collections.reverseOrder());
                        // System.out.println(bstElements);

                        System.out.println("The #" + kthVal + " largest value in the valid BST is: " + bstElements.get(kthVal - 1));
                        
                        bstElements.clear();
                        break;
                    case 2:
                        System.out.println("Exiting...");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }
            }
        } else {
            System.out.println("The input is: Invalid BST.");
            // Exit or early return
        }   
        
        scn.close();
    }

    public static void traverseBST(Node root, List<Integer> treeList) {
        if(root == null) {
            return;
        }

        treeList.add(root.data);
        traverseBST(root.left, treeList);
        traverseBST(root.right, treeList);        
    }

    // Checker if the input is a valid BST
    public static boolean isValidBST(Node root) {
        // Have not . anything along the way
        if(root == null || root.left == null || root.right == null) {
            return true;
        }

        // BST rule of left less, right more
        if(root.left.data > root.data || root.right.data < root.data) {
            return false;
        }

        // Recursive for the subtrees
        return isValidBST(root.left) && isValidBST(root.right);
    }

}
