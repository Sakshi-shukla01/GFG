class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {

        int[] dp = new int[x + 100];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int area = 1; area < dp.length; area++) {

            if (area >= s && dp[area - s] != Integer.MAX_VALUE) {
                dp[area] = Math.min(dp[area], dp[area - s] + cs);
            }

            if (area >= m && dp[area - m] != Integer.MAX_VALUE) {
                dp[area] = Math.min(dp[area], dp[area - m] + cm);
            }

            if (area >= l && dp[area - l] != Integer.MAX_VALUE) {
                dp[area] = Math.min(dp[area], dp[area - l] + cl);
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int area = x; area < dp.length; area++) {
            answer = Math.min(answer, dp[area]);
        }

        return answer;
    }
}