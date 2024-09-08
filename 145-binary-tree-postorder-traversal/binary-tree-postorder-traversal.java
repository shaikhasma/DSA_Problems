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
  Approach - DFS
  TC - 0(N)
  SC - 0(N) auxillary stack
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<>();
       
       if(root == null)
         return list;
        
       Stack<TreeNode> stack = new Stack<>();
       stack.push(root);

       while(!stack.isEmpty()){
        TreeNode temp = stack.pop();
        list.add(temp.val);

       
        if(temp.left != null)
            stack.push(temp.left);

        if(temp.right != null)
            stack.push(temp.right);
       }
    
       Collections.reverse(list);
       return list;
    }
}