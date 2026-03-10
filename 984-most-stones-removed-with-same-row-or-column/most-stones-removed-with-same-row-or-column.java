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
            else parent[pb]=pa;
        }
        public int find(int x){
            if (parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DSU obj=new DSU(n);
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]) {
                    obj.union(i, j);
                }
            }
        }
        Set<Integer> st = new HashSet<>();
        for (int i : obj.parent) {
            st.add(obj.find(i));
        }
        return n-st.size();
    }
}