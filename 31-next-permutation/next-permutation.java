class Solution {
    public void nextPermutation(int[] nums) {
        int m = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                m = i - 1;
                break;
            }
        }
        if (m != -1) {
            for (int i = nums.length - 1; i > m; i--) {
                if (nums[m] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[m];
                    nums[m] = temp;
                    break;
                }
            }
        }
        int i = m+1, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}