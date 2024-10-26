class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int maxKey = 0;

        for(int r=nums.size()-1;r>=0;r--){
            for(int c=0;c<nums.get(r).size();c++){
                int currKey = r + c;
                maxKey = Math.max(maxKey, currKey);
                if(!map.containsKey(currKey)) map.put(currKey, new ArrayList<>());
                map.get(currKey).add(nums.get(r).get(c));
                n++;
            }
        }

        int res[] = new int[n];
        int index = 0;
        for(int key =0;key<=maxKey;key++){
            List<Integer> temp = map.get(key);
            for(int val : temp) res[index++] = val;
        }
        return res;
    }
}