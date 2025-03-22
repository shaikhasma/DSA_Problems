class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        // connect components
        for(int[] edge : edges){
            uf.union(edge[0], edge[1]);
        }

        Map<Integer, Integer> edgesCount = new HashMap<Integer, Integer>();
        // count edges in each components
        for(int[] edge : edges){ //  u - v
            int root = uf.find(edge[0]);
            edgesCount.put(root, edgesCount.getOrDefault(root,0)+1);
        }


        int ans = 0;
        // check for all the parents 
        // no of edges in each component == n(n-1) /2 
        for(int i=0; i<n; i++){
            if(uf.find(i) == i){            // this node is parent of a component
                int size = uf.size[i];
                int e = edgesCount.getOrDefault(i,0);
                if( e == (size * (size-1))/2 )
                    ans++;
            }
        }
        return ans;
    }

    class UnionFind{
        int[] parent;
        int[] size;

        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];  
            Arrays.fill(parent, -1);
            Arrays.fill(size, 1);
        }

        int find(int x){
            if(parent[x] == -1) return x;
            return parent[x] = find(parent[x]);     // path compression
        }

        void union(int a, int b){
            int p1 = find(a);
            int p2 = find(b);
            
            if(p1 == p2) return;

            // combine those two groups
            if(size[p1] > size[p2]){
                parent[p2] = p1;
                size[p1] += size[p2];
            }else{
                parent[p1] = p2;
                size[p2] += size[p1];
            }
        }

    }
}