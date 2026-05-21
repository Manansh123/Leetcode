class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n][m];
        for (int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, n, m, nums1, nums2, dp);
    }
    public int solve(int i, int j, int n, int m, int[] nums1, int[] nums2, int[][] dp) {
        if (i==n || j==m) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        if (nums1[i]==nums2[j]) return dp[i][j]=1+solve(i+1, j+1, n, m, nums1, nums2, dp);
        else return dp[i][j]=Math.max(solve(i+1, j, n, m, nums1, nums2, dp), solve(i, j+1, n, m, nums1, nums2, dp));
    }
}