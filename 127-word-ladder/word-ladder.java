class Solution {
    class pair{
        String word;
        int dist;
        public pair(String word, int dist) {
            this.word=word;
            this.dist=dist;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(beginWord, 1));
        HashSet<String> st=new HashSet<>(wordList); // we are making this because we dont want words to repeat again and again when traversingg
        st.remove(beginWord);
        if (!st.contains(endWord)) return 0;
        while (!q.isEmpty()) {
            pair curr=q.poll();
            String currword=curr.word;
            int currdist=curr.dist;
            if (currword.equals(endWord)) {
                return currdist;
            }
            char[] wordarr=currword.toCharArray();
            for (int i=0; i<currword.length(); i++) {
                char original=wordarr[i];
                for (char j='a'; j<='z'; j++) {
                    wordarr[i]=j;
                    String newword=new String(wordarr);
                    if (st.contains(newword)) {
                        q.add(new pair(newword, currdist+1));
                        st.remove(newword);
                    }
                }
                wordarr[i]=original;
            }
        }
        return 0;
    }
}