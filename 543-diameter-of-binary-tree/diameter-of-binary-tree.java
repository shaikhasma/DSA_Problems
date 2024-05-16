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
   Approach - postOrder + maintain max diameter (max carry diameter)

   TC - 0(n) height of every node
   SC -0 0(H) height of tree auxillary stack
 */
class Solution {
   //idea is carry max diamter so need reference    
   public int diameterOfBinaryTree(TreeNode root) {
    int[] diameter = new int[1];

    heightAndDiameter(root, diameter);

    return diameter[0];
   }

   int heightAndDiameter(TreeNode root, int[] diameter){
    if(root == null)
        return 0;
    
    int leftHeight = heightAndDiameter(root.left, diameter);
    int rightHeight = heightAndDiameter(root.right, diameter);

    diameter[0] = Math.max(diameter[0] , leftHeight + rightHeight); // maintain maxDaimeter
    return Math.max(leftHeight, rightHeight) + 1; //height calculation

   }

}