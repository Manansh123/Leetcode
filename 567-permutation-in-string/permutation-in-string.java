class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int start = 0, end = 0;
        int k = s1.length();
        HashMap<Character, Integer> s1freq = new HashMap<>();
        for (char i : s1.toCharArray()) {
            s1freq.put(i, s1freq.getOrDefault(i, 0) + 1);
        }
        HashMap<Character, Integer> s2freq = new HashMap<>();
        while (end < s2.length()) {
            char c = s2.charAt(end);
            s2freq.put(c, s2freq.getOrDefault(c, 0) + 1);
            if (end >= k - 1) {
                if (s1freq.equals(s2freq)) return true; //pahele liikhenge jisse equal hone ke baad dubara excllude naa hojaaye nhi toh equal wala start htt jaayega
                char exc = s2.charAt(start);
                s2freq.put(exc, s2freq.getOrDefault(exc, 0) - 1);
                if (s2freq.get(exc)==0) s2freq.remove(exc); //mtlb start wala purre hashmap mai ekk hi th toh usko zero krke remove krdo humlog directly remove nhi krte nhi toh uss element ki freq zyaada bhi ho skti hi toh usse answe galat ho jaayega
                start++;
            }
            end++;
        }
        return false;
    }
}