/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        // base 
        if(root == null)
            return 0;

        // core logic
         int diameter = height(root.left) + height(root.right);
        // recurcive call
        int leftDia = diameterOfBinaryTree(root.left);
         int rightDia = diameterOfBinaryTree(root.right);
        return Math.max(diameter, Math.max(leftDia, rightDia));
    }

    int height(TreeNode root){
        if(root == null)
            return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}