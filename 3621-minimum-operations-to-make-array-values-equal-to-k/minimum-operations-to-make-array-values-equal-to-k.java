class Solution {
    public int minOperations(int[] nums, int k) {
        
        TreeSet<Integer> treeSet = new TreeSet<>((a,b) -> a-b);
        int mini = Integer.MAX_VALUE, operations = 0;

        for(int i:nums){
            mini = Math.min(mini, i);
            treeSet.add(i);
        }

        if(mini < k) return -1;

        operations += treeSet.size();
        if(treeSet.first()==k) operations--;
        return operations;
    }
}

