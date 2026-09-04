class Solution {
    public int firstSearch(int[] arr, int k) {
        // Code Here
        int n=arr.length;
        int left=0;
        int right=n-1;
        int result=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(k==arr[mid]){
                result=mid;
                right=mid-1;
            }else if(k<arr[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
}