class Solution {
    public int minimumIndex(List<Integer> nums) {
        
        int n = nums.size();
        int[] leftDominant = new int[n], rightDominant = new int[n];
        Map<Integer, Integer> map = new HashMap<>(); // value , frequency
        int currMaxFreq = 0, currMaxElement = 0;

        for(int i=0;i<n;i++){
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            if(map.get(nums.get(i)) > currMaxFreq){
                currMaxFreq = map.get(nums.get(i));
                currMaxElement = nums.get(i);
            }

            if(currMaxFreq * 2 > i + 1) leftDominant[i] = currMaxElement;
        }
        map.clear();
        currMaxElement = 0;
        currMaxFreq = 0;

        for(int i=n-1;i>=0;i--){
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            if(map.get(nums.get(i)) > currMaxFreq){
                currMaxFreq = map.get(nums.get(i));
                currMaxElement = nums.get(i);
            }

            if(currMaxFreq * 2 > n - i) rightDominant[i] = currMaxElement;
        }

        for(int i=0;i<n-1;i++){
            if(leftDominant[i]!=0 && leftDominant[i]==rightDominant[i+1]) return i;
        }
        return -1;
    }
}