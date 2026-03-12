class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent=new int[n];
            for (int i=0; i<n; i++) parent[i]=i;
            rank=new int[n];
        }
        public void union(int a, int b) {
            int pa=find(a);
            int pb=find(b);
            if (pa==pb) return;
            if (rank[pa]>rank[pb]) parent[pb]=pa;
            else if (rank[pb]>rank[pa]) parent[pa]=pb;
            else {
                parent[pb]=pa;
                rank[pa]++;
            }
        }
        public int find(int x){
            if (parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //hashmap bhi use hoga email key hongi and values node hongi yaa
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        int n=accounts.size();
        DSU obj=new DSU(n);
        for (int i=0; i<n; i++) {
            for (int j=1; j<accounts.get(i).size(); j++) {
                if (map.containsKey(accounts.get(i).get(j))) {
                    obj.union(map.get(accounts.get(i).get(j)), i);
                }
                else {
                    map.put(accounts.get(i).get(j), i);
                }
            }
        }
        List<List<String>> lst=new ArrayList<>();
        for (int i=0; i<n; i++) {
            lst.add(new ArrayList<>());
        }
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            String mail=i.getKey();
            int node=obj.find(i.getValue());
            lst.get(node).add(mail);
        }
        List<List<String>> res=new ArrayList<>();
        for (int i=0; i<lst.size(); i++) {
            if (lst.get(i).size()==0) continue;
            Collections.sort(lst.get(i));
            ArrayList<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(lst.get(i));
            res.add(temp);
        }
        return res;
    }
}