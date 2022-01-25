class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCase=0;
        int lowerCase=0;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(Character.isUpperCase(ch)) upperCase++;
            else lowerCase++;
        }
        return upperCase==word.length() || lowerCase==word.length() || lowerCase==word.length() -1 && Character.isUpperCase(word.charAt(0));
        
    }
}