class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int n=arr.length;
        int largest=-1;
        int secondLargest=-1;
        for(int num:arr){
            if(num>largest){
                secondLargest=largest;
                largest=num;
            }else if(num>secondLargest && num!=largest){
                secondLargest=num;
            }
            
        }
        return secondLargest;
    }
}