class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        backTrack(curr, 0, 0, n, ans);
        return ans;
    }

    private void backTrack(StringBuilder curr, int open, int close, int n, List<String> ans) {
        if (open == close && close == n) {
            ans.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append("(");
            backTrack(curr, open + 1, close, n, ans);
            curr.deleteCharAt(curr.length()-1);
        }
        if (close < open) {
            curr.append(")");
            backTrack(curr, open, close + 1, n, ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
