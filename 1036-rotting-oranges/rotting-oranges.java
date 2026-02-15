//level wise level order traversal
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
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        int onecount=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]==2 && !visited[i][j]) {
                    q.add(new pair(i, j));
                    visited[i][j]=true;
                }
                if (grid[i][j]==1) onecount++;
            }
        }
        int minute=0;
        while (!q.isEmpty()) {
            int size=q.size();
            boolean flag=false; // this will check agar kooi fresh orrange ott hua hai tbhi minute++ kro
            while(size>0) {
                pair curr=q.poll();
                size--;
                for (int i=0; i<4; i++) {
                    int neighrow=curr.row+rowdirection[i];
                    int neighcol=curr.col+coldirection[i];
                    if (isvalid(neighrow, neighcol, n, m) && grid[neighrow][neighcol]==1 && !visited[neighrow][neighcol]) {
                        q.add(new pair(neighrow, neighcol));
                        visited[neighrow][neighcol]=true;
                        flag=true; //yahan pe fresh se rotten bana toh true krdiya
                        onecount--;
                    }
                }
            }
            if (flag) minute++; //har ek bfs ke level pe hoga
        }
        if(onecount>0 && q.isEmpty()) return -1;
        return minute;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m);
    }
}