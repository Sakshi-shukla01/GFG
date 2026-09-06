
class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        
        int first = -1;
        int last = -1;
        
        int low = 0;
        int high = arr.length - 1;
        
       
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            }
            else if (arr[mid] < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        low = 0;
        high = arr.length - 1;
        
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            }
            else if (arr[mid] < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(first);
        result.add(last);
        
        return result;
    }
}

