/* Approach - BFS
TC - 0(N) 
SC - 0(N) + Max(level nodes)
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
    public List<List<Integer>> levelOrder(TreeNode root) {
     
List<List<Integer>> list = new ArrayList<>();  
     Queue<TreeNode> q = new LinkedList<>();
     if(root == null)
        return list;
     
     q.add(root);

     while(!q.isEmpty()){

        int levelSize = q.size();
        ArrayList<Integer> temp = new ArrayList<>();

        for(int index = 1; index <= levelSize; index++){
            
            TreeNode node = q.poll();
            temp.add(node.val);
            
            if(node.left != null)
               q.add(node.left);
            
            if(node.right != null)
                q.add(node.right);
        }
        
        list.add(temp);  
     }

     return list;
    }
}