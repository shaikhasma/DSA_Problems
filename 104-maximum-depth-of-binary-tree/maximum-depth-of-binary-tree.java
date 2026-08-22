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
 //[ 15 7] 
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
         return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;//0 1 2 3

        while(!q.isEmpty()){
          int levelSize  = q.size();
          for(int index = 1 ; index <= levelSize; index++){
            TreeNode temp = q.poll();
            if(temp.left != null)
                 q.add(temp.left);
            if(temp.right !=null)
                q.add(temp.right);
          }
          level++;
        }

        return level;
    }
}