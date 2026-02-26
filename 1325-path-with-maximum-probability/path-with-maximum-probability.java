class Solution {
    class pair{
        int node;
        double weight;
        public pair(int node, double weight) {
            this.node=node;
            this.weight=weight;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succprob, int start_node, int end_node) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<edges.length; i++) {
            adj.get(edges[i][0]).add(new pair(edges[i][1], succprob[i]));
            adj.get(edges[i][1]).add(new pair(edges[i][0], succprob[i]));
        }
        PriorityQueue<pair> q=new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));
        double[] dist=new double[n];
        Arrays.fill(dist, 0.0);
        dist[start_node]=1.0;
        q.add(new pair(start_node, 1.0));
        
        while (!q.isEmpty()) {
            pair curr=q.poll();
            if (curr.weight<dist[curr.node]) continue;
            for (pair neigh : adj.get(curr.node)) {
                int neighnode=neigh.node;
                double neighweight=neigh.weight;
                if (dist[curr.node]*neighweight>dist[neighnode]) {
                    dist[neighnode]=neighweight*dist[curr.node];
                    q.add(new pair(neighnode, dist[neighnode]));
                    
                }
            }
        }
        return dist[end_node];
    }
}