class Solution {
    public int countDays(int days, int[][] meetings) {
        
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        int result = meetings[0][0]-1;
        int end = meetings[0][1];

        for(int i=1;i<meetings.length;i++){
            if(end < meetings[i][0]){
                result += meetings[i][0]-end-1;
            }
            end = Math.max(end, meetings[i][1]);
        }
        result += days- end;
        return result;

    }
}