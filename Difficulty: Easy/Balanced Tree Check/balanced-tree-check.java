/* Structure of binary tree node
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}*/

class Solution {

    boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    int checkHeight(Node root) {

        // Empty tree has height 0
        if (root == null) {
            return 0;
        }

        // Get height of left subtree
        int leftHeight = checkHeight(root.left);

        // If left subtree is unbalanced
        if (leftHeight == -1) {
            return -1;
        }

        // Get height of right subtree
        int rightHeight = checkHeight(root.right);

        // If right subtree is unbalanced
        if (rightHeight == -1) {
            return -1;
        }

        // Check current node
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return height of current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}