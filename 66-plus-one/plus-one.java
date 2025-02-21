class Solution {
    public int[] plusOne(int[] digits) {
        
        List<Integer> result = new ArrayList<>();
        int index = digits.length-1;
        int carry = 1;

        while(carry>0 || index>=0){
            int currSum = carry;
            if(index>=0) currSum += digits[index--];
            carry = currSum > 9 ? 1 : 0;
            result.add(currSum%10);
        }

        Collections.reverse(result);
        int ans[] = new int[result.size()];
        index=0;
        for(int i : result) ans[index++] = i;

        return ans;
    }
}