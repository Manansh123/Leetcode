class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] countSort = new int[10001];
        for (int num : nums) {
            countSort[num]++;
        }
        int[] dp = new int[10001];
        dp[1] = countSort[1];
        for (int i = 2; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * countSort[i]);
        }
        return dp[10000];
    }
}