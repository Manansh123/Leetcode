class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int start=0, end=0;
        int maxlen=0;
        while (end<s.length()) {
            while (hs.contains(s.charAt(end))) {
                hs.remove(s.charAt(start));
                start++;
            }
            if (!hs.contains(s.charAt(end))) hs.add(s.charAt(end));
            maxlen= Math.max(maxlen, end-start+1);
            end++;
        }
        return maxlen;
    }
}