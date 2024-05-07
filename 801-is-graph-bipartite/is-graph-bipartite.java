class Solution {
    public boolean isBipartite(int[][] graph) {
      
       int[] color = new int[graph.length];
       Arrays.fill(color, -1);
       
        for(int i = 0; i <= graph.length - 1; i++){
            if(color[i] == -1){
               
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

        
                    color[i] = 1;

                while(!q.isEmpty()){
                    Integer node = q.poll();
                        for(int neighbor : graph[node]){
                            
                            if(color[neighbor] == -1) {
                                //fill with opposite  color
                                color[neighbor] = 1 - color[node];
                                q.add(neighbor);
                            }
                            else if(color[neighbor] == color[node]){
                                return false;
                            }
                        }
                }
            }
        }
       
        return true;                 
    }
}