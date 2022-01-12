class Solution {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
         dp=new Integer[grid.length][grid[0].length][grid[0].length];
        return dfs(0,0,grid[0].length-1,grid);
        
    }
    public int dfs(int row,int col1,int col2,int[][] grid){
        if(row<0 || col1<0 || col2<0 || col1>=grid[0].length || col2>=grid[0].length || row>=grid.length) return 0;
        if(dp[row][col1][col2]!=null) return dp[row][col1][col2];
        int maxValue=0;
        for(int i=-1;i<=1;i++)
            for(int j=-1;j<=1;j++)
                maxValue=Math.max(maxValue,dfs(row+1,col1+i,col2+j,grid));
        if(col1==col2) maxValue+=grid[row][col1];
        else maxValue+=grid[row][col1] + grid[row][col2];
        return dp[row][col1][col2]=maxValue;
        
    }
}