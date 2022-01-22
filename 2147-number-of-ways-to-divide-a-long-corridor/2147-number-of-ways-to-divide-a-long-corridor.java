class Solution {
    int MOD=1000000007;
    public int numberOfWays(String corridor) {
        int sCount=0;
        for(int i=0;i<corridor.length();i++) if(corridor.charAt(i)=='S') sCount++;    
        if(sCount%2!=0 || sCount==0) return 0;
      long ans=1;
        int prevS=0;
        for(int i=0;i<corridor.length();){
            
            if(corridor.charAt(i)=='S') {
                prevS++;
                
            if(prevS==2){
                int p=i+1;
                while(p<corridor.length() && corridor.charAt(p)!='S')
                    p++;
              if(p!=corridor.length()){
              int len = p -i;
                ans = ((ans% MOD) * (len % MOD)) % MOD;   
              }
            i=p;
              prevS=0; 
            }
            else i++;
            }
            else i++;
        }
        return (int) ans;
    }
}