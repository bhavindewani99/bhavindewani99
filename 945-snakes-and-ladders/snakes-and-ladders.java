class Solution {
    public int snakesAndLadders(int[][] board) {
        Set<Integer> set = new HashSet<>();
        int n = board.length;
        reverseBoard(board, n);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0}); // SquareNumber, Moves
        set.add(1);

        while(!queue.isEmpty()){
            int currSquare = queue.peek()[0];
            int currMoves = queue.peek()[1];
            queue.poll();
            if(currSquare == n*n) return currMoves;

            for(int i=1;i<=6;i++){
                int nextSquare = currSquare + i;
                int[] position = getPosition(nextSquare, n);
                int r = position[0];
                int c = position[1];
                if(board[r][c]!=-1) nextSquare = board[r][c];
                if(nextSquare == n*n) return currMoves +1;
                if(!set.contains(nextSquare)){
                    set.add(nextSquare);
                    queue.offer(new int[]{nextSquare, currMoves+1});
                }
            }
        }
        return -1;
    }

    private int[] getPosition(int square, int n){
        int r = (square-1)/n;
        int c = (square-1)%n;
        if(r%2!=0){
            c = n - 1 - c;
        }
        return new int[]{r,c};
    }

    private void reverseBoard(int[][] board, int n){
        for(int i=0;i<n/2;i++){
            int temp[] = board[i];
            board[i] = board[n-i-1];
            board[n-i-1] = temp;
        }
    }
}