class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        stack.add(heights[n-1]);

        for(int i=n-2;i>=0;i--){

            if(stack.peek() > heights[i]) {
                result[i] = 1;
            }else{
                int count = 0;
                while(stack.isEmpty()==false && stack.peek() < heights[i]) {
                    count++;
                    stack.pop();
                }
                if(stack.isEmpty() == false) count++;
                result[i] = count;
            }
            stack.add(heights[i]);
        }

        return result;
    }
}