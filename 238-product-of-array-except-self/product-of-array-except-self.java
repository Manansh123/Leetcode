class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int z = 0, pro = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                z++;
        }
        if (z > 1)
            return arr;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pro *= nums[i];
            }
        }
        if (z == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    arr[i] = pro;
                } else {
                    arr[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                arr[i] = pro / nums[i];
            }
        }

        return arr;
    }
}
