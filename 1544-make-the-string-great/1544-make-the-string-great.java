class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
           if(!st.isEmpty() && Math.abs(st.peek() - ch) == 32) st.pop();
           else st.add(ch);
            
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()) res.append(st.pop());
        return res.reverse().toString();
    }
}