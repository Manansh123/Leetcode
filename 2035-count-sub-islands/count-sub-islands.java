class Solution {
    class pair{
        int row;
        int col;
        public pair(int row, int col) {
            this.row=row;
            this.col=col;
        }
    }
    int[] rowdirection={-1, 0, 0, 1};
    int[] coldirection={0, 1, -1, 0};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count=0;
        int n=grid1.length;
        int m=grid1[0].length;
        boolean[][] visited=new boolean[n][m]; //for grid 2
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid2[i][j]==1 && !visited[i][j]) {
                    boolean shouldcount=bfs(i, j, visited, grid1, grid2);
                    if (shouldcount) count++;
                }
            }
        }
        return count;
    }
    public boolean bfs(int row, int col, boolean[][] visited, int[][] grid1, int[][] grid2) {
        int n=grid1.length;
        int m=grid1[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row, col));
        visited[row][col]=true;
        boolean issubisland=true;
        if (grid1[row][col]==0) issubisland=false;
        while (!q.isEmpty()) {
            pair curr=q.poll();
            for (int i=0; i<4; i++) {
                int neighrow=curr.row+rowdirection[i];
                int neighcol=curr.col+coldirection[i];
                if (isvalid(neighrow, neighcol, grid1, grid2) && grid2[neighrow][neighcol]==1 && !visited[neighrow][neighcol]) {
                    q.add(new pair(neighrow, neighcol));
                    visited[neighrow][neighcol]=true;
                    if (grid1[neighrow][neighcol]==0) issubisland=false;
                }
            }
        }
        return issubisland;
    }
    public boolean isvalid (int row, int col, int[][] grid1, int[][] grid2) {
        int n=grid1.length;
        int m=grid1[0].length;
        return (row>=0 && row<n && col>=0 && col<m) ? true : false;
    }
}