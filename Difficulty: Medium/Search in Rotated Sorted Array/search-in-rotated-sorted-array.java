class Solution {
    int search(int[] arr, int key) {
        // code here
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] == key)
                return i;
        }
       
        return -1;
    }
}