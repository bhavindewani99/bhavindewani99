class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        boolean[] occurences = new boolean[n+1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);

        for(int value : map.values()){
            if(occurences[value]==true) return false;
            occurences[value] = true;
        }

        return true;
    }
}