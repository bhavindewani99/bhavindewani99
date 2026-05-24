class Solution {

    int difference = Integer.MAX_VALUE;
    int result = -1;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        for(int i = 0; i < baseCosts.length; i++){
            recursion(0, toppingCosts, target, baseCosts[i]);
        }

        return result;
    }

    private void recursion(int index, int[] toppingCosts, int target, int curr) {
        int curr_diff = Math.abs(target - curr);

        // 1. Update the best result at every valid step/combination
        if (result == -1 || curr_diff < difference) {
            difference = curr_diff;
            result = curr;
        } else if (curr_diff == difference && curr < result) {
            result = curr;
        }

        // 2. Base Case Check: Stop if we used all toppings
        if (index == toppingCosts.length) {
            return;
        }

        

        // Branch 1: Don't take this topping
        recursion(index + 1, toppingCosts, target, curr);

        // Branch 2: Take 1 of this topping
        recursion(index + 1, toppingCosts, target, curr + toppingCosts[index]);

        // Branch 3: Take 2 of this topping
        recursion(index + 1, toppingCosts, target, curr + toppingCosts[index] * 2);
    }
}
