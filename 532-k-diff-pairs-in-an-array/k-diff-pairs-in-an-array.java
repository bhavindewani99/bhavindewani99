class Solution {
    public int findPairs(int[] nums, int k) {
        Set<String> result = new HashSet();
        Map<Integer, Integer> elements = new HashMap<>();

        for(int num : nums) elements.put(num, elements.getOrDefault(num, 0)+ 1);

        for(int num : nums){
            elements.put(num, elements.getOrDefault(num, 0) - 1);
            int b1 = num - k, b2 = num + k;

            if(elements.getOrDefault(b1, 0) > 0) {
                if(b1 <= num) result.add(b1 + "&"+ num);
                else result.add(num + "&" + b1);
            } 
            if(elements.getOrDefault(b2, 0) > 0) {
                if(b2 <= num) result.add(b2 + "&"+ num);
                else result.add(num + "&" + b2);
            } 
            elements.put(num, elements.getOrDefault(num, 0) + 1);
        }

        return result.size();
    }
}

