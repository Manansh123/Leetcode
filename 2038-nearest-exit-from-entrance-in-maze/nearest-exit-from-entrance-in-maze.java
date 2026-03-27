class Solution {
    class pair {
        int row, col;

        pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] rowdirection = { -1, 0, 0, 1 };
    int[] coldirection = { 0, 1, -1, 0 };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int steps = 0;
        q.add(new pair(entrance[0], entrance[1]));
        visited[entrance[0]][entrance[1]] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                pair curr = q.poll();
                if ((curr.row == 0 || curr.col == 0 || curr.row == m - 1 || curr.col == n - 1) && !(curr.row == entrance[0] && curr.col == entrance[1]))
                    return steps;
                for (int i = 0; i < 4; i++) {
                    int neighrow = curr.row + rowdirection[i];
                    int neighcol = curr.col + coldirection[i];
                    if (isValid(neighrow, neighcol, m, n) && !visited[neighrow][neighcol]  && maze[neighrow][neighcol] == '.') {
                        q.add(new pair(neighrow, neighcol));
                        visited[neighrow][neighcol] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public boolean isValid(int r, int c, int m, int n) {
        return (r>=0 && r<m && c>=0 && c<n);
    }
}