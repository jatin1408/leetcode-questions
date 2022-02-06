class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        int p=0;
        while(p<len){
            int ele=nums[p];
            int j=p+1;
            while(j<len && ele==nums[j]) j++;
            int steps=j-p-2;
            if(steps>=1){
                while(j<len){
                    nums[j-steps]=nums[j];
                    j++;
                }
                len-=steps;
            }
            p++;
        }
        return len;
    }
}