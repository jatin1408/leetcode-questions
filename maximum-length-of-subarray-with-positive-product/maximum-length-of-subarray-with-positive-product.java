class Solution {
    public int getMaxLen(int[] nums) {
        int negative=0;
        int len=0;
        int f=-1;
        int l=-1;
        int n=nums.length;
        int lastZero=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) {
                if(f==-1) f=i;
                l=i;
                negative++;
            }
            else if(nums[i]==0){
                if(negative%2==0) {
                    int ans=i-lastZero - 1;
                    len=Math.max(len,ans);
                    lastZero=i;
                    f=-1;
                    l=-1;
                    continue;
                }
                int ll=i-l;
                int fl=f-lastZero;
                if(fl<ll){
                    f++;
                    int ans=i-f;
                    len=Math.max(len,ans);
                }
                else{
                    l--;
                    int ans=l-lastZero;
                    len=Math.max(len,ans);
                }
                lastZero=i;
                f=-1;
                l=-1;
                negative=0;
                
            }
        }
        if(f!=-1 || l!=-1){
            if(negative%2==0){
                int ans=n-lastZero -1;
                    len=Math.max(len,ans);
                    return len;
            }
        int ll=n-l;
        int fl=f-lastZero;
        if(fl<ll){
            f++;
            int ans=n-f;
            len=Math.max(len,ans);
        }
        else{
            l--;
            int ans=l-lastZero;
            len=Math.max(len,ans);
        }
        }
        else{
            int ans=n-lastZero -1;
            len=Math.max(len,ans);
        }
        return len;
    }
}