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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    
    if(root == null)
        return list;
    
    Queue < TreeNode > q = new LinkedList<>();
    q.add(root);
    
    boolean leftToRight = true;
        while(!q.isEmpty()){
            
            int levelSize = q.size();
            ArrayList<Integer> tempList = new ArrayList<>();

            for( int index = 1; index <= levelSize; index++ ){
                TreeNode temp = q.poll();
                   
                    if(temp.left != null)
                        q.add(temp.left);
                    if(temp.right != null)
                        q.add(temp.right);

               
                if(leftToRight){
                    tempList.add(temp.val);
                }else{
                    tempList.add(0,temp.val);          
                }
            }
            
            leftToRight = !leftToRight;
            list.add(tempList);
        }   
    return list;    
    }
}