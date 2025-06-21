class Solution {

    Map<String, Integer> map = new HashMap<>();
    int m,n;
    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        return dfs(0, 0, seats);
    }

    private int dfs(int row, int prevMask, char[][] seats){
        if(row == m) return 0;
        String key = row + "*" + prevMask;

        if(map.containsKey(key)) return map.get(key);

        int currStudents = 0;

        for(int currMask = 0; currMask < (1<<n); currMask++){
            if(isValid(currMask, row, seats) && noDiagonalConflict(currMask, prevMask)){
                int count = Integer.bitCount(currMask);
                currStudents = Math.max(currStudents, count + dfs(row+1, currMask, seats));
            }
        }

        map.put(key, currStudents);
        return map.get(key);
    }

    // This method is to check if currMask means students are seating on no broken seats
    private boolean isValid(int currMask, int row, char[][] seats){
        for(int col=0;col<n;col++){
            if(((currMask >> col) & 1) == 1){
                if(seats[row][col] == '#') return false;
                
                if(col > 0 && ((currMask >> col-1 ) & 1)== 1) return false;
                if(col < n-1 && ((currMask >> col+1) & 1)==1) return false;
            }
        }
        return true;
    }

    // To check diagonal confict
    private boolean noDiagonalConflict(int currMask, int prevMask){
        if(((currMask << 1) & prevMask) != 0) return false;
        if(((currMask >> 1) & prevMask) != 0) return false;

        return true;
    }

}