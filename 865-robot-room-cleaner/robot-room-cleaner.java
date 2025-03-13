/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        dfs(0, 0, directions, set, robot, 0);
    }

    private void dfs(int x, int y, int[][] directions, Set<Pair<Integer, Integer>> set, Robot robot, int currDirection){
        robot.clean();
        set.add(new Pair(x, y));

        for(int i=0;i<4;i++){
            int newDirection = (currDirection + i) %4;
            int newX = directions[newDirection][0] + x;
            int newY = directions[newDirection][1] + y;
            Pair<Integer, Integer> pair = new Pair(newX, newY);
            if(!set.contains(pair) && robot.move()==true){
                dfs(newX, newY, directions, set, robot, newDirection);
                // go back
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}