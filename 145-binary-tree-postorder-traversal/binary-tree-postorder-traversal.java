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
 // 3 2 6 5 1
 
 // D R L

 // 1 5 6 2 3
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode current = root;

        while(current != null){
          if(current.right == null){
            list.add(current.val);
            current = current.left;
          }
          else{
            TreeNode temp = current.right;
            while(temp.left != null && temp.left != current){
                temp = temp.left;
            }

            if(temp.left == null){
                temp.left = current;
                list.add(current.val);
                current = current.right;
            }else{
                temp.left = null; 
                current = current.left;
            }
          }
        }
        Collections.reverse(list);
        return list;
    }
}