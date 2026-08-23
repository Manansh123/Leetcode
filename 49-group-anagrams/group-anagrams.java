class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for (String s : strs) {
            String i=sort(s);
            if (!map.containsKey(i)) map.put(i, new ArrayList<>());
            map.get(i).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public String sort(String s) {
        char[] arr=s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}