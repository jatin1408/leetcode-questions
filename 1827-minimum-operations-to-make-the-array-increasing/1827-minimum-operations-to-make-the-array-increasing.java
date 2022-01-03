class Solution {
    public int minOperations(int[] nums) {
      int sub=0;
    int add=0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<=nums[i-1]){
                add+=nums[i-1]  + 1;
                sub+=nums[i];
                nums[i] = nums[i-1]  + 1;
            }
        }
        return add - sub;
    }
}