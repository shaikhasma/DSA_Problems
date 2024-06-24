/*
  1 2 3
1[1,1,0],
2[1,1,0],
3[0,0,1]]
1 - -- 2 
V      V

3 no path
V

2

 //prepareGraph
        //visited[]
        // dfs 1 - row check non visited
        // count dfs call
*/
class Solution {
    public int findCircleNum(int[][] matrix) {
       ArrayList<ArrayList<Integer>> adjList = prepareGraph(matrix);
       boolean[] visited = new boolean[matrix.length];
       int component = 0;

       for(int node = 0 ; node < matrix.length ; node++){
            if(!visited[node]){
                 component++;
                 dfs(node, visited, adjList);
            }
       }

       return component;
    }

    void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList){
        visited[node] = true;

        for(Integer neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, visited, adjList);
            }
        }
    }

    ArrayList<ArrayList<Integer>> prepareGraph(int[][] matrix){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int index = 0; index < matrix.length ; index++){
            adjList.add(new ArrayList<>());
        }

        for(int row = 0; row < matrix.length; row++){
             for(int col = 0; col < matrix[0].length; col++){
                if(matrix[row][col] == 1)
                   adjList.get(row).add(col);
            }
        }

        return adjList;
    }
}