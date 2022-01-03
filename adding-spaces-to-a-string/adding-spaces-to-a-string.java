class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int index=0;
        for(int i=0;i<s.length();i++){
            if(index!=spaces.length && i==spaces[index]){
                sb.append(' ');
                index++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}