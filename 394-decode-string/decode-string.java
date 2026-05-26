class Solution {
    public String decodeString(String s) {
        Stack<String> stk=new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!=']') stk.push(String.valueOf(s.charAt(i)));
            else {
                String c=""; // for closing bracket ke pahele ki string
                while (!stk.peek().equals("[")) c=stk.pop()+c;
                stk.pop();//for opening bracket
                String n="";
                while (!stk.isEmpty() && Character.isDigit(stk.peek().charAt(0))) n=stk.pop()+n;
                int num=Integer.parseInt(n);
                String ans="";
                while (num!=0) {
                    ans+=c;
                    num--;
                }
                stk.push(ans);
            }
        }
        String ans="";
        while (!stk.isEmpty()) {
            ans=stk.pop()+ans;
        }
        return ans;
    }
}