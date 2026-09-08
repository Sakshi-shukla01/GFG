class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int[] board=new int[n];
        solve(0,n,board,ans);
        
        return ans;
    }
    void solve(int row,int n,int[] board,ArrayList<ArrayList<Integer>> ans){
        if(row==n){
            ArrayList<Integer> temp=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                temp.add(board[i]+1);
                
            }
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col,board)){
                board[row]=col;
                
                solve(row+1,n,board,ans);
                board[row]=-1;
            }
        }
    }
    boolean isSafe(int row,int col,int[] board){
        for(int i=0;i<row;i++){
            if(board[i]==col){
                return false;
            }
            if(Math.abs(i-row)==Math.abs(board[i]-col)){
                return false;
            }
        }
        return true;
    }
}