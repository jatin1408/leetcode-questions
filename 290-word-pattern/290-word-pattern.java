class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word=s.split(" ");
        if(word.length != pattern.length()) return false;
        Map<String,Character> stringToChar=new HashMap<>();
        Map<Character,String> charToStr =  new HashMap<>();
        
        for(int i=0;i<pattern.length();i++){
           char ch=pattern.charAt(i);
           String preWord = null;
           char preChar='#';
           if(charToStr.containsKey(ch)){
               preWord=charToStr.get(ch);
           }
           else{
                charToStr.put(ch,word[i]);
           }
           if(stringToChar.containsKey(word[i])){
             
               preChar=stringToChar.get(word[i]);
           }
           else{
                stringToChar.put(word[i],ch);
           }
  
            
            
            if(preWord != null || preChar != '#'){
                if(preWord==null) {
                    if(ch!=preChar) return false;
                }
                else 
                    if(!preWord.equals(word[i])) return false;
                
            } 
        }
        return true;
    }
}