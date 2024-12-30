class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Pair> intervals = new ArrayList<>();
        int n = startTime.length;

        for(int i=0;i<n;i++){
            intervals.add(new Pair(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(intervals, (a,b) -> a.startTime - b.startTime);
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dfs(0, intervals, dp);


    }

    private int dfs(int index, List<Pair> intervals, int[] dp){
        if(index >= intervals.size()) return 0;
        if(dp[index]!=-1) return dp[index];

        int not_take = dfs(index+1, intervals, dp);
        int newIndex = binarySearch(index, intervals);
        int take = intervals.get(index).profit + dfs(newIndex, intervals, dp);
        return dp[index] = Math.max(not_take, take);

    }

    private int binarySearch(int index, List<Pair> intervals){
        int endTime = intervals.get(index).endTime;
        int low = index + 1;
        int high = intervals.size()-1;
        int res = intervals.size();
        while(low<=high){
            int mid = (low+high)/2;
            if(intervals.get(mid).startTime>=endTime){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }

    class Pair{
        int startTime, endTime, profit;
        Pair(int startTime, int endTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}