class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>(); // run 2 times without emptying stack so will get next greater in the 2 time for circular array
        int n = nums.length;
        int[] result = new int[n];

        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]) stack.pop();
            result[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(nums[i%n]);
        }

        return result;
    }
}