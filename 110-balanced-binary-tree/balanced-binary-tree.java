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
    Approach - Post order traversal + maintain left & right height
    1. Post order traversal calculate left & right hight
        if any heigh is -1 return -1
    2. if leftHeight - rightHeigth > 1 then also return -1
    3. If above both condition false then do
    return  Max(leftHeight , rightHeight) + 1

    Do this for all all node
    
    

    TC - 0(N) Number of nodes
    SC - 0(H) Auxillary space . If it is balance then  log2N 
  */
class Solution {
    public boolean isBalanced(TreeNode root) {
     return height(root) != -1;
    }
    int height(TreeNode root){
      if(root == null)
        return 0;

      int leftHeight = height(root.left);
      if(leftHeight == -1) return leftHeight;
    
      int rightHeight = height(root.right);
      if(rightHeight == -1) return rightHeight;
      
      if(Math.abs(leftHeight - rightHeight) > 1) return -1;

      return Math.max(leftHeight, rightHeight) + 1;
    }

}