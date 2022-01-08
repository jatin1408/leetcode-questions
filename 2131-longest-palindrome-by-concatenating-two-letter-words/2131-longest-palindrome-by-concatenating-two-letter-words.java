class Solution {
    public int longestPalindrome(String[] words) {
        int ans=0;
        Map<String,Integer> map=new HashMap<>();
        for(String word:words) map.put(word,map.getOrDefault(word,0) + 1);
        boolean found=false;
        for(String word:words){
            String reversed="";
            reversed+=word.charAt(1);
            reversed+=word.charAt(0);
            if(reversed.equals(word) && map.containsKey(word)) {
                int num = map.get(word);
                if(num%2!=0){
                    found=true;
                    num--;
                }
                ans += num * 2;
                map.remove(word);
            }

            else if(map.containsKey(reversed)){
                int ff=map.get(word);
                int sf=map.get(reversed);
                int min=Math.min(ff,sf);
                ans+=min*4;
                map.remove(reversed);
                map.remove(word);
            }
        }
        if(found) ans+=2;
        return ans;
    }
}