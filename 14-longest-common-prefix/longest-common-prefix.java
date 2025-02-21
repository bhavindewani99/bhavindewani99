class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder result = new StringBuilder();
        char[] arr= strs[0].toCharArray();
        int mini = Integer.MAX_VALUE;

        for(String s : strs) mini = Math.min(s.length(), mini);

        for(int i=0;i<mini;i++){
            for(String s : strs){
                if(strs[0].charAt(i)!=s.charAt(i)) return result.toString();
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();

    }
}