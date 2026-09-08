class Solution {
    int minCost(int ind,int[] height,int[] dp){
        if(ind==0){
            return 0;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        
        int left=minCost(ind-1,height,dp)+Math.abs(height[ind]-height[ind-1]);
        
        int right=Integer.MAX_VALUE;
        if(ind>1){
            right=minCost(ind-2,height,dp)+Math.abs(height[ind]-height[ind-2]);
        }
        dp[ind]=Math.min(left,right);
        
        return dp[ind];
        
    }
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        
        return minCost(n-1,height,dp);
        
    }
}