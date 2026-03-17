class NumArray {
    class segmentTree{
        int[] segtree;
        segmentTree(int n) {
            segtree=new int[4*n];
        }
        //i hai segtree ka 
        void buildTree(int i, int[] arr, int s, int e) {
            if (s==e) {
                segtree[i]=arr[s];
                return;
            }
            int mid=(s+e)/2;
            buildTree(2*i+1, arr, s, mid);
            buildTree(2*i+2, arr, mid+1, e);
            segtree[i]=segtree[2*i+1]+segtree[2*i+2];
        }
        // void update(int i, int idx, int val, int[] arr, int s, int e) {
        //     if (s==e) {
        //         segtree[i]=val;
        //         return;
        //     }
        //     int mid=(s+e)/2;
        //     if (idx<=mid) update(2*i+1, idx, val, arr, s, mid);
        //     else update(2*i+2, idx, val, arr, mid+1, e);
        //     segtree[i]=segtree[2*i+1]+segtree[2*i+2];
        // }
        int query(int i, int qs, int qe, int s, int e) {
            if (s>=qs && e<=qe) {
                return segtree[i];
            }
            if (s>qe || e<qs) {
                return 0;
            }
            int mid=(s+e)/2;
            int left=query(2*i+1, qs, qe, s, mid);
            int right=query(2*i+2, qs, qe, mid+1, e);
            return left+right;
        }
    }
    segmentTree obj;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        obj=new segmentTree(nums.length);
        obj.buildTree(0, nums, 0, nums.length-1);
    }
    
    public int sumRange(int left, int right) {
        return obj.query(0, left, right, 0, nums.length-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */