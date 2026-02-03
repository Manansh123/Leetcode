class NumArray {
    int pre[]; //prefix sum array
    public NumArray(int[] nums) {
        pre=nums;
        //constructor ek bar call hoga toh ek hi baar prefix sum banega toh yahan prefix sum array banaayenge naaki sumrange mai bnaayenge
        for (int i=1; i<nums.length; i++) {
            pre[i]=pre[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left==0) return pre[right];
        
        return pre[right]-pre[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */