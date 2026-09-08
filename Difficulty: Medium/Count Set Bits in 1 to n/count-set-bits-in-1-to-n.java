class Solution {
    public static int countSetBits(int n) {
        int count = 0;

       for (int i = 1; i <= n; i *= 2) {
    int total = n + 1;
    int full = total / (2 * i);
    int rem = total % (2 * i);

    count += full * i;

    if (rem > i) {
        count += rem - i;
    }
}

        return count;
    }
}