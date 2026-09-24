class Solution {
    public int maxStackHeight(int[] r, int[] h) {

        int n = r.length;

        int[] dp = new int[1001];

        int ans = 0;

        for (int radius = 1; radius <= 1000; radius++) {

           
            int[] update = new int[1001];

            for (int i = 0; i < n; i++) {

                if (r[i] == radius) {

                    int height = h[i];

                    int best = 0;

                    for (int j = 1; j < height; j++) {
                        best = Math.max(best, dp[j]);
                    }

                    int current = best + height;

                    update[height] =
                        Math.max(update[height], current);

                    ans = Math.max(ans, current);
                }
            }

            for (int height = 1; height <= 1000; height++) {
                dp[height] =
                    Math.max(dp[height], update[height]);
            }
        }

        return ans;
    }
}

