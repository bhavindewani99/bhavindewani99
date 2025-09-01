class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        Arrays.sort(clips, (a,b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        if(clips[0][0] !=0) return -1;

        int end = clips[0][1];if(end>=time) return 1;
        int taken = 1;
        int index = 1;

        while (index < clips.length) {
            if(clips[0][0] > end) return -1;
            int currMax = -1;
            while(index < clips.length && clips[index][0] <= end){
                currMax = Math.max(currMax, clips[index][1]);
                index++;
            }
            taken++;
            end = currMax;
            if(end >= time) return taken;
        }

        return -1;


    }
}