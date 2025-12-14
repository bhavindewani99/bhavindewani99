class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {

        long area1 = (long) (ax2 - ax1) * (ay2 - ay1);
        long area2 = (long) (bx2 - bx1) * (by2 - by1);

        int overlapW = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapH = Math.min(ay2, by2) - Math.max(ay1, by1);

        long overlap = 0;
        if (overlapW > 0 && overlapH > 0) {
            overlap = (long) overlapW * overlapH;
        }

        return (int) (area1 + area2 - overlap);
    }
}
