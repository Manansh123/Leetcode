class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start=0, end=0;
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;

        while (end<nums.length) {
            currsum+=nums[end];  //include end element;
            if(end>=k-1) {
                maxsum=Math.max(currsum, maxsum);  //check size is the sliding window of size k
                currsum-=nums[start];  //exclude start element
                start++;
            }
            end++;
        }
        return (double) maxsum/k;
    }
}