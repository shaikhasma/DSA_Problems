/*
  Approach - DFS

  count how many time we have started new DFS
  if diconnected graph then we have to start graph those many number of time which is equal to total components

  TC - 0(V+E)
  SC - 0(V)
  
  */
class Solution {
    public int findCircleNum(int[][] isConnected) {
       
       ArrayList<ArrayList<Integer>> adjList = prepareAdjList(isConnected);
       boolean[] visited = new boolean[isConnected.length];
       int count = 0;

       for(int index = 0; index < isConnected.length; index++){
         if(!visited[index]){
            count++;
            dfs(index, adjList, visited );
         }
       }

       return count;
    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited){
       visited[node] = true;

       for(Integer neighbor : adjList.get(node)){
         if(!visited[neighbor]){
            dfs(neighbor, adjList, visited);
         }
       }
    }

    ArrayList<ArrayList<Integer>> prepareAdjList(int[][] edges){

      ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int index = 0; index < edges.length; index++){
            adjList.add( new ArrayList<Integer>());
        }

        for(int row = 0; row < edges.length; row++){
            for(int col = 0; col < edges.length; col++){
            
                if(edges[row][col] == 1)
                adjList.get(row).add(col);
            
            }
        }

       return adjList; 
    }
}