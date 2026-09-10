class Solution {
    public void rotateMatrix(int[][] matrix) {
        // code here
        int n=matrix.length;
        //int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
      for (int i = 0; i < n / 2; i++) {
    int[] temp = matrix[i];
    matrix[i] = matrix[n - 1 - i];
    matrix[n - 1 - i] = temp;
}
            
    }
}