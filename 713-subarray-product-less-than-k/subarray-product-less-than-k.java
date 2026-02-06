class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // if (k<=1) return 0;  // not use u can only check left<=right because for testcase 2 left aage badhta jaaayega right ke bhi aage
        int start=0, end=0, count=0, pro=1;
        while (end<nums.length) {
            pro*=nums[end];
            while (start<=end && pro>=k) {
                pro/=nums[start];
                start++;
            }
            count+=end-start+1;
            end++;
        }
        return count;
    }
}