class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l=new ArrayList<>();
        rec("(", 1, 0, n, l);
        return l;
    }
    public void rec(String ans, int open, int close, int n, List<String> l) {
        if (open==n && close==n) {
            l.add(ans);
            return;
        }
        if (open<n) rec(ans+"(", open+1, close, n, l);
        if (close<open) rec(ans+")", open, close+1, n, l);
    }
}