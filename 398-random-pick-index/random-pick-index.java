class Solution {
    Map<Integer, Pair> map;
    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])==false){
                map.put(nums[i], new Pair());
            }
            map.get(nums[i]).indexes.add(i);
        }
    }
    
    public int pick(int target) {
        Pair pair = map.get(target);
        int res = pair.indexes.get(pair.pointer);
        pair.pointer = (pair.pointer+1) % pair.indexes.size();
        return res;
    }
    
    class Pair{
        int pointer;
        List<Integer> indexes;
        Pair(){
            pointer =0;
            indexes = new ArrayList<>();
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */