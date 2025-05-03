class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] check=new boolean[nums.length];
        backtrack(nums,ans,new ArrayList<>(),check);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans,List<Integer> temp,boolean[] check){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!check[i]){
                check[i]=true;
                temp.add(nums[i]);
                backtrack(nums,ans,temp,check);
                temp.remove(temp.size()-1);
                check[i]=false;
            }
        }
    }
}