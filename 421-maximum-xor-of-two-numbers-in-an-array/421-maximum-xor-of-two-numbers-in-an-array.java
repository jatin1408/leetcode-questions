class TrieNode{
    TrieNode[] links;
    public TrieNode(){
        links=new TrieNode[2];
    }
}
class Solution {
     TrieNode root=new TrieNode();
    public int findMaximumXOR(int[] nums) {
       TrieNode curr=root;
        for(int ele:nums){
            curr=root;
            for(int i=30;i>=0;i--){
                int bit = (ele & (1<<i)) == 0 ? 0 : 1;
                if(curr.links[bit]==null)
                    curr.links[bit]=new TrieNode();
                curr=curr.links[bit];
            }
        }
        int max=Integer.MIN_VALUE;
        for(int ele:nums){
            int xor=0;
            curr=root;
            for(int i=30;i>=0;i--){
                 int oppBit = (ele & (1<<i)) == 0 ? 1 : 0;
                    
                 if(curr.links[oppBit]!=null){
                   curr=curr.links[oppBit];
                   xor+=(1<<i);  
                 } 
                else{
                    int bit = oppBit == 0 ? 1: 0;
                     curr=curr.links[bit];
                 }  
            }
            max=Math.max(max,xor);
        }
        return max;
    }
}