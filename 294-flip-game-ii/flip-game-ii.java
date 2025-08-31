class Solution {
    public boolean canWin(String currentState) {
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i+1) == '+') {
                String next = currentState.substring(0, i) + "--" + currentState.substring(i+2);
                if (!canWin(next)) {  
                    return true;  // If opponent loses, I win
                }
            }
        }
        return false;  // No winning move
    }
}
