class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> powers = new ArrayList<>();
        Map<Integer, Long> dp = new HashMap<>();

        for (int p : power)
            freqMap.put(p, freqMap.getOrDefault(p, 0) + 1);

        powers.addAll(freqMap.keySet());
        Collections.sort(powers);

        for (int i = 0; i < powers.size(); i++) {
            int curr = powers.get(i);
            int idx = binarySearch(curr - 3, powers);

            long currDamage = (long) curr * freqMap.get(curr);   // <-- cast fixed
            if (idx >= 0) currDamage += dp.get(powers.get(idx));
            if (i > 0) currDamage = Math.max(currDamage, dp.get(powers.get(i - 1)));

            dp.put(curr, currDamage);
        }
        return dp.get(powers.get(powers.size() - 1));
    }

    private int binarySearch(int target, List<Integer> arr) {
        int low = 0, high = arr.size() - 1;   // <-- fixed bound
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
