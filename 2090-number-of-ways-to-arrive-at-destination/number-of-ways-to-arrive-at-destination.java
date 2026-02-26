class Solution {
    class Pair{
        int node;
        long dist;
        Pair(int node, long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int countPaths(int n, int[][] roads) {

        final int MOD=1000000007;

        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        long[]dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;

        int[]ways=new int[n];
        ways[0]=1;

        PriorityQueue<Pair>pq=new PriorityQueue<>(Comparator.comparingLong(a -> a.dist)); 
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int r=curr.node;
            long c=curr.dist;

            if(c>dist[r]) continue;
            for(int i=0;i<adj.get(r).size();i++){
                Pair p=adj.get(r).get(i);
                int v=p.node;
                long wt=p.dist;

                if(dist[r]+wt<dist[v]){
                    dist[v]=dist[r]+wt;
                    ways[v]=ways[r];
                    pq.add(new Pair(v,(long) dist[v]));
                }
                else if(dist[r]+wt==dist[v]){
                    ways[v]=(int)((ways[v]+(long)ways[r])% MOD);
                }
            }
        }
        return ways[n-1];
        
    }
}