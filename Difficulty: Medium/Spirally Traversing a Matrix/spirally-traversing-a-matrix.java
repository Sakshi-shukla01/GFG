class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=m-1;
        
        ArrayList<Integer> ans = new ArrayList<>();

        while(top<=bottom && left<=right){
            for(int j=left;j<=right;j++){
                ans.add(mat[top][j]);
            }
            top++;
            
            //top-bottom
            for(int i=top;i<=bottom;i++){
                ans.add(mat[i][right]);
                
            }right--;
            //right-left
            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    ans.add(mat[bottom][j]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
