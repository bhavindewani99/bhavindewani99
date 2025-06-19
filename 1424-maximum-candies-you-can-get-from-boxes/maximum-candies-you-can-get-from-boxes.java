class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        
        Queue<Integer> queue = new LinkedList<>(); // will process boxes
        int result = 0;
        boolean[] boxFound = new boolean[status.length];
        boolean[] processed = new boolean[status.length];
        boolean[] keyFound = new boolean[status.length];

        for(int box : initialBoxes){
            if(status[box] == 1){
                queue.add(box);
                processed[box] = true;
            }else{
                boxFound[box] = true;
            }
        }

        while (!queue.isEmpty()) {
            int nextBox = queue.poll();

            result += candies[nextBox];

            for(int canOpen : containedBoxes[nextBox]){
                if(processed[canOpen]) continue;
                if(status[canOpen] == 1 || keyFound[canOpen]){
                    processed[canOpen] = true;
                    queue.add(canOpen);
                }else{
                    boxFound[canOpen] = true;
                }
            }

            for(int key : keys[nextBox]){
                if(processed[key]) continue;
                if(boxFound[key]){
                    processed[key] = true;
                    queue.add(key);
                }else{
                    keyFound[key] = true;
                }
            }
        }

        return result;
    }
}