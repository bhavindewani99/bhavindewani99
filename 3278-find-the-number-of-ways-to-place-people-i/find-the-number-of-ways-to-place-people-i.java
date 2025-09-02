class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        // Sort by x asc, then y desc
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int pairs = 0;
        for (int i = 0; i < n; i++) {
            int baseX = points[i][0], baseY = points[i][1];
            int maxY = -1;  // track the maximum y among points between i and j

            for (int j = i + 1; j < n; j++) {
                int currX = points[j][0], currY = points[j][1];
                if (currY > baseY) continue; // not a valid rectangle

                // If there is any point with y strictly between currY and baseY
                if (maxY >= currY) {
                    // some point lies inside rectangle → skip
                } else {
                    pairs++;
                }

                // update maxY seen so far
                maxY = Math.max(maxY, currY);
            }
        }
        return pairs;
    }
}
