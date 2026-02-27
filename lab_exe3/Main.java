public class Main {
    public static void main(String[] args) {
        // BST to be tested
        // Choose BST here:
        InputBST_01 inputOne = new InputBST_01();
        InputBST_02 inputTwo = new InputBST_02();

        // Corresponding statements for validity
        if(isValidBST(inputTwo)) {
            System.out.println("The input is: Valid BST.");
        } else {
            System.out.println("The input is: Invalid BST.");
        }
    }

    // Checker if the input is a valid BST
    public static boolean isValidBST(Node root) {
        // Have not . anything along the way
        if(root == null || root.left == null || root.right == null) {
            return true;
        }

        /*
        System.out.println("Root: " + root.data);
        System.out.println("Root.left: " + root.left.data);
        System.out.println("Root.right: " + root.right.data);
         */

        if(root.left.data > root.data || root.right.data < root.data) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);

        /* 
        if (node === null) return true;

        // If the current node's data 
        // is not in the valid range, return false
        if (node.data < min || node.data > max) return false;

        // Recursively check the left and 
        // right subtrees with updated ranges
        return isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max);
        }

        // Function to check if the entire binary tree is a BST
        function isBST(root) {
        return isBSTUtil(root, -Infinity, Infinity);
        }
        */
    }


}
