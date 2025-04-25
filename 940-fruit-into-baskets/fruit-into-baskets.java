class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, result = 0;

        for(int i=0;i<fruits.length;i++){
            map.put(fruits[i], map.getOrDefault(fruits[i], 0)  +1);

            while(map.size()>2){
                int leftFruit = fruits[left++];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if(map.get(leftFruit) == 0) map.remove(leftFruit);
            }

            result = Math.max(result, i - left + 1);
        }

        return result;
    }
}