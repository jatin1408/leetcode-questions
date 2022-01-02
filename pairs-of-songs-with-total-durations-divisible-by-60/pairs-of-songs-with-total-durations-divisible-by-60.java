class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans=0;
        int[] rem=new int[60];
        for(int t:time){
            if(t%60 == 0) ans+=rem[0];
            else {
                 int f= 60 - t % 60;
                ans+=rem[f];
            }
            rem[t%60]++;
        }
        return ans;
    }
}