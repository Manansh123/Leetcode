class Solution {
    public int majorityElement(int[] nums) {
        int num=nums[0];
        int count=1;
        for (int i=1; i<nums.length; i++) {
            if (num==nums[i]) count++;
            else {
                if (count!=0) {
                    count--;
                }
                else {
                    num=nums[i];
                }
            }
        }
        return num;
    }
}