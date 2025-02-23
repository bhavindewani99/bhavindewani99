class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int tail = x % 10;
            x /= 10;
            
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && tail > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && tail < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            
            result = result * 10 + tail;
        }
        
        return result;
    }
}
