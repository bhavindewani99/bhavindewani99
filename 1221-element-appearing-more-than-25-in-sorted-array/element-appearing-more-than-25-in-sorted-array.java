class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;
        int last = -1, count = 0, result = -1;

        for(int i : arr){
            if(i==last) count++;
            else{
                count = 1;
                last = i;
            }
            if(count>n/4) result = last;
        }
        return result;
    }
}