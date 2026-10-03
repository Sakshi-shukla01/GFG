class Solution {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][4];

        // Base case: day 0
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][0],
                        Math.max(matrix[0][1], matrix[0][2]));

        // Remaining days
        for (int day = 1; day < n; day++) {

            for (int last = 0; last < 4; last++) {

                dp[day][last] = 0;

                for (int task = 0; task < 3; task++) {

                    if (task != last) {
                        int points = matrix[day][task]
                                   + dp[day - 1][task];

                        dp[day][last] = Math.max(
                            dp[day][last],
                            points
                        );
                    }
                }
            }
        }

        return dp[n - 1][3];
    }
}
