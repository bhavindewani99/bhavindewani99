class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        int n = intervals.length;
        Pair[] pairs = new Pair[n];
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            pairs[i] = new Pair(intervals[i][0], intervals[i][1], i);
        }

        Arrays.sort(pairs, (a,b) -> a.start - b.start);

        for(int i=0;i<n;i++){
            int index = getNextBigger(pairs[i].end, pairs, 0, n-1);
            result[pairs[i].index] = index;
        }

        return result;
    }

    private int getNextBigger(int end, Pair[] pairs, int low, int high){
        int result = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(pairs[mid].start >= end){
                result = pairs[mid].index;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return result;
    }


    class Pair{
        int start, end, index;
        Pair(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}