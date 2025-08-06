class Solution {
    public int maxBalancedShipments(int[] weight) {
        int shipments  = 0;
        int currMax = weight[0];
        int left = 0;

        for(int i=1;i<weight.length;i++){
            currMax = Math.max(currMax, weight[i]);
            if(currMax != weight[i] && left!=i){
                currMax = -1;
                left = i+1;
                shipments++;
            }
        } 
        return shipments;
    }
}