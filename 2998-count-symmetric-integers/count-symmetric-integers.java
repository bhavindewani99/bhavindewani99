class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0 ;
        for(int i = low; i <= high; i++){
            String s = String.valueOf(i);
            if(s.length() % 2 != 0){
                continue;
            }
            int left = 0;
            int right = s.length() - 1;
            int sumL = 0;
            int sumR = 0;
            while(left < right){
                sumL += s.charAt(left) - '0';
                sumR += s.charAt(right) - '0';
                left++;
                right--;
            }
            if(sumL == sumR){
                count++;
            }
        }
        return count;
    }
}