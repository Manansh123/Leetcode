class Solution {
    class segmentTree{
        int[] segtree;
        segmentTree(int n) {
            segtree=new int[4*n];
        }
        void buildTree(int[] arr, int i, int s, int e) {
            if (s==e) {
                segtree[i]=arr[s];
                return;
            }
            int mid=(s+e)/2;
            buildTree(arr, 2*i+1, s, mid);
            buildTree(arr, 2*i+2, mid+1, e);
            segtree[i]=Math.max(segtree[2*i+1], segtree[2*i+2]);
        }
        void update(int i, int idx, int val, int s, int e) {
            if (s==e) {
                segtree[i]=val;
                return;
            }
            int mid=(s+e)/2;
            if (idx<=mid) update(2*i+1, idx, val, s, mid);
            else update(2*i+2, idx, val, mid+1, e);
            segtree[i]=Math.max(segtree[2*i+1], segtree[2*i+2]);
        }
        int query(int i, int fruit, int s, int e) {
            if (segtree[i]<fruit) return -1;
            if (s==e) return s;
            int mid=(s+e)/2;
            if (segtree[2*i+1]>=fruit) return query(2*i+1, fruit, s, mid);
            else return query(2*i+2, fruit, mid+1, e);
        }
    }
    segmentTree obj;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        obj=new segmentTree(n);
        int unplaced=0;
        obj.buildTree(baskets, 0, 0, n-1);
        for (int fruit : fruits) {
            int i=obj.query(0, fruit, 0, n-1);
            if (i==-1) unplaced++;
            else obj.update(0, i, -1, 0, n-1);
        }
        return unplaced;
    }
}