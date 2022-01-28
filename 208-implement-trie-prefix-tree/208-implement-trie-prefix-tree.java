class TrieNode{
    TrieNode[] links;
    int radix=26;
    boolean isEnd;
    TrieNode(){
        links=new TrieNode[radix];
    }
}
class Trie {
     TrieNode root;
    public Trie() {
       root=new TrieNode();  
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length() && curr!=null;i++){
            char ch=word.charAt(i);
            if(curr.links[ch-'a']==null) curr.links[ch-'a']=new TrieNode();
            curr=curr.links[ch-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode res=searchPrefix(word);
        
        return res!=null && res.isEnd?true:false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode res=searchPrefix(prefix);
        return res==null?false:true;
    }
      public TrieNode searchPrefix(String word){
         TrieNode curr=root;
        int i=0;
        for(;i<word.length() && curr!=null;i++){
            char ch=word.charAt(i);
            curr=curr.links[ch-'a'];
        }
        return curr;
      }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */