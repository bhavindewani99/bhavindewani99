class Solution {
    public int maxScore(String s) {
        
        int rightOnes = 0;
        int leftZeros = 0;
        int result = 0;

        for(char c : s.toCharArray()){
            if(c=='1') rightOnes++;
        }

        for(int i=0;i<s.length()-1;i++){
            char c = s.charAt(i);
            if(c=='0') leftZeros++;
            else rightOnes--;
            result = Math.max(result, rightOnes+leftZeros);
        }
        return result;

    }
}