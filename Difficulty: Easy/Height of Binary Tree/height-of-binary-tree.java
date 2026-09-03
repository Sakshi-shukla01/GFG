/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}*/

class Solution {
    public int height(Node root) {
        // code here
        
        
       if(root==null){
           return -1;
       } 
       int leftHeight=height(root.left);
       int rightHeight=height(root.right);
       
       return 1+Math.max(leftHeight,rightHeight);
        
        
        
        
        
    }
}