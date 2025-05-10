/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        
        return dfs(0, 0, grid.length, grid);
    }

    private Node dfs(int row, int col, int size, int[][] grid){

        boolean allValuesSame = true;

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(grid[row][col] != grid[row + i][col + j]){
                    allValuesSame=false;
                }
            }
        }

        if(allValuesSame == true){
            return new Node(grid[row][col] == 1 ? true : false, true);
        }

        size = size/2;

        Node topLeft = dfs(row, col, size, grid);
        Node bottomLeft = dfs(row+size, col, size, grid);
        Node topRight = dfs(row, col+size, size, grid);
        Node bottomRight = dfs(row+size, col+size, size, grid);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}