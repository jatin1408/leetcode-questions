import java.lang.Math;
class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        char prev=s.charAt(0);
        int num=0;
        boolean operator=prev=='+' || prev == '-' ? true:false;
        if(!Character.isDigit(prev) && !operator) return 0;
        if(!operator)
            num=num*10 + Character.getNumericValue(prev);
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            int val=Character.getNumericValue(ch);
            if(Character.isDigit(ch)){
                try{
                    int newNum = Math.multiplyExact(num,10);
                    newNum = Math.addExact(newNum,val);
                    num=newNum;
                }
                catch(Exception e){
                    return operator && prev == '-' ? Integer.MIN_VALUE :Integer.MAX_VALUE;
                }
            }            
            else return operator && prev=='-' ? num * -1 : num;
        }
        return operator && prev =='-' ? num * -1 : num;
    }
}