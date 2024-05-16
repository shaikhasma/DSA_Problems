/* Approach - Recusion + backtrack + maintain maxSum

  1. Call recursion with root 
  2. Alwasys pathSum = leftSum + rightSum + root.val 
  3. Maintain max Path Sum

  4. Decide with which path we have to cansider for going ahead 
     so take root.val + max(leftSum, rightSum)


  TC - 0(N)
  SC - 0(H) / 0(log2N) auxillary stack space
*/

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
   public int maxPathSum(TreeNode root) {
    int[] maxSum = new int[1];
    maxSum[0] = Integer.MIN_VALUE;
    maxPathSum(root, maxSum);
    return maxSum[0];       
   }

   int maxPathSum(TreeNode root, int[] maxSum){
    if(root == null)
        return 0;

    int leftSum = Math.max(0, maxPathSum(root.left, maxSum));
    int rightSum = Math.max(0, maxPathSum(root.right, maxSum));

    maxSum[0] = Math.max(maxSum[0], root.val + leftSum + rightSum);

    return root.val + Math.max(leftSum, rightSum);

   }
}