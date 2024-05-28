/*
   0 1
   0 2
   1 2

1. Traverse for all edges & connect (union (u,v )) in disjoint set & count extra edges 
   1. check if parent of u & v are in same means they are in same component
      count this edge as an extra 
      - if they are in diffrent component not call union (u, v) connect

2. Count total components
   1. Traverse all nodes / Computers (n) 0 to n -1
   2. count node whose parent is equal to that node
      means those many component we have

3. required edges to connect computers = totalComponents - 1 edges 

4. if we have extra edges >= required edges

TC - 0(E + 4alpha) + O(n * 4alpha)
      extra edges      total component

SC - 0(N)    + 0(N)
     parent[].  sizep[]
*/
class DisjointSet{
    int[] parent ;
    int[] size;

    public DisjointSet(int n){
        parent = new int[n + 1];
        size = new int[n+1];

        for( int index = 0; index <= n; index++){
            parent[index] = index;
            size[index] = 1;
        }
    }

    public int findParent(int node){
        if(node == parent[node])
            return node;

        int p = findParent(parent[node]);
        parent[node] = p;

        return parent[node];

    }

    public void unionBySize(int u , int v){
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if(parent_u == parent_v)
            return;
        
        if(size[parent_u] < size[parent_v]){
            parent[parent_u] = parent_v;
            size[parent_v] = size[parent_v] + size[parent_u];
        }else{
            parent[parent_v] = parent_u;
            size[parent_u] = size[parent_u] + size[parent_v];
        }

    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int edges = connections.length;
        
        int extraEdges = 0;
        int components = 0;

        for( int index = 0; index < edges; index++){
           int u = connections[index][0];
           int v = connections[index][1];
           
           int parent_u = ds.findParent(u);
           int parent_v = ds.findParent(v);
           if(parent_u == parent_v){
                extraEdges++;
           }else{
              ds.unionBySize(u,v);
           }
        }

        for( int index = 0; index < n ; index++){
            if(index == ds.findParent(index)){
                components++;
            }
        }
        
        int requiredEdges = components - 1;
        if( extraEdges >= requiredEdges)
            return requiredEdges;
        
        return -1;
    }
}