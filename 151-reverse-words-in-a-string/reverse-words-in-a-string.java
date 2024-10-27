class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int right = s.length()-1;
        StringBuilder res = new StringBuilder();

        while(right>=0){

            while(right>=0 && s.charAt(right)==' ') right--;

            int left = right;
            while(left>=0 && s.charAt(left)!=' ') left--;
            res.append(s.substring(left+1,right+1));
            res.append(" ");
            right=left;

        }
        if(res.length()>0)
        res.setLength(res.length()-1);
        return res.toString();
    }
}