class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int totalWeight = 0;
        int maxWeight = 0; 

        for(int weight : weights) {
            totalWeight += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int lowestWeight = maxWeight, highestWeight = totalWeight, result = 0;

        while (lowestWeight <= highestWeight) {
            int targetWeight = (lowestWeight + highestWeight) / 2;
            if (possible(targetWeight, days, weights)) {
                result = targetWeight;
                highestWeight = targetWeight - 1;
            } else {
                lowestWeight = targetWeight + 1;
            }
        }
        return result;
    }

    private boolean possible(int targetWeight, int maxDays, int[] weights) {
        int currWeight = 0;
        int daysRequired = 1;

        for (int weight : weights) {
            if (currWeight + weight > targetWeight) {
                daysRequired++;
                currWeight = 0;
            }
            currWeight += weight;
        }
        return daysRequired <= maxDays;
    }
}
