class Solution {
    public int maxHeight(int[] height, int[] width, int[] length) {

        int n = height.length;

        int[] h = new int[3 * n];
        int[] w = new int[3 * n];
        int[] l = new int[3 * n];

        int k = 0;

        for (int i = 0; i < n; i++) {

            h[k] = height[i];
            w[k] = Math.min(width[i], length[i]);
            l[k] = Math.max(width[i], length[i]);
            k++;

            h[k] = width[i];
            w[k] = Math.min(height[i], length[i]);
            l[k] = Math.max(height[i], length[i]);
            k++;

            h[k] = length[i];
            w[k] = Math.min(height[i], width[i]);
            l[k] = Math.max(height[i], width[i]);
            k++;
        }

        int m = 3 * n;

        // we sort by base area
        for (int i = 0; i < m - 1; i++) {

            for (int j = i + 1; j < m; j++) {

                // here use long becoz i/p is large
                if ((long) w[i] * l[i] > (long) w[j] * l[j]) {

                    int temp = w[i];
                    w[i] = w[j];
                    w[j] = temp;

                    temp = l[i];
                    l[i] = l[j];
                    l[j] = temp;

                    temp = h[i];
                    h[i] = h[j];
                    h[j] = temp;
                }
            }
        }

        int[] dp = new int[m];

        for (int i = 0; i < m; i++) {
            dp[i] = h[i];
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < i; j++) {

                if (w[j] < w[i] && l[j] < l[i]) {

                    dp[i] = Math.max(dp[i], h[i] + dp[j]);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}




// Input: height[] = [4, 1, 4, 10], width[] = [6, 2, 5, 12], length[] = [7, 3, 6, 32]
// Output: 60
// Explanation: One possible arrangement of the boxes from bottom to top is shown below. Note that there can be multiple instances of a box type.
 
// Hence, the total height of this stack is 10 + 32 + 4 + 4 + 6 + 1 + 3 = 60. No other combination of boxes produces a height greater than this.
// Input: height[] = [1, 4, 3], width[] = [2, 5, 4], length[] = [3, 6, 1]
// Output: 15
// Explanation: One possible arrangement of the boxes from bottom to top is shown below: 

// Hence, the total height of this stack is 4 + 6 + 1 + 1 + 3 = 15 No other combination of boxes produces a height greater than this.
// Constraints:

// 1 ≤ height.size(), width.size(), length.size() ≤ 100
// 1 ≤ height[i], width[i], length[i] ≤ 106
