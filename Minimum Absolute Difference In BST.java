/* The Node structure is defined as
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int ans = Integer.MAX_VALUE;
    int prev = -1;

    void inorder(Node root) {
        if (root == null) {
            return;
        }

        
        inorder(root.left);

        
        if (prev != -1) {
            ans = Math.min(ans, root.data - prev);
        }

        prev = root.data;

        
        inorder(root.right);
    }

    public int absDiff(Node root) {
        inorder(root);
        return ans;
    }



  
}

// Input: root[] = [50, 30, 70, 20, N, 60, 80]
// 420046990
// Output: 10
// Explanation: There are no two nodes whose absolute difference is smaller than 10.
