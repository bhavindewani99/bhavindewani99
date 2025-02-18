class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }

     private void recursion(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> ans) {
        if (target == 0 || target < 0 || index == candidates.length) {
            if(target==0) ans.add(new ArrayList<>(temp));
            return;
        }
        

        // take
        temp.add(candidates[index]);
        recursion(candidates, target - candidates[index], index, temp, ans); 
        temp.remove(temp.size() - 1);

        // not_take
        recursion(candidates, target, index + 1, temp, ans);
    }
}