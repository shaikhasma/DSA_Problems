class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];
        ArrayList<ArrayList<Integer>> adjList = prepareAdjList(numCourses, prereq);

        for(int course = 0; course < numCourses; course++){
            if(!visited[course]){
                if(dfs(course, adjList, visited, dfsVisited)){
                    return false;
                }
            }
        }
      return true;
    }

    boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
                    boolean[] dfsVisited){
        visited[node] = true;
        dfsVisited[node] = true;

        for( Integer neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, adjList, visited, dfsVisited)){
                    return true;
                }
            }else if(dfsVisited[neighbor]){
                return true;
            }
        }

        dfsVisited[node] = false;

        return false;
    }

    private ArrayList<ArrayList<Integer>> prepareAdjList(int numCourses, int[][] prereq){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int course = 0 ; course < numCourses ; course++){
            adjList.add(new ArrayList<>());
        }
      
        for(int i = 0 ; i < prereq.length; i++)
            adjList.get(prereq[i][1]).add(prereq[i][0]);
        
       return adjList;
    }
}