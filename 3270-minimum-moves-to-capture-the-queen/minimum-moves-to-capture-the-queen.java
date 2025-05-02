class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {

        // CASE 1: Rook and queen are on the same row or column
        if (a == e || b == f) {

            // Sub-case: all 3 on the same **row**, and bishop is between rook and queen
            if (a == c && a == e && ((d - b) * (d - f)) < 0)
                return 2;

            // Sub-case: all 3 on the same **column**, and bishop is between rook and queen
            if (b == d && b == f && ((c - a) * (c - e)) < 0)
                return 2;

            return 1; // Rook can capture queen in 1 move
        }

        // CASE 2: Bishop and queen are on same diagonal
        if (Math.abs(c - e) == Math.abs(d - f)) {

            // Sub-case: Rook lies on same diagonal and is between bishop and queen
            if (Math.abs(c - a) == Math.abs(d - b) && ((b - f) * (b - d)) < 0)
                return 2;

            return 1; // Bishop can capture queen in 1 move
        }

        // CASE 3: Neither piece can reach the queen directly
        return 2;
    }
}
