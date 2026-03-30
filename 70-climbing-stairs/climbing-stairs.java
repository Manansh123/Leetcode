class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+2];
        Arrays.fill(dp, -1);
        int i=0;
        return solve(i, n, dp);
    }
    public int solve(int i, int n, int[] dp) {
        if (dp[i]!=-1) return dp[i];
        if (i == n) return 1;
        if (i > n) return 0;
        return dp[i]=solve(i+1, n, dp) + solve(i+2, n, dp);
    }
}
