class Solution {
    Map<Integer,Boolean> memo=new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(((maxChoosableInteger+1)*maxChoosableInteger)/2<desiredTotal)
        return false;
        return canIwinHelper(maxChoosableInteger,desiredTotal,0,memo);
    }
    public boolean canIwinHelper(int maxChoosableInteger,int desiredTotal,int currentstState,Map<Integer,Boolean> memo){
        if(memo.containsKey(currentstState)){
            return memo.get(currentstState);
        }

        for(int i=1;i<=maxChoosableInteger;i++){
            if((currentstState & (1<<(i-1)))==0){
                int newstate=currentstState | (1<<(i-1));
                if(i>=desiredTotal || !canIwinHelper(maxChoosableInteger,desiredTotal-i,newstate,memo)){
                    memo.put(currentstState,true);
                    return true;
                }
            }
        }
        memo.put(currentstState,false);
        return false;

    }
}