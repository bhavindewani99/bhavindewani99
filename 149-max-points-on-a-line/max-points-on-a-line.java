import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 2) return points.length; // Handle edge case
        
        int res = 1;

        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            Map<Double, Integer> count = new HashMap<>();
            
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                double slope;

                // Vertical line case
                if (p2[0] == p1[0]) {
                    slope = Double.POSITIVE_INFINITY; // Use positive infinity for vertical line
                }
                // Horizontal line case
                else if (p2[1] == p1[1]) {
                    slope = 0.0; // Slope of a horizontal line is 0
                }
                // Calculate slope as a double
                else {
                    int dy = p2[1] - p1[1];
                    int dx = p2[0] - p1[0];
                    slope = (double) dy / dx; // Cast to double to avoid integer division
                }

                count.put(slope, count.getOrDefault(slope, 0) + 1);
                res = Math.max(res, count.get(slope) + 1); // +1 to include the starting point
            }
        }

        return res;
    }
}
