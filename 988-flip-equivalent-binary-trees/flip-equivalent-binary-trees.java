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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return solv(root1, root2);
    }    

    boolean solv(TreeNode root1, TreeNode root2){
      if(root1 == null || root2 == null)
         return  root1 == root2;
      
      return root1.val == root2.val  && 
                      (solv(root1.left, root2.right) && solv(root1.right, root2.left)) || 
                      (solv(root1.left, root2.left) && solv(root1.right, root2.right));
    }
}