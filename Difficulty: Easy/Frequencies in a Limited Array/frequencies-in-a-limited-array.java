class Solution {
    public ArrayList<Integer> frequencyCount(int[] arr) {
        // code here
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
            
        }
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=1;i<=n;i++){
            result.add(map.getOrDefault(i,0));
        }
        return result;
    }
}
