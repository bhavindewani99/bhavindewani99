class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        
        List<int[]> xcord = new ArrayList<>();
        List<int[]> ycord = new ArrayList<>();

        for(int[] rectangle : rectangles){
            xcord.add(new int[]{rectangle[0], rectangle[2]});
            ycord.add(new int[]{rectangle[1], rectangle[3]});
        }

        Collections.sort(xcord, (a,b) -> a[0]-b[0]);
        Collections.sort(ycord, (a,b) -> a[0]-b[0]);

        return mergeIntervals(xcord) || mergeIntervals(ycord);
    }


    private boolean mergeIntervals(List<int[]> intervals){
        int pairs = 1;
        int end = intervals.get(0)[1];

        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i)[0]>=end){
                pairs++;
                end = intervals.get(i)[1];
            }else{
                end = Math.max(end, intervals.get(i)[1]);
            }
        }
        return pairs >=3;
    }
}