class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int result = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;

                int dist = squaredDistance(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            for (int count : map.values()) {
                result += count * (count - 1);
            }
        }

        return result;
    }

    private int squaredDistance(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        return dx * dx + dy * dy;
    }
}
