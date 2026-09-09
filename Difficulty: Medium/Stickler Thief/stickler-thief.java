class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=arr[0];
        
        for(int i=2;i<=n;i++){
            int pick=arr[i-1]+dp[i-2];
            
            int notPick=dp[i-1];
            
            dp[i]=Math.max(pick,notPick);
        }
        return dp[n];
    }
}