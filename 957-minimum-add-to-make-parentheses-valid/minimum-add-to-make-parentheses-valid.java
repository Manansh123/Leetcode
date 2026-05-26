class Solution {
    public int minAddToMakeValid(String s) {
        Stack<String> stk=new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(') stk.push("(");
            else {
                if (!stk.isEmpty() && stk.peek().equals("(")) stk.pop();
                else stk.push(")");
            }
        }
        return stk.size();
    }
}