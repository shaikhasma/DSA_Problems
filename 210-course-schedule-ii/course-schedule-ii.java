class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        //1. Prepare adjList
        ArrayList<ArrayList<Integer>> adjList = prepareAdjList(numCourses, prerequisites);
        int[] order = {};
        boolean isCycle = false;
        
        //2. call DFS with stack 
        for (int i  = 0; i < numCourses; i++){
            if(!visited[i]){
                if(dfs(i, adjList, visited, pathVisited, stack)){
                   return order;
                }
            }
        }

        //4. Conver stack into array if courses and size of stack is same 
        System.out.println(stack.size());
        if(stack.size() == numCourses){
            order =  stackToArray(stack);
        }
        
        return order;
        
    }

    //3. Call dfs for non visited not once we find a node which do not have any prerequisites 
    // or neighor node then keep that in stack as we have to start with that course
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adjList,
                            boolean[] visited, boolean[] pathVisited, Stack<Integer> stack){
        visited[node] = true;
        pathVisited[node] = true;
        for(Integer neighbor : adjList.get(node)){
            if(!visited[neighbor]){
              if(dfs(neighbor, adjList, visited, pathVisited, stack)){
                return true;
              }
            }else if(pathVisited[neighbor]){
                return true;
            }
        }
        pathVisited[node] = false;
        stack.add(node);
        return false;  
    }

    private ArrayList<ArrayList<Integer>> prepareAdjList(int numCourses, int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return adjList;
    }
    
    private int[] stackToArray(Stack<Integer> stack){
        int[] order = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()){
            order[index++] = stack.pop();
        }

        return order;
    }
}