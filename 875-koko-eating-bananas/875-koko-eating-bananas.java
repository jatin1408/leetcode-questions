class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int ele:piles) max=Math.max(max,ele);
        int l=1;
        int r=max;
        while(l<=r){
            int mid = l + (r-l) / 2;
            int hours=getHours(piles,mid);
            if(hours>h) l=mid+1; 
            
            else r=mid-1;
            
        }
        return l;
        
        
    }
    public int getHours(int[] piles,int k){
        int ans=0;
        for(int ele:piles) ans+=ele/k + (ele%k==0?0:1);
        return ans;
    }
}