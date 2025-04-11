class Solution {
    public int minOperations(int[] nums, int k) {
        
        Set<Integer> treeSet = new HashSet<>();
        int mini = Integer.MAX_VALUE, operations = 0;

        for(int i:nums){
            mini = Math.min(mini, i);
            treeSet.add(i);
        }

        if(mini < k) return -1;

        operations += treeSet.size();
        if(mini == k) operations--;
        return operations;
    }
}

