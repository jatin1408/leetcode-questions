class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            boolean add=true;
            while(!st.isEmpty() && Math.abs(ch-st.peek()) == 32) {
                add=false;
                st.pop();
                break;
            }
            if(add) 
                st.add(ch);
            
        }
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()) res.insert(0,st.pop());
        return res.toString();
    }
}