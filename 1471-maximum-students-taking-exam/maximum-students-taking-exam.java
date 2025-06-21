import java.util.*;

class Solution {
    int m, n;
    char[][] seats;
    Map<String, Integer> memo;

    public int maxStudents(char[][] seats) {
        this.seats = seats;
        this.m = seats.length;
        this.n = seats[0].length;
        this.memo = new HashMap<>();
        return dfs(0, 0);
    }

    // Recursively try all valid seatings row by row
    private int dfs(int row, int prevMask) {
        if (row == m) return 0;  // base case: all rows processed

        String key = row + "," + prevMask;
        if (memo.containsKey(key)) return memo.get(key);

        int maxStudents = 0;

        // Try all seat configurations (bitmasks) for this row
        for (int currMask = 0; currMask < (1 << n); currMask++) {
            if (isValid(row, currMask) && noDiagonalConflict(currMask, prevMask)) {
                int count = Integer.bitCount(currMask); // number of students seated in this mask
                maxStudents = Math.max(maxStudents, count + dfs(row + 1, currMask));
            }
        }

        memo.put(key, maxStudents);
        return maxStudents;
    }

    // Check if current row mask has valid student positions
    private boolean isValid(int row, int mask) {
        for (int col = 0; col < n; col++) {
            if (((mask >> col) & 1) == 1) {
                // Can't sit on broken seat
                if (seats[row][col] == '#') return false;

                // Can't sit next to another student (left-right)
                if (col > 0 && ((mask >> (col - 1)) & 1) == 1) return false;
                if (col < n - 1 && ((mask >> (col + 1)) & 1) == 1) return false;
            }
        }
        return true;
    }

    // Check for diagonal conflicts with previous row
    private boolean noDiagonalConflict(int currMask, int prevMask) {
        // Diagonal left: student above right (prevMask at col+1)
        if ((currMask << 1 & prevMask) != 0) return false;

        // Diagonal right: student above left (prevMask at col-1)
        if ((currMask >> 1 & prevMask) != 0) return false;

        return true;
    }
}

