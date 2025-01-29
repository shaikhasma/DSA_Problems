/*
  Disjoint set
  Time Complexity: O(N)length of edges
  Space Complexity: O(N) for par and the recursion stack
*/
class DisjointSet{
    int[] parent;
    public DisjointSet(int size){
        parent = new int[size + 1];

        for(int index = 0; index < size ; index++)
            parent[index] = index;
    }

    public int find(int x){
        if(x == parent[x])
            return x;

        //memorizing before return the answer
        parent[x] = find(parent[x]);
        return parent[x];   
    }

    public void union(int x, int y){
        //set x
        int parentX = find(x);
        int parentY = find(y);

        parent[parentX] = parentY;
    }
}
class Solution {
    
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet set = new DisjointSet(n);
        
        for (int[] edge : edges)
            if (set.find(edge[0]) == set.find(edge[1])) 
                return edge;
            else 
                set.union(edge[0],edge[1]);
        return edges[0];
    }
}