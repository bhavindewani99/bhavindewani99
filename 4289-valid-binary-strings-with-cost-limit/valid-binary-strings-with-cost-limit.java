class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> res = new ArrayList<>();
        recursion(new StringBuilder(), k, n, 0, res);
        return res;
    }

    private void recursion(StringBuilder curr, int k, int n, int taken, List<String> res){
        if(curr.length() == n){
            res.add(curr.toString());
            return;
        }

        curr.append('0');
        recursion(curr, k, n, taken, res);
        curr.deleteCharAt(curr.length()-1);

        if(curr.length() == 0 || (curr.charAt(curr.length()-1) != '1' && taken + curr.length() <= k)){
            curr.append('1');
            recursion(curr, k, n, taken+curr.length()-1, res);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}