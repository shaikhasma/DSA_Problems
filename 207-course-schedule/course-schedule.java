class Solution {
    public boolean canFinish(int numCourses, int[][] matrix) {
        ArrayList<ArrayList<Integer>> adjList = prepareAdjList(matrix, numCourses);

        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];

        for(int node = 0; node < numCourses; node++){
           if(!visited[node]){
             if(dfs(node, visited, dfsVisited, adjList) == true)
                return false;
           }
        }

        return true;
    }
    
    boolean dfs(int node, boolean[] visited, boolean[] dfsVisited , 
                ArrayList<ArrayList<Integer>> adjList){

        visited[node] = true;
        dfsVisited[node] = true;

        for(Integer neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, visited, dfsVisited, adjList) == true){
                    return true;
                }
            }else if(dfsVisited[neighbor] == true){
                return true;
            }
        }

    dfsVisited[node] = false;
    return false;
    }

    ArrayList<ArrayList<Integer>> prepareAdjList(int[][] matrix, int numCourses){
         ArrayList<ArrayList<Integer>> list = new ArrayList<>();

         for(int index = 0; index < numCourses; index++ ){
            list.add(new ArrayList<Integer>());
         }

         for(int index = 0; index < matrix.length; index++){
            list.get(matrix[index][1]).add(matrix[index][0]);
         }

         return list;
    }
}