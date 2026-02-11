class Solution {
    class pair{
        int row;
        int col;
        pair(int row, int col) {
            this.row=row;
            this.col=col;
        }
    }
    int[] rowdirection={-1, 0, 0, 1};
    int[] coldirection={0, 1, -1, 0};
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for (int i=0; i<m; i++) {
            if (board[0][i]=='O') {
                bfs(0, i, board);
            }
        } 
        for (int i=0; i<n; i++) {
            if (board[i][0]=='O') {
                bfs(i, 0, board);
            }
        } 
        for (int i=0; i<n; i++) {
            if (board[i][m-1]=='O') {
                bfs(i, m-1, board);
            }
        } 
        for (int i=0; i<m; i++) {
            if (board[n-1][i]=='O') {
                bfs(n-1, i, board);
            }
        } 
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j]=='O') board[i][j]='X';
                else if (board[i][j]=='A') board[i][j]='O';
            }
        }
    }
    public void bfs(int row, int col, char[][] board) {
        int n=board.length;
        int m=board[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row, col));
        board[row][col]='A';
        //see we are making this "A" because to identify that the border  having "o" and all the "o" connected to it either vertically or horizontally not have to be changed to "x"
        while (!q.isEmpty()) {
            pair curr=q.poll();
            for (int i=0; i<rowdirection.length; i++) {
                int neighrow=curr.row+rowdirection[i];
                int neighcol=curr.col+coldirection[i];
                if (isvalid(neighrow, neighcol, n, m) && board[neighrow][neighcol]=='O') {
                    board[neighrow][neighcol]='A';
                    q.add(new pair(neighrow, neighcol));
                }
            }
        }
    }
    public boolean isvalid(int row, int  col, int n, int m){
        return (row>=0 && row<n && col>=0 && col<m) ? true : false;
    }
}