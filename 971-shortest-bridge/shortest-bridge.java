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

    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        Queue<pair> q=new LinkedList<>();
        boolean flag1=false;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]==1 && !visited[i][j]) {
                    q.add(new pair(i, j));
                    visited[i][j]=true;
                    flag1=true;
                    break;
                }
            }
            if (flag1) break; 
        }
        while (!q.isEmpty()) {
            pair curr=q.poll();
            for (int i=0; i<4; i++) {
                int neighrow=curr.row+rowdirection[i];
                int neighcol=curr.col+coldirection[i];
                if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol]==1 && !visited[neighrow][neighcol]) {
                    q.add(new pair(neighrow, neighcol));
                    visited[neighrow][neighcol]=true;
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if ( visited[i][j]) {
                    q.add(new pair(i, j));
                }
            }
        }
        int count=0;
        while (!q.isEmpty()) {
            int size=q.size();
            while (size>0) {
                size--;
                pair curr=q.poll();
                for (int i=0; i<4; i++) {
                    int neighrow=curr.row+rowdirection[i];
                    int neighcol=curr.col+coldirection[i];
                    if (isvalid(neighrow, neighcol, n, m) && !visited[neighrow][neighcol]) {
                        if (grid[neighrow][neighcol]==1) {
                            return count;
                        }
                        else {
                            visited[neighrow][neighcol]=true;
                            q.add(new pair(neighrow, neighcol));
                        }
                    }
                }
                
            }
            count++;
        }
        return count;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m);
    }
}