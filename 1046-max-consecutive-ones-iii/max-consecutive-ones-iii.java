class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0, end=0, zeros=0, maxlen=0;
        while (end<nums.length) {
            if (nums[end]==0) zeros++;
            while (zeros>k) {
                if (nums[start]==0) zeros--;
                start++;
            }
            end++;
            maxlen=Math.max(maxlen, end-start);
        }
        return maxlen;
    }
}