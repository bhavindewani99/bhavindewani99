class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int rows = matrix.length, cols = matrix[0].length;
        int[][] subSum = new int[rows][cols];
        int result =0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int sum = matrix[i][j];
                if(i-1>=0) sum += subSum[i-1][j];
                if(j-1>=0) sum += subSum[i][j-1];
                if(i-1>=0 && j-1>=0) sum-= subSum[i-1][j-1]; // because we added twice
                subSum[i][j] = sum;
            }
        }

        for(int r1 = 0;r1<rows;r1++){
            for(int r2=r1;r2<rows;r2++){
                for(int c1=0;c1<cols;c1++){
                    for(int c2=c1;c2<cols;c2++){

                        int currSum = subSum[r2][c2];
                        if(r1-1>=0) currSum -= subSum[r1-1][c2];
                        if(c1-1>=0) currSum -= subSum[r2][c1-1];
                        if(r1-1>=0 && c1-1>=0) currSum += subSum[r1-1][c1-1]; // beacuse we subtracted twice
                        
                        if(currSum==target) result++;
                    }
                }
            }
        }
        return result;
    }
}