class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;

        long[][] max = new long[n + 1][k + 1];
        long[][] min = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(max[i], Long.MIN_VALUE);
            java.util.Arrays.fill(min[i], Long.MAX_VALUE);
        }

        max[0][0] = min[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {

                // Don't take
                max[i][j] = max[i - 1][j];
                min[i][j] = min[i - 1][j];

                // Take
                if (j > 0 && max[i - 1][j - 1] != Long.MIN_VALUE) {
                    long a = max[i - 1][j - 1] * arr[i - 1];
                    long b = min[i - 1][j - 1] * arr[i - 1];

                    max[i][j] = Math.max(max[i][j], Math.max(a, b));
                    min[i][j] = Math.min(min[i][j], Math.min(a, b));
                }
            }
        }

        return (int) max[n][k];
    }
}