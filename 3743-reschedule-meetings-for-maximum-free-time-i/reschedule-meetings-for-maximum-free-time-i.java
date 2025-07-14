class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        
        int n = startTime.length;
        int[] freeTimes = new int[n+1];
        int currTime = 0, maxTime = 0;

        freeTimes[0] = startTime[0] - 0;

        for(int i=0;i<n-1;i++){
            freeTimes[i+1] = startTime[i+1] - endTime[i];
        }

        freeTimes[n] = eventTime - endTime[n-1];

        for(int i=0;i<=n;i++){
            currTime += freeTimes[i];

            if(i > k) currTime-= freeTimes[i-(k+1)];

            maxTime = Math.max(maxTime, currTime);
        }
        return maxTime;
    }
}