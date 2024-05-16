 /*
     Approach - BFS + Q + create node class with Treenode and level index

     1. Do level order traversal & give imaginary index to each node
       start root with 1
       left child = node index * 2;
       right child = node index * 2 + 1;
     2. take firstIndex & last Index of each level 
     3. once one level is compeleted
        width = lastIndex - firstIndex + 1
        maintain maxWidth
     
     TC - 0(N) total nodes
     SC - 0(N) Queue

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

 
 

class Node{
    TreeNode node ;
    int levelIndex;
    public Node(TreeNode node, int levelIndex){
        this.node = node;
        this.levelIndex = levelIndex;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
      if(root == null)
          return 0;

      Queue<Node> q = new LinkedList<>();
      q.add(new Node(root,1));

      int maxWidth = 0;
        while(!q.isEmpty()){
            int levelSize = q.size();
       
            int firstIndex = 0;
            int lastIndex = 0;
            for(int index = 0; index < levelSize; index++){
                Node node = q.poll();
                int currentIndex = node.levelIndex;

                if(index == 0)
                    firstIndex = currentIndex;
                if(index == levelSize - 1)
                    lastIndex = currentIndex;
                
                if(node.node.left != null)
                    q.add( new Node(node.node.left, currentIndex * 2));
                if(node.node.right != null)
                    q.add( new Node(node.node.right, currentIndex * 2 + 1));
            
            } 
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }
        return maxWidth;
    }
}