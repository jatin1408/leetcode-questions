/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode root;
    Random rand;
    public Solution(ListNode head) {
        this.root=head;
        this.rand=new Random();
    }
    
    public int getRandom() {
        ListNode head=root;
        int ans=0;
        for(int i=1;head!=null;i++){
            if(rand.nextInt(i) == i - 1)
                ans=head.val;
            
            head=head.next;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */