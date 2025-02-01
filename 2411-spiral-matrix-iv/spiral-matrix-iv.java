class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int[][] result = new int[m][n];

        int row = 0, col = 0;
        int rowEnd = m - 1, colEnd = n - 1;

        while (row <= rowEnd && col <= colEnd) {
            
            // Left to Right
            for (int i = col; i <= colEnd; i++) {
                result[row][i] = (head != null) ? head.val : -1;
                if (head != null) head = head.next;
            }
            row++;

            // Top to Bottom
            for (int i = row; i <= rowEnd; i++) {
                result[i][colEnd] = (head != null) ? head.val : -1;
                if (head != null) head = head.next;
            }
            colEnd--;

            // Right to Left
            if (row <= rowEnd) {
                for (int i = colEnd; i >= col; i--) {
                    result[rowEnd][i] = (head != null) ? head.val : -1;
                    if (head != null) head = head.next;
                }
                rowEnd--;
            }

            // Bottom to Top
            if (col <= colEnd) {
                for (int i = rowEnd; i >= row; i--) {
                    result[i][col] = (head != null) ? head.val : -1;
                    if (head != null) head = head.next;
                }
                col++;
            }
        }
        return result;
    }
}
