class Solution {
    public int maxVowels(String s, int k) {
        int start=0, end=0;
        int count=0;
        int maxcount=Integer.MIN_VALUE;
        while (end<s.length()) {
            if (s.charAt(end)=='a' || s.charAt(end)=='e' || s.charAt(end)=='i' || s.charAt(end)=='o' || s.charAt(end)=='u') {
                count++; //include end
            }
            if (end>=k-1) {
                maxcount=Math.max(count, maxcount);
                if (s.charAt(start)=='a' || s.charAt(start)=='e' || s.charAt(start)=='i' || s.charAt(start)=='o' || s.charAt(start)=='u') {
                    count--; //exclude start ka count
                }
                start++; //exclude start
            }
            end++;
        }
        return maxcount;
    }
}