class Solution {
    public int takeCharacters(String s, int k) {
        
        int[] count = new int[3];

        for(char c : s.toCharArray()){
            count[c-'a']++;
        }

        if(getMinimum(count)<k) return -1;
        int left = 0;
        int res = Integer.MAX_VALUE;

        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            count[c-'a']--;
            while(left<=right && getMinimum(count)<k){
                count[s.charAt(left)-'a']++;
                left++;
            }
            res= Math.min(res, s.length()-(right-left+1));
        }
        return res;
    }


    private int getMinimum(int[] count){
        int mini = count[0];
        for(int i=1;i<=2;i++) mini = Math.min(mini, count[i]);
        return mini;
    }
}