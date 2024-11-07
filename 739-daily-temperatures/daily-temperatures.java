class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]) stack.pop();
            if(stack.isEmpty()) result[i] = 0;
            else result[i] = stack.peek()-i;
            stack.add(i);
        }
        return result;
    }
}