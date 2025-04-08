class Solution {
    public int minimumOperations(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int nonDistCount = 0, left =0, n = nums.length, operations = 0;

        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        for(int keys : map.keySet()){
            if(map.get(keys)>1) nonDistCount++;
        }

        if(nonDistCount==0) return 0;

        while(left < n && nonDistCount>0){
            operations++;
            for(int i=0;i<3 && left<n ;i++){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==1) nonDistCount--;
                left++;
            }
        }

        return operations++;
    }
}