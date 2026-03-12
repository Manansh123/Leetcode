class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent=new int[n+1];
            for (int i=1; i<=n; i++) parent[i]=i;
            rank=new int[n+1];
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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int len=edges.length;
        DSU alice=new DSU(n);
        DSU bob=new DSU(n);
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        int count=0;
        for (int i=0; i<len; i++) {
            if (edges[i][0]==3) {
                if (alice.find(edges[i][1])==alice.find(edges[i][2]) && bob.find(edges[i][1])==bob.find(edges[i][2])) count++;
                else {
                    alice.union(edges[i][1], edges[i][2]);
                    bob.union(edges[i][1], edges[i][2]);
                }
            }
            else if (edges[i][0]==2) {
                if (bob.find(edges[i][1])==bob.find(edges[i][2])) count++;
                else bob.union(edges[i][1], edges[i][2]);
            }
            else {
                if (alice.find(edges[i][1])==alice.find(edges[i][2])) count++;
                else alice.union(edges[i][1], edges[i][2]);
            }
        }
        Set<Integer> sta=new HashSet<>();
        Set<Integer> stb=new HashSet<>();
        for (int i=1; i<=n; i++) {
            sta.add(alice.find(i));
            stb.add(bob.find(i));
        }
        if (sta.size()>1 || stb.size()>1) return -1;
        return count;
        
    }
}