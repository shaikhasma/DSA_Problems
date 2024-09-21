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
    public int sumNumbers(TreeNode root) {
      return solv(root, 0);
    }

    int solv(TreeNode root, int sum){
        if(root == null)
            return 0;
        sum = sum * 10 + root.val;

        if(root.left == null && root.right == null)
            return sum;
        
        int left = solv(root.left, sum);
        int right = solv(root.right, sum);

        return left + right;
    }
}