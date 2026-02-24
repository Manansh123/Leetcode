//dijkistra algo
class Solution {
    class pair {
        int node;
        int weight;

        public pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] edges, int v, int src) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>(v + 1);
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new pair(edges[i][1], edges[i][2]));
        }
        PriorityQueue<pair> q = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new pair(src, 0));
        while (!q.isEmpty()) {
            pair curr = q.poll();
            if (curr.weight > dist[curr.node])
                continue;
            for (pair neighbor : adj.get(curr.node)) {
                int neighnode = neighbor.node;
                int neighweight = neighbor.weight;
                if (curr.weight + neighweight < dist[neighnode]) {
                    dist[neighnode] = curr.weight + neighweight;
                    q.add(new pair(neighnode, dist[neighnode]));
                }
            }
        }
        int max = 0;

        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}