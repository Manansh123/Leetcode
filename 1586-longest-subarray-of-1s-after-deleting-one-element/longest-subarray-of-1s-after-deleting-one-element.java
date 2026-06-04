class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;
        int zerocount=0;
        int max=0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j]==0) zerocount++;
            while (zerocount>1) {
                if (nums[i]==0) {
                    i++; zerocount--;
                }
                else {
                    i++;
                }
            }
            max=Math.max(max, j-i);
        }
        return max;
    }
}