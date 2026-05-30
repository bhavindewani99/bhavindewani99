class Solution {
    int result = Integer.MIN_VALUE;
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix.length, n = matrix[0].length;
        recursion(m, n, new HashSet(), matrix, 0, numSelect, 0);
        return result;
    }


    private void recursion(int m, int n, Set<Integer> cols, int[][] matrix, int count, int numSelect, int index){
        if(count == numSelect){
            result = Math.max(result,calculate(matrix, cols, m, n));
            return;
        }

        for(int i=index;i<n;i++){
            if(!cols.contains(i)){
                cols.add(i);
                recursion(m, n, cols, matrix, count+1, numSelect, i+1);
                cols.remove(i);
            }
        }
    }

    private int calculate(int[][] matrix, Set<Integer> cols, int m, int n){
        int res = 0;

        for(int i=0;i<m;i++){
            boolean present = true;
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1){
                    if(cols.contains(j) == false){
                        present = false;
                        break;
                    }
                }
            }
            if(present) res++;
        }
        return res;
    }
}