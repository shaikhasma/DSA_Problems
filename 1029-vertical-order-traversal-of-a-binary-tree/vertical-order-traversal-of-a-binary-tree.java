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
 class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node, int row, int col ){
        this. node = node;
        this.row = row;
        this.col = col;
    }
 }

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        queue.add(new Tuple(root, 0, 0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            if(!map.containsKey(row)){
                map.put(row, new TreeMap<>());
            }

            if(!map.get(row).containsKey(col)){
                map.get(row).put(col, new PriorityQueue<>());
            }
            
            map.get(row).get(col).add(node.val);

            if(node.left != null)
                queue.add(new Tuple(node.left, row - 1, col + 1));

            if(node.right != null)
                queue.add(new Tuple(node.right, row + 1, col + 1));

        }
        List<List<Integer>> list =new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> pq : map.values()){
            list.add(new ArrayList<>());
            for( PriorityQueue<Integer> nodesQueue : pq.values()){
                while(!nodesQueue.isEmpty()){
                    list.get(list.size() - 1).add(nodesQueue.poll());
                }
            }
        }

        return list;
    }
}