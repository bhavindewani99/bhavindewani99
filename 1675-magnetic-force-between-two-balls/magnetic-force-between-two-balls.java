class Solution {
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        int len = position.length;
        int low = 1, high = position[len-1] - position[0];
        int result = 0;

        while(low<=high){
            int distance = (low+high)/2;
            if(possible(position, m, len, distance)){
                result = distance;
                low = distance+1;
            }else{
                high = distance - 1;
            }
        }
        return result;
    }

    private boolean possible(int[] position, int totalBalls, int len, int currDistance){
        int currentBalls = 1;
        int prevPosition = position[0];

        for(int i=1;i<len;i++){
            if(position[i] - prevPosition >= currDistance){
                prevPosition = position[i];
                currentBalls++;
            }
        }

        return currentBalls >= totalBalls;
    }
}