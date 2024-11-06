class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int result = 0;
        int start = 0;
        long currBudget = 0;
        Deque<Pair> stack = new LinkedList<>();
        int n = chargeTimes.length;
        long currSum = 0;

        for(int i=0;i<n;i++){
            currSum += runningCosts[i];
            while(!stack.isEmpty() && stack.peekLast().value<chargeTimes[i]){
                stack.pollLast();
            }
            stack.addLast(new Pair(chargeTimes[i],i));
            currBudget = stack.peek().value + (i-start+1)*currSum;
            while(currBudget>budget && stack.isEmpty()==false){
                currSum -= runningCosts[start];
                if(start==stack.peekFirst().index) stack.pollFirst();
                start++;
                if(stack.isEmpty()){
                    currBudget=0;
                    currSum = 0;
                }else{
                    currBudget = stack.peekFirst().value + (i-start+1)*currSum;
                }
                
            }
            result = Math.max(result,i-start+1);
        }
        return result;


    }

    class Pair{
        int value, index;
        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}