class Solution {
    public boolean validUtf8(int[] data) {
        // 0b0 means 0 0b10 means 10 in binary form

        int remainingBytes = 0;

        for(int number : data){
            if(remainingBytes == 0){
                if((number >> 7) == 0b0) remainingBytes =0; // 1 Byte Character
                else if((number >> 5) == 0b110) remainingBytes = 1; // 2 Byte Character
                else if((number >> 4) == 0b1110) remainingBytes = 2; // 3 Byte Character
                else if((number >> 3) == 0b11110) remainingBytes = 3; // 4 Byte Character
                else return false; // more than 4 bytes
            }else{
                if((number >> 6) == 0b10) remainingBytes--;
                else return false; // means doesnt starts with 10
            }
        }

        return remainingBytes == 0;
    }
}