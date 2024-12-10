class Solution {
    public int maximumLength(String s) {
        int[][] freq = new int[26][3];
        char lastSeen  = '*';
        int currCount = 0;
        for(int[] temp : freq) Arrays.fill(temp, -1);
        int longest = -1;

        for(char c: s.toCharArray()){
            if(c==lastSeen){
                currCount++;
            }else{
                currCount = 1;
                lastSeen = c;
            }
            int mini = Math.min(freq[c-'a'][0], Math.min(freq[c-'a'][1], freq[c-'a'][2]));
            if(mini<currCount){
                for(int k=0;k<3;k++){
                    if(freq[c-'a'][k]==mini) {
                        freq[c-'a'][k] = currCount;
                        break;
                    }
                }
            }
        }

        for(int i=0;i<26;i++){
            longest = Math.max(longest, Math.min(freq[i][0], Math.min(freq[i][1], freq[i][2])));
        }

        return longest;

    }
}