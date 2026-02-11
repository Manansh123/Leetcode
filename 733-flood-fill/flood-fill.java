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

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        Queue<pair> q=new LinkedList<>();
        int oldcolour=image[sr][sc];
        image[sr][sc]=color;
        pair p=new pair(sr, sc);
        q.add(p);
        while (!q.isEmpty()) {
            pair curr=q.poll();
            for (int i=0; i<rowdirection.length; i++) {
                int neighrow=curr.row+rowdirection[i];
                int neighcol=curr.col+coldirection[i];
                if (isvalid(neighrow, neighcol, n, m) && image[neighrow][neighcol]!=color && image[neighrow][neighcol]==oldcolour) {
                    image[neighrow][neighcol]=color;
                    pair neigh=new pair(neighrow, neighcol);
                    q.add(neigh);
                }
            }
        }
        return image;
    }
    public boolean isvalid(int row, int col, int n, int m) {
        return (row>=0 && row<n && col>=0 && col<m) ? true : false;
    }
}