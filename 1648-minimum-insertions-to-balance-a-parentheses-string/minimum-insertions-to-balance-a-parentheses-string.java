class Solution {
    public int minInsertions(String s) {
        
        int open = 0;
        int result = 0;
        int index = 0;
        int n = s.length();

        while (index<n) {
            char c = s.charAt(index);
            if(c=='(') open++;
            else{
                if(index + 1<n && s.charAt(index+1)==')') {
                    index++;
                }else{
                    result++;
                }
                if(open>0) open--;
                else result++;
            }
            index++;
        }
        result += open*2;
        return result;
    }
}