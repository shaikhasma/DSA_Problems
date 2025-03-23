/*
 Approach - 1 Count node & edges of complete component using DFS
 adjList = V + E
 DFS = V + E
 TC - 0(V + E)
 SC - 0(V + E)adList ,  N stack
    - 0(V + E)
                
 
*/
class Solution {
    List<List<Integer>> adjList;
     boolean[] visited ;
    int n;
    int compNodes;
    int compEdges;

    public int countCompleteComponents(int n, int[][] edges) {
        this.n = n;
        visited = new boolean[n];
        int ans = 0;

        adjList = prepareAdjList(edges, n);

        for(int node = 0; node < n; node++){
            if(!visited[node]){
                compNodes = 0;
                compEdges = 0;
                
                dfs(node);

                if(compEdges / 2 == (compNodes * (compNodes - 1)) / 2)
                   ans++;
            }
        }
        
        return ans;
    }

    void dfs(int node){
       visited[node] = true;
       compNodes++;
       compEdges += adjList.get(node).size();

       for(Integer neighbor : adjList.get(node)){
          if(!visited[neighbor])
                dfs(neighbor);
       }
    }

    List<List<Integer>> prepareAdjList(int[][] edges, int n){
        List<List<Integer>> list = new ArrayList();
        for(int node = 0; node < n; node++)
            list.add(new ArrayList<>());
        
        for(int index = 0; index < edges.length; index++){
            int source = edges[index][0];
            int target = edges[index][1];

            list.get(source).add(target);
            list.get(target).add(source);
        }

        return list;
    }
}