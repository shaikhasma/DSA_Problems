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
  Queue[3]
  list[[]]
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> list = new ArrayList<>();
       if(root == null)
         return list;

       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);

       while(!queue.isEmpty()){

        ArrayList<Integer> temp = new ArrayList<>();
        int levelSize = queue.size();
        for(int index = 1 ; index <= levelSize ; index++){
            TreeNode node = queue.poll();
            temp.add(node.val);

            if(node.left != null)
                queue.add(node.left);
            
            if(node.right != null)
                queue.add(node.right);
        }
        list.add(temp);
       }

       return list;
    }
}