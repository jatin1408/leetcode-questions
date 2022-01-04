class TreeAncestor {
    int maxBits;
    Integer [][] dp;
    public TreeAncestor(int n, int[] parent) {
        maxBits=(int) (Math.log(n) / Math.log(2) + 1);
        dp=new Integer[maxBits][n];
        for(int i=0;i<n;i++) dp[0][i]=parent[i];
        for(int i=1;i<maxBits;i++){
            for(int j=0;j<n;j++){
                int last = dp[i - 1][j];
                dp[i][j] = last == -1 ? -1 : dp[i - 1][last];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0;i<maxBits;i++){
            if((k & (1<<i)) > 0){
            
                Integer val = dp[i][node];
                
                if(val==-1) return -1;
                node=val;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */