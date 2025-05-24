class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int operations = 0;

        for(int num : nums){
            int x = k - num;
            if(map.containsKey(x)){
                map.put(x, map.get(x) - 1);
                if(map.get(x)==0) map.remove(x);
                operations++;
            }else{
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return operations;
    }
}