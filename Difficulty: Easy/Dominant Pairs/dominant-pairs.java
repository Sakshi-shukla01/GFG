class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
        int half = n / 2;

        int[] first = Arrays.copyOfRange(arr, 0, half);
        int[] second = Arrays.copyOfRange(arr, half, n);

        Arrays.sort(first);
        Arrays.sort(second);

        int count = 0;
        int j = 0;

        for (int i = 0; i < half; i++) {
           
            while (j < second.length && 5L * second[j] <= first[i]) {
                j++;
            }
            count += j;
        }

        return count;
    }
}