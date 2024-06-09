/*
      0 1 2
    0 1,1,0
    1 1,1,0
    2 0,0,1

    0 -- 1
    1 ---0
    2. ---
     0 1 2
    [T T T]
*/
class Solution {
    public int findCircleNum(int[][] graph) {
        int component = 0;
        ArrayList<ArrayList<Integer>> adjList = prepareAdjList(graph);
        boolean[] visited = new boolean[graph.length];

        for( int node = 0 ; node < graph.length; node++){
          if(!visited[node]){
            component++;
            dfs(node, adjList, visited);
          }
        }

        return component;
    }
  
    void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited){
        visited[node] = true;

        for( Integer neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adjList, visited);
            }
        }
    }

    ArrayList<ArrayList<Integer>> prepareAdjList(int[][] graph){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int index = 0; index < graph.length; index++){
            list.add(new ArrayList<>());
        }
       
        for(int row = 0; row < graph.length; row++){
            for(int col = 0; col < graph[0].length; col++){
                if(graph[row][col] == 1){
                    list.get(row).add(col);
                }
            }
        }

        return list;
    }
}