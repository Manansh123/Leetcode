class Solution {
    public int maxSubArray(int[] nums) {
        int pre[] = new int[nums.length];
        int minprefixsum = 0, maxsum = Integer.MIN_VALUE;
        //miprefixsum is used whenever we will subtract prefix sum with the minprefixsum we will get the the max sum
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            maxsum = Math.max(maxsum, pre[i] - minprefixsum);
            minprefixsum = Math.min(minprefixsum, pre[i]);
        }
        return maxsum;
    }
}