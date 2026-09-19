/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
// r  l    
//[1 ,2, 3, 4,5]
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
          return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        
        q.add(root);

        while(!q.isEmpty()){
          TreeNode node = q.poll();
          //if node null
          if(node == null){
            str.append("null" + " ");
            continue;
          }
            
          str.append(node.val + " ");
          q.add(node.left);
          q.add(node.right);
        }
          return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
          return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        String[] val = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));

        q.add(root);

        for(int index = 1;  index < val.length; index++){
            TreeNode parent = q.poll();
            //if not null
            if(!val[index].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(val[index]));
                parent.left = left;
                q.add(left);
            }

            index++;
            if(!val[index].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(val[index]));
                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));