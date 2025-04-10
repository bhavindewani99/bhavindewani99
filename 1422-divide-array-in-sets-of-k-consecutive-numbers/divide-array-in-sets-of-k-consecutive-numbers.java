class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {

        if(nums.length % k !=0) return false;
        
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int pair = 0;

        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        for(int i=0;i<nums.length;i++){

            if(map.containsKey(nums[i])){
                int curr = nums[i];
                int count = 0;
                while(count < k){
                    if(map.containsKey(curr) == false) return false;
                    if(map.get(curr)==1) map.remove(curr);
                    else map.put(curr, map.get(curr) - 1);
                    count++;
                    curr++;                  
                }
                pair++;
            }
        }

        return pair == nums.length/k;

    }
}