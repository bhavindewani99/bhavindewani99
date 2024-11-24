class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] matrix = new char[m][n];

        for (char[] temp : matrix) Arrays.fill(temp, 'F');

        for (int[] guard : guards) {
            matrix[guard[0]][guard[1]] = 'G';
        }

        for (int[] wall : walls) {
            matrix[wall[0]][wall[1]] = 'W';
        }

        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];
            markGuarded(r, c, -1, 0, matrix, m, n); // Up
            markGuarded(r, c, 1, 0, matrix, m, n);  // Down
            markGuarded(r, c, 0, -1, matrix, m, n); // Left
            markGuarded(r, c, 0, 1, matrix, m, n);  // Right
        }

        // Count unguarded cells ('F')
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'F') result++;
            }
        }

        return result;
    }

    private void markGuarded(int r, int c, int dr, int dc, char[][] matrix, int m, int n) {
        r += dr;
        c += dc;

        while (r >= 0 && c >= 0 && r < m && c < n) {
            if (matrix[r][c] == 'W' || matrix[r][c] == 'G') break;
            if (matrix[r][c] == 'F') matrix[r][c] = 'T';
            r += dr;
            c += dc;
        }
    }
}
