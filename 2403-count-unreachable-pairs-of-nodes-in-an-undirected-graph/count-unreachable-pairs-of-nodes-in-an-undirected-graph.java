class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent=new int[n];
            for (int i=0; i<n; i++) parent[i]=i;
            rank=new int[n];
        }
        public void union(int a, int b) {
            int pa=find(a);
            int pb=find(b);
            if (pa==pb) return;
            if (rank[pa]>rank[pb]) parent[pb]=pa;
            else if (rank[pb]>rank[pa]) parent[pa]=pb;
            else {
                parent[pb]=pa;
                rank[pa]++;
            }
        }
        public int find(int x){
            if (parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }
    }
    public long countPairs(int n, int[][] edges) {
        int len=edges.length;
        DSU obj=new DSU(n);
        for (int i=0; i<len; i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            obj.union(u, v);
        }
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i=0; i<n; i++) {
            map.put(obj.find(i), map.getOrDefault(obj.find(i), 0)+1);
        }
        long res=0;
        int remain=n;
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            int node=i.getValue();
            int size=i.getValue();
            res+=(long)size*(remain-size);
            remain-=size;
        }
        return res;
    }
}