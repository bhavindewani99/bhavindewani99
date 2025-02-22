class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        
        int m = mat1.length;
        int n = mat2[0].length;
        int[][] result = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<mat1[0].length;j++){
                for(int k =0;k<mat2[0].length;k++){ 
                    result[i][k] += mat1[i][j] * mat2[j][k]; 
                }
            }
        }
        return result;
    }
}