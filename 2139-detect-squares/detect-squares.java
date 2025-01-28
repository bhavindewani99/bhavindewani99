class DetectSquares {

      // We store the points in hashmap when we get query point then we iterate through all the points and the find the diagonal point
    // if we find diagonal point then we can easily get the remainig points and their count and multiply them
    Map<String, Integer> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0], py = point[1];
        int result = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String[] coords = entry.getKey().split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            
            // Check if the points form a diagonal (exclude points with zero area)
            if (Math.abs(x - px) != Math.abs(y - py) || x == px || y == py) {
                continue;
            }

            // Form the other two points of the square
            String point1 = x + "," + py;
            String point2 = px + "," + y;

            // Check if the points exist in the map
            if (map.containsKey(point1) && map.containsKey(point2)) {
                result += entry.getValue() * map.get(point1) * map.get(point2);
            }
        }

        return result;
    }
}
