class Solution {
    public boolean canBeValid(String s, String locked) {
        
        if(s.length()%2!=0) return false; // we cant have odd length because we have to match open and close

        Stack<Integer> lockedStack = new Stack<>(); // we will put index which are locked
        Stack<Integer> unlockedStack = new Stack<>(); // we will put index which are unlocked

        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0') unlockedStack.add(i);
            else if(s.charAt(i)=='(') lockedStack.add(i);
            else {
                if(lockedStack.isEmpty()==false) lockedStack.pop(); // first we give priority to lockedStack because that is opening bracket so we matched that first
                else if(unlockedStack.isEmpty()==false) unlockedStack.pop();
                else return false;
            }
        }

        // now in the locked stack we are remaining with all the opening parethesis 
        // so we have to check if there is any unlocked character appearing after this locked character to be matched

        while(!lockedStack.isEmpty() && !unlockedStack.isEmpty() && lockedStack.peek()<unlockedStack.peek()){
            lockedStack.pop();
            unlockedStack.pop();
        }

        return lockedStack.isEmpty();

    }
}