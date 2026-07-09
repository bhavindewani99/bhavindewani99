class Solution { 
    public boolean splitString(String s) { 
        return recursion(0, -1, -1, s, 0, false); 
    } 

    // Added an 'isLastValid' boolean to track if the current path validly covers the end of the string
    private boolean recursion(int index, int prevIndex, long prevNum, String s, int parts, boolean isLastValid){
        if(index == s.length()){ 
            // The split is only correct if we have >= 2 parts AND the last part ended exactly at the string limit
            return parts >= 2 && isLastValid; 
        }

        long currNum = 0;
        for (int i = prevIndex + 1; i <= index; i++) {
            currNum = currNum * 10 + (s.charAt(i) - '0');
        }

        if(currNum > 9999999999L || (prevNum != -1 && currNum >= prevNum)) return false; 

        // If we choose 'not_take', the current substring isn't a final slice yet, so pass false
        boolean not_take = recursion(index + 1, prevIndex, prevNum, s, parts, false); 
        boolean take = false; 

        if(currNum == prevNum - 1 || prevNum == -1){ 
            // If we choose 'take', this slice successfully ends at the current 'index'. 
            // We pass 'true' to signal that if this index happens to be the last character, it's valid.
            take = recursion(index + 1, index, currNum, s, parts + 1, true); 
        } 

        return take || not_take; 
    } 
}
