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
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        DSU obj=new DSU(n);
        ArrayList<ArrayList<Integer>> lst=new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int xi=points[i][0];
                int yi=points[i][1];
                int xj=points[j][0];
                int yj=points[j][1];
                int dist=Math.abs(xi-xj)+Math.abs(yi-yj);
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(j);
                temp.add(dist);
                lst.add(temp);
            }
        }
        Collections.sort(lst, (a, b) -> a.get(2)-b.get(2));
        int res=0;
        for (int i=0; i<lst.size(); i++) {
            int a=lst.get(i).get(0);
            int b=lst.get(i).get(1);
            int cost=lst.get(i).get(2);
            int pa=obj.find(a);
            int pb=obj.find(b);
            if (pa!=pb) {
                obj.union(pa, pb);
                res+=cost;
            }
        }
        return res;
    }
}