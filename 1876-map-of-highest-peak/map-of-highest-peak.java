class Solution {
    class pair {
        int row;
        int col;
        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    int[] rowdirection = { -1, 0, 0, 1 };
    int[] coldirection = { 0, 1, -1, 0 };
    public int[][] highestPeak(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] ans=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    q.add(new pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            int size=q.size();
            while (size > 0) {
                pair curr=q.poll();
                size--;
                for (int i=0; i<4; i++) {
                    int neighrow=curr.row+rowdirection[i];
                    int neighcol=curr.col+coldirection[i];
                    if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol]==0 && !visited[neighrow][neighcol]) {
                        q.add(new pair(neighrow, neighcol));
                        visited[neighrow][neighcol]=true;
                        ans[neighrow][neighcol]=ans[curr.row][curr.col]+1;
                    }
                }
            }
        }
        return ans;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row >= 0 && row < n && col >= 0 && col < m);
    }
}