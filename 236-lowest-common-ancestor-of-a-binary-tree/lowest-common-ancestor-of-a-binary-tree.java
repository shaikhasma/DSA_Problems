/* Approach - 1 Recursion
1. call recursively
  - if we find null || p or q then return that node
  - if we find both left & right tree not null means we found both p & q first time so this is lca of p & q

  - if any of then is null then return non null
    left is null return right vice versa

    
   TC  - 0(N)
   SC - (N) auxillary stack
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null || root == p || root == q)
        return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //when we receive node from left & right subtree first time that is lca of p & q
        if(left != null && right != null)
            return root;
        
        return left == null ? right : left;
        
    }
}