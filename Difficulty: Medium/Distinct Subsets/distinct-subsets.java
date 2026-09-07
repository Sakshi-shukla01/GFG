class Solution {
    public ArrayList<ArrayList<Integer>> findSubsets(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        Arrays.sort(arr);
        backtrack(arr,0,new ArrayList<>(),ans);
        
        return ans;
        
        
    }
    private void backtrack(int[] arr,int start,ArrayList<Integer> current,ArrayList<ArrayList<Integer>> ans)
{
    ans.add(new ArrayList<>(current));
    
    for(int i=start;i<arr.length;i++){
        if(i>start && arr[i]==arr[i-1]){
            continue;
        }
        current.add(arr[i]);
        
        backtrack(arr,i+1,current,ans);
        
        current.remove(current.size()-1);
    }
    
}
    
}
