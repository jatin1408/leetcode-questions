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
    public int pairSum(ListNode head) {
        Map<Integer,ListNode> map=new HashMap<>();
        int index=0;
        ListNode curr=head;
        while(curr!=null){
            map.put(index++,curr);
            curr=curr.next;
        }
        int len=index;
        int pairSum=0;
        index=0;
        curr=head;
        while(curr!=null){
            if(index==(len/2)) return pairSum;
            int twin= (len - 1 - index);
            if(!map.containsKey(twin)) return pairSum;
            int newPair=map.get(twin).val + curr.val;
            pairSum=Math.max(newPair,pairSum);
            index++;
            curr=curr.next;
         }
        return pairSum;
    }
}