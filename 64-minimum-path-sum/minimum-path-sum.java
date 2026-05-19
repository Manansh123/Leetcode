class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, n, m, grid, dp);
    }
    public int solve(int i, int j, int n, int m, int[][] grid, int[][] dp) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = solve(i + 1, j, n, m, grid, dp);
        int right = solve(i, j + 1, n, m, grid, dp);
        int min = Math.min(down, right);
        if (min == Integer.MAX_VALUE) {
            return dp[i][j] = Integer.MAX_VALUE;
        }
        return dp[i][j] = grid[i][j] + min;
    }
}