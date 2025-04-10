class Robot {

    private int width, height;
    private int x, y;
    private int dir; // 0 = East, 1 = North, 2 = West, 3 = South
    private int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    private String[] dirNames = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0; // Start facing East
    }

    public void step(int num) {
        int perimeter = 2 * (width + height) - 4;
        num = num % perimeter;

        while (num > 0) {
            int maxSteps = 0;

            if (dir == 0) maxSteps = width - 1 - x;                  // East
            else if (dir == 1) maxSteps = height - 1 - y;            // North
            else if (dir == 2) maxSteps = x;                         // West
            else if (dir == 3) maxSteps = y;                         // South

            int step = Math.min(num, maxSteps);
            x += directions[dir][0] * step;
            y += directions[dir][1] * step;
            num -= step;

            if (num > 0) { // Turn clockwise
                dir = (dir + 1) % 4;
            }
        }

        // Special case: if we land at origin after a full loop, direction should be South
        if (x == 0 && y == 0 && num == 0) dir = 3;
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dirNames[dir];
    }
}
