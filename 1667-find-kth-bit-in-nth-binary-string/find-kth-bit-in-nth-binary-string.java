class Solution {
    public char findKthBit(int n, int k) {
        int length = ((int) Math.pow(2, n)) -1;
        return tabulation(length, k);
        //return recursion(length, k);
    }

    private char tabulation(int length, int k){
        boolean invert = false;
        while(length>1){
            int half = length/2;
            if(k<=half){
                length /=2;
            }else if(k>half+1){
                k = length +1 -k;
                length/=2;
                invert = !invert;
            }else{
                if(invert==false) return '1';
                return '0';
            }
        }
        char res = '0';
        if(invert) res= '1';
        return res;
    }


    private char recursion(int length, int k){
        if(length==1) return '0';

        int half = length/2;
        if(k<=half){
            return recursion(half, k);
        }else if(k> half+1){
            char res = recursion(half, length+1 - k);
            return res=='1' ? '0' : '1';
        }else{
            return '1';
        }
    }
}