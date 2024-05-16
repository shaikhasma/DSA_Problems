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

 /*
   Approach - left + right hight of every node = diameter

   TC - 0(n^2) height of every node
   SC -0 0(H) height of tree auxillary stack
 */
class Solution {
    
   public int diameterOfBinaryTree(TreeNode root) {
    if(root == null)
        return 0;

     int leftHeight = height(root.left);
     int rightHeight = height(root.right);    

     int diameter = leftHeight + rightHeight;

     int leftDiameter = diameterOfBinaryTree(root.left);
     int rightDiameter = diameterOfBinaryTree(root.right);

     return Math.max(diameter , Math.max(leftDiameter, rightDiameter));
   }

   int height(TreeNode root){
    if(root == null)
        return 0;
    
    return Math.max(height(root.left), height(root.right)) + 1;
   }
}