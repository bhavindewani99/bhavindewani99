class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mod = (int) 1e9 + 7;

        long maxh = 0, maxb = 0, prev = 0;

        for(int curr : horizontalCuts){
            maxh = Math.max(maxh, curr - prev);
            prev = curr;
        }
        maxh = Math.max(maxh, h - prev);
        prev = 0;

        for(int curr : verticalCuts){
            maxb = Math.max(maxb, curr - prev);
            prev = curr;
        }
        maxb = Math.max(maxb, w - prev);

        return (int) ((maxh * maxb) % mod);

    }
}