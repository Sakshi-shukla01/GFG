class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        int [][] dp=new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0]=i*costS1;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j*costS2;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int deleteFromS1=costS1+dp[i-1][j];
                    int deleteFromS2=costS2+dp[i][j-1];
                    
                    
                    dp[i][j]=Math.min(deleteFromS1,deleteFromS2);
                }
            }
        }
        return dp[n][m];
    }
}