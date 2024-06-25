class Solution {
    public int[] findOrder(int numCourses, int[][] courses) {
     ArrayList<ArrayList<Integer>> adjList = prepareAdjList(numCourses, courses);

     int[] indegree = new int[numCourses];

     //step calculate indegree of all nodes
     for(int index = 0 ; index < numCourses; index++){
          for(Integer neighbor : adjList.get(index)){
            indegree[neighbor]++;
          }
     }
     
     Queue<Integer> q = new LinkedList<>();
     // step 2 add zero indegree node into Q
     for(int index = 0 ; index < numCourses; index++){
        if(indegree[index] == 0)
           q.add(index);
     }

     // step 3 traverse q and remove edges
     int[] topo = new int[numCourses];
     int pos = 0;
     while(!q.isEmpty()){
        Integer node = q.poll();
        topo[pos++] = node;

        for(Integer neighbor : adjList.get(node)){

            indegree[neighbor]--;
            if(indegree[neighbor] == 0){
                  q.add(neighbor);
            }
        }
     }

        if(pos == numCourses){
            return topo;
        }

        return new int[0];
    }
   
   

    ArrayList<ArrayList<Integer>> prepareAdjList(int totalCourse, int[][] courses){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int index = 0; index < totalCourse; index++){
            adjList.add(new ArrayList<>());
        }

        for(int index = 0; index < courses.length; index++){
            adjList.get(courses[index][1]).add(courses[index][0]);
        }
        return adjList;
    }
}