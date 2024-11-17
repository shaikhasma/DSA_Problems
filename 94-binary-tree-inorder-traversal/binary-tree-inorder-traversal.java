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
   
    public List<Integer> inorderTraversal(TreeNode root) {
       
        List<Integer> list = new ArrayList<Integer>();
        TreeNode current = root;

        while(current != null){
            if(current.left == null){
                list.add(current.val);
                current = current.right;
            }
            else{
                TreeNode temp = current.left;

                while(temp.right != null && temp.right != current){
                    temp = temp.right;
                }

                if(temp.right == null){
                    temp.right = current;
                    current = current.left;
                }else{
                    temp.right = null;
                    list.add(current.val);
                    current = current.right;
                }
            }
        }
        return list;
    }
}