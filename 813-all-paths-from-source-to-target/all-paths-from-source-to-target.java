/*
   Approach - DFS + Backtracking
   TC - 0(V * V)
   SC - 0(V * V)
*/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        
        path.add(0);
        dfs(graph, 0, path, paths);

        return paths;

    }

    void dfs(int[][] graph, int node, ArrayList<Integer> path, List<List<Integer>> paths ){
        
        if(node == graph.length - 1){
           paths.add(new ArrayList<>(path));
           return;
        }
        
        for(Integer neighbor : graph[node]){
          
                path.add(neighbor);

                dfs(graph,neighbor, path, paths);

                path.remove(path.size() - 1);
        } 
    }
}