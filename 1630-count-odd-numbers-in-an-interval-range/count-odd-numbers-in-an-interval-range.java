class Solution {
    class segmentTree{
        int[] segtree;
        segmentTree(int n) {
            segtree=new int[4*n];
        }
        //i hai segtree ka 
        void buildTree(int i, int[] arr, int s, int e) {
            if (s==e) {
                segtree[i]=(arr[s]%2!=0) ? 1 : 0;
                return;
            }
            else {
                int mid=(s+e)/2;
                buildTree(2*i+1, arr, s, mid);
                buildTree(2*i+2, arr, mid+1, e);
                segtree[i]=segtree[2*i+1]+segtree[2*i+2];
            }
        }
        void update(int i, int idx, int val, int[] arr, int s, int e) {
            if (s==e) {
                segtree[i]=(val%2!=0) ? 1 : 0;
                return;
            }
            else {
                int mid=(s+e)/2;
                if (idx<=mid) update(2*i+1, idx, val, arr, s, mid);
                else update(2*i+2, idx, val, arr, mid+1, e);
                segtree[i]=segtree[2*i+1]+segtree[2*i+2];
            }
        }
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
    public int countOdds(int low, int high) {
        int n=high-low+1;
        if (n > 100000) {
            return ((high + 1) / 2) - (low / 2);
        }
        int[] arr=new int[n];
        int temp=low;
        for (int i=0; i<n;i++) {
            arr[i]=temp;
            temp++;
        }
        segmentTree obj=new segmentTree(n);
        obj.buildTree(0, arr, 0, n-1);
        return obj.query(0, 0, n-1, 0, n-1);
    }
}