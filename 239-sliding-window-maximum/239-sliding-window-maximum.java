class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new LinkedList<>();
        int[] res=new int[nums.length - k + 1];
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.addLast(i);
        }
        int index=0;
        res[index++]=nums[dq.peekFirst()];
        for(int i=k;i<nums.length;i++){
           
            while(!dq.isEmpty() && i -  dq.peekFirst() >= k) dq.pollFirst(); 
            // System.out.println(dq.size());
             while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            
             dq.addLast(i);
             res[index++]=nums[dq.peekFirst()];
        }
        return res;
        
    }
}