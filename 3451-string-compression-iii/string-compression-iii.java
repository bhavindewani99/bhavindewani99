class Solution {
    public String compressedString(String word) {
        StringBuilder res = new StringBuilder();
        char lastChar = word.charAt(0);
        int cnt = 1;

        for(int i=1;i<word.length();i++){
            char currChar = word.charAt(i);
            if(currChar==lastChar){
                cnt++;
                if(cnt>9){
                    res.append(cnt-1);
                    res.append(lastChar);
                    cnt = 1;
                }
            }
            else{
                res.append(cnt);
                res.append(lastChar);
                lastChar = currChar;
                cnt =1;
            }
        }
        res.append(cnt);
        res.append(lastChar);
        return res.toString();
    }
}