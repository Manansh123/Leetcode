class Solution {
    public void moveZeroes(int[] nums) {
        int i=0, j=0;
        for (int m=0; m<nums.length; m++) {
            if (nums[j]==0) j++;
            else {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++; j++;
            }
        }
    }
}