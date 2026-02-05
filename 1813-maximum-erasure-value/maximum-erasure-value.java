class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int start=0, end=0;
        int maxsum=0, sum=0;
        while (end<nums.length) {
            while (hs.contains(nums[end])) {
                sum-=nums[start];
                hs.remove(nums[start]);
                start++;
            }
            if (!hs.contains(nums[end])) {
                hs.add(nums[end]);
                sum+=nums[end];
            }
            end++;
            maxsum=Math.max(maxsum, sum);
        }
        return maxsum;
    }
}