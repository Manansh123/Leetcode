class Solution {
    long[][] dp;

    private long util(int i, int[] nums, boolean isPos) {
        if (i >= nums.length) return 0;
        if (dp[isPos ? 1 : 0][i] != -1) return dp[isPos ? 1 : 0][i];

        long curr = isPos ? nums[i] : -1L * nums[i];
        return dp[isPos ? 1 : 0][i] = Math.max(
            curr + util(i + 1, nums, !isPos),
            util(i + 1, nums, isPos)
        );
    }

    public long maxAlternatingSum(int[] nums) {
        dp = new long[2][nums.length + 1];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        return util(0, nums, true);
    }
}