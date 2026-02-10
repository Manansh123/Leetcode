class Solution {
    public int findCenter(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int v=edges.length+1; //in this ques there will be always edges+1=vertex
        for (int i=0; i<=v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<edges.length; i++) {
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        for (int i=1; i<=v; i++) {
            if (adj.get(i).size()==v-1) return i;
        }
        return -1; //problem guarrantees that graph is a star graph we only have to tell the center node so if pe humesha jaayega return i humesha hoga so yahan humlog kbhi nhi pahuchenge
    }
}