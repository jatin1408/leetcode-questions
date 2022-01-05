class Solution {
     List<List<String>> ls=new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> temp=new ArrayList<>();
        dfs(0,s.length(),s,temp);
        return ls;
    }
    public void dfs(int start,int end,String s,List<String> temp){
        if(start>=end) {
            ls.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<end;i++){
            String newSub=s.substring(start,i + 1);
            if(isPalindrome(newSub)) {
                temp.add(newSub);
                dfs(i+1,end,s,temp);
                temp.remove(temp.size()-1);
            }    
        }
    }
    boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r) 
            if(s.charAt(l++) != s.charAt(r--)) return false;
        
        return true;
    }
    
}