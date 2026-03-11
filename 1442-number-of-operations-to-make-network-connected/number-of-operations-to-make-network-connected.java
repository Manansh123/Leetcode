class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent=new int[n];
            for (int i=0; i<n; i++) parent[i]=i;
            rank=new int[n];
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int z) {
            int pa = find(x);
            int pb = find(z);
            if (pa == pb)
                return;
            if (rank[pb] > rank[pa]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pa] = pb;
                rank[pb]++;
            }
        }
    }

    public int makeConnected(int n, int[][] c) {
        int len=c.length;
        DSU obj=new DSU(n);
        if (len<n-1) return -1;
        for (int i=0; i<len; i++) {
            if (obj.find(c[i][0])!=obj.find(c[i][1])) {
                obj.union(c[i][0], c[i][1]);
            }
        }
        Set<Integer> st=new HashSet<>();
        for (int i : obj.parent) {
            st.add(obj.find(i));
        }
        return st.size()-1;
    }
}