class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int maxi = 0;
        int currSum = 0;
        int result = 0;

        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==1){
                currSum += customers[i];
            }else{
                result += customers[i];
            }

            if(i >= minutes){
                if(grumpy[left] == 1) currSum -= customers[left];
                left++;
            }
            maxi = Math.max(maxi, currSum);
        }
        return result + maxi;
    }
}