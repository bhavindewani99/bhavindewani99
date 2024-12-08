class Solution {
    public int maxTwoEvents(int[][] events) {
        List<List<Integer>> lineSweep = new ArrayList<>();
        int n = events.length;

        for(int i=0;i<n;i++){
            lineSweep.add(Arrays.asList(events[i][0], 1, events[i][2]));
            lineSweep.add(Arrays.asList(events[i][1]+1, -1, events[i][2]));
        }

        Collections.sort(lineSweep, (a, b) -> a.get(0).equals(b.get(0)) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));

        int maxSum =0;
        int maxSeen = 0;

        for(List<Integer> event : lineSweep){
            int time = event.get(0);
            int type = event.get(1);
            int val = event.get(2);
            
            if(type==-1) maxSeen = Math.max(maxSeen, val);
            else{
                int currSum = val + maxSeen;
                maxSum = Math.max(currSum, maxSum);
            }
        }

        return maxSum;

    }
}