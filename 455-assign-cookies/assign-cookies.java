class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0, j=0;
        for (int i=0; i<s.length && j<g.length; i++) {
            if (s[i]>=g[j]) {
                cnt++;
                j++;
            }
        }
        return cnt;
    }
}