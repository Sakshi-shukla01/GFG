class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;

        while (i < arr.length) {

            int correctIndex = arr[i] - 1;

            if (arr[i] != arr[correctIndex]) {

                
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;

            } else {
                i++;
            }
        }

     
        for (i = 0; i < arr.length; i++) {

            if (arr[i] != i + 1) {
                ans.add(arr[i]);
            }
        }

        return ans;
    }
}