class Solution {
    public String answerString(String word, int numFriends) {
        
        int wordLen = word.length();
        if(numFriends==1) return word;
        int maxPossibleLen = wordLen - (numFriends - 1);
        char maxPossibleChar = 'a';
        String resultString= "";

        for(char curr : word.toCharArray()){
            if(curr > maxPossibleChar) maxPossibleChar = curr;
        }

        for(int i=0;i < wordLen;i++){
            int currEndingIndex = Math.min(i+maxPossibleLen, wordLen);
            String curString = word.substring(i,currEndingIndex);
            if( ( resultString.length()==0 || curString.compareTo(resultString) > 0)){
                resultString = curString;
            }
        }

        return resultString;

    }
}