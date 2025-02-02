class Solution {
    public int getLargestOutlier(int[] nums) {
        
        // We traverse in every element in nums and take tha element as getLargestOutlier
        // We have total sum so formular can be outlier + sum + sum = totalSum
        // Sum = (totalSum-outlier)/2 we have to check there exist this sum means that element in hash map

        int totalSum = 0;
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            totalSum += num; 
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i=0;i<n;i++){
            int outlier = nums[i];
            if((totalSum - outlier)%2 !=0) continue;
            int sum = (totalSum - outlier)/2;
            if(map.containsKey(sum) && (sum!=outlier ||  map.get(sum)>1)){
                result = Math.max(outlier, result);
            }
        }

        return result;
    }
}