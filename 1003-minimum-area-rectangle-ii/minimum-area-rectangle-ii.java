import java.util.HashSet;
import java.util.Set;

class Solution {
    public double minAreaFreeRect(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] point : points) {
            String coordinate = point[0] + "-" + point[1];
            set.add(coordinate);
        }

        double result = Double.MAX_VALUE;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx1 = points[j][0] - points[i][0];
                int dy1 = points[j][1] - points[i][1];

                for (int k = j + 1; k < n; k++) {
                    int dx2 = points[k][0] - points[i][0];
                    int dy2 = points[k][1] - points[i][1];  // Corrected this line

                    if (dx1 * dx2 + dy1 * dy2 != 0) continue;  // Corrected the perpendicular condition

                    int x = dx1 + points[k][0], y = dy1 + points[k][1];
                    String coordinate = x + "-" + y;
                    
                    if (set.contains(coordinate)) {
                        double area = Math.sqrt(dx1 * dx1 + dy1 * dy1) * Math.sqrt(dx2 * dx2 + dy2 * dy2);
                        result = Math.min(result, area);
                    }
                }
            }
        }

        return result == Double.MAX_VALUE ? 0 : result;
    }
}
