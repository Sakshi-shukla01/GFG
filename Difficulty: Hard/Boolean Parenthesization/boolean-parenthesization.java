class Solution {

    static int countWays(String s) {
        int n = s.length();

        long[][][] dp = new long[n][n][2];

     
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return (int) solve(s, 0, n - 1, 1, dp);
    }

    static long solve(String s, int i, int j, int isTrue,
                      long[][][] dp) {

        // Empty expression
        if (i > j) {
            return 0;
        }

        // One character
        if (i == j) {
            if (isTrue == 1) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }

 
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        long ans = 0;

        for (int k = i + 1; k < j; k += 2) {

            char op = s.charAt(k);

            long leftTrue = solve(s, i, k - 1, 1, dp);
            long leftFalse = solve(s, i, k - 1, 0, dp);

            long rightTrue = solve(s, k + 1, j, 1, dp);
            long rightFalse = solve(s, k + 1, j, 0, dp);

            if (op == '&') {

                if (isTrue == 1) {
                    ans += leftTrue * rightTrue;
                } else {
                    ans += leftTrue * rightFalse
                         + leftFalse * rightTrue
                         + leftFalse * rightFalse;
                }

            } 
            else if (op == '|') {

                if (isTrue == 1) {
                    ans += leftTrue * rightTrue
                         + leftTrue * rightFalse
                         + leftFalse * rightTrue;
                } else {
                    ans += leftFalse * rightFalse;
                }

            } 
            else if (op == '^') {

                if (isTrue == 1) {
                    ans += leftTrue * rightFalse
                         + leftFalse * rightTrue;
                } else {
                    ans += leftTrue * rightTrue
                         + leftFalse * rightFalse;
                }
            }
        }

        return dp[i][j][isTrue] = ans;
    }
}