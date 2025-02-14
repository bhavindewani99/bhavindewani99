class Solution {
    public int maximumSum(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>(); // sum to max value from nums
        int result = -1;

        for(int i=0;i<nums.length;i++){
            int currElement = nums[i];
            int currSum = getSum(currElement);

            if(map.containsKey(currSum)){
                result = Math.max(result, currElement + map.get(currSum));
                map.put(currSum, Math.max(map.get(currSum), currElement));
            }else{
                map.put(currSum, currElement);
            }
        }
        return result;
    }

    private int getSum(int n){
        int sum = 0;
        while (n>0) {
            sum += n%10;
            n/=10;
        }
        return sum;
    }
}