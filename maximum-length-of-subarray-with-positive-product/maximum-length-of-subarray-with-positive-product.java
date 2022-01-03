class Solution {
    public int getMaxLen(int[] nums) {
        int lastZero=-1;
        int firstNegative=-1;
        int countNegative=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                countNegative++;
                if(firstNegative==-1) firstNegative=i; 
            }
            
            if(nums[i]==0){
                countNegative=0;
                firstNegative=-1;
                lastZero=i;
            }
            
            else{
                if(countNegative%2==0) max=Math.max(max,i-lastZero);
                else max=Math.max(max,i - firstNegative);
            }
        }
        return max;
    }
}
    
