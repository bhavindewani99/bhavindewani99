class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        backtrack(num, 0, res);
        return res;
    }

    private boolean backtrack(String s, int index, List<Integer> res) {
    if (index == s.length()) {
        return res.size() >= 3; // Must have at least 3 numbers
    }

    long num = 0; // Use long to prevent overflow during construction
    for (int i = index; i < s.length(); i++) {
        // Fix 1: Handle leading zeros correctly
        if (i > index && s.charAt(index) == '0') break;

        num = num * 10 + (s.charAt(i) - '0');

        // Fix 2: Check for 32-bit integer overflow
        if (num > Integer.MAX_VALUE) break;

        int size = res.size();
        // Fix 3: Pruning optimization
        if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) break;

        if (size < 2 || num == res.get(size - 1) + res.get(size - 2)) {
            res.add((int) num);
            if (backtrack(s, i + 1, res)) return true;
            res.remove(res.size() - 1); // Standard backtrack
        }
    }
    return false;
}

}