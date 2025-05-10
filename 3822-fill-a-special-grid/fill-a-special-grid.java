class Solution {
    int number;
    public int[][] specialGrid(int n) {
        
        int power = (int) Math.pow(2, n);
        number = power*power - 1;
        int[][] result = new int[power][power];

        recursion(0, 0, power, result);

        return result;

    }

    private void recursion(int row, int col, int size, int[][] result){
        if(size == 1) {
            result[row][col] = number;
            number -=1;
            return;
        }

        int newSize = size / 2;

        recursion(row, col, newSize, result); // top left
        recursion(row + newSize, col, newSize, result); // bottom left
        recursion(row + newSize, col + newSize, newSize, result); // bottom right
        recursion(row , col + newSize, newSize, result);

    }
}