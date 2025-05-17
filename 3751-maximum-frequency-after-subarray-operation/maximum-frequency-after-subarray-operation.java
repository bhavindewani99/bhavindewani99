class Solution {
// We are trying to find maxium occurence of any element appart from k 
    public int maxFrequency(int[] nums, int k) {
        
        int kCount = 0, result =0;

        for(int num : nums){
            if(num == k) kCount++;
        }

        result = kCount;

        for(int target = 1;target<=50;target++){
            int targetCount = 0, maxTargetCount =0;
            for(int num : nums){
                if(num == target) targetCount++;
                
                if(num == k) targetCount--;

                if(targetCount < 0) targetCount = 0;
                maxTargetCount = Math.max(maxTargetCount, targetCount);
            }
            result = Math.max(result, maxTargetCount + kCount);
        }

        return result;
    }
}