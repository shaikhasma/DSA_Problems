/** Recursive Approach:

// TC : O(n)
   SC : O(n)
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
    public TreeNode invertTree(TreeNode root) {
           // Base case: if the tree is empty
        if(root == null)
            return root;
        // Call left subtree...
        invertTree(root.left);

        // Call right subtree...
        invertTree(root.right);
        
        // Swapping 
        TreeNode current = root.left;
        root.left = root.right;
        root.right = current;
        
        return root;
    }
}