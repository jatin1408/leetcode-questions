class Solution {
    public void reverse(int i,int j,int[] nums){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        if(k==0) return;
        if(k<0) k+=nums.length;
        reverse(nums.length-k,nums.length-1,nums);
        reverse(0,nums.length-k - 1,nums);
        reverse(0,nums.length-1,nums);
        
    }

}