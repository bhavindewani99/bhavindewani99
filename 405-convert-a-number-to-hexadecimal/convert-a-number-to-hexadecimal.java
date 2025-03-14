class Solution {
    public String toHex(int num) {
        
        if(num==0) return "0";

        long val = num;
        if(num<0) val = (long) (Math.pow(2, 32) + num);
        char[] arr = "0123456789abcdef".toCharArray();
        StringBuilder result = new StringBuilder();

        while(val!=0){
            int remainder = (int) (val % 16);
            result.append(arr[remainder]);
            val /= 16;
        }

        return result.reverse().toString();

    }
}

