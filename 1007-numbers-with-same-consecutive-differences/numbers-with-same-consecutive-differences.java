class Solution {
    public int[] numsSameConsecDiff(int n, int k) {

        List<Integer> res = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            backtrack(i, n - 1, k, res);
        }

        int[] ans = new int[res.size()];

        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    private void backtrack(int currentNum, int remainingDigits, int k, List<Integer> res) {

        if(remainingDigits == 0) {
            res.add(currentNum);
            return;
        }

        int lastDigit = currentNum % 10;

        int nextDigit1 = lastDigit + k;
        int nextDigit2 = lastDigit - k;

        if(nextDigit1 <= 9) {
            backtrack(currentNum * 10 + nextDigit1,
                      remainingDigits - 1,
                      k,
                      res);
        }

        if(k != 0 && nextDigit2 >= 0) {
            backtrack(currentNum * 10 + nextDigit2,
                      remainingDigits - 1,
                      k,
                      res);
        }
    }
}