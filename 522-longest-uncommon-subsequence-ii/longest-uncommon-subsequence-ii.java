class Solution {
    public int findLUSlength(String[] strs) {

        int result = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean isSub = false;

            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;

                // check if strs[i] is a subsequence of strs[j]
                if (isSubSequence(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }

            if (!isSub) {
                result = Math.max(result, strs[i].length());
            }
        }

        return result;
    }

    private boolean isSubSequence(String small, String big) {
        

        int i = 0, j = 0;

        while (i < small.length() && j < big.length()) {
            if (small.charAt(i) == big.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == small.length();
    }
}
