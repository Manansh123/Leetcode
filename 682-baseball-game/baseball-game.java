class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stk=new Stack<>();
        for (String i : ops) {
            if (i.equals("C")) {
                stk.pop();
            }
            else if (i.equals("D")) {
                stk.push(stk.peek()*2);
            }
            else if (i.equals("+")) {
                int top=stk.pop();
                int newtop=stk.peek()+top;
                stk.push(top);
                stk.push(newtop);
            }
            else {
                stk.push(Integer.parseInt(i));
            }
        }
        int ans=0;
        while (!stk.isEmpty()) {
            ans+=stk.pop();
        }
        return ans;
    }
}