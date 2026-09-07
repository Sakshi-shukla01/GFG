class Solution {
    static ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> ans=new ArrayList<>();
        
        char[] arr=s.toCharArray();
        
        Arrays.sort(arr);
        
        boolean[] used=new boolean[arr.length];
        backtrack(arr,used,new StringBuilder(),ans);
        return ans;
    }
    private static void backtrack(char[] arr,boolean[] used,StringBuilder current,ArrayList<String> ans){
    if(current.length()==arr.length){
        ans.add(current.toString());
        return;
    }
    for(int i=0;i<arr.length;i++){
        if(used[i]){
            continue;
        }
        if(i>0 && arr[i]==arr[i-1] && !used[i-1]){
            continue;
        }
        used[i]=true;
        current.append(arr[i]);
        
        backtrack(arr,used,current,ans);
        
        current.deleteCharAt(current.length()-1);
        used[i]=false;
    }
}
}