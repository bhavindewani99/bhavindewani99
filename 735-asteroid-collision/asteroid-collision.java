class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();

        for(int i : asteroids){
            if(stack.isEmpty() || i >0) stack.add(i);
            else{
                int curr = -1*i;
                while(!stack.isEmpty() && stack.peek()>0 && curr>stack.peek()) stack.pop();
                if(stack.isEmpty() || stack.peek()<0) stack.add(i);
                else if(stack.peek()==curr) stack.pop();
            }
        }
        int[] result = new int[stack.size()];
        for(int i=0;i<result.length;i++) result[i] = stack.pop();
        
        for(int i=0;i<result.length/2;i++){
            int temp = result[i];
            result[i] = result[result.length-i-1];
            result[result.length-i-1] = temp;
        }

        return result;


    }
}